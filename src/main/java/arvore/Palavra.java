package arvore;

public class Palavra implements Comparable<Palavra> {

	private String palavra;
	private double distancia;

	public Palavra(String palavra, double distancia) {
		this.palavra = palavra;
		this.distancia = distancia;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int compareTo(Palavra palavra) {
		if (this.distancia < palavra.getDistancia()) {
			return -1;
		}
		if (this.distancia > palavra.getDistancia()) {
			return 1;
		}
		return 0;
	}
}
