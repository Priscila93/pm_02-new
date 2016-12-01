package teclado;

import java.util.ArrayList;

/** 
* Classe para criação de teclados
* 
* @author marcella e priscila
*/

public class KeyboardLayout {

	private static final double valorInsercaoDelecao = 0.25;
	private final int tamanhoAlfabeto = 26;
	private final int posicaoDaLetra = 65;
	private double distanciaMaxima;

	private String modelo;
	private ArrayList<Linha> linhas;

	private ParOrdenado[] tabela;

        /** 
         * Construtor
         */
	public KeyboardLayout() {
		linhas = new ArrayList<Linha>();
		tabela = new ParOrdenado[tamanhoAlfabeto];
	}
  
        /** 
         *Get do modelo do teclado
        */
	public String getModelo() {
		return modelo;
	}
        
        /** 
        *   Set do modelo do teclado
        */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
       
        /** 
        *   Get das linhas do teclado, incluindo offset
        */
        public ArrayList<Linha> getLinhas() {
		return linhas;
	}
        
        /** 
        *   Set das linhas do teclado, incluindo offset
        */
	public void setLinhas(ArrayList<Linha> linhas) {
		this.linhas = linhas;
	}
        
        /**
	 * Adiciona uma nova linha ao teclado, incluindo offset, se houver
	 */
	public void adicionarLinha(Linha linha) {
		linhas.add(linha);
	}
          
	protected ParOrdenado[] getTabela() {
		return tabela;
	}

	protected void setTabela(ParOrdenado[] tabela) {
		this.tabela = tabela;
	}
              
	/**
	 * Prepara o vetor de pares ordenados facilitando o calculo da distancia
	 * Instancia o valor da maior distancia ao fim
	 */
	public void preparaDistancia() {

		double absolutOfsset = 0;
		int altura = 0;
		for (Linha linha : linhas) {
			absolutOfsset += linha.getOffset();
			for (int i = 0; i < linha.getLength(); i++) {
				char letras = linha.charAt(i);

				ParOrdenado parOrdenado = new ParOrdenado(i + absolutOfsset, altura);

				tabela[letras - posicaoDaLetra] = parOrdenado;
			}
			altura++;
		}
		calculaDistanciaMaxima();
	}

	/**
	 * Pega a distancia nominal entre duas letras de acordo com o teclado
	 */
	public double getDistanciaNominal(char primeiraLetra, char segundaLetra) {
		if (primeiraLetra == segundaLetra) {
			return 0;
		}
		primeiraLetra = Character.toUpperCase(primeiraLetra);
		segundaLetra = Character.toUpperCase(segundaLetra);

		ParOrdenado par1 = tabela[primeiraLetra - posicaoDaLetra];
		ParOrdenado par2 = tabela[segundaLetra - posicaoDaLetra];

		double diferencaLargura = Math.abs(par1.getLargura() - par2.getLargura());

		double diferencaAltura = Math.abs(par1.getAltura() - par2.getAltura());

		return dist(diferencaLargura, diferencaAltura);
	}

	/**
	 * Calcula a hipotenusa para achar a distancia de duas teclas no teclado
	 */
	private double dist(double largura, double altura) {
		return Math.sqrt(largura * largura + altura * altura);

	}

	/**
	 * Retorna valor preestabelecido para inserções e deleções
	 */
	public double getDistanciaInsercaoDelecao() {
		return valorInsercaoDelecao;
	}

	/**
	 * Retorna a maior distancia
	 */
	public double getDistanciaMaxima() {
		return distanciaMaxima;
	}

	/**
	 * Calculo da maior distancia
	 */

	private void calculaDistanciaMaxima() {
		double max = 0;
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela.length; j++) {
				char c1 = (char) ((char) posicaoDaLetra + i);
				char c2 = (char) ((char) posicaoDaLetra + j);

				if (getDistanciaNominal(c1, c2) > max)
					max = getDistanciaNominal(c1, c2);
			}
		}
		distanciaMaxima = max;
	}

	@Override
	public String toString() {
		String string = modelo + "\n \n";
		for (Linha line : linhas) {
			string += line + "\n";
		}
		string += "\n";
		return string;
	}

	/**
	 * Retorna o valor relativo da distancia de duas teclas pelo maximo do
	 * teclado
	 */
	public double getDistanciaRelativa(char primeiraLetra, char segundaLetra) {
		return (getDistanciaNominal(primeiraLetra, segundaLetra) / getDistanciaMaxima());
	}

	/**
	 * Diferencia o teclado neutro dos demais
	 * 
	 */
	public boolean isNeutro() {
		return false;
	}

}