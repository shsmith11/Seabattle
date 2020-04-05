// chose game model.  10 or 8 cells

public class gameModel {
    private int size;
    private int[] shipsKit = new int[8];

    public gameModel(int size) {
        this.size = size;            //TODO add size checking
    }

    public int[] model(int size){
        if (size == 10) {

            shipsKit[0] = 1; //1x
            shipsKit[1] = 4; //4 decks

            shipsKit[2] = 2; //2x
            shipsKit[3] = 3; //3 decks

            shipsKit[4] = 3; //3x
            shipsKit[5] = 2; //2decks

            shipsKit[6] = 4; // 4x
            shipsKit[7] = 1; // 1 deck
        }
        if (size == 8) {
            shipsKit[0] = 0; //0x
            shipsKit[1] = 4; //4 decks

            shipsKit[2] = 2; //2x
            shipsKit[3] = 3; //3 decks

            shipsKit[4] = 2; //2x
            shipsKit[5] = 2; //2decks

            shipsKit[6] = 0; // 0x
            shipsKit[7] = 1; // 1 deck
        }
//TODO add condition
            System.out.println("Incorrect field size. Please set 10 or 8");

        return shipsKit;
    }
}
