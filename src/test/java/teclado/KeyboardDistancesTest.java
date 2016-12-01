package teclado;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import teclado.KeyboardLayout;
import teclado.KeyboardLayoutList;
import leituras.KeyboardLayoutReader;

/**
 * Casos de teste para distância entre teclas em modelos de teclado
 *
 * @author Marcio Barros
 */
public class KeyboardDistancesTest {
	private static KeyboardLayoutList layouts;

	@BeforeClass
	public static void setup() {
		layouts = new KeyboardLayoutReader().loadFromFile("layouts.xml");
	}

	@Test
	public void testQwerty() {
		KeyboardLayout layout = layouts.getLayoutPorNome("QWERTY");
		layout.preparaDistancia();
		assertEquals(dist(9.0, 0), layout.getDistanciaMaxima(), 0.001);
		assertEquals(0.0, layout.getDistanciaNominal('q', 'q'), 0.001);

		assertEquals(1.0, layout.getDistanciaNominal('q', 'w'), 0.001);
		assertEquals(1.0, layout.getDistanciaNominal('w', 'q'), 0.001);

		assertEquals(2.0, layout.getDistanciaNominal('q', 'e'), 0.001);
		assertEquals(2.0, layout.getDistanciaNominal('e', 'q'), 0.001);

		assertEquals(9.0, layout.getDistanciaNominal('q', 'p'), 0.001);
		assertEquals(9.0, layout.getDistanciaNominal('p', 'q'), 0.001);

		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('q', 'a'), 0.001);
		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('a', 'q'), 0.001);

		assertEquals(dist(1.5, 1), layout.getDistanciaNominal('q', 's'), 0.001);
		assertEquals(dist(1.5, 1), layout.getDistanciaNominal('s', 'q'), 0.001);

		assertEquals(dist(8.5, 1), layout.getDistanciaNominal('q', 'l'), 0.001);
		assertEquals(dist(8.5, 1), layout.getDistanciaNominal('l', 'q'), 0.001);

		assertEquals(dist(1.0, 2), layout.getDistanciaNominal('q', 'z'), 0.001);
		assertEquals(dist(1.0, 2), layout.getDistanciaNominal('z', 'q'), 0.001);

		assertEquals(dist(2.0, 2), layout.getDistanciaNominal('q', 'x'), 0.001);
		assertEquals(dist(2.0, 2), layout.getDistanciaNominal('x', 'q'), 0.001);

		assertEquals(dist(7.0, 2), layout.getDistanciaNominal('q', 'm'), 0.001);
		assertEquals(dist(7.0, 2), layout.getDistanciaNominal('m', 'q'), 0.001);

		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('w', 'a'), 0.001);
		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('a', 'w'), 0.001);

		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('w', 's'), 0.001);
		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('s', 'w'), 0.001);

		assertEquals(dist(0.0, 2), layout.getDistanciaNominal('w', 'z'), 0.001);
		assertEquals(dist(0.0, 2), layout.getDistanciaNominal('z', 'w'), 0.001);

		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('a', 'z'), 0.001);
		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('z', 'a'), 0.001);

		assertEquals(dist(8.0, 2), layout.getDistanciaNominal('p', 'z'), 0.001);
		assertEquals(dist(8.0, 2), layout.getDistanciaNominal('z', 'p'), 0.001);

		assertEquals(dist(0.5, 1), layout.getDistanciaNominal('g', 't'), 0.001);
		assertEquals(dist(1.5, 1), layout.getDistanciaNominal('a', 'e'), 0.001);
		assertEquals(dist(1.0, 0), layout.getDistanciaNominal('b', 'v'), 0.001);

		assertEquals(0.25, layout.getDistanciaInsercaoDelecao(), 0.001);
		assertEquals(dist(9.0, 0), layout.getDistanciaMaxima(), 0.001);

	}

	@Test
	public void testDvorak() {
		KeyboardLayout layout = layouts.getLayoutPorNome("DVORAK");
		layout.preparaDistancia();
		assertEquals(dist(3, 1), layout.getDistanciaNominal('p', 'a'), 0.001);
		assertEquals(dist(9, 1), layout.getDistanciaNominal('z', 'a'), 0.001);
		assertEquals(dist(9.055, 0), layout.getDistanciaMaxima(), 0.001);
	}

	private double dist(double width, double height) {
		return Math.sqrt(width * width + height * height);
	}
}

