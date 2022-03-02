package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import exceptions.WrongStringLengthException;

public class Spill implements SpillADT {

	private String fasit;

	public Spill() {
		setFasit(nyttOrd());
	}

	@Override
	public boolean sjekkLengde(String ord) {
		return ord.length() == 5;
	}

	@Override
	public boolean sjekkTall(String ord) {
		boolean resultat = true;
		char[] ch = ord.toCharArray();
		for (char c: ch) {
			if (Character.isDigit(c)) {
				resultat = false;
			}
		}
		return resultat;
	}

	@Override
	public String sjekkBokstaver(String ord) {
		StringBuilder resultat = new StringBuilder();
		
		char[] brukerOrd = ord.toCharArray();
		
		for (int i = 0; i<ord.length();i++) {
			char c = brukerOrd[i];
			if (finnes(c)) {
				if (riktigPlass(c,i)) {
					resultat.append('2');
				} else {
					resultat.append('1');
				}
			} else {
				resultat.append('0');
			}
		}
		
		return resultat.toString();
	}

	@Override
	public boolean finnes(char c) {
		boolean resultat = false;

		char[] ch = getFasit().toCharArray();

		for (char cch: ch) {
			if (cch == c) {
				resultat = true;
			}
		}

		return resultat;
	}

	@Override
	public boolean riktigPlass(char c, int index) {
		return c == getFasit().charAt(index);
	}

	@Override
	public String nyttOrd() {
		int antallLinjer = 0;
		File fil = new File("ordbok.txt");

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(fil));

			while ((br.readLine()) != null) {
				antallLinjer++;
			}

			br.close();
			br = new BufferedReader(new FileReader(fil));

			Random random = new Random();
			int randomInt = random.nextInt(antallLinjer);

			int count = 0;
			String fasit;

			while ( (fasit = br.readLine()) != null) {
				if (count == randomInt) {
					br.close();
					return fasit;
				}

				count++;
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fil.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file: " + fil.toString());
		}
		return "Fullførte ikke";
	}
	
	@Override
	public String getFasit() {
		return fasit;
	}

	@Override
	public void setFasit(String fasit) {
		this.fasit = fasit;
	}

	@Override
	public boolean erFerdig(String ord) {
		char[] sjekk= sjekkBokstaver(ord).toCharArray();
		boolean resultat = true;
		
		for (char c: sjekk) {
			if (c != '2') {
				resultat = false;
			}
		}
		
		return resultat;
	}

}
