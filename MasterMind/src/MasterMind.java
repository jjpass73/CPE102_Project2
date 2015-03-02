import java.util.Random;

public class MasterMind {

	boolean winner = false;
	char[] theSecret = new char[4];	
	char[] storedSecret = new char[4];
	
	public MasterMind()
	{
		for(int i = 0; i < 4; i++)
		{
		Random r = new Random();
		char c = (char)(r.nextInt(6) + 'A');
		theSecret [i] = c;
		storedSecret[i] = c; //Need to make a cloned instance because of the 'X'-ing out of characters
		//System.out.print(theSecret [i]);
		System.out.print(storedSecret [i]);
		}
	}
	
	public boolean ifWon()
	{
		return winner;
	}
	
	public void checkGuess(char[] aGuess)
	{
		int count = 0;
		//SETUP THE NEW GUESS
		char[] theGuess = new char[4]; 
		
		theGuess = aGuess;
		
			for(int i = 0; i < 4; i++)
			{
				theSecret[i] = storedSecret[i]; //RE-point the "'X'-ed out" secret to the original one
			}
			
			//CHECK TO SEE IF YOU'RE A WINNER
			for(int k = 0; k < 4; k++)
			{
				if(theGuess[k]==theSecret[k])
					count++;
				if (count == 4)
					winner = true;
			}
			
				for(int i = 0; i < 4; i++)
				{
				if(theGuess[i]==theSecret[i]) //First check to see if letters are in right place,AND right character
				{
					theGuess[i]='X'; //"X out" so that it cannot be compared to again
					theSecret[i]='Y'; //one guess corresponds to one "answer", so we must also remove one character from this array
					System.out.print("*"); //the character we denoted as "RIGHT CHAR, RIGHT PLACE"
				}
				else //now check if right char, wrong place
					for(int j = 0; j < 4; j++) //stay on the same character in theSecret array, but compare against different positions in our array
					{
						if(theSecret[i] == theGuess[j]) //if we find a matching character in a different place....
						{
							if(theGuess[j] == theSecret[j])//we need to make sure it isn't actually a character matched up in the right place
							{
								System.out.print("*");//if it is we will print the previously used character for RIGHT PLACE, RIGHT CHAR
								theGuess[j]='X'; //same as before
								theSecret[j]='Y';
							}
							else
							{
							theGuess[j] = 'X';// if we are sure it isnt a right place/ right char situation, we will denote it as a right char, wrong place
							theSecret[i]='Y';//remove characters so they cant be used twice
							System.out.print('#');//using this symbol
							}
						}
						
					}
				for(int k = 0; k < 4; k++)
				{
					if(theGuess[k]==theSecret[k])
						count++;
					if (count == 4)
						winner = true;
				}
			}
		
		
		
		
	}
}
