package sorting.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.*;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorInvertido;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		vetorInvertido = new Integer[] {10, 9, 8, 7, 6, 5 , 4, 3, 2, 1};
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = null;
		
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void countingSortArrayTamPar() {
		// { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 })

		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = vetorTamPar.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorTamPar, 0, vetorTamPar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamPar);
		
	}

	@Test
	public void countingSortArrayTamImpar() {

		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = vetorTamImpar.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorTamImpar, 0, vetorTamImpar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamImpar);
		
	}

	@Test
	public void countingSortArrayElementosRepetidos() {

		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = vetorValoresRepetidos.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1);
		assertArrayEquals(arrayOrdenado, vetorValoresRepetidos);
		
	}

	@Test
	public void countingSortArrayElementosIguais() {

		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = vetorValoresIguais.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorValoresIguais, 0, vetorValoresIguais.length - 1);
		assertArrayEquals(arrayOrdenado, vetorValoresIguais);
		
	}

	@Test
	public void countingSortArrayVazio() {

		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = vetorVazio.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorVazio, 0, vetorVazio.length);
		assertArrayEquals(arrayOrdenado, vetorVazio);
		
	}

	@Test
	public void countingSortArrayCrescente() {

		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = vetorInvertido.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorInvertido, 0, vetorInvertido.length - 1);
		assertArrayEquals(arrayOrdenado, vetorInvertido);
		
	}

	@Test
	public void countingSortPrimeiraMetadeArrayPar() 
	{
		// { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 })
		int middle = vetorTamPar.length/2;
		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = new Integer[]{7, 11, 26, 28, 29, 30, 4, 22, 23, 31};

		countingSort.sort(vetorTamPar, 0, middle);
		assertArrayEquals(arrayOrdenado, vetorTamPar);
		
	}

	@Test
	public void countingSortSegundaMetadeArrayPar() 
	{
		// { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 })
		int middle = vetorTamPar.length/2;
		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = new Integer[]{30, 28, 7, 29, 11, 4, 22, 23, 26, 31 };
		
		countingSort.sort(vetorTamPar, middle, vetorTamPar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamPar);
		
	}

	@Test
	public void countingSortPrimeiraMetadeArrayImpar() 
	{
		// { 6, 41, 32, 7, 26, 4 **, 37, 49, 11, 18, 36 }
		int middle = vetorTamImpar.length/2;
		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = new Integer[]{4, 6, 7, 26, 32, 41, 37, 49, 11, 18, 36};

		countingSort.sort(vetorTamImpar, 0, middle);
		assertArrayEquals(arrayOrdenado, vetorTamImpar);
		
	}

	@Test
	public void countingSortSegundaMetadeArrayImpar() 
	{
		// { 6, 41, 32, 7, 26, 4 **, 37, 49, 11, 18, 36 }
		int middle = vetorTamImpar.length/2;
		CountingSort countingSort = new CountingSort();
		Integer[] arrayOrdenado = new Integer[]{6, 41, 32, 7, 26, 4, 11, 18, 36, 37, 49};

		countingSort.sort(vetorTamImpar, middle, vetorTamImpar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamImpar);
		
	}

	@Test
	public void ExtendedCountingSortVetorTamPar()
	{
		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = vetorTamPar.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorTamPar, 0, vetorTamPar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamPar);
	}

	@Test
	public void ExtendedCountingSortVetorTamImpar()
	{
		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = vetorTamImpar.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorTamImpar, 0, vetorTamImpar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamImpar);
	}

	@Test
	public void extendedCountingSortArrayElementosRepetidos() {

		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = vetorValoresRepetidos.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1);
		assertArrayEquals(arrayOrdenado, vetorValoresRepetidos);
		
	}

	@Test
	public void extendedCountingSortArrayElementosIguais() {

		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = vetorValoresIguais.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorValoresIguais, 0, vetorValoresIguais.length - 1);
		assertArrayEquals(arrayOrdenado, vetorValoresIguais);
		
	}

	@Test
	public void extendedCountingSortArrayVazio() {

		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = vetorVazio.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorVazio, 0, vetorVazio.length);
		assertArrayEquals(arrayOrdenado, vetorVazio);
		
	}

	@Test
	public void extendedCountingArrayCrescente() {

		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = vetorInvertido.clone();
		Arrays.sort(arrayOrdenado);
		countingSort.sort(vetorInvertido, 0, vetorInvertido.length - 1);
		assertArrayEquals(arrayOrdenado, vetorInvertido);
		
	}

	@Test
	public void extendedCountingSortPrimeiraMetadeArrayPar() 
	{
		// { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 })
		int middle = vetorTamPar.length/2;
		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = new Integer[]{7, 11, 26, 28, 29, 30, 4, 22, 23, 31};

		countingSort.sort(vetorTamPar, 0, middle);
		assertArrayEquals(arrayOrdenado, vetorTamPar);
		
	}

	@Test
	public void extendedCountingSortSegundaMetadeArrayPar() 
	{
		// { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 })
		int middle = vetorTamPar.length/2;
		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = new Integer[]{30, 28, 7, 29, 11, 4, 22, 23, 26, 31 };
		
		countingSort.sort(vetorTamPar, middle, vetorTamPar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamPar);
		
	}

	@Test
	public void extendedCountingSortPrimeiraMetadeArrayImpar() 
	{
		// { 6, 41, 32, 7, 26, 4 **, 37, 49, 11, 18, 36 }
		int middle = vetorTamImpar.length/2;
		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = new Integer[]{4, 6, 7, 26, 32, 41, 37, 49, 11, 18, 36};

		countingSort.sort(vetorTamImpar, 0, middle);
		assertArrayEquals(arrayOrdenado, vetorTamImpar);
		
	}

	@Test
	public void extendedCountingSortSegundaMetadeArrayImpar() 
	{
		// { 6, 41, 32, 7, 26, 4 **, 37, 49, 11, 18, 36 }
		int middle = vetorTamImpar.length/2;
		ExtendedCountingSort countingSort = new ExtendedCountingSort();
		Integer[] arrayOrdenado = new Integer[]{6, 41, 32, 7, 26, 4, 11, 18, 36, 37, 49};

		countingSort.sort(vetorTamImpar, middle, vetorTamImpar.length - 1);
		assertArrayEquals(arrayOrdenado, vetorTamImpar);
		
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}