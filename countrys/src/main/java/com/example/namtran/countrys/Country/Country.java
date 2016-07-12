package com.example.namtran.countrys.Country;

/**
 * Created by Nam Tran on 7/27/2015.
 */
public class Country {
    public static final String TABLE = "Countries";
    public static final String ID = "_id";
    public static final String RATING = "rating";
    public static final String NAME_VI = "nameVi";
    public static final String NAME_EN = "nameEn";
    public static final String FLAG = "flag";
    public static final String IMAGE = "image";
    public static final String RELIGIONVI = "religionVi";
    public static final String RELIGIONEN = "religionEn";
    public static final String LANGUAGE = "language";
    public static final String CURRENCY = "Currency";
    public static final String CODE = "Code";
    public static final String CAPTION = "caption";
    public static final String POPULATION = "population";
    public static final String GOVERNMENTVI = "GovernmentVi";
    public static final String GOVERNMENTEN = "GovernmentEn";
    public static final String ACREAGE = "acreage";
    public static final String AUTHEMNAME = "anthemName";
    public static final String AUTHEMSONG = "anthemSong";
    public static final String XAPXEP = NAME_EN + " ASC";

    int id;
    String nameVi;
    String nameEn;
    String anthemName;
    String anthemSong;
    String flag;
    String image;
    String religionVi;
    String religionEn;
    String GovernmentVi;
    String GovernmentEn;
    String language;
    String caption;
    String Currency;
    double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAnthemName() {
        return anthemName;
    }

    public void setAnthemName(String anthemName) {
        this.anthemName = anthemName;
    }

    public String getAnthemSong() {
        return anthemSong;
    }

    public void setAnthemSong(String anthemSong) {
        this.anthemSong = anthemSong;
    }

    int population;
    int Code;
    Double acreage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameVi() {
        return nameVi;
    }

    public void setNameVi(String nameVi) {
        this.nameVi = nameVi;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReligionVi() {
        return religionVi;
    }

    public void setReligionVi(String religionVi) {
        this.religionVi = religionVi;
    }

    public String getReligionEn() {
        return religionEn;
    }

    public void setReligionEn(String religionEn) {
        this.religionEn = religionEn;
    }

    public String getGovernmentVi() {
        return GovernmentVi;
    }

    public void setGovernmentVi(String governmentVi) {
        GovernmentVi = governmentVi;
    }

    public String getGovernmentEn() {
        return GovernmentEn;
    }

    public void setGovernmentEn(String governmentEn) {
        GovernmentEn = governmentEn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }
}
