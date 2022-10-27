package com.martina.demo;
import java.io.*;
import static com.martina.demo.ConsoleColors.*;

public class WriteFileSystem {

    public void makeFile() {
        try {
            File testFile = new File("filename.txt");

            if (testFile.createNewFile()) {
                System.out.println("File created: " + testFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void addToFile(Player player, TinyAnimals tinyAn){

        try {
            String content = GREEN_BOLD+"\nEnjoy some statistic!"+RESET;

            FileWriter fileWriter = new FileWriter("filename.txt", true);

            fileWriter.write(content);

            fileWriter.write("\nName: "+ player.player.getName());
            fileWriter.write("\nCharacter: "+ player.player.getcharacter());
            fileWriter.write("\nDefeated enemy's: "+ player.player.getDefeatedEnemys());
            fileWriter.write("\nHealth :"+player.player.getHealth());
            fileWriter.write("\nPeaceAndQuiet: "+ player.player.getPeaceAndQuiet());
            fileWriter.write("\nAntihistamine: "+ player.player.getAntihistamine()+"\n");

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile3(){
        try {
            FileReader reader = new FileReader("filename.txt");
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(){
        File myObj = new File("filename.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }


}
