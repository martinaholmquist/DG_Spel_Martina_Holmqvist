package com.martina.demo;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLOutput;

import static com.martina.demo.ConsoleColors.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
          /*      Har 3 @Test som kollar:
            • Kolla om spelaren kan gå upp i level
            • Kolla om spelaren kan ‘förlora’
            • Kolla om skadan är lika mycket som spelaren KAN skada */

    Game game = new Game();
    Player player = new Player();
    TinyAnimals tinyAn = new TinyAnimals();


    @Test
    @DisplayName(RED_BOLD+"jUnitTestCheckFleeFunktion"+RESET)
    public void checkFlee() {
        System.out.println(RED_BOLD+"Test flee funktion" +RESET);
        player.player = new GubbStrutt(9, 7, 0, 4, 2, 4, 0, 3,0, 0,"TestTina", "GubbStrutt");
        int chance = player.player.getAgility() * 10;
        int result = (int) (Math.random() * 120) + 1;
        int randomForTest1 = 41;
        int randomForTest2 = 39;

        assertNotNull(player);
        assertEquals(4, player.player.getAgility());
        assertEquals(40, chance);
        assertTrue(result > 0 && result < 121, "Random is between 1-120, the no is: " + result);
        assertTrue(randomForTest1 > chance, "Random: " + randomForTest1 + " is higher than agility*10: " + chance);
        assertTrue(randomForTest2 < chance, "Random" + randomForTest2 + " is lower than agility*10: " + chance);
    }

    @org.junit.Test
    public void testLevelUp() {
        System.out.println(RED_BOLD+"Test player allergyLevel up"+RESET);
        player.player = new Namby_Pamby(4, 4, 0, 10, 2, 7, 2, 6,0, 0,"TestTina", "Namby_Pamby");
        tinyAn.midge = new Mosquito(7, 5, 2, 2, "Mosquito");
        player.humans.add(player.player);
        tinyAn.insects.add(tinyAn.midge);
        assertNotNull(player);
        assertNotNull(tinyAn);
        assertEquals(3, tinyAn.fightWinLost(player, tinyAn));
    }

    @org.junit.Test
    public void damageCheckEqualPlayerMidge() {

        System.out.println(RED_BOLD+"Test damagePoints equal player & midge by running methods"+RESET);
        player.player = new GubbStrutt(9, 7, 0, 4, 2, 4, 0, 3,0,  0,"TestTina", "GubbStrutt");
        tinyAn.midge = new Mosquito(7, 5, 2, 2, "Mosquito");
        player.humans.add(player.player);
        tinyAn.insects.add(tinyAn.midge);
        assertNotNull(player);
        assertNotNull(tinyAn);
        player.calculateDamage(player, tinyAn);   //check by running method
        tinyAn.calculateDamage(player, tinyAn);     //check by running method
        assertEquals(player.damagePoints, tinyAn.damagePoints);
    }

    @org.junit.Test
    public void damageCheckEqualPlayerMidge2() {
        System.out.println(RED_BOLD+"Test damagePoints equal player & midge by running methods"+RESET);
        player.player = new GubbStrutt(9, 7, 0, 4, 2, 4, 0, 3,0, 0, "TestTina", "GubbStrutt");
        tinyAn.midge = new Mosquito(7, 5, 2, 2, "Mosquito");
        player.humans.add(player.player);
        tinyAn.insects.add(tinyAn.midge);
        //    midge     **********************************
        int damagePointsMidge = 0;
        int mstrength = tinyAn.midge.getStrength() + tinyAn.midge.getStrength();
        damagePointsMidge = ((mstrength - tinyAn.midge.getFear()) / 4 + 1);
        //    player   *************************************
        int pstrength = player.player.getStrength() + player.player.getAgility();
        int damagePoints = (int) ((pstrength - player.player.getFear()) / 4 + 1);

        assertNotNull(player);
        assertNotNull(tinyAn);
        assertEquals(5, tinyAn.midge.getStrength());
        assertEquals(2, tinyAn.midge.getFear());
        assertEquals(4, player.player.getAgility());
        assertEquals(3, player.player.getFear());
        assertEquals(7, player.player.getStrength());
        assertEquals(10, mstrength);
        assertEquals(3, damagePointsMidge);
        assertEquals(11, pstrength);
        assertEquals(3, damagePoints);
        assertEquals(damagePointsMidge, damagePoints);
    }

    @org.junit.Test
    public void looseAFight() {
        System.out.println(RED_BOLD+"Test player loose a fight2, lowest damage"+RESET);
        player.player = new GubbStrutt(9, 3, 0, 3, 2, 4, 0, 3,0, 0, "TestTina", "GubbStrutt");
        tinyAn.midge = new Mosquito(7, 9, 1, 2, "Mosquito");
        player.humans.add(player.player);
        tinyAn.insects.add(tinyAn.midge);
        //    midge     **********************************
        int damagePointsMidge = 0;
        int resultOfRandom2 = (int) (Math.random() * 4) + 1; // Throws a dice with max 4 and min 1
        int mstrength = tinyAn.midge.getStrength() + tinyAn.midge.getStrength();
        damagePointsMidge = ((mstrength - tinyAn.midge.getFear()) / 4 + 1);
        assertNotNull(tinyAn);
        assertTrue(resultOfRandom2 > 0 && resultOfRandom2 < 5, "Random is between 1-4, the no is: " + resultOfRandom2);
        assertEquals(18, mstrength);
        assertEquals(5, damagePointsMidge);
        assertEquals(9, tinyAn.midge.getStrength());
        assertEquals(1, tinyAn.midge.getFear());

        int sum2 = 0;
        int damageMidge = 0;
        int resultOfDie2 = 0;
        for (int i = 0; i < damagePointsMidge; i++) {
            resultOfDie2 = (int) (Math.random() * 4) + 1; // Throws a dice with max 4 and min 1
            sum2 = sum2 + resultOfDie2; //add all dice result per how many dices
            damageMidge = damageMidge + resultOfDie2; //add all dice result totally
        }
        assertTrue(damageMidge > 6 && damageMidge < 21, "5 throw, random 1-4, range 5-20 : " + damageMidge);

        //    player   **************************************************************************************
        int resultOfRandom = (int) (Math.random() * 4) + 1; // Throws a dice with max 4 and min 1
        int pstrength = player.player.getStrength() + player.player.getAgility();
        int damagePoints = (int) ((pstrength - player.player.getFear()) / 4 + 1);
        assertNotNull(player);
        assertTrue(resultOfRandom > 0 && resultOfRandom < 5, "Random is between 1-4, the no is: " + resultOfRandom);
        assertEquals(6, pstrength);
        assertEquals(1, damagePoints);
        assertEquals(3, player.player.getAgility());
        assertEquals(3, player.player.getFear());
        assertEquals(3, player.player.getStrength());

        int sum = 0;
        int damagePlayer = 0;
        int resultOfDie = 0;
        for (int i = 0; i < damagePoints; i++) {
            resultOfDie = (int) (Math.random() * 4) + 1; // Throws a dice with max 4 and min 1
            sum = sum + resultOfDie; //add all dice result per how many dices
            damagePlayer = damagePlayer + resultOfDie; //add all dice result totally
            //System.out.println("the total damage the player gave is: " + damagePlayer);
        }
        assertTrue(resultOfDie > 0 && resultOfDie < 5, "player only one throw (damagePoints=1): " + resultOfDie);
        assertTrue(sum > 0 && sum < 5, "player only one throw (sum=resultOfDie): ");
        assertEquals(sum, resultOfDie); //only one throw
        assertTrue(damagePlayer > 0 && damagePlayer < 5, "player only one throw : " + damagePlayer);

        //   compare damage
        assertTrue(damageMidge > damagePlayer, "Midge won: " + damageMidge + "  Player lost: " + damagePlayer);

    }

    @org.junit.Test
    public void looseAFight2() {
        System.out.println(RED_BOLD+"Test player loose a fight, lowest damage"+RESET);
        player.player = new GubbStrutt(9, 3, 0, 3, 2, 4, 0, 3,0, 0, "TestTina", "GubbStrutt");
        tinyAn.midge = new Mosquito(7, 9, 1, 2, "Mosquito");
        player.humans.add(player.player);
        tinyAn.insects.add(tinyAn.midge);
        assertNotNull(player);
        assertNotNull(tinyAn);
        assertTrue(player.calculateDamage(player, tinyAn) < tinyAn.calculateDamage(player, tinyAn));
    }

    @org.junit.Test
    public void winAFight() {
        System.out.println(RED_BOLD+"Test player win a fight, highest damage"+RESET);
        player.player = new GubbStrutt(9, 7, 0, 4, 2, 4, 0, 3, 0,0, "TestTina", "GubbStrutt");
        tinyAn.midge = new Mosquito(7, 2, 2, 2, "Mosquito");
        player.humans.add(player.player);
        tinyAn.insects.add(tinyAn.midge);
        assertNotNull(player);
        assertNotNull(tinyAn);
        assertTrue(player.calculateDamage(player, tinyAn) >= tinyAn.calculateDamage(player, tinyAn));
    }


}
