package com.dsa.dieetschema.controllers;//Class that performs all calculations for the Diet Plan application


import java.text.DecimalFormat;
import java.util.HashMap;

public class calculatorController {
    private double bmiTotal, calcTotal;
    private int caloriesTotal;

    // Calculating Body mass index via standard method
    public double calculateBMI(int gender, int age, double length, double weight){
        setBmiTotal((weight) / (length * length) * 10000);

        bmiLogs(gender, age, getBmiTotal());
        return getBmiTotal();
    }

    // Calculating energy expenditure via Harris and Benedict formula
    public int calculateCals(int gender, double age, double length, double weight, int activityLevel){
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
    public void makeScheme(int weight, int targetWeight, int dailyCals){
        double weightKgToG = weight * 16;
        double wordenKG = targetWeight * 16;

        int totalLoseKgs = weight - targetWeight;

        double calcDays = (weightKgToG - wordenKG) / 7;
        double weeklyLoss = totalLoseKgs / calcDays;

        DecimalFormat df1 = new DecimalFormat("#");
        DecimalFormat df2 = new DecimalFormat("#.#");

        double d = Double.parseDouble(df1.format(calcDays));
        double startWeight = weight;
        for (int i = 1;i <= d;i++){
            System.out.println("Week " + i);
            double calcWeeklyWeight = startWeight - weeklyLoss;
            startWeight = calcWeeklyWeight;
            System.out.println("Gewicht nu: " + df2.format(calcWeeklyWeight));
            System.out.println("BMI Nu: " + df2.format(calculateBMI(1, 25,180, calcWeeklyWeight)));
        }

        System.out.println("Totaal te verliezen KGs: " + totalLoseKgs);
        System.out.println("Totaal weken om dit gewicht te verliezen: " + calcDays);
        System.out.println("Per week verliest in kgs: " + weeklyLoss);

    }


    // Adds BMI log about visitor input and result
    public void bmiLogs(int gender, int age,double bmi){

    }

    public int getCaloriesTotal() {
        return caloriesTotal;
    }

    public void setCaloriesTotal(int caloriesTotal) {
        this.caloriesTotal = caloriesTotal;
    }

    public double getBmiTotal() {
        return bmiTotal;
    }

    public void setBmiTotal(double bmiTotal) {
        this.bmiTotal = bmiTotal;
    }
}
