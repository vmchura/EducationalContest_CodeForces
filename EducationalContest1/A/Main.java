import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
			long n = sc.nextLong();
			long sumaContinua = (n*(n+1))/2L;
			int k=0; //maximo k tal que 2**k <= n
			for(int j = 0; j< 32; j++){
				if( (1L << j ) > n){
					k = j-1;
					break;
				}
			}
			//System.out.println(n+" "+k);
			long suma2k_1 = (1L<<(k+1)) -1L;
			long ans = sumaContinua - 2L * suma2k_1;
			System.out.println(ans);
		}
	}
}