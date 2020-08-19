package sk.brano.gameControl;

public interface GameControls {

    String putPassword();
    String chooseCharacter();
    int setTurnsCount();
    //void printGameResult();
    String chooseMove(String player);

}
