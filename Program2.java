package chessboardProgram;
import static chessboardProgram.GeneralBoard.*;

public class Program2 {

   public static void getAdjacencyMatrix () {

      finalMat = new int [latticeX.length][latticeY.length];

         for (int i = 0; i < latticeX.length; i++) {
             for (int j = 0; j < latticeY.length; j++) {
                  int xDif = latticeX[i] - latticeX[j];
                  int yDif = latticeY[i] - latticeY[j];
                   
                  for (int k = 0; k < moveX.length; k++) {
                       if (moveX[k] == 0 && moveY[k] == 0) { 
                           continue; 
                       }//if moveX[k] == 0
                       if (moveX[k] != 0 && moveY[k] == 0 && latticeY[i] == latticeY[j] && xDif*moveX[k] < 0) {
                          if (xDif % moveX[k] == 0) {
                              finalMat[i][j] = 1;
                          }//if (xDif % moveX[k] == 0)
                       }//if (moveX[k] != 0
          
                       if (moveY[k] != 0 && moveX[k] == 0 && latticeX[i] == latticeX[j] && yDif*moveY[k] < 0) {
                          if (yDif % moveY[k] == 0) {
                              finalMat[i][j] = 1;
                          }//if (yDif % moveY[k] == 0)
                       }//if (moveY[k] != 0
          
                       if (((double)yDif / moveY[k] == (double)xDif / moveX[k] && xDif*moveX[k] < 0) 
                             || (latticeX[i] == latticeX[j] && latticeY[i] == latticeY[j])) {
                                   finalMat[i][j] = 1;
                       }//if (((double)yDif / moveY[k]
          
                  }//for int k
               }//for int j
            }//for int i
          
                // printMatrix();
        }//getAdjacencyMatrix()

    /*
        Print the adjacency matrix for simple viewing.
    */
    private static void printMatrix() {
        for (int i = 0; i < latticeX.length; i++) {
            if (i == 0) {System.out.print("       |");}
            System.out.print(" " + latticeX[i] + " |");
        }
        System.out.println("");
        
        for (int i = 0; i < latticeY.length; i++) {
            if (i == 0) {System.out.print("       |");}
            System.out.print("_" + latticeY[i] + "_|");
        }
        System.out.println("");
 
        for (int i = 0; i < latticeX.length; i++) {
            System.out.print("(" + latticeX[i] + ", " + latticeY[i] + " )|");
            for (int j = 0; j < latticeY.length; j++) {
               System.out.print(" " + finalMat[i][j] + " |");
            }//for int j
            System.out.println("");
        }//for int i
        System.out.println("");
    }//printMatrix()
 }//class Program2