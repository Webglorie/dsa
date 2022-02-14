package com.dsa.dieetschema.formsubmissions;

import java.util.HashMap;

public class Calorie {
    private double length;
    private double weight;
    private double age;
    private double calcTotal;
    private int gender;
    private int activityLevel;
    private int caloriesTotal;

    public double calculateCalorie(){
        // Man(1) or Woman(2) check
        if (gender == 1){
            calcTotal = 88.362 + (13.397 * weight) + (4.799 * length) - (5.677 * age);
        } else {
            calcTotal = 447.593 + (9.247 * weight) + (3.098 * length) - (4.330 * age);
        }

        //Check activity level and multiply the result of the first calculation by the activity factor
        HashMap<Integer, Double> mapLevels = new HashMap<Integer, Double>();
        mapLevels.put(1, (Double)(1.2));
        mapLevels.put(2, (Double)(1.375));
        mapLevels.put(3, (Double)(1.55));
        mapLevels.put(4, (Double)(1.725));
        mapLevels.put(5, (Double)(1.9));

        double factorCalc = calcTotal * mapLevels.get(activityLevel);

        setCaloriesTotal((int)factorCalc);
        return getCaloriesTotal();
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

    public int getCaloriesTotal() {
        return caloriesTotal;
    }

    public void setCaloriesTotal(int caloriesTotal) {
        this.caloriesTotal = caloriesTotal;
    }
}