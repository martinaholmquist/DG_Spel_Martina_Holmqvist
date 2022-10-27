package com.martina.demo;

import static com.martina.demo.ConsoleColors.*;

public class Fly extends Insect{

    public Fly(int grumpiness, int strength,  int fear, int health,  String character) {
        super(grumpiness, strength,  fear, health, character);
    }
    @Override
    public void appearance() {
        System.out.println(RED_BOLD+"                     THE FLY\n"+
                "          _,_              __   __                   STAT\n" +
                "       ._(@I@)_.          /  \\-/  \\                  Grumpiness  4\n" +
                "      .--{___}--.       ._\\   |   /_.                Strength    6\n" +
                "      .-/  Y  \\-.       .__\\__Y__/__.                Fear        2\n" +
                "       /   |   \\           _{___}_                   Health      2\n" +
                "       \\__/-\\__/          ' (@I@) '\n" +
                "                             ~^~\n"+RESET);
    }
}
