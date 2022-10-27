package com.martina.demo;
import static com.martina.demo.ConsoleColors.*;
abstract class Insect {
    private int grumpiness;     // The order of turn is determined by who is most grumpy
    private int strength;       //  affect base damage
    private int fear;            // affect base damage
    private int health;         // game over by 0
    private String character;   // name of character

    @Override
    public String toString() {
        return GREEN_BOLD+
                "Insect Stat>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "\nCharacter=" + character +
                ", Strength=" + strength +
                ", Fear=" + fear +
                ", Health=" + health +
                ", Grumpiness=" + grumpiness +
                "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+RESET;
    }

    public Insect (){

    }  //tom constructor pga interface

    public abstract void appearance();

    public Insect(int grumpiness, int strength, int fear, int health,  String character) {
        this.grumpiness = grumpiness;
        this.strength = strength;
        this.fear = fear;
        this.health = health;
        this.character = character;
    }

    public int getGrumpiness() {
        return grumpiness;
    }

    public void setGrumpiness(int grumpiness) {
        this.grumpiness = grumpiness;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getCharacter() {
        return GREEN_BOLD+character+RESET;
    }

    public void setCharacter(String character) {
        this.character = character;
    }


}
