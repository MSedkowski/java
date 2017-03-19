package RowKwadrat;

public class RowKwadrat {

	private double[] dane;
	private double delta, x1, x2;

	RowKwadrat(int rozmiar) {
		dane = new double[rozmiar];
	}

	public void parsowanie(String[] tab) throws ArgumentAIsZero {
		for (int i = 0; i < tab.length; i++) {
			try {
				dane[i] = Double.parseDouble(tab[i]);
			} catch (NumberFormatException error) {
				System.out.println("Argument: " + (i + 1) + " nie jest liczb¹!");
			}
		}
		if (dane[0] == 0) {
			throw new ArgumentAIsZero("Wartosc a = 0 wiec rownanie nie jest kwadratowe!");
		}
	}

	public void funkcjaKwadrat() {

		delta = Math.pow(dane[1], 2) - 4 * dane[0] * dane[2];

		if (delta == 0) {
			x1 = x2 = (-dane[1]) / (2 * dane[0]);
		}

		if (delta > 0) {
			x1 = (-dane[1] + Math.sqrt(delta)) / (2 * dane[0]);
			x2 = (-dane[1] - Math.sqrt(delta)) / (2 * dane[0]);
		}
	}

	public void wyswietl() {
		if (delta < 0) {
			System.out.println("Brak miejsc zerowych!");
		}

		if (delta == 0) {
			System.out.println("Jedno miejsce zerowe x1 = " + x1);
		}

		if (delta > 0) {
			System.out.println("Dwa miejsca zerowe x1 = " + x1 + " x2 = " + x2);
		}
	}

	public boolean check() {
		if (dane[0] == 0) {
			return false;
		} else {
			return true;
		}
	}
}
