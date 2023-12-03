import java.util.*;
import java.io.*;
 
public class AOC2023Day1Part2 
{
    public static void main(String args[]) throws FileNotFoundException
    {
        int firstInt = 0, lastInt = 0, sumOfInt = 0;
        String currentLine = "", reverseCurrentLine = "", placeholder = "";
        String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] weirdNumbers = {"o1e", "t2o", "th3ee", "f4ur", "f5ve", "s6x", "se7en", "ei8ht", "n9ne"};
        Scanner fileInput = new Scanner(new File("AOC2023Day1Input.txt"));
 
        while (fileInput.hasNextLine())
        {
            currentLine = fileInput.nextLine();
            //replace words with numbers
            for (int p = 0; p<9; p++)
                currentLine = currentLine.replaceAll(numbers[p], weirdNumbers[p]);
            placeholder = currentLine;
            Scanner input = new Scanner(currentLine);
            //going character by character until its an integer 
            for (int i = 0; i<placeholder.length(); i++)
            {
                currentLine = Character.toString(placeholder.charAt(i));
                input = new Scanner(currentLine);
                if (input.hasNextInt())
                    break;
            }
            firstInt = input.nextInt();
            //character by character from the other side
            Scanner reverseInput = new Scanner(reverseCurrentLine);
            for (int j = (placeholder.length()-1); j>=0; j--)
            {
                reverseCurrentLine = Character.toString(placeholder.charAt(j));
                reverseInput = new Scanner(reverseCurrentLine);
                if (reverseInput.hasNextInt())
                    break;
            }
            lastInt = reverseInput.nextInt();
            sumOfInt += (10*firstInt+lastInt);
        }
        fileInput.close();
        System.out.println(sumOfInt);
    }
}
