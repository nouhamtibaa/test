package test;


public  class Solution {


	public static int[] solution(int N, int[] A) throws Exception {
	    int[] result = new int[N];
	    int maximum = 0;
	    int resetLimit = 0;

	    for (int K = 0; K < A.length; K++)
	    {
	        if (A[K] < 1 || A[K] > N + 1)
	            throw new Exception();

	        if (A[K] >= 1 && A[K] <= N)
	        {
	            if (result[A[K] - 1] < resetLimit) {
	                result[A[K] - 1] = resetLimit + 1;
	            } else {
	                result[A[K] - 1]++;
	            }

	            if (result[A[K] - 1] > maximum)
	            {
	                maximum = result[A[K] - 1];
	            }
	        }
	        else
	        {
	        	 // inefficiency here
	            //for (int i = 0; i < result.Length; i++)
	            //    result[i] = maximum;
	            resetLimit = maximum;
	        }
	    }

	    for (int i = 0; i < result.length; i++)
	        result[i] = Math.max(resetLimit, result[i]);

	    return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	   public static int[] solution1(int[] a, int[] b) {
	        final int[] cn = new int[a.length < 2 ? 2 : a.length];
	        cn[0] = 1;
	        cn[1] = 2;
	        // numbers of combinations are fibonacci numbers
	        // if we take combinations for n - 2, we should add one 2 or two 1 to some places.
	        // but any of these transformations are reduced to the following forms:
	        // 1. combination from (n - 1) and 1
	        // 2. combination from (n - 2) and 2
	        // the same for n - 1. we can should add one 1 to some places.
	        // it gives the same possible outcomes as in the previous case.
	        // Hence the number of combination for n is number of combinations for n - 1 and n - 2
	        // At the same time it cannot be less than this. Suppose it was.
	        // Since all the combinations from n - 1 are appended only by 1 and for n - 2 by 2,
	        // the parts from n - 1 and n - 2 are present only once maximum. In our case it means that some parts are missed.
	        // but it also means, that we can add this part plus 1 or 2. Contraction.
	        for (int i = 2; i < a.length; i++) {
	            // we store values by mod 2**30.
	            // we can do it because (x mod a + y mod a) mod a == (x + y) mod a
	            //later they are easily converted to modulo by power of 2 by removing bits.
	            // 0101 & 2**2 = 0101 & 0011
	            cn[i] = (cn[i - 1] + cn[i - 2]) & ((1 << 30) - 1);
	        }
	        for (int i = 0; i < a.length; i++) {
	            a[i] = cn[a[i] - 1] & ((1 << b[i]) - 1);
	        }
	        return a;
	    }
	
	
	


	   
	   
	   
	   
	   
	
		    public static int solution3(int[] a) {
		        if (a.length == 0) {
		            return 0;
		        }
		        int sum = 0;
		        int max = Integer.MIN_VALUE;
		        // O(N)
		        for (int i = 0; i < a.length; i++) {
		            final int value = Math.abs(a[i]);
		            sum += value;
		            if (max < value) {
		                max = value;
		            }
		            a[i] = value;
		        }
		        // O(max(abs(a))) space but no more than O(sum(abs(a))), so ignore it
		        // O(N)
		        final int[] counts = new int[max + 1];
		        for (int value: a) {
		            counts[value]++;
		        }
		        // O(sum(abs(a)))
		        final int[] r = new int[sum + 1];
		        for (int i = 1; i < r.length; i++) {
		            r[i] = -1;
		        }
		        // outer is O(max(abs(a)))
		        // inner is O(sum(abs(a))) which is less than O(N * max(abs(a)))
		        // we don't care of 0 values
		        for (int i = 1; i < counts.length; i++) {
		            // we check r[j]. if it's not less than 0, then it means we've reached j value with previous steps, so no need to spend current
		            // if it's less than 0, spend 1 current number if r[j - i] has been reached
		            for (int j = 0; j < r.length; j++) {
		                // negative value means we haven't reached this value, so we have to spend 1 current if we can
		                if (r[j] >= 0) {
		                    r[j] = counts[i];
		                } else if (j - i >= 0 && r[j - i] > 0) {
		                    r[j] = r[j - i] - 1;
		                }
		                // the value in r[j] then means how many of the current values are left when we reached the value j
		            }
		        }
		        int result = sum;
		        // don't have to traverse all the arrays, since i - the sum of elements. if it's reachable then (sum - i) - reachable as well.
		        // so if the value is reachable then the diff is abs(i - (sum - i)), which is the same as abs(sum - 2 * i)
		        for (int i = 0; i < r.length / 2 + 1; i++) {
		            if (r[i] >= 0 && result > Math.abs(sum - 2 * i)) {
		                result = Math.abs(sum - 2 * i);
		            }
		        }
		        return result;
		    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
	    }
