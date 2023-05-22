package nz.ac.auckland.se281;

public class Average implements Stratergy {    

    public int fingers;
    public  int sum;
    public int avg;

    //get the average number of fingers that the player has chosen
    public Average(int avg){
        this.avg = avg;
    }

    @Override
    //get a random number for the finger and sum is the average number of fingers the player has chosen + finger
    public void execute() {
        int tempFinger = Utils.getRandomNumber(1, 5);
        int tempSum = avg + tempFinger;
        this.fingers = tempFinger;
        this.sum = tempSum;
    }

    @Override
    public int getFinger() {
        return fingers;
    }

    @Override
    public  int getSum() {
        return sum;
    }
    
    public int getAvg(){
        return avg;
    }
}
