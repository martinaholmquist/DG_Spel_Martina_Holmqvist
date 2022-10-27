package com.martina.demo;

import static com.martina.demo.ConsoleColors.*;

public class Ant extends Insect{

    public Ant(int grumpiness, int strength, int fear, int health,  String character) {
        super(grumpiness, strength, fear, health, character);
    }
    @Override
    public void appearance() {
        System.out.println(GREEN_BOLD+"               THE ANT\n"+
                " \\       /\n" +
                "  \\     /                                     STAT\n" +
                "   \\.-./                                      Grumpiness  6\n" +
                "  (o\\^/o)  _   _   _     __                   Strength    8\n" +
                "   ./ \\.\\ ( )-( )-( ) .-'  '-.                Fear        2\n" +
                "    {-} \\(//  ||   \\\\/ (   )) '-.             Health      2\n" +
                "         //-__||__.-\\\\.       .-'\n" +
                "        (/    ()     \\)'-._.-'\n" +
                "        ||    ||      \\\\\n" +
                "        ('    ('       ')"+RESET);
    }
}
