package com.aiad;

public class ClientParameters {
    String name;
    String typeOfInsurance;
    String first;
    String second;
    String third;
    String isNegotiator;
    String min;
    String max;

    public ClientParameters(String name, String typeOfInsurance, String first, String second, String third, String isNegotiator, String min, String max) {
        this.name = name;
        this.typeOfInsurance = typeOfInsurance;
        this.first = first;
        this.second = second;
        this.third = third;
        this.isNegotiator = isNegotiator;
        this.min = min;
        this.max = max;
    }
}
