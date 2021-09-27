import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;

public class Problem1 {
  
public static void main(String[] args)throws FileNotFoundException {
   
  try {
   String address = new String("E:/Lab Assignment 4/Task 1/LCS1.txt");
   Scanner sc = new Scanner(new File(address));
   
   String x = sc.nextLine();
   String y = sc.nextLine();
   
   int e = x.length();
   int f = y.length();
   int[][] c = new int[e+1][f+1];
   String[][] b = new String[e+1][f+1];
   
   for(int i =0; i < e; i++) {
    c[i][0] = 0;
    c[0][i] = 0;
   }
   
   for(int i = 1; i <=e; i++) {
     
    for(int j = 1; j <=f; j++) {
      
     if(x.charAt(i-1) == y.charAt(j-1)) {
      c[i][j] = c[i-1][j-1] +1;
      b[i][j] = "D";
     }
     
     else if(c[i-1][j] > c[i][j-1]) {
      c[i][j] = c[i-1][j];
      b[i][j] = "U";
     }
     
     else {
      c[i][j] = c[i][j-1];
      b[i][j] = "L";
     }  
    }
   }
   
   Stack<Character> stack = new Stack<Character>();
   int i =e;
   int j =f;
   while (b[i][j] != null) {
     
    if(b[i][j].equals("D")) {
     stack.push(x.charAt(i-1));
     i--;
     j--;
    }else if(b[i][j].equals("L")) {
     j--;
    }else if(b[i][j].equals("U")) {
     i--;
    }
   }
   double l = stack.size();
   
   while(!stack.isEmpty()) {
    System.out.print(stack.pop());  
   }
   System.out.println();
   System.out.println((l/e)*100 + " PASSED");
   
  }
  
  catch(Exception e){
   System.out.println("the Exception is: " + e);
  }
 }
}