

public class foobar {
	
	public static void main(String []args){
		//int result = answer(s);
//		int [][] a = {{0, 0, 0, 0, 0}, 
//				{1, 0, 1, 0, 0}, 
//				{0, 1, 0, 1, 0}, 
//				{0, 0, 1, 0, 1}, 
//				{0, 0, 0, 0, 0}};
//		int [][] a = {{0, 2, 1, 0, 0}, 
//				{0, 0, 0, 3, 4}, 
//				{0, 0, 0, 0, 0}, 
//				{0, 0, 0, 0, 0}, 
//				{0, 0, 0, 0, 0}};
//		int [][]a = {{0, 1, 0, 0, 0, 1}, 	
//				{4, 0, 0, 3, 2, 0},
//				{0, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 0, 0}, 
//				{0, 0, 0, 0, 0, 0}, 
//				{0, 0, 0, 0, 0, 0}};

//		int [][]a ={{0, 0, 12, 0, 15, 0, 0, 0, 1, 8},
//		        {0, 0, 60, 0, 0, 7, 13, 0, 0, 0},
//		        {0, 15, 0, 8, 7, 0, 0, 1, 9, 0},
//		        {23, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//		        {37, 35, 0, 0, 0, 0, 3, 21, 0, 0},
//		        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//		        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//		        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//		        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//		        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		int [][]a = {{1,2,3,0,0,0},{4,5,6,0,0,0},{7,8,9,1,0,0},{0,0,0,0,1,2},{0,0,0,0,0,0},{0,0,0,0,0,0}};
		int []result = answer(a);
		for(int i = 0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	
    public static fraction multiply(fraction x,fraction y){
    	if(x.n!=0 && y.n!=0){//) && x.d!=0 && y.d!=0){
			fraction temp = new fraction(0,0);
//			Long a = gcd(x.n,y.d);
//			Long b = gcd(x.d,y.n);
//			
//			temp.n = x.n/a * y.n/b;
//			temp.d = x.d/b * y.d/a;
			temp.n = x.n * y.n;
			temp.d = Math.abs(x.d * y.d);
			temp = reduce(temp);
			return temp;
		}else return new fraction(0,0);
	}

    public static fraction reduce(fraction x){
		if(x.n == 0) return new fraction(0,0);
		else{
			Long a = gcd(x.n,x.d);
			x.n /= a;
			x.d /= a;
			return x;
		}
	}

	public static fraction reciprocal(fraction x){
		if(x.n < 0){
			return new fraction(x.d*-1,Math.abs(x.n));
		}else{
			return new fraction(x.d,x.n);
		}
	}
    
    public static fraction divide(fraction x,fraction y){
    	if(x.n!=0 && y.n!=0){//) && x.d!=0 && y.d!=0){ 
    		fraction temp = reciprocal(y);
    		return multiply(x,temp);
		}else return new fraction(0,0);
	}
	
	public static fraction toggle(fraction x){
		fraction temp = new fraction(0,0);
		if(x.n== 0){
			return temp;
		}else{
			temp.n = x.n * -1;
			temp.d = x.d;
			return temp;
		}
	}
	
	public static fraction subtract(fraction x,fraction y){
		if(x.n!=0 && y.n!=0){//) && x.d!=0 && y.d!=0){ 
			fraction temp = new fraction(0,0);
//			Long a = gcd(x.d,y.d);
//			Long lcm = x.d * y.d * a;
//			temp.n = (x.n* lcm/x.d) - (y.n*lcm/y.d);
//			temp.d = lcm;
			temp.n = x.n* y.d - y.n* x.d;
			temp.d = Math.abs(x.d* y.d);
			//temp = reduce(temp);
			//return temp;
			temp = reduce(temp);
			return temp;
		}else if(x.d==0 || x.n == 0) return toggle(y);
		else if(y.d==0 || y.n == 0) return x;
		else return new fraction(0,0);
	}
	
	public static fraction add(fraction x , fraction y){
		if(x.n!=0 && y.n!=0){//) && x.d!=0 && y.d!=0){
			fraction temp = new fraction(0,0);
//			Long a = gcd(x.d,y.d);
//			Long lcm = x.d * y.d * a;
//			temp.n = (x.n* lcm/x.d) + (y.n*lcm/y.d);
//			temp.d = lcm;
			temp.n = x.n* y.d + y.n* x.d;
			temp.d = Math.abs(x.d* y.d);
			temp = reduce(temp);
			return temp;
		}else if(x.d==0 || x.n == 0) return y;
		else if(y.d==0 || y.n == 0) return x;
		else return new fraction(0,0);
	}
	
	public static Long gcd(Long n, Long d){
		n = Math.abs(n);
		d = Math.abs(d);
		return d == 0? n:gcd(d,n%d);
	}
	
	public static int findSum(int []arr){
		int sum= 0;
		for (int i = 0;i<arr.length;i++){
			sum += arr[i];
		}
		return sum;
	}
	
	public static fraction [][]makeIdentity(int n){
		fraction [][] temp = new fraction[n][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				if(i == j) temp[i][j] = new fraction(1,1);
				else temp[i][j] = new fraction(0,0);
			}
		}
		return temp;
	}

    public static boolean greater(fraction x,fraction y){
    	if(y.n<0) return true;
    	else if(x.n != 0 && y.n!=0){
    		Long a = gcd(x.d, y.d);
    		Long lcm = Math.abs(x.d /a * y.d /a);
			if(x.n * lcm/x.d > y.n * lcm / y.d) return true;
			else return false;
		}else if(x.n == 0) return false;
		else return true;
	}    
    
    public static void gaussian(fraction a[][], int index[]){
        int n = index.length;
        fraction c[] = new fraction[n];
 
        // Initialize the index
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
        // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i){
        	fraction c1 = new fraction(0,0);
            for (int j=0; j<n; ++j){
            	fraction c0 = abs(a[i][j]);
                if (greater(c0,c1)) c1 = c0;
            }
            c[i] = c1;
        }
 
        // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j){
            fraction pi1 = new fraction(0,0);
            for (int i=j; i<n; ++i){
            	fraction pi0 = abs(a[index[i]][j]);
                pi0 = divide(pi0,c[index[i]]);
                // /= c[index[i]];
                if (greater(pi0,pi1)) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
 
            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i){
                fraction pj = divide(a[index[i]][j],a[index[j]][j]);
                		//a[index[i]][j]/a[index[j]][j];
 
                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;
 
                // Modify other elements accordingly
                for (int l=j+1; l<n; ++l){
                    a[index[i]][l] = subtract(a[index[i]][l],multiply(pj,a[index[j]][l])); 
                    		// -= pj*a[index[j]][l];
                }
            }
        }
    }
    
    public static fraction[][] invert(fraction a[][]){
        int n = a.length;
        fraction x[][] = new fraction[n][n];
        fraction b[][] = new fraction[n][n];
        int index[] = new int[n];
        b = makeIdentity(n);
        for(int i = 0;i<n;i++){
        	for(int j = 0;j<n;j++){
        		x[i][j] = new fraction(0,0);
        	}
        }
        // Transform the matrix into an upper triangle
        gaussian(a, index);
		for(int i = 0;i<n;i++){
		for(int j = 0;j<n;j++){
			System.out.print(a[i][j].n + " | " + a[i][j].d + ", ");
		}
		System.out.println(" ");
	}  
        // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i){
            for (int j=i+1; j<n; ++j){
                for (int k=0; k<n; ++k){
                    b[index[j]][k] = subtract(b[index[j]][k],multiply(a[index[j]][i],b[index[i]][k]));
                    	    //-= a[index[j]][i]*b[index[i]][k];
                }
            }
        }
        // Perform backward substitutions
        for (int i=0; i<n; ++i){
//        	System.out.println("start i "+ i);
            x[n-1][i] = divide(b[index[n-1]][i],a[index[n-1]][n-1]);
            		//b[index[n-1]][i]/a[index[n-1]][n-1];
//          System.out.println(b[index[n-1]][i].n + " | " + b[index[n-1]][i].d);
//          System.out.println(a[index[n-1]][n-1].n + " | " + a[index[n-1]][n-1].d);
//          System.out.println(x[n-1][i].n + " | " + x[n-1][i].d);
            for (int j=n-2; j>=0; --j){
            	//System.out.println("start j " + j);
                x[j][i] = b[index[j]][i];
              //System.out.println(x[j][i].n + " | " + x[j][i].d);
                for (int k=j+1; k<n; ++k){
//                	System.out.println("start k " + k);
//                	System.out.println(x[j][i].n + " | " + x[j][i].d);
                    x[j][i] = subtract(x[j][i],multiply(a[index[j]][k],x[k][i]));
                    		//-= a[index[j]][k]*x[k][i]; 
//                  System.out.println(a[index[j]][k].n + " | " + a[index[j]][k].d);
//                  System.out.println(x[k][i].n + " | " + x[k][i].d);
//                  System.out.println(multiply(a[index[j]][k],x[k][i]).n + " | " + multiply(a[index[j]][k],x[k][i]).d);
//                  //System.out.println(x[k][i].n + " | " + x[k][i].d);
//                  System.out.println(x[j][i].n + " | " + x[j][i].d);
//                  System.out.println(" end k ");
                }
                x[j][i] = divide(x[j][i],a[index[j]][j]);
//              System.out.println(a[index[j]][j].n + " | " + a[index[j]][j].d);
//              System.out.println(x[j][i].n + " | " + x[j][i].d);
//              System.out.println(" end j");
                		// /= a[index[j]][j];
            }
            //System.out.println(" end i");
        }
        return x;
    }

    public static fraction[][] multiplyMatrix(fraction[][]x,fraction[][]y){
    	int xrow = x.length;
    	int xcol = x[0].length;
    	int yrow = y.length;
    	int ycol = y[0].length;
		fraction [][] result = new fraction[xrow][ycol];
		fraction temp;
		for(int k = 0;k<xrow;k++){
			for(int j = 0;j<ycol;j++){
				temp = new fraction(0,0);
				for(int i = 0;i<xcol;i++){
				    if(x[k][i] == null) x[k][i] = new fraction(0,0);
					temp = add(temp, multiply(x[k][i],y[i][j]));
				}
				if(temp.d == 0){
					result[k][j] = new fraction(0,0);
				}else{
					result[k][j] = temp;
				}
			}
		}
		return result;
	}
    
  	public static void rowSwap(int[]x,int index){
		int temp = x[index];
		for(int i = index;i<x.length-1;i++){
			x[i] = x[i+1];
		}
		x[x.length-1] = temp;
	}
    
    public static fraction abs(fraction x){
		fraction temp = new fraction(0,0);
		if(x.n == 0){
			return temp;
		}else{
			temp.n = Math.abs(x.n);
			temp.d = Math.abs(x.d);
			return temp;
		}
	}
	
	public static int [] answer(int [][]m){
        int lessTwo [] = new int[2];
        if(m.length < 2){
            lessTwo[0] = m[0][0];
            lessTwo[1] = m[0][0];
            return lessTwo;
        }
        int t = 0;
		fraction test[][] = new fraction[m.length][m[0].length];
		int []rowOp = new int[m.length];
		for(int i = 0;i<rowOp.length;i++){
			rowOp[i]= i;
		}
		int sum[] = new int[m.length];
		for(int i = 0;i<m.length;i++){
			sum[i] = findSum(m[i]);
			if(sum[i] != 0){
				t++;
			}
			for(int j = 0;j<m[0].length;j++){
				if(m[i][j]!=0){
					test[i][j] = new fraction(m[i][j],sum[i]);
					test[i][j] = reduce(test[i][j]);
				}else{
					test[i][j] = new fraction(0,0);
				}
			}	
		}
//		for(int i = 0;i<test.length;i++){
//			System.out.println(sum[i]);
//		}
//		for(int i = 0;i<test.length;i++){
//			for(int j = 0;j<test[0].length;j++){
//				System.out.print(test[i][j].n + " | " + test[i][j].d + "; ");
//			}
//			System.out.println(" ");
//		}
		int index = 0;
		int end = m.length;
		while(index < end){
			if(sum[rowOp[index]] == 0){
				rowSwap(rowOp,index);
				end--;
			}else{
				index++;
			}
		}
////		
//		for(int i = 0;i<test.length;i++){
//			System.out.print(rowOp[i] + " ");
//		}
//		
		int r = m.length - t;
//		System.out.print(r + " " + t);
		fraction QR[][] = new fraction[t][m[0].length];
		
		for(int i = 0;i<t;i++){
			for(int j = 0;j<m[0].length;j++){
				QR[i][j] = test[rowOp[i]][rowOp[j]];
			}
		}
//		for(int i = 0;i<QR.length;i++){
//		for(int j = 0;j<QR[0].length;j++){
//			System.out.print(QR[i][j].n + " | " + QR[i][j].d + " ;");
//	}
//		System.out.println(" ");
//}
		fraction [][]Q = new fraction[t][t];
		fraction [][]R = new fraction[t][r];
		for(int i = 0;i<t;i++){
			for(int j = 0;j<QR[0].length;j++){
				if(QR[i][j]!=null){
					if(j<t){
						Q[i][j] = QR[i][j];
					}else{
						R[i][j-t] = QR[i][j];
					}
				}
				
			}	
		}
//		for(int i = 0;i<Q.length;i++){
//		for(int j = 0;j<Q[0].length;j++){
//			System.out.print(Q[i][j].n + " | " + Q[i][j].d + ", ");
//		}
//		System.out.println(" ");
//		}
//		for(int i = 0;i<R.length;i++){
//		for(int j = 0;j<R[0].length;j++){
//			System.out.print(R[i][j].n + " | " + R[i][j].d + ", ");
//		}
//		System.out.println(" ");
//		}
		fraction  [][]inverQ = new fraction[t][t];
		fraction [][] one = makeIdentity(t);
		for(int i = 0;i<t;i++){
			for(int j = 0;j<t;j++){
				inverQ[i][j] = subtract(one[i][j],Q[i][j]);
			}
		}
//		for(int i = 0;i<inverQ.length;i++){
//		for(int j = 0;j<inverQ[0].length;j++){
//			System.out.print(inverQ[i][j].n + " | " + inverQ[i][j].d + " ");
//		}
//		System.out.println(" ");
//		}
		fraction [][] N = invert(inverQ);
//		for(int i = 0;i<N.length;i++){
//		for(int j = 0;j<N[0].length;j++){
//			System.out.print(N[i][j].n + " | " + N[i][j].d + " ");
//		}
//		System.out.println(" ");
//	}
		fraction prob [][] = new fraction[t][r];
		prob = multiplyMatrix(N,R);
//		for(int i = 0;i<prob.length;i++){
//		for(int j = 0;j<prob[0].length;j++){
//			System.out.print(prob[i][j].n + " | " +prob[i][j].d + " ");
//		}
//		System.out.println(" ");
//	}
		int result [] = new int[r+1];
		Long lcm = (long) 1;
		Long a = (long) 0;
		for(int i = 0;i<prob[0].length;i++){
			if(prob[0][i]!=null&&prob[0][i].d != 0){
			    a = gcd(lcm,prob[0][i].d);
				lcm = lcm * (prob[0][i].d / a);
			}else{
			    prob[0][i] = new fraction(0,0);
			}
		}
		
		for(int i = 0;i<prob[0].length;i++){
			if(prob[0][i].d != 0){
				Long temp = prob[0][i].n * (lcm/prob[0][i].d);
				result[i] = temp.intValue();
			}
		}
		result[result.length-1] = lcm.intValue();
		return result;
	}
    
}
class fraction{
	public Long n;
	public Long d;
	fraction(int n, int d){
		this.n = (long)n;
		this.d = (long)d;
	}
	
	fraction(int n){
		this.n = (long)n;
		this.d = (long)1;
	}

	public fraction(long n, long d) {
		this.n = n;
		this.d = d;
	}
}