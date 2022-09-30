package ua.ies.ana;
import java.util.ArrayList;

// import API.ipma_api_client.src.main.java.ua.ies.ana.IpmaApiClient;



public class WeatherForecastByCity {

    public static void main(String[] args) {

        ArrayList<String> city = new ArrayList<String>();

        if (args.length == 0){
            city.add("Aveiro");}

        else{
            for (String inpt: args){
                city.add(inpt);}    
        }

        System.out.println(city);
        
        IpmaApiClient API = new IpmaApiClient();
        API.APIHandle(city);
        System.exit(0);
        
    }
}
