import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Queue; 
import java.util.LinkedList;

public class Task1_Assignment1{
  public static void main(String [] args) throws FileNotFoundException
  {
    
    try{
      int vertexCount;
      int connections;
      int row;
      int col;
      int source;
      int dest;
    
    File file =  new File("G:/Lab 02/Level 01/Input (1).txt"); 
    Scanner sc = new Scanner(file); 
    vertexCount = Integer.parseInt(sc.nextLine());
   connections  = Integer.parseInt(sc.nextLine());
    int [][] a = new int[vertexCount][vertexCount];
   
    for(int i =0; i<connections;i++){
      String StringArray[] = new String [2];
      String line= sc.nextLine();
      String []edge = line.split(" ");
       row = Integer.parseInt(edge[0]);
       col = Integer.parseInt(edge[1]);
      a[row][col]=1;
      
    }
    
    source = 0;
    dest = Integer.parseInt(sc.nextLine());
    bfs(a,source,dest);
  }
  catch(Exception e)
  {
    System.out.println("File not found");
  }
  }

   public static void bfs(int[][] matrix, int source, int dest){
        int [] parent = new int[matrix.length];
        int [] level = new int[matrix.length];
        String [] color = new String[matrix.length];
        for(int i=0; i<matrix.length; i++)
        {
          color[i] = "White";
          parent[i] = 1;
          level[i] = 1;
        }
        color[source] = "Gray";
        parent[source] = 1;
        level[source] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        
         while(!q.isEmpty())
        {
          int x = q.remove();
          for(int i=0; i<matrix.length;i++)
          {
                if(matrix[x][i] == 1 && color[i]=="White")
                {
                  q.add(i);
                  color[i] = "Gray";
                  parent[i] = x;
                  level[i] = level[x]+1;
                }
            }
        }


        

      System.out.println("Minimum number of moves Nora need to go is "+level[dest]);

    }
}
