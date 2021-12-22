package com.cacttuseducation_21_22.models;

import java.io.Serializable;

public class Company implements Serializable {

    private int companyImage;
    private String companyName;
    private String companyValue;

    public Company(int companyImage, String companyName, String companyValue) {
        this.companyImage = companyImage;
        this.companyName = companyName;
        this.companyValue = companyValue;
    }

    public int getCompanyImage() {
        return companyImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyValue() {
        return companyValue;
    }
}
