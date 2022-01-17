package com.java.xml;

public class SateAndBirdName {
    private String name;
    private String abbirivation;
    private String year;
    private String birdName;
    public SateAndBirdName(String name,String abbirivation,String year,String birdName){
        this.name=name;
        this.abbirivation = abbirivation;
        this.year= year;
        this.birdName= birdName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbirivation() {
        return abbirivation;
    }

    public void setAbbirivation(String abbirivation) {
        this.abbirivation = abbirivation;
    }

    public String getYaer() {
        return year;
    }

    public void setYaer(String yaer) {
        this.year = year;
    }

    public String getBirdName() {
        return birdName;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }
}
