package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) 
	{
		if (array.length != 0 && leftIndex >= 0 && rightIndex >= 0 && rightIndex > leftIndex)
		{
			Integer biggestElement = getBiggerElement(array, leftIndex, rightIndex);

			Integer[] auxArrayCounting = new Integer[biggestElement + 1];
			Integer[] auxArraySort = new Integer[array.length];

			for (int i = leftIndex; i < rightIndex + 1; i++)
			{
				auxArrayCounting[array[i]] += 1;
			}

			for (int j = 1; j < auxArrayCounting.length; j++)
			{
				auxArrayCounting[j] += auxArrayCounting[j - 1];
			}

			for(int k = rightIndex; k >= leftIndex ; k++)
			{
				auxArraySort[auxArrayCounting[array[k]]] = array[k];
				auxArrayCounting[array[k]] -= 1;
			}

			for (int l = leftIndex; l < rightIndex + 1; l++)
			{
				array[l] = auxArraySort[l];
			}
		}	
	}
	public Integer getBiggerElement(Integer[] array, int leftIndex, int rightIndex)
	{
		int biggestElement = array[leftIndex];

		for (int i = leftIndex; i < rightIndex + 1; i++)
		{
			if (array[i].compareTo(array[biggestElement]) > 0)
			{
				biggestElement = array[i];
			}
		}
		return biggestElement;
	}
	public Integer getSmallerElement(Integer[] array, int leftIndex, int rightIndex)
	{
		int smallerElement = array[leftIndex];

		for (int i = leftIndex; i < rightIndex + 1; i++)
		{
			if (array[i].compareTo(array[smallerElement]) > 0)
			{
				smallerElement = array[i];
			}
		}
		return smallerElement;
	}

}
