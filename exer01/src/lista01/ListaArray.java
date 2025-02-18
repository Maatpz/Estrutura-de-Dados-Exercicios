public class ListaArray {
	final public static int TAMANHO_INICIAL = 3;
	final public static int FATOR_CRESCIMENTO = 5;
	final public static int NAO_ESTA_PRESENTE = -1;
	//
	// ATRIBUTOS
	//
	private Object[] arrayInterno;
	private int numElementos;
	//
	// MÉTODOS
	//
	public ListaArray() {
		this.numElementos = 0; 
		this.arrayInterno = new Object[TAMANHO_INICIAL];
	}
	
	private void verificarNecessidadeDeCrescimento() {
		
		int tamanho = this.arrayInterno.length;

		if (tamanho == this.numElementos) {
			// Criação de um array maior
			Object[] novoArray = new Object[tamanho + FATOR_CRESCIMENTO];

			// Copiando as referências que estão no arrayInterno para o novo array
			for (int i = 0; i < tamanho; i++) {
				novoArray[i] = this.arrayInterno[i];
			}
			// O novo array passa a ser o arrayInterno
			this.arrayInterno = novoArray;
		}
	}
	/**
	 * @param elemento
	 * @return 
	 */
	public boolean adicionar(Object elemento) {
	
		this.verificarNecessidadeDeCrescimento();

		
		this.arrayInterno[this.numElementos] = elemento;

		
		this.numElementos++;

		
		return true;
	}
	/**
	 * @param elemento 
	 * @return true: Se a posição for plausível; false: se posição for inválida
	 */
	public boolean adicionar(Object elemento, int posicao) {
	
		if (posicao < 0 || posicao > this.numElementos) {
			return false;
		}
		// Verificando se o arrayInterno tem espaço para a inclusão do elemento
		this.verificarNecessidadeDeCrescimento();

		// Deslocando os elementos para abrir espaço para o elemento no array na posição indicada
		for (int i = this.numElementos; i > posicao; i--) {
			this.arrayInterno[i] = this.arrayInterno[i - 1];
		}

		// Colocando a referência para o elemento na posição passada
		this.arrayInterno[posicao] = elemento;

		return true;
	}
	/**
	 * @param posicao 
	 * @return
	 */
	public Object obter(int posicao) {
	
		if (posicao < 0 || posicao >= this.numElementos)
			return null;
	
		return this.arrayInterno[posicao];
	}
	/**
	 * @param elemento 
	 * @return 
	 */
	public int posicaoDe(Object elemento) {
		
		for (int i = 0; i < this.numElementos; i++) {
			// Se na posição 'i' estiver quem estamos procurando, retornamos o valor de 'i'
			if (this.arrayInterno[i] == elemento)
				return i;
		}
		return NAO_ESTA_PRESENTE;
	}
	/**
	 * @param posicao
	 * @return
	 */
	public boolean remover(int posicao) {

		if (posicao < 0 || posicao >= this.numElementos)
			return false;

		for (int i = posicao; i < this.numElementos - 1; i++) {
			this.arrayInterno[i] = this.arrayInterno[i + 1];
		}
		// Para que a última posição não fique duplicada
		this.arrayInterno[this.numElementos - 1] = null;

		this.numElementos--;

		return true;
	}
	/**
	 * @param elemento - 
	 * @return
	 */
	public boolean remover(Object elemento) {
		int posicao = this.posicaoDe(elemento);

		if (posicao == NAO_ESTA_PRESENTE)
			return false;
		return this.remover(posicao);
	}
	/**
	 * @return 
	 */
	public int obterNumElementos() {
		return this.numElementos;
	}
}