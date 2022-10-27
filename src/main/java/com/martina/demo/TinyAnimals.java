package com.martina.demo;

import java.util.ArrayList;
import java.util.Scanner;
import static com.martina.demo.ConsoleColors.*;

public class TinyAnimals implements ICombat {

    ArrayList<Insect> insects = new ArrayList<>();
    Insect midge;
    Scanner sc = new Scanner(System.in);
    int damagePoints = 0;

    public void createInsects() {
        insects.clear();
        midge = new Mosquito(7, 5, 2, 2, "Mosquito");
        insects.add(midge);//3

        midge = new Fly(4, 6, 2, 2, "Fly");
        insects.add(midge); //3,5

        midge = new Ant(6, 8, 2, 2, "Ant");
        insects.add(midge);//4
    }

    public void publicInsect() {
        int playerChoice = 0;
        System.out.println("Below you will find an opportunity to familiarize yourself with the small, innocent insects " +
                "\nthat may randomly appear dead or alive in your surrounding.");
        System.out.println("                      ========================= ");
        System.out.println("                     |         Insect          |");
        System.out.println("                     |   1. Mosquito           |");
        System.out.println("                     |   2. Fly                |");
        System.out.println("                     |   3. Ant                |");
        System.out.println("                      ========================= ");
        boolean correctChoice = true;
        while (correctChoice) {
            System.out.println("\nPlease make a choice between 1-3?");
            if (sc.hasNextInt()) {
                playerChoice = sc.nextInt();
                if (playerChoice > 0 && playerChoice < 4) {
                    break;
                } else {
                    System.out.println("\nPlease follow instructions!");
                }
            } else {
                System.out.println("\nTry again, please!");
                sc.next();
            }
        }

        switch (playerChoice) {
            case 1:
                insects.get(0).appearance();
                break;
            case 2:
                insects.get(1).appearance();
                break;
            case 3:
                insects.get(2).appearance();
                break;

        }
        boolean Choice = true;
        int answer = 0;
        while (Choice) {
            System.out.println("\nDo you want to continue playing or se another insect? \n1. Start gaming! \n2. See some more bugs");
            if (sc.hasNextInt()) {
                answer = sc.nextInt();
                if (answer == 1 || answer == 2) {
                    break;
                } else {
                    System.out.println("\nPlease follow instructions!");
                }
            } else {
                System.out.println("\nTry again, please!");
                sc.next();
            }
        }
        if (answer == 2) {
            System.out.println("OK, lets see another insect");
            publicInsect();
        } else if (answer == 1) {
            System.out.println(RED_BOLD +
                    "\n¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤" +
                    "\nLETS START GAMING!" +
                    "\n¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤" + RESET);
            Choice = false;
        }
    }

    @Override
    public void setPiontsWin(Player player, TinyAnimals tinyAn) {
        tinyAn.midge.setHealth(tinyAn.midge.getHealth() + 1);
        tinyAn.midge.setStrength(tinyAn.midge.getStrength() + 1);
        if (tinyAn.midge.getGrumpiness() > 0) {
            tinyAn.midge.setGrumpiness(tinyAn.midge.getGrumpiness() - 1);
        } else {
            System.out.println(tinyAn.midge.getCharacter() + " is so pleased with itself, no more Grumpiness! ");
        }
        if (tinyAn.midge.getFear() > 0) {
            tinyAn.midge.setFear(tinyAn.midge.getFear() - 1);
        } else {
            System.out.println(tinyAn.midge.getCharacter() + " is so pleased with itself, no more Fear! ");
        }

    }

    public void setPiontsLost(Player player, TinyAnimals tinyAn) {
        tinyAn.midge.setGrumpiness(tinyAn.midge.getGrumpiness() + 1);
        tinyAn.midge.setHealth(tinyAn.midge.getHealth() - 1);
        if (tinyAn.midge.getStrength() > 0) {
            tinyAn.midge.setStrength(tinyAn.midge.getStrength() - 1);
        } else {
            System.out.println(tinyAn.midge.getCharacter() + " run out of strength! ");
        }
    }

    @Override
    public int fightWinLost(Player player, TinyAnimals tinyAn) {
        System.out.println(YELLOW_BOLD + "¤¤¤¤¤¤¤¤¤¤Midge won and will be awarded!!¤¤¤¤¤¤¤¤¤¤" + RESET);
        if (tinyAn.midge.getHealth() >= 5) {
            System.out.println(tinyAn.midge.getCharacter() + " reached maximum health by defeating " + player.player.getName());
        } else {
            setPiontsWin(player, tinyAn);
        }
        player.setPiontsLost(player, tinyAn);
        return player.player.getAllergyLevel();
    }

    @Override
    public int calculateDamage(Player player, TinyAnimals tinyAn) {
        int sum = 0;
        int damageMidge = 0;

        int mstrength = tinyAn.midge.getStrength() + tinyAn.midge.getStrength();
        damagePoints = ((mstrength - tinyAn.midge.getFear()) / 4 + 1);
        System.out.print(tinyAn.midge.getCharacter() + " scored " + damagePoints + " hits on " + player.player.getName());

        for (int i = 0; i < damagePoints; i++) {
            int resultOfDie = (int) (Math.random() * 4) + 1;
            sum = sum + resultOfDie;
            damageMidge = damageMidge + resultOfDie;
        }
        System.out.println(" and bit or stung " + damageMidge + " times");
        return damageMidge;
    }

    @Override
    public void fight(Player player, TinyAnimals tinyAn) {
        System.out.println("The most grumpy is " + tinyAn.midge.getCharacter() + " who just wanna get rid of " + player.player.getName() +
                " and will start the fight.\n");
        if (tinyAn.calculateDamage(player, tinyAn) <= player.calculateDamage(player, tinyAn)) { //player wins with equal
            player.fightWinLost(player, tinyAn);
            if (tinyAn.midge.getHealth() < 1) {
                System.out.println(RED_BOLD + "You took all health from " + tinyAn.midge.getCharacter() + RED_BOLD + ", it's dead." + RESET);
            }
        } else {
            tinyAn.fightWinLost(player, tinyAn);
        }
    }

    @Override
    public void deadPic() {
        System.out.println(RED_BOLD + "\nALL INSECTS DEAD");
        System.out.println("   |         J\n" +
                "   |         J\n" +
                "   |         J\n" +
                "   |         J\n" +
                "   |         |\n" +
                "   F         |\n" +
                "   F        \\J \n" +
                "   F         7\n" +
                "  J          ;:. \n" +
                " /   .        ::::... \n" +
                "J   :             \"\"::::... \n" +
                "F   `                    \":::\"-..___ \n" +
                "J        ___.....____            `\"F \n" +
                " \"\"----\"\"            \"\"\"----\"\"\"---'\n" +
                "              _\n" +
                "         ,()-(_>\n" +
                "          '//'\\" + RESET);
    }


}


