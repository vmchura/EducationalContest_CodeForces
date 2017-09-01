/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package EducationalContest1.C;
import java.math.BigInteger;
import java.util.*;
/**
 *
 * @author VmCHURA
 */
public class Main {
    public static void main(String[] args){
       
        Scanner sc = new Scanner(System.in);
        ArrayList<MyVector> vectors= new ArrayList<>();
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int x= sc.nextInt();
            int y= sc.nextInt();
            MyVector mv= new MyVector(x, y, i);
            vectors.add(mv);
        }
        Collections.sort(vectors);
       
        TupleNum2Den2 ans = null;
        for(int i=0;i<N;i++){
            int j = i+1;
            if(j>=N) j-=N;
            MyVector a=vectors.get(i);
            MyVector b=vectors.get(j);
            TupleNum2Den2 next =  new TupleNum2Den2(a, b);
            //System.out.println("next: "+(next.a.indx+1)+" - "+(next.b.indx+1));
            if(ans == null){
                ans = next;
            }else{
                if( ans.compareTo(next) == 1){
                    ans = next;
                }
                
            }
            //System.out.println("ans: "+(ans.a.indx+1)+" - "+(ans.b.indx+1));
        }
        System.out.println(ans.a.indx+1);
        System.out.println(ans.b.indx+1);
        
    }
    
    
    
}
class MyVector implements Comparable<MyVector>{
    long x;
    long y;
    int indx;
    MyVector(long x,long y,int indx){
        this.x=x;
        this.y=y;
        this.indx=indx;
        
    }
    MyVector rotate90ClockWise(){
        return new MyVector(y, -x, indx);
    }
    @Override
    public int compareTo(MyVector o) {
        if(cuadrante()!=o.cuadrante()){
            return ((Integer)cuadrante()).compareTo(o.cuadrante());
        }
        if(cuadrante()==1){
            if(y*o.x <= o.y*x){
                return -1;
            }else{
                return 1;
            }
        }
        return rotate90ClockWise().compareTo(o.rotate90ClockWise());
    }
    private int cuadrante(){
        if(x==0 || y==0){
            if(x==0){
                if(y>0)
                    return 2;
                return 4;
            }
            if(y == 0){
                if( x>0)
                    return 1;
                return 3;
            }
        }
        if(x>0 ){
            if(y>0){
                return 1;
            }else{
                return 4;
            }
            
        }else{
            if(y>0){
                return 2;
            }else{
                return 3;
            }
        }
    }
}

class TupleNum2Den2 implements Comparable<TupleNum2Den2>{
    public MyVector a;
    public MyVector b;
    long num;
    BigInteger num2;
    BigInteger den2;
    public TupleNum2Den2(MyVector a, MyVector b){
        this.a = a;
        this.b = b;
        this.num = a.x*b.x+a.y*b.y;
        this.num2 = new BigInteger((Long.toString(num*num)));
        BigInteger modA = new BigInteger((new Long(a.x*a.x+a.y*a.y)).toString()) ;
        BigInteger modB = new BigInteger((new Long(b.x*b.x+b.y*b.y)).toString()) ;
        this.den2 = modA.multiply(modB);
        
    }
    
    @Override
    public int compareTo(TupleNum2Den2 o) {
        
        if(this.num == 0 && o.num==0)
            return 0;
        if(this.num == 0){
            if(o.num>0){
                return 1;
            }else{
                return -1;
            }
        }
        if(o.num==0){
            if(num>0){
                return -1;
            }else{
                return 1;
            }
        }
        if(this.num > 0){
            if(o.num > 0){
                //debe retornar aquel que tenga mas num/den
                //                                    num2/den2
               // System.out.println("comparando: "+(num2)+"*"+(o.den2)+" con "+(o.num2)+"*"+(den2));
                //System.out.println("comparando: "+(num2*o.den2)+" con "+(o.num2*den2));
                int k = (num2.multiply(o.den2)).compareTo(o.num2.multiply(den2));
                //System.out.println("result : "+k);
                return  -k;
            }else{
                return -1;
            }
        }else{
            if(o.num > 0){
                return 1;
            }else{
                //debe retornar aquel que tenga mas num/den
                //                              o menos num2/den2
                //System.out.println("comparando - : "+(num2*o.den2)+" con "+(o.num2*den2));
                int k = (num2.multiply(o.den2)).compareTo(o.num2.multiply(den2));
                //System.out.println("result : "+k);
                return k;
            }
        }
    }
    
}
