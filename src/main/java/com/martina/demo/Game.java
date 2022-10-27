package com.martina.demo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import static com.martina.demo.ConsoleColors.*;

public class Game {
    Scanner sc = new Scanner(System.in);
    Player player = new Player();
    TinyAnimals tinyAn = new TinyAnimals();
    WriteFileSystem writeFileSystem = new WriteFileSystem();
    Shop shop = new Shop();
    boolean backToMain = true;
    boolean run = true;

    public void calling() {
        while (backToMain) {
            menuSwitchNrOne(menuNrOne());
        }
    }

    public int menuNrOne() {
        int userChoice = 0;
        boolean isInt = true;

        while (isInt) {
            System.out.println(PURPLE_BOLD + "\n    Welcome to the game   " +
                    "\n***THE LIFE OF AN INSECT***     " + RESET

                    + "\n1: Play the game"
                    + "\n2: See statistics"
                    + "\n3: Run JUnit test"
                    + "\n0: Exit program");
            System.out.print("Make a choice: \n");

            if (sc.hasNextInt()) {
                userChoice = sc.nextInt();
                if (userChoice < 4) {
                    break;
                } else {
                    System.out.println("\nSelect an integer between 0-3");
                }
            } else {
                System.out.println("\nSelect an integer");
                sc.next();
            }
        }
        return userChoice;
    }

    public void menuSwitchNrOne(int userChoice) {
        boolean testing = true;
        while (testing) {
            switch (userChoice) {
                case 1:
                    tinyAn.createInsects();
                    player.welcome();
                    player.setPlayerChoice(player.selectPlayer());
                    tinyAn.publicInsect();
                    battle(player, tinyAn);
                    writeFileSystem.addToFile(player, tinyAn);
                    testing = false;
                    break;
                case 2:
                    if (player.player == null) {
                        System.out.println("No statistic to show.");
                        testing = false;
                    } else {
                        writeFileSystem.readFile3();
                        testing = false;
                    }
                    break;
                case 3:
                    System.out.println("JUnit test will start.");
                    Result result = JUnitCore.runClasses(Tests.class);
                    for (Failure failure : result.getFailures()) {
                        System.out.println(failure.toString());
                    }
                    if (result.wasSuccessful()) {
                        System.out.println("___________________________________________");
                        System.out.println("\nJUnit result is " + result.wasSuccessful());
                    } else {
                        System.out.println("___________________________________________");
                        System.out.println("\nJUnit result is " + result.wasSuccessful());
                    }
                    testing = false;
                    backToMain = false;
                    break;
                case 0:
                    System.out.println("Thank you for using my App ");
                    testing = false;
                    backToMain = false;
                    break;
                default:
                    System.out.println("Wrong input! ");
            }
        }
    }

    public void randomInsect(Player player, TinyAnimals tinyAn) {
        int randomIndex = (int) (Math.random() * tinyAn.insects.size());
        System.out.println(YELLOW_BOLD + "\nOopsy Daisy! A small bug has randomly appeared near you! \n" + RESET + tinyAn.insects.get(randomIndex));

        if (randomIndex == 0) {
            tinyAn.midge = tinyAn.insects.get(0);
            if (tinyAn.midge.getHealth() < 1) {
                System.out.println(RED_BOLD + "Uh-oh! Here lies a dead bug! Lucky for you! " +
                        "\nBoth undisturbedness and a 1 Peace And Quiet (point) are awarded to you. " +
                        "\nVisit the Garden to enjoy." + RESET);
                player.player.setPeaceAndQuiet(player.player.getPeaceAndQuiet() + 1);
                randomInsect(player, tinyAn);
            }

        } else if (randomIndex == 1) {
            tinyAn.midge = tinyAn.insects.get(1);
            if (tinyAn.midge.getHealth() < 1) {
                System.out.println(RED_BOLD +
                        "Uh-oh! Here lies a dead bug! Lucky for you!" +
                        "\nBoth undisturbedness and a 1 Peace And Quiet point are awarded to you." +
                        "\nVisit the Garden to enjoy." + RESET);
                player.player.setPeaceAndQuiet(player.player.getPeaceAndQuiet() + 1);
                randomInsect(player, tinyAn);
            }

        } else if (randomIndex == 2) {
            tinyAn.midge = tinyAn.insects.get(2);
            if (tinyAn.midge.getHealth() < 1) {
                System.out.println(RED_BOLD + "Uh-oh! Here lies a dead bug! Lucky for you!" +
                        "\nBoth undisturbedness and a 1 Peace And Quiet point are awarded to you." +
                        "\nVisit the Garden to enjoy." + RESET);
                player.player.setPeaceAndQuiet(player.player.getPeaceAndQuiet() + 1);
                randomInsect(player, tinyAn);
            }
        }
    }

    public void battle(Player player, TinyAnimals tinyAn) {
        run = true;
        while (run) {
            if (tinyAn.insects.get(0).getHealth() < 1 && tinyAn.insects.get(1).getHealth() < 1 && tinyAn.insects.get(2).getHealth() < 1) {
                tinyAn.deadPic();
                run = false;
            } else if (player.player.getHealth() < 1) {
                player.deadPic();
                run = false;
            } else {
                randomInsect(player, tinyAn);
                FleeOrFightSwitch(menuFleeOrFight(player, tinyAn), player, tinyAn);
            }
        }
    }

    public void Fight1(Player player, TinyAnimals tinyAn) {
        if (player.player.getGrumpiness() >= tinyAn.midge.getGrumpiness()) { //player wins with equal
            player.fight(player, tinyAn);
        } else {
            tinyAn.fight(player, tinyAn);
        }
    }

    public int menuFleeOrFight(Player player, TinyAnimals tinyAn) {
        int userChoiceNo = 0;
        boolean isInt = true;
        while (isInt) {
            System.out.println(player.player.getName() + ", you have the opportunity to fight, flee or visit the Garden, please make a choice:" +
                    "\n1: Fight" +
                    "\n2: Flee" +
                    "\n3: Visit the Garden" +
                    "\n4: See stats" +
                    "\n0: Back to start");

            if (sc.hasNextInt()) {
                userChoiceNo = sc.nextInt();
                if (userChoiceNo == 0 || userChoiceNo == 1 || userChoiceNo == 2 || userChoiceNo == 3 || userChoiceNo == 4) {
                    break;
                } else {
                    System.out.println("\nSelect an integer between 1-4");
                }
            } else {
                System.out.println("\nSelect an integer");
                sc.next();
            }
        }
        return userChoiceNo;
    }

    public void FleeOrFightSwitch(int userChoiceNo, Player player, TinyAnimals tinyAn) {
        switch (userChoiceNo) {
            case 1:
                System.out.println(CYAN_BOLD + CYAN_UNDERLINED + "()()()()()()()()()()   OK, LET'S FIGHT!   ()()()()()()()()()()" + RESET);
                Fight1(player, tinyAn);
                break;

            case 2:
                System.out.println(CYAN_BOLD + CYAN_UNDERLINED + "()()()()()()()()()()   TRY TO FLEE!   ()()()()()()()()()()" + RESET);
                System.out.println(GREEN + "You're a coward! ");

                int chance = player.player.getAgility() * 10;
                int result = (int) (Math.random() * 100) + 1;

                if (result <= chance) {
                    System.out.println("you manage to get away " + tinyAn.midge.getCharacter() + GREEN + " and lost some agility, but be aware......!" + RESET);
                    if (player.player.getAgility() > 0) {
                        player.player.setAgility(player.player.getAgility() - 1);
                    }
                    battle(player, tinyAn);
                } else {
                    System.out.println(GREEN + "But to no avail, you have to stay and fight " + tinyAn.midge.getCharacter() + RESET);
                    Fight1(player, tinyAn);
                }
                break;

            case 3:
                System.out.println("Visit the Garden");
                shop.menuShop(player, tinyAn, shop.shop(player, tinyAn));
                break;

            case 4:
                showStats(player, tinyAn);
                break;

            case 0:
                System.out.println("Back to start");
                run = false;
                calling();
                break;
        }
    }

    public void showStats(Player player, TinyAnimals tinyAn) {
        System.out.println(player.player.toString());
        FleeOrFightSwitch(menuFleeOrFight(player, tinyAn), player, tinyAn);
    }


}
