/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EducationalContest1.B;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] org = s.toCharArray();
		char[] dummy = s.toCharArray();
		int m = sc.nextInt();
                for(int i = 0; i < m;i++){
                    int l = sc.nextInt()-1;
                    int r = sc.nextInt()-1;
                    int k = sc.nextInt();
                    int N = r-l+1;
                    int n = k%N;
                    int itemsLeft = N-n;
                    int pivot = l+itemsLeft;// desde pivot hasta el final k si se coge
                    backUp(org,dummy,pivot,r);
                    for(int j=pivot-1; j>=l; j--){
                        org[j+n]=org[j];
                    }
                    for(int j =pivot; j<=r;j++){
                        org[l+j-pivot] = dummy[j];
                    }
                    
                }
                String result = new String(org);
                System.out.println(result);
	}
	private static void backUp(char[] org,char dest[],int ini,int fin){
		for(int i =ini; i<=fin;i++){
			dest[i]=org[i];
		}
	}
}


