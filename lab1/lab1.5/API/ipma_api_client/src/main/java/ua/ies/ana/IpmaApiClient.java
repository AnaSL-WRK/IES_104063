package ua.ies.ana;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.*;



public class IpmaApiClient {
    


    private static Call<CityForecast> cidadeByName;
    private static final int CITY_ID_AVEIRO = 1010500;

    
        public static void APIHandle(ArrayList<String> city) { //localName

    
    
             // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
                Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.ipma.pt/open-data/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();  


             // create a typed interface to use the remote API (a client)(infos for forecast)
             IpmaService service = retrofit.create(IpmaService.class);
             
             
             // prepare the call to remote endpoint
             Call<IpmaCityForecast>  cityName = service.getCidadeByName();

  
             try {
                 
                Response<IpmaCityForecast> data = cityName.execute();
                List<CityForecast> forecastInfo = data.body().getData();

              
                    for (String local: city){

                        for (CityForecast match: forecastInfo){

                            if(local.equals(match.getLocal())){

                                    
                                Call<IpmaCityForecast> callSync = service.getForecastForACity(match.getGlobalIdLocal());
                                Response<IpmaCityForecast> apiResponse = callSync.execute();
                                IpmaCityForecast forecast = apiResponse.body();

                                if (forecast != null) {
                                    CityForecast firstDay = forecast.getData().listIterator().next();
                                    System.out.printf( " Local: %s \n Dia: %s \n Min temp: %.1f °C \n Max temp: %.1f °C \n Prob. Precipitaçao: %.1f \n",
                                        match.getLocal(),
                                        firstDay.getForecastDate(),
                                        Double.parseDouble(firstDay.getTMin()),
                                        Double.parseDouble(firstDay.getTMax()),
                                        Double.parseDouble(firstDay.getPrecipitaProb()));}

                                else {
                                    System.out.println( "No forecast data for this city");}
                                    
                            }
                        }
                    }

            }catch (Exception ex) {
                ex.printStackTrace();}
            
        }
    }




























      // static int ID = (Integer) null;
      // static String DATE = null;
      // static Double TMIN = null;
      // static Double TMAX = null;
      // static Double PPROB = null;
 

  // try{
  //     Response<IpmaCityForecast> apiResponse = callSync.execute();
  //     IpmaCityForecast forecast = apiResponse.body();

  //     if (forecast != null) {
  //         CityForecast firstDay = forecast.getData().listIterator().next();
  //         var ID = forecast.getGlobalIdLocal();
  //         String DATE = firstDay.getForecastDate();
  //         double TMIN = Double.parseDouble(firstDay.getTMin());
  //         double TMAX = Double.parseDouble(firstDay.getTMax());
  //         double PPROB = Double.parseDouble(firstDay.getPrecipitaProb());}

  //          
  //     }
  //     catch (Exception ex){
  //         ex.printStackTrace();}
  //     




      

//try {
//    Response<IpmaCityForecast> apiResponse = callSync.execute();
//    IpmaCityForecast forecast = apiResponse.body();
//
//    if (forecast != null) {
//        CityForecast firstDay = forecast.getData().listIterator().next();
//        int ID = forecast.getGlobalIdLocal();
//        String DATE = firstDay.getForecastDate();
//        Double TMIN = Double.parseDouble(firstDay.getTMin());
//        Double TMAX = Double.parseDouble(firstDay.getTMax());
//        Double PPROB = Double.parseDouble(firstDay.getPrecipitaProb());}
//
//         
//    }catch (Exception ex) {
//    ex.printStackTrace();}
//}}
