package com.martina.demo;

import static com.martina.demo.ConsoleColors.*;

public class Mosquito extends Insect{

    public Mosquito(int grumpiness, int strength, int fear, int health,  String character) {
        super(grumpiness, strength,  fear, health, character);
    }
    @Override
    public void appearance() {
        System.out.println(YELLOW_BOLD+"             THE MOSQUITO\n"+
                "                     ,-.\n" +
                "         `._        /  |        ,          STAT\n" +
                "            `--._  ,   '    _,-'           Grumpiness  7\n" +
                "     _       __  `.|  / ,--'               Strength    5\n" +
                "      `-._,-'  `-. \\ : /                   Fear        2\n" +
                "           ,--.-.-`'.'.-.,_-               Health      2\n" +
                "         _ `--'-'-;.'.'-'`--\n" +
                "     _,-' `-.__,-' / : \\\n" +
                "                _,'|  \\ `--._\n" +
                "           _,--'   '   .     `-.\n" +
                "         ,'         \\  |        `\n"+RESET);
    }
}
