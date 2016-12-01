
package arvore;

import distancias.IDistanceCalculator;

public class BurkhardKellerTree {

	private Node root;

	private IDistanceCalculator calculator;

	public BurkhardKellerTree(IDistanceCalculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Adiciona no a partir de string passada e adiciona o no na árvore
	 */
	public void addNode(String no) {

		if (no == null || no.isEmpty()) {
		} else {
			Node newNode = new Node(no);
			if (root == null) {
				root = newNode;
			} else {
				add(root, newNode);
			}
		}
	}

	/**
	 * Adiciona nó na árvore de acordo com a distancia do DistanceCalculator
	 */
	private void add(Node srcNode, Node newNode) {

		if (srcNode.equals(newNode)) {
			return;
		}

		double distance = calculator.distanciaEntrePalavras(srcNode.getWord(), newNode.getWord());

		if (!calculator.isKeyboardLayoutNeutro()) {
			int modificador = 100;
			distance = distance * modificador;
		}

		Node bkNode = srcNode.filhoNumaDistancia((int) distance);
		if (bkNode == null) {
			srcNode.addChildNode((int) distance, newNode);
		}

		// senao adiciona nó como filho
		else {
			add(bkNode, newNode);
		}
	}

	/**
	 * Funcao para busca de nó com uma distancia máxima
	 */
	public BurkhardKellerTreeSearchResult search(String word, int distanciaMaximaPermitida, int maxWords) {
		return new BurkhardKellerTreeSearchResult(root.search(word, distanciaMaximaPermitida, calculator));

	}

}
