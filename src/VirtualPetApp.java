/**
 * This is the Main Class application that will call the startGame()method to
 * start the game.
 * 
 * @author Schryll Schuch
 */

public class VirtualPetApp {
    public static void main(String[] args) throws Exception {

        GameStarter newGame = new GameStarter();
        newGame.startGame();

    }

}
