package distancias;

/**
 *
 *  Interface para as calculadoras existentes - Damerau e Levenshtein.
 * 
 *  @author marcella e priscila
 */

public abstract class IDistanceCalculator {
	/**
	 * método abstrato para implementação da distancia
	 */
	public abstract double distanciaEntrePalavras(String palavra1, String palavra2);

	public abstract boolean isKeyboardLayoutNeutro();

}