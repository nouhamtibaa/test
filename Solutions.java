package test;

public class Solutions {

	public static void main(String[] args) throws Exception {
		int [] monTableau = {3,4,4,6,1,4,4};
		int [] a = {4,4,5,5,1};
		int [] b = {3,2,4,3,1};
		int [] c = {1,5,2,-2};
		int[] result = Solution.solution(5, monTableau);
		int [] res = Solution.solution1(a,b);
		for (int i=0; i<result.length; i++) {
			System.out.print(result[i]);
			
		}
		
	/*	for(int i=0; i< res.length; i++) {
			System.out.print(res[i]);
		}
	
*/
		int res1 = Solution.solution3(c);
		
	/**	System.out.print(res1);*/
}}
