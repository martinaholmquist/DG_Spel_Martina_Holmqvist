package com.martina.demo;

public interface ICombat {

    int fightWinLost(Player player, TinyAnimals tinyAn);

    void setPiontsWin(Player player, TinyAnimals tinyAn);

    void setPiontsLost(Player player, TinyAnimals tinyAn);

    int calculateDamage(Player player, TinyAnimals tinyAn);

    void fight(Player player, TinyAnimals tinyAn);

    void deadPic();

}
