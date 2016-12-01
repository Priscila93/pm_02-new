package teclado;

/**
 * Classe para montar uma linha do teclado
 *   @author marcella e priscila
 */
public class Linha {

	private String letras;
	private double offset;

        /** 
        * Get das letras
        */
	public String getLetras() {
		return letras;
	}

        /** 
        * Set das letras
        */
	public void setLetras(String letras) {
		this.letras = letras;
	}

        /** 
        * Get do offset
        */
	public double getOffset() {
		return offset;
	}

        /** 
        * Set do offset
        */
	public void setOffset(double offset) {
		this.offset = offset;
	}

	public char charAt(int i) {
		return letras.charAt(i);
	}

        /** 
        * Get do tamanho
        */
	public int getTamanho() {
		return letras.length();
	}

        /** 
        * Get do lenght
        */
	public int getLength() {
		return letras.length();
	}

	@Override
	public String toString() {
		String string = letras + " " + offset;
		return string;
	}

}