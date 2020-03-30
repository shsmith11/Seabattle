class initialsetup {
    //public int size;
    public int[] CoordNum;// = new int[size * size]; //battlefield size X x Y


    public int GameSetUp(int size) {
        //decks = 1;
        //size=8;


        //    String[] Xcells = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
        return 1;
    }

    public int[] ShipSetUp(int size, int shipQty, int decks) {
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

                    CoordCheck=InitialShipSetup(size, initpos, decks, CoordNum);
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

        return CoordNum;
    }

    public int[] InitialShipSetup(int size, int initpos, int decks, int[] CooedNum) {
        int[] CoordCheck = new int[CoordNum.length];
        System.out.println("CoordNum.length in = InitialShipSetup  " + CoordNum.length);

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

    public int[] drowShips(int[] CoordNum, int size){
        int j=0;
        for (int i=1; i <= size; i++){
            System.out.print(i + " line - ");
            for (; j <= i*size-1; j++) {
                System.out.print(CoordNum[j] + "  ");
            }
            System.out.println("");
        }

        return CoordNum;
    }

}



