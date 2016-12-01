package teclado;

import java.util.ArrayList;
import java.util.List;

/** 
* Classe com arraylist de teclados
* 
* @author marcella e priscila
*/

public class KeyboardLayoutList {

	private List<KeyboardLayout> layouts;

	/**
	 * Adiciona teclado individualmente
	 */
	public void adiciona(KeyboardLayout keyboardLayout) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		layouts.add(keyboardLayout);
	}

	/**
	 * Retorna um KeyboardLayout de acordo com o nome de entrada
	 */
	public KeyboardLayout getLayoutPorNome(String layoutNome) {
		
		layoutNome = layoutNome.toUpperCase();
		KeyboardLayout layout = null;
		
		for (KeyboardLayout keyboardLayout : layouts) {
			if (keyboardLayout.getModelo().equals(layoutNome)) {
				layout = keyboardLayout;
			}
		}
		return layout;
	}

	/**
	 * Retorna lista dos layouts
	 */
	public List<KeyboardLayout> getList() {
		return layouts;
	}

	public void setList(List<KeyboardLayout> layouts) {
		if (layouts == null) {
			layouts = new ArrayList<KeyboardLayout>();
		}
		this.layouts = layouts;
	}

	@Override
	public String toString() {
		String string = "";
		for (KeyboardLayout keyboardLayout : layouts) {
			string += keyboardLayout.toString();
		}

		return string;
	}
}
