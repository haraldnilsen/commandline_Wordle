package model;

import exceptions.WrongStringLengthException;

public interface SpillADT {
	
	/**
	 * gir et ord
	 * @return tilfeldig ord fra ordbok
	 */
	String nyttOrd();
	
	/**
	 * sjekker om bruker sitt ord er 5 bokstaver
	 * @param ord bruker sitt ord
	 * @return true hvis bruker sitt ord er 5 bokstaver, false ellers
	 */
	boolean sjekkLengde (String ord);
	
	/**
	 * sjekker om bruker sitt ord inneholder tall
	 * @param ord bruker sitt ord
	 * @return true hvis bruker sitt ord ikke inneholder tall, false ellers
	 */
	boolean sjekkTall(String ord);
	
	/**
	 * sjekker ordet til brukeren
	 * @param ord brukeren sitt ord
	 * @return string som viser hvilke bokstaver som er riktig
	 */
	String sjekkBokstaver(String ord);
	
	
	/**
	 * @param bruker-input
	 * @return true om spill er ferdig, false ellers
	 */
	boolean erFerdig(String ord);

	
	/**
	 * sjekker om bokstaven finnes i ordet
	 * @param c bokstav i bruker-ord
	 * @return true om bokstaven er i svaret, false ellers
	 */
	boolean finnes(char c);
	
	/**
	 * sjekker om en bokstav som er i ordet, også er på riktig plass
	 * @param c en bokstav i bruker sitt ord
	 * @return true om bokstav er på riktig plass i svaret, false ellers
	 */
	boolean riktigPlass(char c, int index);
	
	/**
	 * 
	 * @return returnerer fasit-ordet
	 */
	String getFasit();
	
	
	/**
	 * setter nytt fasit-ord
	 * @param fasit-ord
	 */
	void setFasit(String fasit);
}
