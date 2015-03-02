package caesarCipherUnknownTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Caesar
{
	public static char[] charAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean wantsEncript = false;
		boolean needsInput = true;
		String word;
		int key;
		
		while(true) //repeat program until quit
		{
			System.out.println("Would you like to [e]ncript, [d]ecript, or [q]uit?");
			
			while(needsInput) //repeat until you have a valid input char
			{
				char input = 'a';
				String inputWord = "default";
				if(scan.hasNext())
				{
					inputWord = scan.nextLine();
					if(inputWord.length() < 1)
						input = scan.nextLine().charAt(0);
					else
						input = inputWord.charAt(0);
				}
				
				if(input == 'e')
				{
					wantsEncript = true;			
					needsInput = false;
				}
				else if(input == 'd')
				{
					wantsEncript = false;
					needsInput = false;
				}
				else if(input == 'q')
				{
					System.exit(0);
				}
				else
					System.out.println("Please enter an 'e', 'd', or 'q'");
			}
			if(wantsEncript)
			{
				System.out.println("Please enter one word to encript");
				word = scan.nextLine();
				System.out.println("Please enter encription key");
				key = scan.nextInt();
				System.out.println(encript(word, key));
			}
			else if(!wantsEncript)
			{
				System.out.println("Please enter one word to decript");
				word = scan.nextLine();
				System.out.println("Please enter encription key, or a '0' if unknown");
				key = scan.nextInt();
				if(key == 0)
				{
					System.out.println(decript(word));
				}
				else
				{
					System.out.println(decript(word, key));
				}
			}
			needsInput = true;
		}	
		
	}
	
	public static String encript(String w, int key)
	{
		String end = "";
		for(int i = 0; i<w.length(); i++)//for each char in w
		{	
			char charPreChanged = w.charAt(i);
			int index = 0;
			for (int z = 0; z<charAlphabet.length; z++)   //find index of char in alphabet
			{
				if(charPreChanged == charAlphabet[z]) 
					index = z;	
			}
			
			for(int j = 0; j<key; j++) //add 1 k times
			{
				if(index == 25)
					index = 0;
				else
					index++;
			}
			end +=charAlphabet[index];
		}
		return end;
		
	}
	
	public static String decript(String w, int key)
	{
		String end = "";
		for(int i = 0; i<w.length(); i++)//for each char in w
		{	
			char charPreChanged = w.charAt(i);
			int index = 0;
			for (int z = 0; z<charAlphabet.length; z++)   //find index of char in alphabet
			{
				if(charPreChanged == charAlphabet[z]) 
					index = z;
					
			}
			
			for(int j = 0; j<key; j++) //add 1 k times
			{
				if(index == 0)
					index = 25;
				else
					index--;
			}
		
			end +=charAlphabet[index];

		}
		return end;
		
	}
	
	public static String decript(String w)
	{
		ArrayList<String> allWords = new ArrayList<String>();
		
		try
		{
			for (String line : Files.readAllLines(Paths.get("wordsEn.txt"))) 
			{
			    allWords.add(line);
			}
		} 
		catch (IOException e)
		{
			System.out.println("Error reading file");
		}
		
		for(String word : allWords)
		{
			//System.out.print('x');
			for(int i=0; i<25; i++)
			{
				String check = decript(w,i);
				if(word.equals(check))
				{
					return check;
				}
			}
			
		}
		
		return "Unknown Word";
	}
}
