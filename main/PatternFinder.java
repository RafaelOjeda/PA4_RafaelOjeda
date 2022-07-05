package main;

import util.*;
import java.util.*;

public class PatternFinder {
    private static String randomStringGenerator(int length) {// generates a string made of randomly generated lowercase
							     // letters.
	Random random = new Random(System.nanoTime());
	char[] array = new char[length];
	for (int i = 0; i < length; i++)
	    array[i] = (char) ('a' + random.nextInt(26));
	return new String(array);
    }
    private static void singletonMiner(String mine, int length) throws SingletonException {
		for (int start = 0; start < mine.length() - length; start++) {
			int i;
			for (i = start + 1; i < start + length; i++) {
				if (mine.charAt(i) != mine.charAt(i - 1)) {
					break;
				}
			}
			if (i == start + length) {
				throw new SingletonException(mine.substring(start, start + length), start);
			}
		}
    }

	private static void arithmeticMiner(String mine, int length) throws ArithmeticOrderException {
		// Checks to see if the string in alphabetical order
		for (int start = 0; start < mine.length() - length; start++) {
			int i;
			for (i = start + 1; i < start + length; i++) {
				if (mine.charAt(i-1) !=  (char)(mine.charAt(i)-1)) { // If the previous char does not equal to the inner-loop char - 1 break;
					break;
				}
			}
			if (i == start + length) {
				throw new ArithmeticOrderException(mine.substring(start, start + length), start);
			}
		}
	}

	private static void arithmeticReverseMiner(String mine, int length) throws ArithmeticReverseOrderException {
		// Checks to see if the string is in reverse alphabetical order
		for (int start = 0; start < mine.length() - length; start++) {
			int i;
			for (i = start + 1; i < start + length; i++) {
				if (mine.charAt(i-1) !=  (char)(mine.charAt(i)+1)) { // If the previous char does not equal to the inner-loop char - 1 break;
					break;
				}
			}
			if (i == start + length) {
				throw new ArithmeticReverseOrderException(mine.substring(start, start + length), start);
			}
		}
	}

    public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		//Step 1: handling input...
		System.out.println("Enter the length of random string: ");
		int randomStringLength = keyboard.nextInt();
		System.out.println("Enter the maximum length of special patterns: ");
		int patternMaxLength = keyboard.nextInt();

		while (true) { // Input handling
			try {
				if (randomStringLength < 100000 || randomStringLength > 1000000000) {
					throw new NumberFormatException();
				} else if (patternMaxLength < 3 || patternMaxLength > 15) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Try again! " +
									"\nRandom string range 100k-1bil" +
									"\nSpecial patterns range 3-15");
				System.out.println("Enter the length of random string: ");
				randomStringLength = keyboard.nextInt();
				System.out.println("Enter the maximum length of special patterns: ");
				patternMaxLength = keyboard.nextInt();
				continue;
			}
			break;
		}
		//Step 2: generating random string...
		String randomString = randomStringGenerator(randomStringLength);
		//Step 3: finding the interesting patterns
			try {
				for (int length = patternMaxLength; length > 0; length--) {
					singletonMiner(randomString, length);
					arithmeticMiner(randomString, length);
					arithmeticReverseMiner(randomString, length);
//					tripartiteMiner(randomString, length);
//					bipartiteMiner(randomString, length);
//					palindromeMiner(randomString, length);
				}
			}
//			catch (SingletonException singleton) {
//				System.out.println(singleton.getMessage());
//			}
//			catch (ArithmeticOrderException arithmeticOrder) {
//				System.out.println(arithmeticOrder.getMessage());
//			}
//			catch (ArithmeticReverseOrderException arithmeticReverseOrder) {
//				System.out.println(arithmeticReverseOrder.getMessage());
//			}
			catch (BalancedTripartiteException balancedTripartite) {
				System.out.println(balancedTripartite.getMessage());
			}
    }
}
