import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] board = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printBoard(board);
		//getting a input value from user point of view
		while (true) {
			playerTurn(board, scanner);
			if (isGameFinished(board)){
				break;
			}
			printBoard(board);
			
			computerTurn(board);
			if (isGameFinished(board)){
				break;
			}
			printBoard(board);
		}
	 	scanner.close();
	 }
//this is the simple representation of the 3x3 matrix board
	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
		System.out.println("-----");
		System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
		System.out.println("-----");
		System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
	}
	


	private static boolean isGameFinished(char[][] board) {
		//the symbol i is player  win
		if (IsOponentWon(board, '1')) {	
			printBoard(board);
			System.out.println("Player wins!");
			return true;
		}
		// the symbol 0 is computer win
		if (IsOponentWon(board, 'O')) {	
			printBoard(board);
			System.out.println("Computer wins!");
			return true;
		}
		//here i have  write a loop to try getting values until the length of the board will finish 
		//an if the board will empty and it returns false and it will print print the game  end tie
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;

				}
			}
		}
		printBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
	}

//given below condition the winning logic possible conditions
	private static boolean IsOponentWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}

//here i have written logic for computer move creating a rondom class for choose the value randomly
//and given random values  from 1 to 9 
	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (isValidMove(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + computerMove);
		placeMove(board, Integer.toString(computerMove), 'O');
	}

//this is the flag that i have creating to implement to check is the move valid for both computer
//and the oponent 
	private static boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "1":
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}
//here i have written playerturn method to which is input value getting from the user by 
//creating an scanner  class 
	private static void playerTurn(char[][] board, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)){
				break;
			} else {
				System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(board, userInput, '1');
	}

//which method followed by the position of the move
	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
				System.out.println("");
		}
	}
}