package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String gDadName = reader.readLine();
        Cat gDad = new Cat(gDadName);

        String gMomName = reader.readLine();
        Cat gMom = new Cat(gMomName);

        String dadName = reader.readLine();
        Cat catDad = new Cat(dadName, null, gDad);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, gMom, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catDad);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catDad);

        System.out.println(gDad);
        System.out.println(gMom);
        System.out.println(catDad);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentDad;
        private Cat parentMom;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentMom, Cat parentDad) {
            this.name = name;
            this.parentMom = parentMom;
            this.parentDad = parentDad;
        }

        @Override
        public String toString() {
            String fullname;
            if (parentMom == null)
                fullname = "The cat's name is " + name + ", no mother";
            else
                fullname = "The cat's name is " + name + ", mother is " + parentMom.name;
            if (parentDad == null)
                fullname = fullname + ", no father";
            else
                fullname = fullname + ", father is " + parentDad.name;
            return fullname;
        }
    }

}
