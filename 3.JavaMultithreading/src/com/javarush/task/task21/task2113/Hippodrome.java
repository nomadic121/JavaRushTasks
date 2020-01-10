package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run () throws Exception{
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move () {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print () {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    public Horse getWinner () {
        Horse result;
        if (horses != null) {
            result = horses.get(0);
            for (Horse horse : horses) {
                result = result.getDistance() > horse.getDistance() ? result : horse;
            }
        } else {
            return null;
        }
        return result;
    }

    public void printWinner() {
//        System.out.printf ("Winner is %n!", getWinner().getName());
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws Exception {

        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(new Horse("Lucky", 3, 0));
        game.getHorses().add(new Horse("Old Nag", 3, 0));
        game.getHorses().add(new Horse("Demon", 3, 0));
        game.run();
        game.printWinner();

    }
}
