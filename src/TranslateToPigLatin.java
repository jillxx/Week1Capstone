import java.util.Scanner;

/*
 * Author Victoria Rush with help from Maurice Tedder, Tim Pieniazek, Allison Farr, and Stack Overflow
 *   April 27, 2018
 */
public class TranslateToPigLatin {

	public static void main(String[] args) {
		String input;
		String cont = "y";

		// Prompt user for input
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println();

		do {
			System.out.println("Enter a sentence to be translated: ");
			input = scan.nextLine();

			// Convert to lower case
			input = input.toLowerCase();

			// Split sentence into words
			String[] words = input.split(" ");
			String output = "";

			// Loop through each word in sentence
			for (String word : words) {

				// Translate to pig latin
				// If vowel, add "way"
				// if (isVowel(word) == true) { // == true is redundant
				if (isVowel(word)) {
					output = translateVowel(word);
				} else {
					// Else, consonant translate
					output = translateConsonant(word);
				}
				// Display result to console, one word at a time, with space after
				System.out.print(output + " ");
			}

			// Prompt user to continue
			System.out.println();
			System.out.println("Translate another line? (y/n): ");
			cont = scan.nextLine();
		} while (cont.equalsIgnoreCase("y"));

		System.out.println("Thanks for playing!");

		scan.close();
	}

	private static boolean isVowel(String word) {
		// char firstChar = word.charAt(0);
		if ((word.startsWith("a")) || (word.startsWith("e")) || (word.startsWith("i")) || (word.startsWith("o"))
				|| (word.startsWith("u"))) {
			return true;
			// Next three lines commented out and replaced with single line to eliminate
			// unneeded "else"
			// } else {
			// return false;
			// }
		}
		return false;
	}

	private static String translateVowel(String word) {
		word = word + "way";
		return word;
	}

	public static String translateConsonant(String word) {
		char letterA = 'a';
		char letterE = 'e';
		char letterI = 'i';
		char letterO = 'o';
		char letterU = 'u';
		char letterY = 'y';

		int start = 0;
		int firstVowel = 0;
		int end = word.length();
		for (int i = 0; i < end; i++) {
			char c = (word.charAt(i));
			if (c == letterA || c == letterE || c == letterI || c == letterO || c == letterU || c == letterY) {
				firstVowel = i;
				break;
			}
		}
		if (start != firstVowel) {
			String startString = word.substring(firstVowel, end);
			String endString = word.substring(start, firstVowel) + "ay";
			return startString + endString;
		}
		return word;
	}

}
