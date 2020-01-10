package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("C:\\temp\\text.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            Human ivanov2 = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
//            System.out.println(somePerson.name + " "
//                            + somePerson.assets.get(0).getName()
//                            + " "
//                            + somePerson.assets.get(0).getPrice()
//                    );

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (name != null) {
                outputStream.write((name + "\n").getBytes());
            } else {
                outputStream.write("\n".getBytes());
            }
            if (assets == null) {
                outputStream.write("assets:null\n".getBytes());
            } else if (assets.isEmpty()) {
                outputStream.write("assets:empty\n".getBytes());
            } else {
                outputStream.write("assets:yes\n".getBytes());
                for (Asset asset :
                        assets) {
                    outputStream.write((asset.getName() + " : " + asset.getPrice() + "\n").getBytes());
                }
            }
            outputStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int i = 0;
            String assetsStatus = null;
            while (reader.ready()){
                String buff = reader.readLine();
//                System.out.println("load : " + buff);
                if (i == 0)
                    name = buff;
                if (i == 1)
                    assetsStatus = buff;
                if (i > 1){
                    switch (assetsStatus.trim()){
                        case ("assets:null") :
                            assets = null;
                            break;
                        case ("assets:empty") :
                            assets = new ArrayList<>();
                            break;
                        case ("assets:yes") :
                            if (assets == null) assets = new ArrayList<>();
                            assets.add(new Asset(buff.split(" : ")[0], Double.parseDouble(buff.split(" : ")[1])));
                            break;
                    }
                }
                i++;
            }
        }
    }
}
