import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] ch = new char[s.length()];
		
		int m = sc.nextInt();
	}
	private static void backUp(char[] org,char dest[],int ini,int fin){
		for(int i =ini; i<=fin;i++){
			dest[i]=org[i];
		}
	}
}


