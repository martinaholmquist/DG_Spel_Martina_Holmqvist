package com.martina.demo;

public class MAIN {

    public static void main(String[] args) {

        WriteFileSystem writeFileSystem = new WriteFileSystem();
        writeFileSystem.makeFile();
        writeFileSystem.deleteFile();


        Game game = new Game();
        game.calling();



    }
}
