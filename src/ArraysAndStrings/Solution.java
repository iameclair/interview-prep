package ArraysAndStrings;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import javax.management.openmbean.ArrayType;


public class Solution
{
	//string permutation
	public ArrayList<String> permutation(String s)
	{
		ArrayList<String> results = new ArrayList<>();
		return permutations("", s, results);
	}

	public ArrayList<String> permutations(String prefix, String suffix, ArrayList<String> results)
	{
		if(suffix.length() == 0) results.add(prefix);
		else
			for(int i = 0; i < suffix.length(); i++){
				permutations(prefix + suffix.charAt(i), suffix.substring(0,i)+
						suffix.substring(i+1, suffix.length()), results);
			}
			return results;
	}

	//longest common sub-sequence




	public static void main(String[] args)
	{
		Solution solution = new Solution();
		System.out.println(solution.permutation("abc"));
	}

}
