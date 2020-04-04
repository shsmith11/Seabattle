public class Battle {
    public static void main(String[] args) {

        int size = 10;

        GameModel shipKit = new GameModel(size);
        int[] shipsKit = shipKit.model(size);

        GameConstructor enemySet = new GameConstructor(size);
        enemySet.shipsBuild(shipsKit);

        GameConstructor ownSet = new GameConstructor( size);
        ownSet.shipsBuild(shipsKit);

        Draw drawShips = new Draw();
        drawShips.drawShips(enemySet.getCoordNum(), ownSet.getCoordNum(), size);


    }
}
