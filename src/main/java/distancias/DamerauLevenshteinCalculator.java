package distancias;

import teclado.KeyboardLayout;

/**
 *
 *  Classe que calcula a distância Damerau-Levenshtein por meio de um layout
 * 
 *  @author marcella e priscila
 */

public class DamerauLevenshteinCalculator extends IDistanceCalculator {

	private KeyboardLayout layout;

	public DamerauLevenshteinCalculator(KeyboardLayout layout) {
		this.layout = layout;
	}

	/**
	 * Implementação do calculo da distancia com Damerau-Levenshtein
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
		double deleção;
		double inserção;
		double substituição;
		double transposição;

		for (int i = 1; i <= array_palavra_um.length(); i++) {
			for (int j = 1; j <= array_palavra_dois.length(); j++) {

				deleção = matriz_calcular_distancia[i - 1][j] + layout.getDistanciaInsercaoDelecao();
				inserção = matriz_calcular_distancia[i][j - 1] + layout.getDistanciaInsercaoDelecao();
				substituição = matriz_calcular_distancia[i - 1][j - 1] + ((array_palavra_um.charAt(i - 1) == array_palavra_dois.charAt(j - 1)) ? 0
						: layout.getDistanciaRelativa(array_palavra_um.charAt(i - 1), array_palavra_dois.charAt(j - 1)));

				// Verifica se é transponivel - Damerau
				if (isTransponivel(array_palavra_um, array_palavra_dois, i, j)) {
					transposição = matriz_calcular_distancia[i - 2][j - 2]
							+ layout.getDistanciaNominal(array_palavra_um.charAt(i - 1), array_palavra_dois.charAt(j - 2));

					matriz_calcular_distancia[i][j] = DamerauLevenshteinCalculator.this.menorValor(deleção, inserção, substituição, transposição);

				} else {
					matriz_calcular_distancia[i][j] = menorValor(deleção, inserção, substituição);
				}
			}
		}
		return matriz_calcular_distancia[array_palavra_um.length()][array_palavra_dois.length()];
	}

	/**
	 * Verifica se há troca de letra com a letra seguinte
	 */
	private boolean isTransponivel(CharSequence lhs, CharSequence rhs, int i, int j) {

		return ((i > 1) && (j > 1) && (lhs.charAt(i - 1) == rhs.charAt(j - 2))
				&& (lhs.charAt(i - 2) == rhs.charAt(j - 1)));
	}

	/**
	 * Calcula o menor valor entre deleção, inserção e substituição
	 */
	private double menorValor(double deletion, double insertion, double substitution) {

		double min = (deletion < insertion) ? deletion : insertion;
		min = (min < substitution) ? min : substitution;

		return min;

	}

	/**
	 * Calcula o menor valor entre deleção, inserção , substituição e troca pela
	 * letra seguinte
	 */
	private double menorValor(double delecao, double insercao, double substituicao, double transposicao) {
		double menor = (delecao < insercao) ? delecao : insercao;
		menor = (menor < substituicao) ? menor : substituicao;
		menor = (menor < transposicao) ? menor : transposicao;
		return menor;

	}

	public boolean isKeyboardLayoutNeutro() {
		return layout.isNeutro();
	}

}
