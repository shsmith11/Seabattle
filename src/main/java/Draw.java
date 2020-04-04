public class Draw {

    private String[] Ycells = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
    private int[] coord = {1,2,3,4,5,6,7,8,9,10};

    public Draw(){}

    public void drawShips(int[] enemyCoordNum, int[] ownCoordNum, int size){
        int j=0;
        int v=0;
        System.out.println("");
//Header start_____
        System.out.println("ENEMY FIELD                                      OUR FIELD");
        System.out.print("# |__");
        for (int i=0; i <= size-1; i++){
            System.out.print(coord[i] + "__");
        }
        System.out.print("            ");
        System.out.print("# |__");
        for (int i=0; i <= size-1; i++){
            System.out.print(coord[i] + "__");
        }
//Header end_____

        System.out.println("");
        for (int i=1; i <= size; i++){
           System.out.print(Ycells[i-1] + " |  ");
            for (; j <= i*size-1; j++) {
                System.out.print(enemyCoordNum[j] + "  ");
            }
            System.out.print("            ");
            System.out.print(Ycells[i-1] + " |  ");
            for (; v <= i*size-1; v++) {
                System.out.print(ownCoordNum[v] + "  ");
            }
            System.out.println("");
        }
    }
}
