package com.martina.demo;

import java.util.ArrayList;
import java.util.Scanner;
import static com.martina.demo.ConsoleColors.*;



public class Player implements ICombat {
    Scanner sc = new Scanner(System.in);
    ArrayList<Human> humans = new ArrayList<>();
    Weapon antihistamine = new Weapon();
    Human player;
    int playerChoice;
    int damagePoints = 0;

    public void welcome() {
        System.out.println(BLUE_BOLD + "         How to play the game." +
                "\nYou will be part of a thrilling experience in the magic of nature." +
                "\nYou choose between three characters with different stats." +
                "\nDuring the game, insects appear, which also have different stats." +
                "\nYou will have to fight but you can also flee, if you don´t have the guts." +
                "\nIf your´re lucky (and the insects not) it may also appear dead ones, " +
                "\nwhich will award you points to buy some Peace and Quiet for in the shop." +
                "\nWhen you have killed all insects you have won the game." +
                "\nGood luck!" + RESET);

    }

    public int selectPlayer() {
        System.out.println("\n                     ========================= ");
        System.out.println("                     |         PLAYER          |");
        System.out.println("                     |   1. Namby Pamby        |");
        System.out.println("                     |   2. Gubbstrutt         |");
        System.out.println("                     |   3. The Love Couple    |");
        System.out.println("                      ========================= ");
        boolean correctChoice = true;
        while (correctChoice) {
            System.out.println("\nPlease indicate your choice of character by selecting numbers 1-3.");
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

        if (playerChoice == 1) {
            appearenceNP();
        } else if (playerChoice == 2) {
            appearenceGS();
        } else if (playerChoice == 3) {
            appearenceTLC();
        }

        boolean Choice = true;
        int answer = 0;
        while (Choice) {
            System.out.println("\nDo you want to continue with this character? \n1. Yes \n2. No");
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
            selectPlayer();
        }
        return playerChoice;
    }

    public void setPlayerChoice(int playerChoice) {
        String name = checkName();

        if (playerChoice == 1) {
            player = new Namby_Pamby(4, 6, 0, 8, 5, 5, 0, 6, 0, 0, name, "Namby_Pamby");
            humans.add(player);  //3

        } else if (playerChoice == 2) {
            player = new GubbStrutt(9, 9, 0, 3, 2, 4, 0, 2, 0, 0, name, "GubbStrutt");
            humans.add(player);  //3,5

        } else if (playerChoice == 3) {
            player = new The_Love_Couple(1, 8, 0, 8, 6, 0, 0, 4, 0, 0, name, "The_Love_Couple");
            humans.add(player);  //4
        }
    }

    public String checkName() {
        boolean namecorrect = true;
        String name = "";
        while (namecorrect) {

            System.out.println("\nPlease enter your name, thanks. ");
            name = sc.next();
            try {
                if (!name.matches("^[a-öA-Ö]+$")) {
                    throw new Exception("\nPlease follow instructions!");
                } else {
                    System.out.println("Lets go " + name.toUpperCase() + "!\n");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Follow instructions please.");
            }
        }
        return name;
    }

    public void setPiontsWin(Player player, TinyAnimals tinyAn) {
        player.player.setDefeatedEnemys(player.player.getDefeatedEnemys() + 1);
        player.player.setStrength(player.player.getStrength() + 1);
        player.player.setAgility(player.player.getAgility() + 1);
        player.player.setHealth(player.player.getHealth() + 1);
        if (player.player.getGrumpiness() > 0) {
            player.player.setGrumpiness(player.player.getGrumpiness() - 1);
        } else {
            System.out.println(player.player.getName() + " is so pleased with itself, no more Grumpiness! ");
        }
        if (player.player.getFear() > 0) {
            player.player.setFear(player.player.getFear() - 1);
        } else {
            System.out.println(player.player.getName() + " is so pleased with itself, no more Fear! ");
        }
        if (player.player.getAllergy() > 0) {
            player.player.setAllergy(player.player.getAllergy() - 1);
        } else {
            System.out.println(player.player.getName() + " allergy is down to 0, congrats! ");
        }
        if (player.player.getAllergyLevel() > 0) {
            player.player.setAllergyLevel(player.player.getAllergyLevel() - 1);
        }
    }

    @Override
    public void setPiontsLost(Player player, TinyAnimals tinyAn) {
        if (player.player.getHealth() == 1 && player.player.getAllergyLevel() > 2) {
            System.out.println(YELLOW_BOLD + "\nOhh dear, I'm sorry to tell you. But you will die. Unless....." +
                    "\nI'll give you a chance to survive, hang in there!" + RESET);
            if (antihistamine.secondChance(player, tinyAn) == true) {
                System.out.println(":-)");
            } else {
                System.out.println(":-(");
            }
        } else {
            player.player.setGrumpiness(player.player.getGrumpiness() + 1);
            player.player.setAllergy(player.player.getAllergy() + 1);
            player.player.setHealth(player.player.getHealth() - 1);
            if (player.player.getStrength() > 0) {
                player.player.setStrength(player.player.getStrength() - 1);
            } else {
                System.out.println(player.player.getName() + " run out of strength, hope you will survive this! ");
            }
            if (player.player.getAgility() > 0) {
                player.player.setAgility(player.player.getAgility() - 1);
            } else {
                System.out.println(player.player.getName() + " run out of agility, hope you will survive this! ");
            }
            if (player.player.getAllergy() > 5) {
                player.player.setAllergyLevel(player.player.getAllergyLevel() + 1);
                System.out.println(RED + player.player.getName() + " your allergy level are increasing, be careful!" + RESET);
            }
        }
    }

    @Override
    public int fightWinLost(Player player, TinyAnimals tinyAn) {
        System.out.println(RED_BOLD + "##########Player won and will be awarded!!##########" + RESET);
        if (player.player.getHealth() >= 9) {
            System.out.println(player.player.getName() + " reached maximum health by defeating " + tinyAn.midge.getCharacter());
            player.player.setDefeatedEnemys(player.player.getDefeatedEnemys() + 1);
        } else {
            setPiontsWin(player, tinyAn);
        }
        tinyAn.setPiontsLost(player, tinyAn);
        return 0;
    }

    @Override
    public int calculateDamage(Player player, TinyAnimals tinyAn) {
        int sum = 0;
        int damagePlayer = 0;

        int pstrength = player.player.getStrength() + player.player.getAgility();
        damagePoints = (int) ((pstrength - player.player.getFear()) / 4 + 1);
        System.out.print(player.player.getName() + " scored " + damagePoints + " hits on " + tinyAn.midge.getCharacter());

        for (int i = 0; i < damagePoints; i++) {
            int resultOfDie = (int) (Math.random() * 4) + 1;
            sum = sum + resultOfDie;
            damagePlayer = damagePlayer + resultOfDie;
        }

        if (player.player.getAllergyLevel() > 2) {
            damagePlayer = damagePlayer / 2;
            System.out.println(RED + "\nOh dear, " + player.player.getName() + RED + " your allergy level is too high, your ability to break some legs only affect half as much." + RESET);
            System.out.println(" and broke " + damagePlayer + " bones on the poor bug");
            return damagePlayer;
        } else {
            System.out.println(" and broke " + damagePlayer + " bones on the poor bug");
        }
        return damagePlayer;
    }

    @Override
    public void fight(Player player, TinyAnimals tinyAn) {
        System.out.println("\nThe most grumpy is " + player.player.getName() + " who is so annoyed by the presence of " + tinyAn.midge.getCharacter() + " and will start the fight.\n");

        if (player.calculateDamage(player, tinyAn) >= tinyAn.calculateDamage(player, tinyAn)) {
            fightWinLost(player, tinyAn);
            if (tinyAn.midge.getHealth() < 1) {
                System.out.println(RED_BOLD + "\nYou took all health from " + tinyAn.midge.getCharacter() + RED_BOLD + ", it's dead." + RESET);
            }
        } else {
            tinyAn.fightWinLost(player, tinyAn);
        }
    }

    @Override
    public void deadPic() {
        System.out.println(RED_BOLD + "\n           PLAYER DEAD!");
        System.out.println("                                (()))\n" +
                "                               /|x x|\n" +
                "                              /\\( - )\n" +
                "                      ___.-._/\\/\n" +
                "                     /=`_'-'-'/  !!\n" +
                "                     |-{-_-_-}     !\n" +
                "                     (-{-_-_-}    !\n" +
                "                      \\{_-_-_}   !\n" +
                "                       }-_-_-}\n" +
                "                       {-_|-_}\n" +
                "                       {-_|_-}\n" +
                "                       {_-|-_}\n" +
                "                       {_-|-_}\n" +
                "                   ____%%@ @%%_______" + RESET);

    }

    public void appearenceNP() {
        System.out.println(
                YELLOW_BOLD + "\n" +
                        "               ,,,,\n" +
                        "             /   '             Namby Pamby is 25 years old and lives at home with his parents. He loves gaming and\n" +
                        "            /.. /              spends all his time behind the screen in his boys room. He have a runny nose and is\n" +
                        "           ( c  D              unfortunately allergic to most things. He is carefree and kind but would do well\n" +
                        "            \\- '\\_             with some fresh air every now and then and also some training sessions.\n" +
                        "             `-'\\)\\\n" +
                        "                |_ \\            STAT\n" +
                        "                |U \\\\          Agility     8\n" +
                        "               (__,//          Grumpiness  4\n" +
                        "               |. \\/           Strength    6\n" +
                        "               LL__I           Health      5\n" +
                        "                |||            Allergy     5\n" +
                        "                |||            Fear        6\n" +
                        "             ,,-``'\\  " + RESET);
    }

    public void appearenceTLC() {
        System.out.println(
                RED_BOLD_BRIGHT + "\n" +
                        "          ///\"\\          The lovebirds can't take their eyes off each other.\n" +
                        "          |6 6|          Their love is strong and can overcome anything.\n" +
                        "          \\ - /          Nothing can get in their way and they will fight for each other til the end.\n" +
                        "   .@@@. __) (__\n" +
                        "   @6 6@/  \\./  \\            STAT\n" +
                        "   @ = @ :  :  : \\           Grumpiness   1\n" +
                        "   _) (_'|  :  |) )          Strength     8\n" +
                        " /' \\./ '\\  :  |_/           Health       6\n" +
                        "/ /\\ _ /\\ \\=o==|)            Allergy      0\n" +
                        "\\ \\ )  (/ /%|%%'             Fear         4\n" +
                        " '7/    \\7%%|%%'             Agility      8\n" +
                        "   |    |`%%|%%'\n" +
                        "   |    |`%%|%%'\n" +
                        "   |    | %%|%%\n" +
                        "   |_.._| /_|_\\" + RESET);


    }

    public void appearenceGS() {
        System.out.println(
                GREEN_BOLD + "\n" +
                        "        .-'--.\n" +
                        "      .'      '.                   GubbStrutt is a real scaly old gator! Always washes his dishes twice in a row,\n" +
                        "     /     _    `-.                swears about increased electricity prices, moans and groans all day long.\n" +
                        "    /      .\\-     \\,  ,           He is a tough oldster, strong as an ox but with failing health.\n" +
                        "   ;       .-|-'    \\####,            And he hate insects.\n" +
                        "   |,       .-|-'    ;####\n" +
                        "  ,##         `     ,|###\"\n" +
                        "#,####, \"#,        ,#|^;#             STAT\n" +
                        "`######  `#####,|##\" |`)|             Grumpiness  9\n" +
                        " `#####    ```o\\`\\o_.| ;\\             Strength    9\n" +
                        "  (-`\\#,    .-'` |`  : `;             Health      2\n" +
                        "  `\\ ;\\#,         \\   \\-'             Allergy     4\n" +
                        "    )( \\#    C,_   \\   ;              Agility     3\n" +
                        "    (_,  \\  /   `'./   |              Fear        2\n" +
                        "      \\  / | .-`'--'`. |\n" +
                        "       | ( \\   ,  /_,  |\n" +
                        "       \\    `   ``     /\n" +
                        "        '-.__     // .'\n" +
                        "             `'`.__.'" + RESET);

    }


}