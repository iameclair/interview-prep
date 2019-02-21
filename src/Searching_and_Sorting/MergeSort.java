package Searching_and_Sorting;




public class MergeSort
{
	private Integer [] list;

	public MergeSort(){
		this(10);
	}

	public MergeSort(final int size){
		this.list = new Integer[size];
	}

	public Integer[] merge(Integer [] list, int l, int mid, int r)
	{
		int i = 0 ,j = 0,k = 0;

		while(i <= l && j <= r){
			if(list[i] <= list[j]){
				list[k++] = list[i++];
			}else{
				list[k++] = list[j++];
			}
		}

		for(int x = i; x <=l; x++){
			list[k++] = list[x];
		}

		for(int x = j; x <=r; x++){
			list[k++] = list[x];
		}
		return this.list;
	}

	/**
	 *
	 * @param low begining of the list
	 * @param high end of the list
	 */
	public Integer [] mergeSort(int low, int high){
		//if low is less than high
		if(low < high)
		{
			//find middle of the list
			int mid = (low + high)/2;
			//sort the left side recursively
			mergeSort(0, mid);
			//sort the right side recursively
			mergeSort(mid+1, this.list.length-1);
			//merge the two list together
			return merge(this.list,low,mid, ((mid+1)-(this.list.length-1)));
		}
		return this.list;
	}

	public static void main(String[] args)
	{
		MergeSort mergeSort = new MergeSort();
		mergeSort.list = new Integer[] { 50, 17, 72, 12, 23, 24, 54, 76, 14 };
		mergeSort.mergeSort(0, mergeSort.list.length-1);
	}
}
