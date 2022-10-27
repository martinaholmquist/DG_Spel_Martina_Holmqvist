package com.martina.demo;


import static com.martina.demo.ConsoleColors.*;

public class Weapon {
    public boolean secondChance(Player player, TinyAnimals tinyAn) {
        boolean luck = true;

        for (int i = 0; i < 1; i++) {
            int resultOfRandom = (int) (Math.random() * 5) + 1;
            System.out.println(YELLOW_BOLD + "Your lucky number is: " + resultOfRandom);
            if (resultOfRandom > 2) {
                System.out.println("Yes! Your number is a lucky number, congrats! " + RESET +
                        RED_BOLD + "\nHere you have som antihistamine, enjoy and get well.");
                System.out.println(".     |___________________________________\n" +
                        "|-----|- - -|''''|''''|''''|''''|''''|'##\\|__\n" +
                        "|- -  |  cc 6    5    4    3    2    1 ### __]==----------------------\n" +
                        "|-----|________________________________##/|\n" +
                        "'     |\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"`" + RESET);

                player.player.setAllergyLevel(0);
                player.player.setAllergy(3);
                player.player.setStrength(7);
                player.player.setAgility(7);
                player.player.setHealth(2);
                player.player.setAntihistamine(player.player.getAntihistamine() + 1);
                luck = true;
            } else {
                System.out.println(YELLOW_BOLD + "Im sorry, your number is not a lucky number....you´re out of luck\n"
                        + tinyAn.midge.getCharacter() + YELLOW_BOLD + " will take you down..." + RESET);
                player.player.setGrumpiness(player.player.getGrumpiness() + 1);
                player.player.setAllergy(player.player.getAllergy() + 1);
                player.player.setHealth(player.player.getHealth() - 1);
                if (player.player.getStrength() > 0) {
                    player.player.setStrength(player.player.getStrength() - 1);
                }
                if (player.player.getAgility() > 0) {
                    player.player.setAgility(player.player.getAgility() - 1);
                }
                if (player.player.getAllergy() > 5) {
                    player.player.setAllergyLevel(player.player.getAllergyLevel() + 1);
                }
                luck = false;
            }
        }
        return luck;
    }

}
