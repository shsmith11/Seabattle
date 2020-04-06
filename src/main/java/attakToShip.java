import java.util.Arrays;
import java.util.Random;

public class attakToShip {
    private int[] coordNum;
    private int size;

    public attakToShip(int[] coordNum, int size) {
        this.coordNum = coordNum;
        this.size = size;
    }

    public void setCoordNum(int[] coordNum) {
        this.coordNum = coordNum;
    }
    public void setCoordNumIndex(int indexCoord, int value) {
        this.coordNum[indexCoord] = value;
    }

    public int[] getCoordNum() {
        return coordNum;
    }

    public int[] generateAvailCoord(){ //calculate available coordinates
        int j=0;
        for (int i = 0; i <= getCoordNum().length-1 ; i++) {
            if (getCoordNum()[i] == 0 || getCoordNum()[i] == 2){
                j++;
            }
        }
        int[] randomCoord = new int[j];
        j=0;
        for (int i = 0; i <= getCoordNum().length-1 ; i++) {
            if (getCoordNum()[i] == 0 || getCoordNum()[i] == 2){
                randomCoord[j] = i;
                j++;
            }
        }
        return randomCoord; // add limitation <size*size
    }
    public int generateCoord(){
        int randomIndex = new Random().nextInt(generateAvailCoord().length);
        printInfo(generateAvailCoord(), generateAvailCoord()[randomIndex]);
        return generateAvailCoord()[randomIndex];
    }

    public boolean fireCheck(){
        boolean hit=false;
        int randomIndex = generateCoord();
        if (getCoordNum()[randomIndex] == 0){
            setCoordNumIndex(randomIndex, 3);
            hit = false;
            System.out.println(hit);}
        if (getCoordNum()[randomIndex] == 2){
            setCoordNumIndex(randomIndex, 4);
            hit = true;
            System.out.println(hit);}
        return hit;
    }


//    public boolean ifDestroyed(){
//        //Check if ship completely destroyed
//    }
//    public void calcAroundIfDestroyed(){
//
//    }
//    public void calcNexTurn(){
//        //Calculate current and next turn if injured
//    }
//    public void gameInfo(){
//        // current game info
//    }



    public void printInfo(int[] array, int randomIndex) {
        System.out.println("attakToShip{" +
                "Array = " + Arrays.toString(array) +
                ", Variable =" + randomIndex +
                "'}'");
    }
}
