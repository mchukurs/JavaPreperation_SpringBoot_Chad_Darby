package com.chukurs.mvcthymeleaf.model;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String programmingLanguage;
private String operatingSystems;
    public Student() {
    };

    public String getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
