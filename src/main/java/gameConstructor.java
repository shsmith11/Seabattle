class gameConstructor {
    //public int size;
    int[] CoordNum;
    private int size;
    private int shipQty;

    public gameConstructor(int size) {
        this.size = size;
        CoordNum = new int[size*size];
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCoordNum(int[] coordNum) {
        CoordNum = coordNum;
    }

    public int[] getCoordNum() {
        return CoordNum;
    }

    public void setShipQty(int shipQty) {
        this.shipQty = shipQty;
    }

    public int getShipQty() {
        return shipQty;
    }

    public void shipsBuild (int[] shipsKit){
        for (int i = 0; i<=7; i=i+2){
            setShipQty(shipsKit[i]);
            fieldSetup(size,shipsKit[i+1]);
        }

    }

    public boolean overlaidCheck(int[] CoordCheck){  //Checking if ship are not overlaid to other ship
        boolean CellCheckResult = false;
        for (int j=0; j<= CoordNum.length-1; j++) {
            if ((CoordCheck[j] ==1 && CoordNum[j] ==2) || (CoordCheck[j] ==2 && CoordNum[j] ==1) ){
                CellCheckResult = true;
                System.out.print(" " + j +" Overlaid ");
                break;

            } else {
                System.out.print(j +" huy, ");
                CellCheckResult = false;

            }
            System.out.print("");
        }
        return CellCheckResult;
    }
    public int addToMainArr(int[] CoordCheck){  // adding new ship to main array if not overlaid
        if (!overlaidCheck(CoordCheck)) {
            System.out.println("Ship added to main array");
            for (int j=0; j<= CoordNum.length-1; j++){
                if (CoordNum[j] == 0 ) {
                    CoordNum[j] = CoordCheck[j];
                    System.out.print(" " + j);
                }
            }
            System.out.println("");
            shipQty--;
        }
        return shipQty;
    }
    public void fieldSetup(int size, int decks) {
        int initpos;

        while (shipQty > 0) {   // do until all ships added with no overlay and in limits
            System.out.println();
            System.out.println("Ships left " + shipQty);
    // setup
            int direction = (int) (Math.random()*2);
            initpos =  (int) (Math.random()*size*size-1);
                            // service messages
                                System.out.println("Direction = " + direction);
                                //System.out.println("CoordNum.length = " + CoordNum.length);
                                System.out.println("random position = " + initpos);

            shipPositionCheck(size, initpos, decks, direction); // create, check and add ships
        }
    }
    public int[] aroundShip(int[] CoorCheck, int size, int pos) {  // Adding inactive dots around ship

        if (pos % size == 0) {   // if most left position in the row

                if (pos - size >= 0) {
                    CoorCheck[pos - size] = 1; //row1
                    CoorCheck[pos - size + 1] = 1;
                }

                CoorCheck[pos + 1] = 1; //row2
                CoorCheck[pos] = 1;

                if (pos + size + 1 <= size * size - 1) {
                    CoorCheck[pos + size + 1] = 1; //row3
                    CoorCheck[pos + size] = 1;
                }
            }
            if ((pos) % size == size - 1) {   // if most right position in the row

                if (pos - size >= 0) {
                    CoorCheck[pos - size - 1] = 1; //row1
                    CoorCheck[pos - size] = 1;
                }

                CoorCheck[pos - 1] = 1; //row2
                CoorCheck[pos] = 1;

                if (pos + size - 1 <= size * size - 1) {
                    CoorCheck[pos + size - 1] = 1; //row3
                    CoorCheck[pos + size] = 1;
                }
            }
            if (pos % size >= 1 && (pos) % size <= size - 2) { //middle position

                if (pos - size >= 0) {
                    CoorCheck[pos - size - 1] = 1;//row1
                    CoorCheck[pos - size] = 1;
                    CoorCheck[pos - size + 1] = 1;
                }

                CoorCheck[pos - 1] = 1;//row2
                CoorCheck[pos] = 1;
                CoorCheck[pos + 1] = 1;

                if (pos + size <= size * size - 1) {
                    CoorCheck[pos + size - 1] = 1;//row3
                    CoorCheck[pos + size] = 1;
                    CoorCheck[pos + size + 1] = 1;
                }
            }
        return CoorCheck;
    }
    public int[] shipPositionCheck(int size, int initpos, int decks, int direction) { // Adding new ship to secondary array + dots around
        int[] CoordCheck = new int[CoordNum.length];
// For Horizontal
        if (direction == 0) {
            if ((initpos) % size >= 0 && (initpos) % size <= size - decks) {
                System.out.println("initial position is in limits");
                for (int j = 0; j <= decks - 1; j++) {
                    CoordCheck = aroundShip(CoordCheck, size, initpos + j); // adding dots for each deck separately
                }
                for (int j = 0; j <= decks-1; j++) {
                    CoordCheck[initpos+j] = 2;
                }
                addToMainArr(CoordCheck);
            } else {
                //CoordNum[initpos] = 0;
                System.out.println("Over Horizontal limits ");
            }
        }
// For Vertical
        if (direction == 1) {
            if (initpos >= 0 && initpos <= (size * size - (decks - 1) * size) - 1) {
                System.out.println("initial position is in limits");

                for (int j = 0; j <= decks - 1; j++) {
                    CoordCheck = aroundShip(CoordCheck, size, initpos + j * size); // adding dots for each deck separately
                }

                for (int j = 0; j <= decks - 1; j++) {
                    CoordCheck[initpos + j * size] = 2;
                }
                addToMainArr(CoordCheck);
            } else {
                //CoordNum[initpos] = 0;
                System.out.println("Over Vertical limits ");
            }

        }
        return CoordCheck;
    }



}



