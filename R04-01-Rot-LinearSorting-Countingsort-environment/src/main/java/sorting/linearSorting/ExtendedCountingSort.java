package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
	if (array.length != 0 && leftIndex >= 0 && rightIndex >= 0 && rightIndex > leftIndex)
	{
		Integer smallerElement = getSmallerElement(array, leftIndex, rightIndex);
		Integer biggestElement = getBiggerElement(array, leftIndex, rightIndex);

		Integer[] auxArrayCounting = new Integer[biggestElement - smallerElement + 1];
		fillArrayWithZeros(auxArrayCounting);
		Integer[] auxArraySort = new Integer[(rightIndex - leftIndex) + 1];

		for (int i = leftIndex; i < rightIndex + 1; i++)
		{
			auxArrayCounting[array[i] - smallerElement] += 1;
		}

		for (int j = 1; j < auxArrayCounting.length; j++)
		{
			auxArrayCounting[j] += auxArrayCounting[j - 1];
		}

		for(int k = rightIndex; k >= leftIndex ; k--)
		{
			auxArraySort[auxArrayCounting[array[k] - smallerElement] - 1] = array[k];
			auxArrayCounting[array[k] - smallerElement] -= 1;
		}

		int indexArrayOrd = 0;
		for (int l = leftIndex; l < rightIndex + 1; l++)
		{
			array[l] = auxArraySort[ indexArrayOrd ];
			indexArrayOrd++;
		}
	}
	}
	public void fillArrayWithZeros(Integer[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			array[i] = 0;
		}
	}
	public Integer getBiggerElement(Integer[] array, int leftIndex, int rightIndex)
	{
		int biggestElement = array[leftIndex];

		for (int i = leftIndex; i < rightIndex + 1; i++)
		{
			if (array[i].compareTo(biggestElement) > 0)
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
			if (array[i].compareTo(smallerElement) < 0)
			{
				smallerElement = array[i];
			}
		}
		return smallerElement;
	}

}
