package arvore;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import distancias.DamerauLevenshteinCalculator;
import distancias.IDistanceCalculator;
import distancias.LevenshteinCalculator;
import teclado.KeyboardLayout;
import teclado.KeyboardLayoutList;
import teclado.KeyboardLayoutNeutro;
import leituras.KeyboardLayoutReader;
import static org.junit.Assert.assertEquals;

/**
 * Casos de teste de distanciaEntrePalavras entre palavras
 */
public class WordTest {

	private static KeyboardLayoutList layouts;

	@BeforeClass
	public static void setup() {
		layouts = new KeyboardLayoutReader().loadFromFile("layouts.xml");
	}

	@Test
	public void testDemerauTecladoNeutro() {
		KeyboardLayout layout = new KeyboardLayoutNeutro();
		layout.preparaDistancia();

		IDistanceCalculator calculator = new DamerauLevenshteinCalculator(layout);

		assertEquals(0, calculator.distanciaEntrePalavras("casa", "casa"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "asa"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "cas"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casar"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casal"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "causa"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casba"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casta"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "caca"), 0.01);

		assertEquals(1.0, calculator.distanciaEntrePalavras("cervega", "cerveja"), 0.01);
		assertEquals(2.0, calculator.distanciaEntrePalavras("cervega", "cereja"), 0.01);
		assertEquals(2.0, calculator.distanciaEntrePalavras("cervega", "corveta"), 0.01);
		assertEquals(2.0, calculator.distanciaEntrePalavras("cervega", "corveia"), 0.01);
		assertEquals(2.0, calculator.distanciaEntrePalavras("cervega", "certeza"), 0.01);

	}

	@Test
	public void testLevenshteintTecladoNeutro() {

		KeyboardLayout layout = new KeyboardLayoutNeutro();
		layout.preparaDistancia();
		IDistanceCalculator calculator = new LevenshteinCalculator(layout);

		assertEquals(0.0, calculator.distanciaEntrePalavras("casa", "casa"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "asa"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "cas"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casar"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casal"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "causa"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casba"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casca"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "casta"), 0.01);
		assertEquals(1.0, calculator.distanciaEntrePalavras("casa", "caca"), 0.01);

		assertEquals(1.0, calculator.distanciaEntrePalavras("cervega", "cerveja"), 0.01);
		assertEquals(2.0, calculator.distanciaEntrePalavras("cervega", "cereja"), 0.01);
		assertEquals(2.0, calculator.distanciaEntrePalavras("cervega", "cereja"), 0.01);
		assertEquals(3.0, calculator.distanciaEntrePalavras("cervega", "xereta"), 0.01);

	}

	@Test
	public void testLevenshteinTecladoQwerty() {
		KeyboardLayout layout = layouts.getLayoutPorNome("QWERTY");
		layout.preparaDistancia();
		IDistanceCalculator calculator = new LevenshteinCalculator(layout);

		assertEquals(0.0, calculator.distanciaEntrePalavras("casa", "casa"), 0.01);
		assertEquals(0.11, calculator.distanciaEntrePalavras("casa", "cada"), 0.01);
		assertEquals(0.20, calculator.distanciaEntrePalavras("casa", "caca"), 0.01);
		assertEquals(0.20, calculator.distanciaEntrePalavras("casa", "cara"), 0.01);
		assertEquals(0.23, calculator.distanciaEntrePalavras("casa", "fada"), 0.01);
		assertEquals(0.23, calculator.distanciaEntrePalavras("casa", "vaza"), 0.01);
		// assertEquals(0.25, calculator.distanciaEntrePalavras("casa", "asa"), 0.01);
		assertEquals(0.25, calculator.distanciaEntrePalavras("casa", "cas"), 0.01);
		assertEquals(0.25, calculator.distanciaEntrePalavras("casa", "casal"), 0.01);
		assertEquals(0.25, calculator.distanciaEntrePalavras("casa", "casar"), 0.01);

		assertEquals(0.22, calculator.distanciaEntrePalavras("cervega", "cerveja"), 0.01);
		assertEquals(0.47, calculator.distanciaEntrePalavras("cervega", "cereja"), 0.01);
		assertEquals(0.48, calculator.distanciaEntrePalavras("cervega", "xereta"), 0.01);
		assertEquals(0.54, calculator.distanciaEntrePalavras("cervega", "verbete"), 0.01);
		assertEquals(0.57, calculator.distanciaEntrePalavras("cervega", "careta"), 0.01);
		assertEquals(0.57, calculator.distanciaEntrePalavras("cervega", "ferver"), 0.01);
		assertEquals(0.57, calculator.distanciaEntrePalavras("cervega", "carreta"), 0.01);
		assertEquals(0.58, calculator.distanciaEntrePalavras("cervega", "vereda"), 0.01);

		assertEquals(0.59, calculator.distanciaEntrePalavras("cervega", "refrega"), 0.01);
		assertEquals(0.61, calculator.distanciaEntrePalavras("cervega", "cerca"), 0.01);

	}

	@Test
	public void testLevenshteinTecladoDvorak() {
		KeyboardLayout layout = layouts.getLayoutPorNome("DVORAK");
		layout.preparaDistancia();
		IDistanceCalculator calculator = new LevenshteinCalculator(layout);

		assertEquals(0.0, calculator.distanciaEntrePalavras("casa", "casa"), 0.01);
		assertEquals(0.11, calculator.distanciaEntrePalavras("casa", "cana"), 0.01);
		assertEquals(0.11, calculator.distanciaEntrePalavras("casa", "caso"), 0.01);
		assertEquals(0.15, calculator.distanciaEntrePalavras("casa", "cara"), 0.01);
		assertEquals(0.15, calculator.distanciaEntrePalavras("casa", "nasa"), 0.01);
		assertEquals(0.22, calculator.distanciaEntrePalavras("casa", "gana"), 0.01);
		assertEquals(0.22, calculator.distanciaEntrePalavras("casa", "cano"), 0.01);
		assertEquals(0.22, calculator.distanciaEntrePalavras("casa", "gala"), 0.01);
		assertEquals(0.22, calculator.distanciaEntrePalavras("casa", "tala"), 0.01);
		assertEquals(0.22, calculator.distanciaEntrePalavras("casa", "tosa"), 0.01);

		assertEquals(0.26, calculator.distanciaEntrePalavras("cervega", "corveta"), 0.01);
		assertEquals(0.35, calculator.distanciaEntrePalavras("cervega", "corveia"), 0.01);
		assertEquals(0.37, calculator.distanciaEntrePalavras("cervega", "corneta"), 0.01);
		assertEquals(0.44, calculator.distanciaEntrePalavras("cervega", "corrego"), 0.01);
		assertEquals(0.47, calculator.distanciaEntrePalavras("cervega", "cornea"), 0.01);
		assertEquals(0.47, calculator.distanciaEntrePalavras("cervega", "colega"), 0.01);
		assertEquals(0.48, calculator.distanciaEntrePalavras("cervega", "nervura"), 0.01);
		assertEquals(0.49, calculator.distanciaEntrePalavras("cervega", "cerveja"), 0.01);
		assertEquals(0.51, calculator.distanciaEntrePalavras("cervega", "centena"), 0.01);
		assertEquals(0.55, calculator.distanciaEntrePalavras("cervega", "ternura"), 0.01);
	}

}
