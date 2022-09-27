package ua.ana;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * demonstrates the use of the IPMA API for weather forecast
 */

public class WeatherStarter {

    private static Logger logger = LogManager.getLogger();

    //default city if no arguments passed
    private static final int CITY_ID_AVEIRO = 1010500;

    public static void  main(String[] args ) {

        int city_id;

        if (args.length == 0){
             city_id = CITY_ID_AVEIRO;}

        else{
            city_id = Integer.parseInt(args[0]);}

    
        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint

        
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city_id);
        
        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                CityForecast firstDay = forecast.getData().listIterator().next();

                

                System.out.printf( " Local: %s \n Dia: %s \n Min temp: %.1f °C \n Max temp: %.1f °C \n Prob. Precipitaçao: %.1f \n",
                        forecast.getGlobalIdLocal(),
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMin()),
                        Double.parseDouble(firstDay.getTMax()),
                        Double.parseDouble(firstDay.getPrecipitaProb()));



                logger.info(" \n Local:" + forecast.getGlobalIdLocal() + "\n Dia:" + firstDay.getForecastDate() + "\n Min temp:" +
                 Double.parseDouble(firstDay.getTMin()) + "°C \n Max temp:" + Double.parseDouble(firstDay.getTMax()) 
                 + "°C \n Prob. Precipitaçao:" + Double.parseDouble(firstDay.getPrecipitaProb()));      
        
                         
            } else {
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.exit(0);
    }
}
