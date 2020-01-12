package com.ahl.uasmantap;

import org.json.JSONObject;

public class MovieItems {
    private String movTitle;
    private String movOverview;
    private String movVote;
    private String movRating;
    private String movDateRelease;
    private String movImage;

    private String mealId;
    private String mealName;
    private String mealCategory;
    private String mealArea;
    private String mealInstructions;
    private String mealImage;

    public MovieItems(JSONObject obj) {

        //Get value according to JSON object name value
        try {
            String id = obj.getString("idMeal");
            String name = obj.getString("strMeal");
            String category = obj.getString("strCategory");
            String area = obj.getString("strArea");
            String instructions = obj.getString("strInstructions");
            String image = obj.getString("strMealThumb");

            this.mealId = id;
            this.mealName = name;
            this.mealCategory = category;
            this.mealArea = area;
            this.mealInstructions = instructions;
            this.mealImage = image;

            /*
            String title = obj.getString("title");
            String overview = obj.getString("overview");
            String dateRelease = obj.getString("release_date");
            String image = obj.getString("poster_path");
            String rating = obj.getString("vote_average");
            String vote = obj.getString("vote_count");


            this.movTitle = title;
            this.movOverview = overview;
            this.movDateRelease = dateRelease;
            this.movImage = image;
            this.movRating = rating;
            this.movVote = vote;
            */
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // Setter and Getter function
    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName1) {
        this.mealName = mealName;
    }

    public String getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(String mealCategory) {
        this.mealCategory = mealCategory;
    }

    public String getMealArea() {
        return mealArea;
    }

    public void setMealArea(String mealArea) {
        this.mealArea = mealArea;
    }

    public String getMealInstructions() {
        return mealInstructions;
    }

    public void setMealInstructions(String mealInstructions) {
        this.mealInstructions = mealInstructions;
    }

    public String getMealImage() {
        return mealImage;
    }

    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }
}