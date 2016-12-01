
package teclado;

/**
 * KeyboardLayout com valores que não levam em consideração o teclado
 */
public class KeyboardLayoutNeutro extends KeyboardLayout {

	private static final double valorRetorno = 1.0;

	public KeyboardLayoutNeutro() {

	}

	public String getModelo() {
		return "NEUTRO";
	}

	public double getDistanciaInsercaoDelecao() {
		return valorRetorno;
	}

	public double getDistanciaNominal(char primeriaLetra, char segundaLetra) {
		return valorRetorno;
	}

	public double getDistanciaRelativa(char c1, char c2) {
		return valorRetorno;
	}

	@Override
	public boolean isNeutro() {
		return true;
	}
}
