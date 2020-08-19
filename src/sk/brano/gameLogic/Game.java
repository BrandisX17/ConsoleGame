package sk.brano.gameLogic;

import com.sun.deploy.security.SelectableSecurityManager;
import sk.brano.gameControl.consoleGameControls;
import sk.brano.objects.Character;
import sk.brano.objects.Hunter;
import sk.brano.objects.Warrior;

import java.awt.event.WindowAdapter;

public class Game {

    private consoleGameControls gameControl;
    private int numberOfTurns;
    private String winnigPlayer;
    private Character playerA;
    private Character playerB;

    public Game() {
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
        //par char with a role
        characters[0] = playerA instanceof Warrior ? (Warrior)playerA : (Hunter)playerA;
        characters[1] = playerB instanceof Warrior ? (Warrior)playerB : (Hunter)playerB;
        for (int i = 0; i < numberOfTurns; i++) {
            //are chars alive?
            if (characters[0].getHealth() > 0 || characters[1].getHealth() > 0) {

                //modulo is to switch between the first and the second character
                //retrieving 0 and 1
                int modulo = i % 2;
                //todo
                // check if the char is alive
                //if modulo ==0, playerA is starting
                String move = gameControl.chooseMove(modulo == 0 ? "A" : "B");
                if (move.equalsIgnoreCase("A")) {
                    //attack
                    attack(characters, modulo);
                } else
                //block
                {
                    block(characters, modulo);
                }
                gameControl.printPlayerHealth(playerA,playerB);
            }else{
                setWinningPlayer();
                gameControl.printGameResult(this);
                break;

            }
        }
        setWinningPlayer();
        gameControl.printGameResult(this);
    }

    private void setWinningPlayer() {
        if(playerA.getHealth()==playerB.getHealth()) {
            System.out.println("It is a draw!");
        }else if(playerA.getHealth()>playerB.getHealth()){
            this.winnigPlayer = "A";
        }else{
            this.winnigPlayer = "B";
        }
    }

    private void block(Character[] characters, int modulo) {
        if (characters[modulo] instanceof Warrior) {
            Warrior warrior = (Warrior) characters[modulo];
            if (!warrior.block()) {
                warriorAttack(characters, modulo, warrior);
            }
        } else {
            Hunter hunter = (Hunter) characters[modulo];
            if (!hunter.block()) {
                hunterAttack(characters, modulo, hunter);
            }

        }
    }
    //Find out if I am a warrior or hunter
    private void attack(Character[] characters, int modulo) {
        if (characters[modulo] instanceof Warrior) {
            Warrior warrior = (Warrior) characters[modulo];
            warriorAttack(characters, modulo, warrior);
        } else {
            Hunter hunter = (Hunter) characters[modulo];
            hunterAttack(characters, modulo, hunter);
        }
    }

    private void hunterAttack(Character[] characters, int modulo, Hunter hunter) {
        if(modulo == 0)
            hunter.attack(characters[1]);
        else
            hunter.attack(characters[0]);
    }

    private void warriorAttack(Character[] characters, int modulo, Warrior warrior) {
        if(modulo == 0)
            warrior.attack(characters[1]);
         else
            warrior.attack(characters[0]);
    }

    public Character getPlayerA() {
        return playerA;
    }

    public Character getPlayerB() {
        return playerB;
    }
}

