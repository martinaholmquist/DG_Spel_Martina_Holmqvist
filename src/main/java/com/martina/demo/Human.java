package com.martina.demo;

import static com.martina.demo.ConsoleColors.*;

public class Human {
    private int grumpiness;      // The order of turn is determined by who is most grumpy
    private int strength;        //  affect base damage
    private int peaceAndQuiet;   // currency to buy points that affect base damage and health
    private int agility;        // affects chance to flee as well as base damage
    private int health;         // game over by 0
    private int allergy;       //  allergy over 5 effects allergy level by 1
    private int allergyLevel; // allergy level over 2 affects base damage/2
    private int fear;          // affect base damage
    private int defeatedEnemys;         //how many defeated enemy's
    private int antihistamine;         // will give player extra life and som stat
    private String character;         // name of character
    public String name;             // name of player

    public Human(int grumpiness, int strength, int peaceAndQuiet, int agility, int health, int allergy, int allergyLevel, int fear, int defeatedEnemys,int antihistamine,  String name, String character) {
        this.grumpiness = grumpiness;
        this.strength = strength;
        this.peaceAndQuiet = peaceAndQuiet;
        this.agility = agility;
        this.health = health;
        this.allergy = allergy;
        this.allergyLevel = allergyLevel;
        this.fear = fear;
        this.defeatedEnemys = defeatedEnemys;
        this.antihistamine =antihistamine;
        this.name = name;
        this.character = character;
    }


    @Override
    public String toString() {
        return PURPLE_BOLD +
                "Player Stat**************************************************************" +
                "\ncharacter=" + character +
                ", grumpiness=" + grumpiness +
                ", strength=" + strength +
                ", peaceAndQuiet=" + peaceAndQuiet +
                "\nagility=" + agility +
                ", health=" + health +
                ", allergy=" + allergy +
                ", allergyLevel=" + allergyLevel +
                ", fear=" + fear +
                ", player name='" + name + '\'' +
                "\n*************************************************************************" + RESET;
    }

    public String getcharacter() {
        return BLUE_BOLD+character+RESET;
    }

    public void setGrumpiness(String character) {
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
    public int getPeaceAndQuiet() {
        return peaceAndQuiet;
    }
    public void setPeaceAndQuiet(int peaceAndQuiet) {
        this.peaceAndQuiet = peaceAndQuiet;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getAllergy() {
        return allergy;
    }
    public void setAllergy(int allergy) {
        this.allergy = allergy;
    }
    public int getAllergyLevel() {
        return allergyLevel;
    }
    public void setAllergyLevel(int allergyLevel) {
        this.allergyLevel = allergyLevel;
    }

    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }
    public String getName() {
        return BLUE_BOLD+name+RESET;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getDefeatedEnemys() {
        return defeatedEnemys;
    }
    public void setDefeatedEnemys(int defeatedEnemys) {
        this.defeatedEnemys = defeatedEnemys;
    }
    public int getAntihistamine() {
        return antihistamine;
    }
    public void setAntihistamine(int antihistamine) {
        this.antihistamine = antihistamine;
    }
}
