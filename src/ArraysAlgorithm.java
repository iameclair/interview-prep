import java.util.Arrays;


public class ArraysAlgorithm
{
	public int [] immediateSmallerElement(int [] array){
		int [] isme = new int[array.length];
		for(int i = 0; i < array.length; i++){
			if(i == array.length-1){
				isme[i] = -1; continue;
			}
			isme[i] = array[i] > array[i+1]? array[i+1] : -1;
		}
		return isme;
	}

	public static void main(String[] args)
	{
		String [] array = "PAX 390-2435565713/ETA3/EUR225.49/16JAN19/ATHA308SP/00773883".split("/");

		if(array[0] != null){
			String s = array[0].split("PAX ")[1].trim();
			System.out.println(s);
		}



	}
}
