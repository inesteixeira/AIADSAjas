package com.aiad;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class House implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    private java.lang.Boolean isHouse;
    private java.lang.Boolean isApartment;
    private java.lang.Boolean isFarm;
    private java.lang.Boolean ageBigger25;
    private java.lang.Boolean ageBetween25and60;
    private java.lang.Boolean ageBigger60;
    private java.lang.Boolean isRural;
    private java.lang.Boolean isUrban;
    private int price;

    public House() {
    }

    public java.lang.Boolean getIsHouse() {
        return this.isHouse;
    }

    public void setIsHouse(java.lang.Boolean isHouse) {
        this.isHouse = isHouse;
    }

    public java.lang.Boolean getIsApartment() {
        return this.isApartment;
    }

    public void setIsApartment(java.lang.Boolean isApartment) {
        this.isApartment = isApartment;
    }

    public java.lang.Boolean getIsFarm() {
        return this.isFarm;
    }

    public void setIsFarm(java.lang.Boolean isFarm) {
        this.isFarm = isFarm;
    }

    public java.lang.Boolean getAgeBigger25() {
        return this.ageBigger25;
    }

    public void setAgeBigger25(java.lang.Boolean ageBigger25) {
        this.ageBigger25 = ageBigger25;
    }

    public java.lang.Boolean getAgeBetween25and60() {
        return this.ageBetween25and60;
    }

    public void setAgeBetween25and60(java.lang.Boolean ageBetween25and60) {
        this.ageBetween25and60 = ageBetween25and60;
    }

    public java.lang.Boolean getAgeBigger60() {
        return this.ageBigger60;
    }

    public void setAgeBigger60(java.lang.Boolean ageBigger60) {
        this.ageBigger60 = ageBigger60;
    }

    public java.lang.Boolean getIsRural() {
        return this.isRural;
    }

    public void setIsRural(java.lang.Boolean isRural) {
        this.isRural = isRural;
    }

    public java.lang.Boolean getIsUrban() {
        return this.isUrban;
    }

    public void setIsUrban(java.lang.Boolean isUrban) {
        this.isUrban = isUrban;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public House(java.lang.Boolean isHouse, java.lang.Boolean isApartment,
                 java.lang.Boolean isFarm, java.lang.Boolean ageBigger25,
                 java.lang.Boolean ageBetween25and60, java.lang.Boolean ageBigger60,
                 java.lang.Boolean isRural, java.lang.Boolean isUrban, int price) {
        this.isHouse = isHouse;
        this.isApartment = isApartment;
        this.isFarm = isFarm;
        this.ageBigger25 = ageBigger25;
        this.ageBetween25and60 = ageBetween25and60;
        this.ageBigger60 = ageBigger60;
        this.isRural = isRural;
        this.isUrban = isUrban;
        this.price = price;
    }

}