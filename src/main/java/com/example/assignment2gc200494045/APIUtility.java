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
        //This is the same search http String that you used in your browser
        String uri = "https://api.nytimes.com/svc/books/v3/reviews.json?api-key=mo5tniIxtHGt75HYQnyXUWoE8i02kbJM&author=stephen%20king";

        //configure the environment to make an HTTP request (this includes an update to
        //the module-info.java file
        HttpClient client = HttpClient.newHttpClient();//open my browser
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();//type in my browser

        //send the httpRequest and save the result in a file called "movies.json"
        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
                .BodyHandlers
                .ofFile(Paths.get("books.json")));
    }


}


