package com.example.myapplication;
/*
 this class is for implementing movie list, its basically having getter and setter method to set and get movie details.
 */
public class MovieItemList {
        private String movieDescription;
        private String imageId;
        private String movieName;
        public MovieItemList(String movieName,String description, String imgId) {
            this.movieName = movieName;
            this.movieDescription = description;
            this.imageId = imgId;
        }
       public void setMovieName(String movieName) {
        this.movieName = movieName;
       }
       public String getMovieName() {
        return movieName;
       }
        public String getDescription() {
            return movieDescription;
        }
        public void setDescription(String description) {
            this.movieDescription = description;
        }
        public String getImgId() {
            return imageId;
        }
        public void setImgId(String imgId) {
            this.imageId = imgId;
        }
}
