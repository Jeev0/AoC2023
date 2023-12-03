import java.util.*;
import java.io.*;

public class AOC2023Day1Part1 
{
    public static void main(String args[]) throws FileNotFoundException
    {
        int n=0, m=0, firstInt = 0, lastInt = 0, sumOfInt = 0;
        String currentLine = "", reverseCurrentLine = "", placeholder = "";
        Scanner fileInput = new Scanner(new File("AOC2023Day1Input.txt"));
        
        while (fileInput.hasNextLine())
        {
            currentLine = fileInput.nextLine();
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
