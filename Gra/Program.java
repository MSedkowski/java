public class Program {
	private static int range = 0;
	
	private void parse(String[] data) throws ArgumentAIsZeroException, NumberFormatException {
		range = Integer.parseInt(data[0]);
		if (range <= 0) {
			throw new ArgumentAIsZeroException();
		}
	}
	
	public static void main(String[] data) {
		System.out.println("Gra");
		try {
			Program obj = new Program();
			obj.parse(data);
			Game object = new Game(range);
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
}