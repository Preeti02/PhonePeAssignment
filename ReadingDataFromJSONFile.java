package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.io.*;

public class ReadingDataFromJSONFile {
     public static String movieName;
     public static String movieSummary;
     public static String movieImage;

    public static int readData() {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader("https://api.themoviedb.org/3/movie/now_playing?api_key=38a73d59546aa378980a88b645f487fc&language=en-US&page=1"));
                JSONObject jsonObject = (JSONObject)obj;
                movieName = (String)jsonObject.get("original_title");
                movieSummary = (String)jsonObject.get("overview");
                movieImage = (String)jsonObject.get("backdrop_path");

                JSONArray movieTitle = (JSONArray)jsonObject.get("original_title");

               /* ----for testing purpose
                System.out.println("movieName: " + name);
                System.out.println("movieSummary: " + course);
                */

                Iterator iterator = movieTitle.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
}

