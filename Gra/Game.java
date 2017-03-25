import java.util.Random;

public class Game {
	
	private int numberOfTries, number;
	private static long seed;
	private boolean result;
	
	Game(int range) {
		seed = System.currentTimeMillis();
		Random rnd = new Random();
		rnd.setSeed(seed);
		number = rnd.nextInt(range+1);
		numberOfTries = 0;
	}
	
	public void showResults(int range) {
		if (result) {
			System.out.println("WYGRANA !");
		}
		else {
			System.out.println("PORAZKA !");
		}
		System.out.println("Wyniki koncowe!");
		System.out.println("Zakres: " + range);
		System.out.println("Szukana liczba: " + number);
		System.out.println("Liczba prob: " + numberOfTries);
	}
	
	public void check(int guessingNumber, int range) {
		if (guessingNumber == number) {
			showResults(range);
		}
		if (guessingNumber > number) {
			System.out.println("Szukana liczba jest mniejsza!");
		}
		else {
			System.out.println("Szukana liczba jest wieksza!");
		}
	}
}