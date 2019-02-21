package Searching_and_Sorting;

public class SortingAlgorithms
{
	public static void InsertionSort(int [] array){
		sort( array.length-1, 1, array);
	}

	public static void sort(int unsorted, int position, int array []){
		if(unsorted == 0) return;
		if(position < array.length){
			int value = array[position];
			shift(array, position, value);
			sort(unsorted-1, position+1, array);
		}
	}

	private static void shift(final int[] array, final int position, final int value)
	{
		int starting = position -1;
		while(starting >= 0 && array[starting] > value){
			 array[starting+1] = array[starting];
			starting --;
		}
		array[starting+1] = value;
	}

	public static void MergeSort(int [] list, final int left, int right){
		if(left == right) return;
		int mid = (left + right)/2;

		MergeSort(list, 0, mid);
		MergeSort(list, mid+1, list.length-1);
		Merge(list, left, mid, right);
	}

	public static void Merge(int [] list, int left, int mid, int right){
		return;
	}

	public static void main(String[] args)
	{
		InsertionSort(new int [] {7,2,4,1,5,3});
		MergeSort(new int [] {7,2,4,1,5,3}, 0, 6);
	}


}
