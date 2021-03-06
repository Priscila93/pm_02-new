package arvore;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Árvore de ordenação
 * 
 * @author marcella e priscila
 *
 */
public class BurkhardKellerTreeSearchResult {

	private ArrayList<Palavra> palavras;

	public BurkhardKellerTreeSearchResult(ArrayList<Palavra> palavras) {
		this.palavras = palavras;

		for (Palavra palavra : palavras) {
			System.out.println(palavra.getPalavra());
		}
		Collections.sort(palavras);

	}

        /** 
        * get da palavra
        */
	public String getPalavra(int posicao) {
		return palavras.get(posicao).getPalavra();
	}
/** 
        * get da distancia
        */
	public double getDistancia(int posicao) {
		return palavras.get(posicao).getDistancia();
	}

}
