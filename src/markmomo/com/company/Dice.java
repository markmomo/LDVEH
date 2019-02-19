package markmomo.com.company;

import java.util.Random;

public class Dice {
    private int upperRange;

    public Dice(int upperRange) {
        this.upperRange = upperRange;
    }

    public int getUpperRange() {
        return upperRange;
    }

    public void setUpperRange(int upperRange) {
        this.upperRange = upperRange;
    }

    public static int generateRandomInt(int upperRange){
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    public int lancer(){
        Random random = new Random();
        return random.nextInt(upperRange)+1;
    }
}
