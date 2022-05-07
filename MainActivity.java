package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.util.Iterator;
/*
 Main activity, putting data from JSON to recycler view.
 */
public class MainActivity extends AppCompatActivity {
    public static String movieName;
    public static String movieSummary;
    public static String movieImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readData(); //JSON reading...
        MovieItemList[] myListData = new MovieItemList[] {
                new MovieItemList(movieName,movieSummary, movieImage), // adding data to view onscreen
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MovieListAdapterForRecyclerView adapter = new MovieListAdapterForRecyclerView(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public static void readData() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("https://api.themoviedb.org/3/movie/now_playing?api_key=38a73d59546aa378980a88b645f487fc&language=en-US&page=1"));
            JSONObject jsonObject = (JSONObject) obj;
            movieName = (String) jsonObject.get("original_title");
            movieSummary = (String) jsonObject.get("overview");
            movieImage = (String) jsonObject.get("backdrop_path");

            JSONArray movieTitle = (JSONArray) jsonObject.get("original_title");

               /* ----for testing purpose
                System.out.println("movieName: " + movieName);
                System.out.println("movieSummary: " + movieSummary);
                */

            Iterator iterator = movieTitle.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






