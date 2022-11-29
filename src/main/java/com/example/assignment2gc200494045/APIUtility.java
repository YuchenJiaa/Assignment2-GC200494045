package com.example.assignment2gc200494045;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    //call an API, make a request, receive the response and write it to a file
    public static void getBooksFromNYT(String searchTerm) throws IOException, InterruptedException {
        //handle the spaces
        searchTerm = searchTerm.replaceAll(" ","%20");
        //This is the same search http String that you used in your browser
        String uri = "https://api.nytimes.com/svc/books/v3/reviews.json?api-key=mo5tniIxtHGt75HYQnyXUWoE8i02kbJM&author="+searchTerm;

        //configure the environment to make an HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();//open my browser
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();//type in my browser

        //send the httpRequest and save the result in a file called "movies.json"
        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
                .BodyHandlers
                .ofFile(Paths.get("books.json")));
    }
    public static APIResponse getBooksFromFile()
    {
        //Create a GSON object.  GSON is the Google library that can read and write
        //JSON
        //in order to use this library, we need to update the pom.xml and module-info.java
        //files.  Don't forget to reload the Maven dependencies
        Gson gson = new Gson();

        APIResponse apiResponse = null;

        //open the file and pass it into the Gson object to covert JSON objects to Java objects
        try(
                FileReader fileReader = new FileReader("books.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return apiResponse;
    }

}


