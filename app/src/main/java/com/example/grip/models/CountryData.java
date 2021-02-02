package com.example.grip.models;

import com.google.gson.annotations.SerializedName;

public class CountryData {
    @SerializedName("name")
    String name;

    @SerializedName("capital")
    String capital;

    @SerializedName("flag")
    String flag;

    @SerializedName("region")
    String region;

    @SerializedName("subregion")
    String subregion;

    @SerializedName("population")
    String population;

    @SerializedName("borders")
    String borders;

    @SerializedName("languages")
    String languages;

    public CountryData() {
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlag() {
        return flag;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getPopulation() {
        return population;
    }

    public String getBorders() {
        return borders;
    }

    public String getLanguages() {
        return languages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setBorders(String borders) {
        this.borders = borders;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
