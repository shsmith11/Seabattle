public class battle {
    public static void main(String[] args) {

        int size = 10;

        gameModel shipKit = new gameModel(size);
        int[] shipsKit = shipKit.model(size);

        gameConstructor enemySet = new gameConstructor(size);
        enemySet.shipsBuild(shipsKit);

        gameConstructor ownSet = new gameConstructor( size);
        ownSet.shipsBuild(shipsKit);

        draw drawShips = new draw();
        drawShips.drawShips(enemySet.getCoordNum(), ownSet.getCoordNum(), size);


    }
}
