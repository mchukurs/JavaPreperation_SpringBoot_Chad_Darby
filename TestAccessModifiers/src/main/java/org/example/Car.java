package org.example;

public class Car {
    public final String publicBrand;
    private int privateGear;
    protected boolean protectedAvailable;
    int defaultMaxSpeed;

    public Car(String publicBrand) {
        this.publicBrand = publicBrand;
    }
}
