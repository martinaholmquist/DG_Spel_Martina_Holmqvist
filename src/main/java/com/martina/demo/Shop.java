package com.martina.demo;

import java.util.*;
import static com.martina.demo.ConsoleColors.*;

public class Shop {

    Scanner sc = new Scanner(System.in);

    public int shop(Player player, TinyAnimals tinyAn) {
        System.out.println(YELLOW_BOLD_BRIGHT + "\nWelcome! \n" +
                "So, " + player.player.getName() + YELLOW_BOLD_BRIGHT +" you've earned some Peace And Quiet " + "from "+tinyAn.midge.getCharacter()+
                YELLOW_BOLD_BRIGHT +"\nYou currently have " +RED_BOLD + player.player.getPeaceAndQuiet() +RESET+ YELLOW_BOLD_BRIGHT +" Peace And Quiet (points).");

        int userChoice = 0;
        boolean isInt = true;
        while (isInt) {
            System.out.println("\nChoose as below."
                    + "\n- Please enter how many Peace And Quiet (points) you wish to enjoy"
                    + "\n- Enter 0 if you change your mind, lets go back");
            System.out.print("Make a choice: \n");

            if (sc.hasNextInt()) {
                userChoice = sc.nextInt();
                if (userChoice >= 0 && userChoice <= player.player.getPeaceAndQuiet()) {
                    isInt = false;
                } else {
                    System.out.println("\nSelect a valid choice");
                }
            } else {
                System.out.println("\nSelect an integer" + RESET);
                sc.next();
            }
        }
        return userChoice;
    }

    public void menuShop(Player player, TinyAnimals tinyAn, int userChoice) {
        Game game = new Game();
        if (userChoice > 0 && player.player.getHealth()<9) {
            player.player.setStrength(player.player.getStrength() + userChoice);
            player.player.setAgility(player.player.getAgility() + userChoice);
            player.player.setHealth(player.player.getHealth() + userChoice);
            player.player.setPeaceAndQuiet(player.player.getPeaceAndQuiet() - userChoice);

            if (player.player.getGrumpiness() > userChoice) {
                player.player.setGrumpiness(player.player.getGrumpiness() - userChoice);
            } else {
                player.player.setGrumpiness(0);
                System.out.println(player.player.getName()+ " is so pleased with itself, no more Grumpiness! ");
            }
            if (player.player.getFear() > userChoice) {
                player.player.setFear(player.player.getFear() - userChoice);
            } else {
                player.player.setFear(0);
                System.out.println(player.player.getName()+" is so pleased with itself, no more Fear! ");
            }
            if (player.player.getAllergy() > userChoice) {
                player.player.setAllergy(player.player.getAllergy() - userChoice);
            } else {
                player.player.setAllergy(0);
                System.out.println(player.player.getName()+" allergy is down to 0, congrats! ");
            }
            if (player.player.getAllergy() > 5) {
                player.player.setAllergyLevel(player.player.getAllergyLevel() - 1);
            }
            enjoyPic();
            System.out.println(player.player.toString());
            game.FleeOrFightSwitch(game.menuFleeOrFight(player, tinyAn), player, tinyAn);
        } else if(userChoice > 0 && player.player.getHealth()>8) {
            System.out.println(YELLOW_BOLD_BRIGHT + "You have reached maximum level of health!" + RESET);
            enjoyPic();
            game.FleeOrFightSwitch(game.menuFleeOrFight(player, tinyAn), player, tinyAn);
        }
        else {
            System.out.println(YELLOW_BOLD_BRIGHT + "Lets go back" + RESET);
            game.FleeOrFightSwitch(game.menuFleeOrFight(player, tinyAn), player, tinyAn);
        }
    }

    public void enjoyPic(){
        System.out.println("Stay and enjoy some Peace and Quiet" + RESET);
        System.out.println(PURPLE_BOLD_BRIGHT +
                "      _.od8888888bo._\n" +
                "     .dP\"'   @#@   '\"Yb.\n" +
                "   .d\"'      #@#      '\"b.\n" +
                "  d\"'        @#@        '\"b\n" +
                " d'          #@#          'b\n" +
                "dP           @#@           Yb\n" +
                "8l          oDWBo          l8\n" +
                "Yb        o@#@B@#@o        dP\n" +
                " YI     o@#* #P# *#@o     IP\n" +
                "  YI  o@#*   @#@   *#@o  IP\n" +
                "   \"9@#*     #@#     *#@P\"\n" +
                "     \"8b     @#@     d8\"\n" +
                "       `\"Y888888888P\"`" + RESET);
    }


}

