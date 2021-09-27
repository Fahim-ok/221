import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class T01_Assignment5{
  public static void main(String[]args) throws FileNotFoundException{
    
    Scanner sc = new Scanner (System.in);
    System.out.println("maximum weight");
    int MaximumW = sc.nextInt();
    
    System.out.println("total number");
    int totI = sc.nextInt();
    
    String [] name = new String [totI];
    int w[] = new int [totI];
    int v[] = new int[totI];
    String [] pos = new String [totI];
    int [][] m = new int [totI+1][MaximumW+1];
    sc.nextLine();
    
    for(int i=0; i<v.length; i++){
      System.out.println("Enter name of Player");
      name[i]= sc.nextLine();
      System.out.println("Enter price");
      w[i] = sc.nextInt();
      System.out.println("Enter form");
      v[i] = sc.nextInt();
      sc.nextLine();
      System.out.println("Enter position");
      pos[i] = sc.nextLine();
    }
    
    for(int i =0;i<totI;i++){
      m[i][0]=0;
    }
    
    for(int i=0;i<=MaximumW;i++){
      m[0][i]=0;
    }
    
    for(int i=1; i<=totI; i++){
      
      for(int j=1;j<=MaximumW;j++){
        
        if(w[i-1]>j){
          m[i][j] = m[i-1][j-1];
        }
        else{
          m[i][j] = Math.max(v[i-1]+m[i-1][j-w[i-1]],m[i-1][j-1]);
        }
      }
    }
    System.out.println("Bought Players: ");
    int form = m[totI][MaximumW];
    int var = m[totI][MaximumW];
    for(int i=v.length;i>0 && var>0;i--){
      if(var==m[i-1][MaximumW]){
        continue;
      }
      else{
        System.out.print(name[i-1]+", ");
        var=var-v[i-1];
        MaximumW = MaximumW-w[i-1];
       
      }
    }
    
    System.out.println();
    System.out.println("Maximum summation of form:"+form);
   
  }
}