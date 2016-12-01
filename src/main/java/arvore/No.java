package arvore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import distancias.IDistanceCalculator;

/**
 * Classe do nó
 * 
 * @author marcella e priscila
 *
 */

public class No {

	private final String palavra;
	private final Map<Integer, No> filhos;

	public No(String palavra) {
		this.palavra = palavra;
		this.filhos = new HashMap<Integer, No>();

	}

        /**
	 * get da palavra
	 */
	public String getPalavra() {
		return palavra;
	}

	/**
	 * Pega o filho na posição distanciaEntrePalavras no hashMap
	 */
	public No filhoNumaDistancia(int distancia) {
		return filhos.get(distancia);
	}

	/**
	 * Método usado pela árvore para adicionar o nó na posição do hash
	 */
	public void adicionarNoFilho(int posicao, No Nofilho) {
		filhos.put(posicao, Nofilho);
	}

	/**
	 * Busca por palavras na árvore
	 */
	public ArrayList<Palavra> busca(String no, int distanciaMaxima, IDistanceCalculator calculator) {

		ArrayList<Palavra> palavraCompativel = new ArrayList<Palavra>();

		double distancia = (int) calculator.distanciaEntrePalavras(palavra, no);

		double modificador = 1;

		if (!calculator.isKeyboardLayoutNeutro()) {
			modificador = 100;
		}

		distancia = distancia * modificador;
		distanciaMaxima = (int) (distanciaMaxima * modificador);

		if (distancia <= distanciaMaxima) {
			palavraCompativel.add(new Palavra(palavra, distancia / modificador));
		}

		if (filhos.size() == 0) {
			return palavraCompativel;
		}

		for (int i = Math.max(1, (int) distancia - distanciaMaxima); i <= distancia + distanciaMaxima; i++) {

			No filho = filhos.get(i);
			if (filho != null) {
				palavraCompativel.addAll(filho.busca(no, distanciaMaxima / (int) modificador, calculator));
			}
		}
		return palavraCompativel;

	}
}
