package org.osori.androidstudy.week3;

/**
 * Created by junsu on 2017-05-28.
 */

public class Cat {
    private String name;
    private int hp;

    public static final int MAX_HP = 100;
    private static final int INIT_HP = 10;

    public Cat(String name) {
        this.name = name;
        this.hp = INIT_HP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
