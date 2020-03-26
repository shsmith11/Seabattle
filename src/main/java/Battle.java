
class initialsetup {
    public static int[] CoordNum = new int[Battle.size * Battle.size]; //battlefield size X x Y
    public int GameSetUp(int size) {
        //decks = 1;
        //size=8;


        //    String[] Xcells = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
        return 1;
    }

    public int ShipSetUp(int size, int shipQty, int decks) {
        int i = 0;
        boolean CellCheckRes = false;
        while (i < shipQty) {

            System.out.println();
            System.out.println("Attempt " + i);

            int direction = 0;//(int) (Math.random()*2);
            int initpos =  (int) (Math.random()*size*size-1);

            System.out.println("Direction = " + direction);
            //System.out.println("CoordNum.length = " + CoordNum.length);
            System.out.println("random position = " + initpos);
            //System.out.println("last position  H = " + (initpos) % size);
            //System.out.println("last position  V = " + (initpos + (decks-1)*size));
            System.out.println();

            if (direction == 0) { //Horizontal
                if ((initpos) % size >= 0 && (initpos) % size <= size - decks) {

                    System.out.println("CoordNum.length = " + CoordNum.length);
                    int[] CoordCheck;

                    CoordCheck=InitialShipSetup(size, initpos, decks);
                    System.out.println("CoordCheck.length = " + CoordCheck.length);
                    for (int j=0; j<= CoordNum.length-1; j++) {
                        if (CoordCheck[j] !=0 && CoordNum[j] !=0 ){
                            j=CoordNum.length;
                            CellCheckRes = true;
                            System.out.println("Overlayed");
                        }
                        else CellCheckRes=false;
                    }
                    if (CellCheckRes == false) {
                        for (int j=0; j<= CoordNum.length-1; j++){
                            CoordNum[j] = CoordCheck[j];
                        }
                        i++;
                    }




                } else {
                    CoordNum[initpos] = 0;
                    System.out.println("Over limits H");
                }
            }
            if (direction == 1) { //Vertical
                if (initpos >= 1 && initpos <= (size * size - (decks - 1) * size) - 1) {
                    i++;
                        if (decks == 1) {
                            CoordNum[initpos] = 2;
                        }
                        if (decks == 2) {
                            CoordNum[initpos] = 2;
                            CoordNum[initpos + size] = 2;
                        }
                        if (decks == 3) {
                            CoordNum[initpos] = 2;
                            CoordNum[initpos + size] = 2;
                            CoordNum[initpos + size * 2] = 2;
                        }
                        if (decks == 4) {
                            CoordNum[initpos] = 2;
                            CoordNum[initpos + size] = 2;
                            CoordNum[initpos + size * 2] = 2;
                            CoordNum[initpos + size * 3] = 2;
                            //CoordNum[initpos + size*4] = 2;
                        }

                } else {
                    CoordNum[initpos] = 0;
                    System.out.println("Over limits V");
                }
            }

        }

                for (int j = 0; j <= CoordNum.length - 1; j++) {
                    //System.out.println();
                    if (CoordNum[j] > 0) {
                        System.out.println("Array field is  " + j + " = " + CoordNum[j]);

                    } //else {System.out.println("Over limits" + i);}

                }

    return decks;//CoordNum;
    }
    public static int[] InitialShipSetup(int size, int initpos, int decks) {
    int[] CoordCheck = new int[CoordNum.length];

        if (initpos % size == 0) {   // if most left position in the row
            for (int h=decks; h >= 0; h--) {
                if (initpos - size + h >= 0) {
                    CoordCheck[initpos - size + h] = 1; //row1
                }
                CoordCheck[initpos + h] = 1; //row2
                if (initpos + size + h <= size-1) {
                    CoordCheck[initpos + size + h] = 1; //row3
                }
            }

        }
        if ((initpos+decks-1) % size == size-1) {   // if most right position in the row
            for (int h=decks; h >= 0; h--) {
                if (initpos - size - 1 + h >= 0) {
                    CoordCheck[initpos - size - 1 + h] = 1; //row1
                }
                CoordCheck[initpos + h - 1] = 1; //row2
                if (initpos + size - 1 + h <= size-1) {
                    CoordCheck[initpos + size - 1 + h] = 1; //row3
                }
            }

        }

        if (initpos % size >= 1 && (initpos+decks-1) % size <= size-2) { //middle position
            for (int h = 1 + decks; h >= 0; h--) {
                if (initpos - size - 1 + h >= 0) {
                    CoordCheck[initpos - size - 1 + h] = 1;//row1
                }
                CoordCheck[initpos - 1 + h] = 1;//row2
                if (initpos + size - 1 + h <= size-1) {
                    CoordCheck[initpos + size - 1 + h] = 1;//row3
                }
            }
        }

        for (int j=0; j <= decks-1; j++) {
            CoordCheck[initpos + j] = 2;
        }
        return CoordCheck;
    }

}




public class Battle {

    public static int size=8;

    public static void main(String[] args) {


   // fire dot = new fire();
   // initialsetup enemyset1 = new initialsetup();
    size=8;
    initialsetup enemyset4 = new initialsetup();

    //(field size, ships quantity, decks)
   // enemyset1.ShipSetUp(8,4,1); //1deck
   // enemyset2.ShipSetUp(8,3,2); //2deck
   // enemyset3.ShipSetUp(8,2,3); //3deck
      enemyset4.ShipSetUp(size,1,1); //4deck
      enemyset4.ShipSetUp(size,1,1);
      enemyset4.ShipSetUp(size,1,2);

//        for (int i = 0; i <= size-1; i++) {
//            //System.out.println();
           // System.out.println("Array from method  is  " + enemyset4.ShipSetUp(8,1,4));

    //    dot.CheckFire("a3");
    }
}
