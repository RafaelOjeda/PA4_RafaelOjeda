package main;

import util.*;
import java.util.*;

public class PatternFinder {

	// isTripartite
	private static boolean isTripartite(String inputString) {

		int start = 0;
		int length = inputString.length();

		if (length % 3 == 0) {
			// Checks whether it can be divided by 3 to continue with the tripartite checker.

			// Divides string into 3 substrings
			String part1 = inputString.substring(start, (length / 3));
			String part2 = inputString.substring(length/3, (2 * (length /3)));
			String part3 = inputString.substring(2 * (length/3));

			// Checks if all the 3 substrings are equal.
			return part1.equals(part2) && part1.equals(part3);
		}
		return false;
	}
	
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

	private static void tripartiteMiner(String mine, int length) throws BalancedTripartiteException {
		for (int start = 0; start <= mine.length() - length; start++) {

			String currentString = mine.substring(start, start + length);

			if (isTripartite(currentString)) {
				throw new BalancedTripartiteException(currentString, start);
			}
		}
	}

//	private static void palindromeMiner(String mine, int length) throws PalindromeException {
//
//		int letterCount = 0;
//		int end = 0;
//
//
//		while (letterCount < mine.length() - length) {
//			end = letterCount + length;
//
//			while (true) {
//				if (mine.charAt(letterCount) != mine.charAt(end)) {
//					break;
//				}
//			}
//
//			letterCount++;
//		}
//	}

    public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		//Step 1: handling input...
		System.out.println("Enter the length of random string: ");
		int randomStringLength = keyboard.nextInt();
		System.out.println("Enter the maximum length of special patterns: ");
		int patternMaxLength = keyboard.nextInt();

		while (true) { // Input handling: makes sure randomStringLength and patternMaxLength are within their limits.
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
//					singletonMiner(randomString, length);
//					arithmeticMiner(randomString, length);
//					arithmeticReverseMiner(randomString, length);
					tripartiteMiner(randomString, length);
//					bipartiteMiner(randomString, length);
//					palindromeMiner(randomString, length);
				}
			}
//			catch (SingletonException singleton) {
//				System.out.println(singleton.getMessage());
//			} catch (ArithmeticOrderException arithmeticOrder) {
//				System.out.println(arithmeticOrder.getMessage());
//			} catch (ArithmeticReverseOrderException arithmeticReverseOrder) {
//				System.out.println(arithmeticReverseOrder.getMessage());
//			}
			catch (BalancedTripartiteException balancedTripartite) {
				System.out.println(balancedTripartite.getMessage());
			}
//			catch (PalindromeException palindrome) {
//				System.out.println(palindrome.getMessage());
//			}
    }
}
