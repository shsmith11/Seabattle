public class GameModel {
    private int size;
    private int[] shipsKit = new int[8];

    public GameModel(int size) {
        this.size = size;            //TODO add size checking
    }

    public int[] model(int size){
        if (size == 10) {

            shipsKit[6] = 0; //1x
            shipsKit[7] = 4; //4 decks

            shipsKit[4] = 0; //2x
            shipsKit[5] = 3; //3 decks

            shipsKit[2] = 3; //3x
            shipsKit[3] = 2; //2decks

            shipsKit[0] = 4; // 4x
            shipsKit[1] = 1; // 1 deck
        }
        if (size == 8) {
            shipsKit[6] = 0; //0x
            shipsKit[7] = 4; //4 decks

            shipsKit[4] = 2; //2x
            shipsKit[5] = 3; //3 decks

            shipsKit[2] = 2; //2x
            shipsKit[3] = 2; //2decks

            shipsKit[0] = 0; // 0x
            shipsKit[1] = 1; // 1 deck
        }

            System.out.println("Incorrect field size. Please set 10 or 8");

        return shipsKit;
    }
}
