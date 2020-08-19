package sk.brano.gameLogic;

import com.sun.deploy.security.SelectableSecurityManager;
import sk.brano.gameControl.consoleGameControls;
import sk.brano.objects.Character;
import sk.brano.objects.Hunter;
import sk.brano.objects.Warrior;

public class GamePlay {

    private consoleGameControls gameControl;
    private int numberOfTurns;
    private String winnigPlayer;
    private Character playerA;
    private Character playerB;

    public GamePlay(int numberOfTurns, Character playerA, Character playerB) {
        this.gameControl = new consoleGameControls();
        this.numberOfTurns = gameControl.setTurnsCount();
        String p1 = gameControl.chooseCharacter();
        String p2 = gameControl.chooseCharacter();
        this.playerA  = p1.trim().equalsIgnoreCase("a")
                ? getWarrior()
                : getHunter();
        this.playerB = p2.trim().equalsIgnoreCase("a")
                ? getWarrior()
                : getHunter();
    }

    private Hunter getHunter() {

        return new Hunter(150, 0, 25, 110);
    }

    private Warrior getWarrior() {

        return new Warrior(200, 0, 50, 50);
    }

    public void startGame(){
        Character[] characters = new Character[2];
        characters[0] = playerA instanceof Warrior ? (Warrior)playerA : (Hunter)playerA;
        characters[1] = playerB instanceof Warrior ? (Warrior)playerB : (Hunter)playerB;
        for (int i = 0; i < numberOfTurns; i++) {
            //modulo is to switch between the first and the second character
            int modulo = i%2;
            String move = gameControl.chooseMove(modulo == 0 ? "A" : "B");
            if (move.equalsIgnoreCase("A")){
                //attack
            } else {
                //block
            }
                if(modulo == 0){

                }

        }
            
        }
    }

