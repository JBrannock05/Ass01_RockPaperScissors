import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getPlayerMove(scanner, "Player A");
            String playerB = getPlayerMove(scanner, "Player B");

            System.out.println(determineOutcome(playerA, playerB));

            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = scanner.nextLine().trim().toUpperCase();
        } while (playAgain.equals("Y"));

        scanner.close();
        System.out.println("Thanks for playing!");
    }

    private static String getPlayerMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.print(player + ", enter your move (R/P/S): ");
            move = scanner.nextLine().trim().toUpperCase();
            if (!isValidMove(move)) {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        } while (!isValidMove(move));
        return move;
    }

    private static boolean isValidMove(String move) {
        return move.equals("R") || move.equals("P") || move.equals("S");
    }

    private static String determineOutcome(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            return "It's a Tie!";
        }
        switch (playerA) {
            case "R":
                return playerB.equals("S") ? "Rock breaks Scissors, Player A wins!" : "Paper covers Rock, Player B wins!";
            case "P":
                return playerB.equals("R") ? "Paper covers Rock, Player A wins!" : "Scissors cuts Paper, Player B wins!";
            case "S":
                return playerB.equals("P") ? "Scissors cuts Paper, Player A wins!" : "Rock breaks Scissors, Player B wins!";
            default:
                return "Unexpected error.";
        }
    }
}