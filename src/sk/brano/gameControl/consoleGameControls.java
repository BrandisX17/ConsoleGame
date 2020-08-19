package sk.brano.gameControl;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class consoleGameControls implements GameControls{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String putPassword() {
        System.out.println("Fill in your password: ");
        String password = scanner.nextLine().trim();
        Pattern pattern = Pattern.compile("\\w{3,8}");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()){
            System.out.println("Your password must be from 3 to 8 characters long, try again");
            password = putPassword();
        }

        return password;

    }

    @Override
    public String chooseCharacter() {
        System.out.println("Choose your character class. A for warrior, B for hunter");
        if (!scanner.nextLine().trim().equalsIgnoreCase("a") || !scanner.nextLine().trim().equalsIgnoreCase("b")) {
            System.out.println("Invalid character, try again");
            return chooseCharacter();
        }
          return scanner.nextLine();
    }

    @Override
    public int setTurnsCount() {
        System.out.println("Type number of turns: ");
        int numberOfTurns;
        try{
            numberOfTurns = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception ex) {
            System.out.println("Cannot read input, Have you entered a correct number?");
            setTurnsCount();
        }
        return scanner.nextInt();
    }

    @Override
    public String chooseMove(String player) {
        System.out.println("For attack type A, for block type B");
        String move = scanner.nextLine();
        if (!move.equalsIgnoreCase("a") || !move.equalsIgnoreCase("b")){
            System.out.println("Invalid move... For attack type A, for block type B");
            move = scanner.nextLine();
        }
        return move;
    }

    //todo
/*    @Override
    public String printGameResult(GamePlay game) {
       System.out.printf("Game is over, the winner is player %s", game.GetWinner());
     scanner.close();
    }

 */
}
