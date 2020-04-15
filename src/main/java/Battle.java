import java.io.IOException;

public class Battle {
    public static void main(String[] args) throws IOException {
        //default size 10x10
        int size = 10;


        User userData = new User();
        userData.setName();
//        String userFire = userInput.getUserInput();
        //Integer getSize = new Integer()UserInput;
        UserInput userInput = new UserInput();
        size = userInput.setSize();




        GameModel shipKit = new GameModel(size);
        int[] shipsKit = shipKit.model(size);

        GameConstructor enemySet = new GameConstructor(size);
        enemySet.shipsBuild(shipsKit);

        GameConstructor ownSet = new GameConstructor( size);
        ownSet.shipsBuild(shipsKit);

        AttakToShip compFire = new AttakToShip(ownSet.getCoordNum(), size);
        for (int i = 0; i <=10 ; i++) {
            compFire.fireCheck();
        }


        Draw drawShips = new Draw();
        drawShips.drawShips(enemySet.getCoordNum(), ownSet.getCoordNum(), size);





    }
}
