package com.dsa.dieetschema.formsubmissions;

import java.util.HashMap;

public class Bmi {
    private double length;
    private double weight;
    private double age;
    private double bmiTotal;

    public double calculateBMI(){
        setBmiTotal((weight) / (length * length) * 10000);

        return getBmiTotal();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getBmiTotal() {
        return bmiTotal;
    }

    public void setBmiTotal(double bmiTotal) {
        this.bmiTotal = bmiTotal;
    }
}