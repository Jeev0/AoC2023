import java.util.*;
import java.io.*;

public class AdventOfCodeDay2Part1 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("AOC2023Day2Input.txt"));
        final String[] COLORS = {"red", "green", "blue"};
        final int[] MAXNUM = {12, 13, 14};
        boolean possible = true;
        int currentGame = 0, totalGameID = 0, arrayIndex = 0;
        
        while (fileInput.hasNextLine()) {
            possible = true;
            currentGame++;
            String currentLine = fileInput.nextLine();
            currentLine = currentLine.substring(currentLine.indexOf(":")+2);
            
            String[] semicolonSplit = currentLine.split("; ");
            for (int i = 0; i < semicolonSplit.length; i++) {
                
                String[] commaSplit = semicolonSplit[i].split(", ");
                for (int j = 0; j < commaSplit.length; j++) {
                    
                    Scanner commaSplitScanner = new Scanner(commaSplit[j]);
                    int currentNum = commaSplitScanner.nextInt();
                    String currentColor = commaSplitScanner.next();
                    for (int k = 0; k < COLORS.length; k++) {
                        if (currentColor.equals(COLORS[k])) {
                            arrayIndex = k;
                            break;
                        }
                    }
                    if (currentNum > MAXNUM[arrayIndex]) {
                        possible = false;
                        break;
                    }
                }
                if (!possible)
                    break;
            }
            if (possible)
                totalGameID+= currentGame;
        }
        fileInput.close();
        System.out.print(totalGameID);
    }
}