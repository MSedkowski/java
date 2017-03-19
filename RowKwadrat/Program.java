package RowKwadrat;

public class Program {
	public static void main(String[] tab) {
		System.out.println("Program do obliczania równania kwadratowego");
		try {
			RowKwadrat obiekt = new RowKwadrat(tab.length);
			obiekt.parsowanie(tab);
			obiekt.funkcjaKwadrat();
			obiekt.wyswietl();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Niepoprawny rozmiar tablicy: " + tab.length);
		} catch (ArgumentAIsZero a) {
			a.getMessage();
		} finally {
			System.out.println("Dziêkujê za u¿ycie mojego programu");
		}
	}
}