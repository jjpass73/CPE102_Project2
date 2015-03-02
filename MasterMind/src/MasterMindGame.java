import java.util.Scanner;
import java.lang.Character;
import java.util.Random;

public class MasterMindGame {

	
	public static void main(String[] args)
	{
		int counter = 1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to MasterMind\n");
		System.out.println("To play: \nEnter 4 letters (A-F) **SEPARATED BY SPACES**");
		System.out.println("\n'*' = Correct and in the right position");
		System.out.println("'#' = Correct and in the WRONG position");
		System.out.println("Otherwise nothing will be displayed");
		System.out.println("\nYou have 10 guesses, Good Luck!");
		
		
		MasterMind newGame = new MasterMind();
		
		for(int i=0; i < 10; i++)
		{
			if (newGame.ifWon() == true)
			{
				System.out.println("\n!!!!!!!!!!!CONGRATULATIONS YOU'RE A REAL WINNER !!!!!!!!!!!!!!!");
				break;
			}
			else 
			{
			
			char aGuess[] = new char[4];
			
		    System.out.println("\n\nEnter guess " + counter + ": \n");
			
		    for(int j = 0; j < 4; j++)
		    {
		    	aGuess[j] = Character.toUpperCase(scanner.next().charAt(0));
		    	
		    }
		    newGame.checkGuess(aGuess);
			
		    System.out.print("\n"+aGuess[0]);
		    System.out.print(aGuess[1]);
		    System.out.print(aGuess[2]);
		    System.out.println(aGuess[3]);
			
			if(counter>=11)
			{
				System.out.println("\nGAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
				System.out.println("GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
				System.out.println("GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
				System.out.println("GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
				System.out.println("GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
				System.out.println("GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
				System.out.println("GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
				System.out.println("GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER GAME OVER");
			}
			counter++;
		} 
		}
	}
}
