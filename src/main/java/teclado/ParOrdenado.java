package teclado;

/**
 *
 *  Classe que calcula o par ordenado 
 * 
 *  @author marcella e priscila
 */

public class ParOrdenado {

	private double largura;
	private double altura;

	/**
	 * Par ordenado com largura e altura da posição de uma tecla(letra)
	 */
	public ParOrdenado(double largura, double altura) {
		this.largura = largura;
		this.altura = altura;
	}

        /** 
        * Get da largura
        */
	public double getLargura() {
		return largura;
	}

        /** 
        * Set da largura
        */
	public void setLargura(double largura) {
		this.largura = largura;
	}

        /** 
        * Get da altura
        */
	public double getAltura() {
		return altura;
	}

        /** 
        * Set da altura
        */
	public void setAltura(double altura) {
		this.altura = altura;
	}

}