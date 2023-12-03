import java.util.*;
import java.io.*;

public class AOC2023Day2Part2 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("AOC2023Day2Input.txt"));
        final String[] COLORS = {"red", "green", "blue"};
        int   arrayIndex = 0, currentPower = 0, totalPower = 0;
        
        while (fileInput.hasNextLine()) {
            String currentLine = fileInput.nextLine();
            int[] minNum = {0, 0, 0};
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
                    if (currentNum > minNum[arrayIndex])
                        minNum[arrayIndex] = currentNum;
                }
            }
            currentPower = (minNum[0]*minNum[1]*minNum[2]);
            totalPower += currentPower;
        }
        fileInput.close();
        System.out.print(totalPower);
    }
}