import java.io.IOException;

public class battle {
    public static void main(String[] args) throws IOException {

        int size = 10;

        UserInput userInput = new UserInput();
        String userFire = userInput.getUserInput("Enter coordinates for attacking");

        gameModel shipKit = new gameModel(size);
        int[] shipsKit = shipKit.model(size);

        gameConstructor enemySet = new gameConstructor(size);
        enemySet.shipsBuild(shipsKit);

        gameConstructor ownSet = new gameConstructor( size);
        ownSet.shipsBuild(shipsKit);

        attakToShip compFire = new attakToShip(ownSet.getCoordNum(), size);
        for (int i = 0; i <=10 ; i++) {
            compFire.fireCheck();
        }


        draw drawShips = new draw();
        drawShips.drawShips(enemySet.getCoordNum(), ownSet.getCoordNum(), size);





    }
}
