package utils;

import model.User;

import java.io.*;
import java.util.List;

public class RW {
    private static final String fileNameDriver = "driverList.txt";
    private static final String fileNameManager = "managerList.txt";


    public static void writeToFile(List<User> drivers, List<User> managers) throws IOException {
        try {
            ObjectOutputStream objectOutputStream;
            if(drivers != null){
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileNameDriver));
                objectOutputStream.writeObject(drivers);
            }
            else{
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileNameManager));
                objectOutputStream.writeObject(managers);
            }
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readFromFile(String type)throws IOException{
        List<User> users = null;
        try {
            String fileName = type.equals("D") ? fileNameDriver: fileNameManager;
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            users = (List<User>) objectInputStream.readObject();
            objectInputStream.close();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return users;
    }
}
