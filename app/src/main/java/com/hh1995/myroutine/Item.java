package com.hh1995.myroutine;

public class Item {
    int no;
    int weigh;
    int tall;
    int fatRate;
    int fatWei;
    int muscle;
    int viasceralFat;
    int legMuscle;
    int basal;
    String file;

    public Item(int no, int weigh, int tall, int fatRate, int fatWei, int muscle, int viasceralFat, int legMuscle, int basal, String file) {
        this.no = no;
        this.weigh = weigh;
        this.tall = tall;
        this.fatRate = fatRate;
        this.fatWei = fatWei;
        this.muscle = muscle;
        this.viasceralFat = viasceralFat;
        this.legMuscle = legMuscle;
        this.basal = basal;
        this.file = file;
    }

    public Item() {
    }


}
