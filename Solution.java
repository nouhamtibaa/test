package test;


public  class Solution {

/*  ************ Algo 1 **************** */
	
	public static int[] solution(int N, int[] A) throws Exception {
	    int[] Monresult = new int[N];
	    int maximum = 0;
	    int resetLim = 0;

	    for (int i = 0; i < A.length; i++)
	    {
	        if (A[i] < 1 || A[i] > N + 1)
	            throw new Exception();

	        if (A[i] >= 1 && A[i] <= N)
	        {
	            if (Monresult[A[i] - 1] < resetLim) {
	            	Monresult[A[i] - 1] = resetLim + 1;
	            } else {
	            	Monresult[A[i] - 1]++;
	            }

	            if (Monresult[A[i] - 1] > maximum)
	            {
	                maximum = Monresult[A[i] - 1];
	            }
	        }
	        else
	        {
	        
	            resetLim = maximum;
	        }
	    }

	    for (int i = 0; i < Monresult.length; i++)
	    	Monresult[i] = Math.max(resetLim, Monresult[i]);

	    return Monresult;
	}
	
	
	
	
	
	
	/*  ************ Algo 2 **************** */
	
	
	
	
	
	
	
	   public static int[] solution1(int[] a, int[] b) {
		   
		   int leng = 0; 
		   if (a.length<2) {
			   leng = 2;
		   } else
			   leng= a.length;
		   
	        final int[] cm = new int[leng];
	        cm[0] = 1;
	        cm[1] = 2;
	      
	        for (int i = 2; i < a.length; i++) {
	        
	        	cm[i] = (cm[i - 1] + cm[i - 2]) & ((1 << 30) - 1);
	        }
	        for (int i = 0; i < a.length; i++) {
	            a[i] = cm[a[i] - 1] & ((1 << b[i]) - 1);
	        }
	        return a;
	    }
	
	
	


	   
	   

		/*  ************ Algo 3 **************** */   
	   
	   
	
		    public static int solution3(int[] a) {
		        if (a.length == 0) {
		            return 0;
		        }
		        int sum = 0;
		        int maximum = Integer.MIN_VALUE;
		    
		        for (int i = 0; i < a.length; i++) {
		            final int value = Math.abs(a[i]);
		            sum += value;
		            if (maximum < value) {
		            	maximum = value;
		            }
		            a[i] = value;
		        }
		       
		        final int[] counts = new int[maximum + 1];
		        for (int value: a) {
		            counts[value]++;
		        }
		  
		        final int[] c = new int[sum + 1];
		        for (int i = 1; i < c.length; i++) {
		            c[i] = -1;
		        }
		   
		        for (int i = 1; i < counts.length; i++) {
		      
		            for (int j = 0; j < c.length; j++) {
		                if (c[j] >= 0) {
		                    c[j] = counts[i];
		                } else if (j - i >= 0 && c[j - i] > 0) {
		                    c[j] = c[j - i] - 1;
		                }
		            }
		        }
		        int resultat = sum;

		        for (int i = 0; i < c.length / 2 + 1; i++) {
		            if (c[i] >= 0 && resultat > Math.abs(sum - 2 * i)) {
		                resultat = Math.abs(sum - 2 * i);
		            }
		        }
		        return resultat;
		    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
	    }
