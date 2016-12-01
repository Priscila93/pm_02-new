package distancias;

import teclado.KeyboardLayout;

/**
 *
 *  Classe que calcula a distância Levenshtein por meio de um layout
 * 
 *  @author marcella e priscila
 */
public class LevenshteinCalculator extends IDistanceCalculator {
	KeyboardLayout layout;

	public LevenshteinCalculator(KeyboardLayout layout) {
		this.layout = layout;
	}

	/**
	 * Calcula distância entre palavras pelo algoritmo de LevenshteinCalculator:
        Essa distância é calculada pelo mínimo de operações para transformar uma palavra na outra.
        As operações consideradas nesse algoritmo são: inserção, eliminação ou substituição um caracter.
	 */
	public double distanciaEntrePalavras(String palavra_um, String palavra_dois) {

		CharSequence array_palavra_um = palavra_um;
		CharSequence array_palavra_dois = palavra_dois;

		double[][] matriz_calcular_distancia = new double[array_palavra_um.length() + 1][array_palavra_dois.length() + 1];

		for (int i = 0; i <= array_palavra_um.length(); i++) {
			matriz_calcular_distancia[i][0] = i;
		}

		for (int j = 1; j <= array_palavra_dois.length(); j++) {
			matriz_calcular_distancia[0][j] = j;

		}
		double eliminação;
		double inserção;
		double substituição;

		for (int i = 1; i <= array_palavra_um.length(); i++) {
			for (int j = 1; j <= array_palavra_dois.length(); j++) {

				eliminação = matriz_calcular_distancia[i - 1][j] + layout.getDistanciaInsercaoDelecao();

				inserção = matriz_calcular_distancia[i][j - 1] + layout.getDistanciaInsercaoDelecao();

				substituição = matriz_calcular_distancia[i - 1][j - 1] + ((array_palavra_um.charAt(i - 1) == array_palavra_dois.charAt(j - 1)) ? 0
						: layout.getDistanciaRelativa(array_palavra_um.charAt(i - 1), array_palavra_dois.charAt(j - 1)));

				matriz_calcular_distancia[i][j] = menorValor(eliminação, inserção, substituição);
			}
		}
		return matriz_calcular_distancia[array_palavra_um.length()][array_palavra_dois.length()];
	}

	/**
	 * Calcula o menor valor entre eliminação, inserção e substituição
	 */
	private double menorValor(double deletar, double inserir, double substituir) {
		double minimo = (deletar < inserir) ? deletar : inserir;
		return (minimo < substituir) ? minimo : substituir;

	}

	public boolean isKeyboardLayoutNeutro() {
		return layout.isNeutro();
	}

}
