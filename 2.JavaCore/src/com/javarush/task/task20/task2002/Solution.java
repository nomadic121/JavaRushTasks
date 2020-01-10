package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User usr = new User();
            usr.setFirstName("FName");
            usr.setLastName("LName");
            usr.setBirthDate(new Date());
            usr.setMale(true);
            usr.setCountry(User.Country.OTHER);
            javaRush.users.add(usr);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (users == null) {
                outputStream.write("users:null\n".getBytes());
            } else if (users.isEmpty()) {
                outputStream.write("users:empty\n".getBytes());
            } else {
                outputStream.write("users:yes\n".getBytes());
                for (User user :
                        users) {
                    outputStream.write((
                            user.getFirstName()
                                    + " : "
                                    + user.getLastName()
                                    + " : "
                                    + Long.toString(user.getBirthDate().getTime())
                                    + " : "
                                    + Boolean.toString(user.isMale())
                                    + " : "
                                    + user.getCountry().toString()
                                    + "\n").getBytes());
                }
            }
            outputStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int i = 0;
            String usersStatus = null;
            while (reader.ready()){
                String buff = reader.readLine();
//                System.out.println("load : " + buff);
                if (i == 0)
                    usersStatus = buff;
                if (i > 0){
                    switch (usersStatus.trim()){
                        case ("users:null") :
                            users = null;
                            break;
                        case ("users:empty") :
                            users = new ArrayList<>();
                            break;
                        case ("users:yes") :
                            if (users == null) users = new ArrayList<>();
                            String[] loadedUser = buff.split(" : ");
                            User usr = new User();
                            usr.setFirstName(loadedUser[0]);
                            usr.setLastName(loadedUser[1]);
                            usr.setBirthDate(new Date(Long.parseLong(loadedUser[2])));
                            usr.setMale(Boolean.parseBoolean(loadedUser[3]));
                            usr.setCountry(User.Country.valueOf(loadedUser[4]));
                            users.add(usr);
                            break;
                    }
                }
                i++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
