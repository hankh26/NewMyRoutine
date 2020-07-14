package com.hh1995.myroutine;

public class Goal {
    String weigh;
    String tall;
    String fatRate;
    String fatWei;
    String muscle;
    String visceralFat;
    String legMuscle;
    String basal;

    public Goal() {
    }

    public Goal(String weigh, String tall, String fatRate, String fatWei, String muscle, String visceralFat, String legMuscle, String basal) {
        this.weigh = weigh;
        this.tall = tall;
        this.fatRate = fatRate;
        this.fatWei = fatWei;
        this.muscle = muscle;
        this.visceralFat = visceralFat;
        this.legMuscle = legMuscle;
        this.basal = basal;
    }

    public String getWeigh() {
        return weigh;
    }

    public void setWeigh(String weigh) {
        this.weigh = weigh;
    }

    public String getTall() {
        return tall;
    }

    public void setTall(String tall) {
        this.tall = tall;
    }

    public String getFatRate() {
        return fatRate;
    }

    public void setFatRate(String fatRate) {
        this.fatRate = fatRate;
    }

    public String getFatWei() {
        return fatWei;
    }

    public void setFatWei(String fatWei) {
        this.fatWei = fatWei;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getVisceralFat() {
        return visceralFat;
    }

    public void setVisceralFat(String visceralFat) {
        this.visceralFat = visceralFat;
    }

    public String getLegMuscle() {
        return legMuscle;
    }

    public void setLegMuscle(String legMuscle) {
        this.legMuscle = legMuscle;
    }

    public String getBasal() {
        return basal;
    }

    public void setBasal(String basal) {
        this.basal = basal;
    }
}
