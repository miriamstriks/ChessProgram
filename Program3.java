package chessboardProgram;

import static chessboardProgram.GeneralBoard.*;

import java.util.Date;

public class Program3 {
   
   public static void countSolutions(int[][] matrix, int pieces){
      int[][] b = matrix;
      int p = pieces;
      //output format: (dilation), (number of solutions)
      writer.println(new Date() + "  " + scale + ", " + solutionCount(b,p));
      writer.flush();
   }
   
   public static int solutionCount(int[][] b, int p){
      
      int[] sol = new int [p];
      int numDown=0, count=0;
     
      for(int column=0; column<b.length; column++){
            sol[numDown]=column;
            if(valid(b,sol,numDown)){
                numDown++;
                if(numDown==p){
                    //increment solution count
                    count++;
                   /*print solution
                    *for(int k=0; k<p; k++)
                    *  System.out.print(sol[k] + " ");
                    *System.out.println(); 
                    */ 
                    //remove piece and continue
                    numDown--;
                }
                else if(column==b.length-1)
                   numDown--;
             }
             //if placed piece in last column then backtrack
             if(column==b.length-1)
                if(numDown==0)
                   break;
                else
                   column = sol[--numDown];
      }	
   	  return count;
   }

   
   public static boolean valid(int[][]m, int[] sol, int n){
      //if this is the first placement, it is valid
      if(n==0)
         return true;
      //otherwise, make sure it doesn't interfere with previous placements
      int sum=0, checkingPos=sol[n];
      /*print solution that we're checking
       *for (int i=0; i<=n; i++)
       *   System.out.print(sol[i] + " ");
       */
      //check current placement against previous placements
      for (int i=0; i<n; i++)
         sum+=m[checkingPos][sol[i]];
      if(sum==0){
        // System.out.println("Valid");
         return true;
      }
      
      //System.out.println("Invalid");
      return false;
  }
}
