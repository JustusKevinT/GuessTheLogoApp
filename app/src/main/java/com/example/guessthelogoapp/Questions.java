package com.example.guessthelogoapp;

public class Questions {

private String mQuestions[] = {
        "Guess The Logo ?", "Can You Guess The Logo ?", "Can You Guess This One ?", "Guess The Logo ?", "Can You Guess This Logo ?",
        "Can You Guess The Logo ?", "Can You Guess This One ?", "Can You Guess This Logo ?", "Guess The Logo ?", "Guess The Logo ?",
        "Can You Guess This Logo ?", "Can You Guess The Logo ?", "Can You Guess This One ?", "Guess The Logo ?", "Guess The Logo ?",
        "Guess The Logo ?", "Can You Guess The Logo ?", "Can You Guess This Logo?", "Guess The Logo ?", "Can You Guess This One ?",
        "Can You Guess The Logo ?", "Can You Guess This One ?", "Guess The Logo", "Can You Guess THis One ?", ""
   };

   private String mChoice[] [] = {
           {"MySQL","PostgreSQL","MongoDB"}, {"AMD","CMD","EMR"}, {"Android","Ubuntu", "Mac"}, {"PostgreSQL","SQLite","Firebase"}, {"Chrome","Chromium","Firefox"},
           {"Ferrari","Toyota","Audi"}, {"Dropbox","Onedrive","pCloud"}, {"Internet Explorer","Opera","Safari"}, {"Kotlin","Flutter","Swift"}, {"GitHub","GitLab","Git"},
           {"Flutter","Kotlin","AMD"},{"Gmail","Email Aqua Mail","Samsung Email"},{"Firebase","Superbase","Couchbase"},{"Jaguar","Suzuki","Mercedes Benz"},{"Maruti","Jaguar","Tata"},
           {"JavaScript","Java","Scala"},{"ReactJS","ExpressJS","NodeJS"},{"Steam","Ubisoft","Riot"},{"Windows","Red Hat","ChromeOS"},{"Open 3D","Unity","Blend4Web"},
           {"Asus","Nvidia","MSI"},{"Opera","Brave","Edge"},{"Spike","Outlook","Blue mail"},{"Python","Rust","Ruby"},{"Assassin's Creed 1","Assassin's Creed Rogue", "Assassin's Creed Unity"}
   };

   private String mImages [] = {
           "q1","q2","q3","q4","q5",
           "q6","q7","q8","q9","q10",
           "q11","q12","q13","q14","q15",
           "q16","q17","q18","q19","q20",
           "q21","q22","q23","q24","q25"
   };

   private String mQuestionTypes [] = {
           "radiobutton", "radiobutton", "radiobutton", "radiobutton", "radiobutton",
           "radiobutton", "radiobutton", "radiobutton", "radiobutton", "radiobutton",
           "radiobutton", "radiobutton", "radiobutton", "radiobutton", "radiobutton",
           "radiobutton", "radiobutton", "radiobutton", "radiobutton", "radiobutton",
           "radiobutton", "radiobutton", "radiobutton", "radiobutton", "radiobutton",
   };

   private String mCorrectAnswers [] ={
           "MySQL","AMD","Android","PostgreSQL","Chrome",
           "Ferrari","Dropbox","Internet Explorer","Flutter","GitHub",
           "Kotlin","Gmail","Firebase","Mercedes Benz","Jaguar",
           "Java","NodeJS","Ubisoft","Windows","Unity",
           "Nvidia","Opera","Outlook","Python","Assassin's Creed 1"
   };

   public String getQuestions(int q) {
      String questions = mQuestions[q];
      return questions;
   }

   public String getImages(int q) {
      String images = mImages[q];
      return images;
   }

   public String[] getChoice(int q) {
      String [] choice = mChoice[q];
      return choice;
   }

   public String getType(int q) {
      String type = mQuestionTypes[q];
      return type;
   }

   public String getCorrectAnswers(int q) {
      String correctAnswers = mCorrectAnswers[q];
      return correctAnswers;
   }

   public int getLength(){
      return mQuestions.length;
   }

}
