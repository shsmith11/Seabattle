public class Battle {
    public static void main(String[] args) {

        int size = 8;
        int[] CoordNum = new int[size*size];
        // fire dot = new fire();
        // initialsetup enemyset1 = new initialsetup();

        initialsetup enemyset4 = new initialsetup();
        //enemyset4.size = size;
        enemyset4.CoordNum = new int[size*size];
        //(field size, ships quantity, decks)
        // enemyset1.ShipSetUp(8,4,1); //1deck
        // enemyset2.ShipSetUp(8,3,2); //2deck
        // enemyset3.ShipSetUp(8,2,3); //3deck
        //enemyset4.ShipSetUp(size,1,1); //4deck
        //enemyset4.ShipSetUp(size,1,1);
        CoordNum=enemyset4.ShipSetUp(size,1,2);
        enemyset4.drowShips(CoordNum,size);



//        for (int i = 0; i <= size-1; i++) {
//            //System.out.println();
        // System.out.println("Array from method  is  " + enemyset4.ShipSetUp(8,1,4));

        //    dot.CheckFire("a3");
    }
}
