package ua.ana.showapi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.ana.showapi.builders.*;

@RestController
public class APIController {
    
	@GetMapping("/api/quote")
	  public rdmquote randomQuote() throws IOException, ParseException ,FileNotFoundException {
        JSONParser jsonparser = new JSONParser();
        
        FileReader reader = new FileReader("C:\\Users\\anawk\\OneDrive - Universidade de Aveiro\\Uni\\3.ano\\IES\\IES_104063\\lab2\\lab2.4\\showapi\\src\\main\\java\\ua\\ana\\showapi\\API.json");
  
        //abrir o json pra object
        Object obj = jsonparser.parse(reader);
        JSONObject json = (JSONObject)obj;
  
        //gets all arrays
        JSONArray array = (JSONArray)json.get("info");
  
       //creates random number
       int randomNum = ThreadLocalRandom.current().nextInt(0, array.size());
        
       //gets the info for a random movie/show
       JSONObject um = (JSONObject) array.get(randomNum);
        
       //gets id and show name
       long id = (long) um.get("id");
       String show = (String) um.get("show");


       //gets all quotes from that show
       JSONArray quotesArray = (JSONArray) um.get("quotes");
        
        
       int randomNum2 = ThreadLocalRandom.current().nextInt(0, quotesArray.size()); 
        
        
       String quote = (String) quotesArray.get(randomNum2);

      // formatQuote = 

       return new rdmquote(id, show, quote);
	}


   
@GetMapping("/api/shows")
  public JSONArray allShows() throws IOException, ParseException, FileNotFoundException {
   JSONParser jsonparser = new JSONParser();
   FileReader reader = new FileReader("C:\\Users\\anawk\\OneDrive - Universidade de Aveiro\\Uni\\3.ano\\IES\\IES_104063\\lab2\\lab2.4\\showapi\\src\\main\\java\\ua\\ana\\showapi\\API.json");

   //abrir o json pra object
   Object obj = jsonparser.parse(reader);
   JSONObject json = (JSONObject)obj;

   //gets all arrays
   JSONArray array = (JSONArray)json.get("info");

   //JSONObject jsonObj = new JSONObject();
   JSONArray jsonArr = new JSONArray();

   for (int i = 0; i < array.size(); i++){
      JSONObject container = (JSONObject) array.get(i);

      if (container.get("quotes") != null){
         JSONObject jsonObj = new JSONObject();
          long id = (long) container.get("id");
          String show = (String) container.get("show");
          jsonObj.put("show", show );
          jsonObj.put("id", id);
          jsonArr.add(jsonObj);
      }
   }
      return jsonArr;
}


@GetMapping("/api/quotes")
  public rdmquote idQuote(@RequestParam(value = "show", required=true) Long inputId) throws IOException, ParseException, FileNotFoundException {

   JSONParser jsonparser = new JSONParser();
   FileReader reader = new FileReader("C:\\Users\\anawk\\OneDrive - Universidade de Aveiro\\Uni\\3.ano\\IES\\IES_104063\\lab2\\lab2.4\\showapi\\src\\main\\java\\ua\\ana\\showapi\\API.json");

   //abrir o json pra object
   Object obj = jsonparser.parse(reader);
   JSONObject json = (JSONObject)obj;

   //gets all arrays
   JSONArray array = (JSONArray)json.get("info");


   Long id = null;
   String show = null;
   String quote = null;

  for (int i = 0; i < array.size(); i++){
   JSONObject container = (JSONObject) array.get(i);
 
   if (container.get("id") == inputId){
       id = (Long) container.get("id");
       show = (String) container.get("show");
       JSONArray quotesArray = (JSONArray) container.get("quotes");
       int randomNum3 = ThreadLocalRandom.current().nextInt(0, quotesArray.size()); 
       quote = (String) quotesArray.get(randomNum3);
   }
}
return new rdmquote(id, show, quote);

}

}



