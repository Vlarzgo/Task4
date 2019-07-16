import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String robotMove = "UUDLDR";
        System.out.println("Is robot in start position?\n[" + robotMove + "] - " + isMoveToStartPosition(robotMove));

        int isPrimeNumber = 160;
        System.out.println("\nIs number is Prime number?\n" + isPrimeNumber + " - " + isPrimeNumber(isPrimeNumber));

        int[] sortArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numberInArray = 5;

        System.out.println("\nNumber " + numberInArray + " in the Array? - " + isNumberInArray(numberInArray, sortArray) + "\n" + Arrays.toString(sortArray));
    }

    private static boolean isMoveToStartPosition(String robotMove) {
        char[] robotMoveArray = robotMove.toCharArray();
        int x = 0; 
        int y = 0;  // enter Cartesian coordinates for move
        for (char c : robotMoveArray) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x++;
            } else if (c == 'R') {
                x--;
            }
        }
        return x == 0 && y == 0;
    }

    private static String isPrimeNumber(int isPrimeNumber) {
        LinkedList<Integer> divisors = new LinkedList<>();
        for (int i = 2; i < isPrimeNumber; i++) {

            if (isPrimeNumber % i == 0) {
                divisors.add(i);
            }
        }
        if (divisors.isEmpty()) {
            return "Yes, it is Prime Number";
        }
        divisors.addFirst(1);
        divisors.addLast(isPrimeNumber);
        return "No, it is NOT Prime Number\nDivisors is - " + divisors.toString();
    }

    private static boolean isNumberInArray(int numberInArray, int[] sortArray) {
        int firstIndex = 0;
        int lastIndex = sortArray.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (sortArray[middleIndex] == numberInArray) {
                return true;
            } else if (sortArray[middleIndex] < numberInArray) {
                firstIndex = middleIndex + 1;
            } else if (sortArray[middleIndex] > numberInArray) {
                lastIndex = middleIndex - 1;
            }
        }
        return false;
    }

}
