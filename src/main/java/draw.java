public class draw {

    private String[] Ycells = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
    private int[] coord = {1,2,3,4,5,6,7,8,9,10};

    public draw(){}

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
        System.out.print("           ");
        System.out.print("# |__");
        for (int i=0; i <= size-1; i++){
            System.out.print(coord[i] + "__");
        }
//Header end_____




// body start___________
        System.out.println("");
        for (int i=1; i <= size; i++){              //drawing line by line enemy
           System.out.print(Ycells[i-1] + " | ");
            for (; j <= i*size-1; j++) {
                System.out.print("["+drawSymbols(enemyCoordNum)[j] + "]");
            }
            System.out.print("             ");
            System.out.print(Ycells[i-1] + " | ");
            for (; v <= i*size-1; v++) {            //drawing line by line our
                System.out.print("["+drawSymbols(ownCoordNum)[v] + "]");
            }
            System.out.println("");
        }



// body end


    }
    public String[] drawSymbols(int[] coordNum){  // simbols   ▇ , ◯, ☒ , ✕ , ● ▒ ▓  ╸
        String[] symbArr = new String[coordNum.length];
        for (int i=0; i <= coordNum.length-1; i++){
            if (coordNum[i] == 0) symbArr[i] = " ";  // if empty
            if (coordNum[i] == 1) symbArr[i] = "▒";  // if around ship space
            if (coordNum[i] == 2) symbArr[i] = "█";  // if ship
            if (coordNum[i] == 3) symbArr[i] = "●";  // if missed
            if (coordNum[i] == 4) symbArr[i] = "╳";  // if destroyed cell
            if (coordNum[i] == 5) symbArr[i] = "╳";  // if destroyed cell
        }
        return symbArr;
    }
}
