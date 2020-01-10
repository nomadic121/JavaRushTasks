package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {

    abstract public void getRightCup();

    abstract public void putIngredient();

    abstract public void pour();

    public void makeDrink() {
        this.getRightCup();
        this.putIngredient();
        this.pour();
    }

}
