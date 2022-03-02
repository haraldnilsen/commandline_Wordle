package controller;

import java.util.Scanner;

import model.Spill;

public class SpillWordle {

	public SpillWordle() {

	}

	public void startSpill(){
		Spill spill = new Spill();
		info();
		Scanner reader = new Scanner(System.in);

		boolean ferdig = false;
		for (int i = 1; i<=6 || ferdig; i++) {
			String input = "";
			boolean riktigFormat = false;

			while (!riktigFormat) {
				input = reader.next();
				if (!spill.sjekkLengde(input)) {
					System.out.println("Ordet må være på 5 bokstaver");
				} else if(!spill.sjekkTall(input)) {
					System.out.println("Ordet kan ikke inneholde bokstaver");
				} else {
					riktigFormat = true;
				}
			}

			String sjekk = spill.sjekkBokstaver(input);

			System.out.println(sjekk);

			if (spill.erFerdig(input)) {
				ferdig = true;
			}
		}

		reader.close();

	}

	public void info() {
		System.out.println("Velkommen til DIY Wordle!\n"
				+ "Reglene er enkle:\n"
				+ "- Skriv inn ett ord på 5 bokstaver\n"
				+ "- 0 = bokstaven i ordet ditt finnes ikke i fasiten\n"
				+ "- 1 = bokstaven i ordet ditt finnes i fasiten, men er på feil plass\n"
				+ "- 2 = bokstaven er riktig og er riktig plassert\n\n"
				+ "Forsøk å skriv inn et ord:");
	}
}
