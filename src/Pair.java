import java.util.Scanner;

public class Pair<E> {
	private E first; 
	private E last;
	private E second; 
	public E first() { return first;}
	public E last() { return last;}
	public void first(E first) { this.first = first;}
	public E second() { return second;}
	public Pair(E first, E second) {super();  this.first = first;  this.second = second; this.last = last;}
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number for fibonacci:  ");
		
		long num = in.nextLong();
		
		Pair<Long> result = fibonacci(num);
		
		System.out.println(fibonacci(num).first);
		

		
	}

	
	public static  Pair<Long> fibonacci(long n){
		if(n == 0 || n ==1)
	        return new Pair<Long>(1L, 1L);
	   
	   else{
		  Pair<Long> res = fibonacci(n-1);
		  
		  return new Pair<Long>(res.first+res.second, res.first);
	   }
	      
	}
	

	public static long fib(int n) { 
		   if (n == 1 || n == 0) return 1; 
		   else return fib(n-1) + fib(n-2); 
		}
	


}
