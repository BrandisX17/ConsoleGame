package sk.brano.gameControl;

import sk.brano.gameLogic.Game;
import sk.brano.objects.Character;

public interface GameControls {

    String putPassword();
    String chooseCharacter();
    int setTurnsCount();
    void printGameResult(Game game);
    String chooseMove(String player);


    void printPlayerHealth(Character playerA, Character playerB);
}
