import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class T02_Assignment5{
  
  public static void main (String [] args) throws FileNotFoundException{
    
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter maximum weight");
    int MaximumW = sc.nextInt();
    System.out.println("Enter total number of trophies");
    int total = sc.nextInt();
    
    String [] club = new String [total];
    int [] w = new int [total];
    sc.nextLine();
    double [] sp = new double [total];
    String [] trophy = new String [total];
    double [][] m = new double [total+1][MaximumW+1];
    
    for (int i=0; i<total;i++)
    {
     
      System.out.println("Enter name of club");
      club[i]= sc.nextLine();
      System.out.println("Enter weight");
      w[i] = sc.nextInt();
      System.out.println("Enter  the selling price");
      sp[i] = sc.nextDouble();
      sc.nextLine();
      System.out.println("Enter name of trophy");
      trophy[i] = sc.nextLine();
      
    }
    
    for(int i=0; i<=total;i++)
    {
      m[i][0]= 0.0;
     
    }
    for(int i=0; i<=MaximumW;i++)
    {
      m[0][i]= 0.0;
      
    }
    
    for(int i=1;i<=total;i++)
    {
      
   for (int j =1; j<=MaximumW;j++)
      {
        
        if(w[i-1]> j)
        {
          m[i][j]= m[i-1][j-1];
        }
        else
        {
          m[i][j]= Math.max((sp[i-1]+m[i-1][j-w[i-1]]), m[i-1][j]);
        }
      }
    }
    
    double money = m[total][MaximumW];
    double var = m[total][MaximumW];
    System.out.println("Name of clubs whose trophies were sold:");
    
    
    for(int i =sp.length; i>0 && var>0 && MaximumW>0; i--)
    {
      if(var == m[i-1][MaximumW])
      {
        continue;
      }  
      else
      {
        System.out.print(club[i-1] + "-> ");
        var = var - sp[i-1];
       MaximumW = MaximumW- w[i-1];
      }  
    }
    System.out.println();
    String result= String.format("%.1f", money);
    System.out.println("Maximum money he earned: "+ result +" million.");
    
  }
}