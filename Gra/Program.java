import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	private static int range, guessingNumber;
	
	private void parse(String[] data) throws ArgumentAIsZeroException, NumberFormatException {
		range = Integer.parseInt(data[0]);
		if (range <= 0) {
			throw new ArgumentAIsZeroException();
		}
	}
	
	private void input() {
		try {
		Scanner input = new Scanner(System.in);
		guessingNumber = input.nextInt();
		} 
		catch(InputMismatchException e)
		{
			System.out.println("Nalezy podac liczbe!");
			System.out.println("Straciles probe!");
			guessingNumber = -1;
		}
	}
	
	public static void main(String[] data) {
		System.out.println("Gra");
		try {
			Program obj = new Program();
			obj.parse(data);
			Game object = new Game(range);
			System.out.println("Szukana liczba zostala wylosowana z zakresu od 0 do " + range);
			do {
				System.out.print("Podaj swoj typ: ");
				obj.input();
				object.check(guessingNumber);
			} while (object.getNumberOfTries() < 10 && object.getResult() == false);
			clearScreen();
			object.showResults(range);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Brak podanego zakresu");
		}
		catch (NumberFormatException error) {
			System.out.println("Podany zakres musi byc liczba!");
		}
		catch (ArgumentAIsZeroException a) {
			System.out.println(a.getMessage());
		} 
		finally {
			System.out.println("Dziekuje za gre");
		}
	}
	
	public static void clearScreen() { //Works only on Linux 
		System.out.print("\033[H\033[2J");  
	    System.out.flush(); 
	}
}