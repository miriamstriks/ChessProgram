package chessboardProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class GeneralBoard {

   public static int[] latticeX, latticeY, moveX, moveY, xvertices, yvertices, numPieces;
   public static Board[] boards;
   public static Piece[] pieceType;
   public static Range[] scales;
   public static int[][] finalMat;
   public static PrintWriter writer;
   public static int scale;
   public static File inputFile;
   
   public static void main(String[] args){
      
      SwingUtilities.invokeLater(new Runnable() { 
         public void run(){
            //choose input file
            openFile();
            //read input file
            ReadInput.readInputFile(inputFile);
          
           try{
              int pieces;
              Board currentBoard;
              Piece currentPiece;
              String outfile=null;
              //iterate through boards
              for(int b=0; b<boards.length; b++){
                 currentBoard = boards[b];
                 //iterate through piece types
                 for(int t=0; t<pieceType.length; t++){
                    currentPiece = pieceType[t];
                    moveX = currentPiece.getXs();
                    moveY = currentPiece.getYs();         
                    //iterate through number of pieces
                    for(int n=0; n<numPieces.length; n++){
                       pieces = numPieces[n];  
                       outfile = currentBoard.getName() + "_" + currentPiece.getName() + "_" + pieces + ".txt";
                       writer = new PrintWriter(outfile);
                       //iterate through scales
                       for(int s=0; s<scales.length; s++){
                          for(scale=scales[s].getLow(); scale<=scales[s].getHigh(); scale++){
                             Program1.getLatticePoints(currentBoard.getXs(),currentBoard.getYs());
                             Program2.getAdjacencyMatrix();
                             Program3.countSolutions(finalMat,pieces);
                          }
                       }
                       writer.println(new Date());
                       writer.flush();
                    }
                 }
              }
           }catch (FileNotFoundException e){
              JOptionPane.showMessageDialog(null, "Output file not found.");
           }
         }     
    });
   }  

   public static void openFile() {

            JOptionPane.showMessageDialog(null,"Choose input file.");
            JFileChooser fileChooser = new JFileChooser();

            int status = fileChooser.showOpenDialog(null);

            if (status == JFileChooser.APPROVE_OPTION)
                inputFile = fileChooser.getSelectedFile();
            else{
                JOptionPane.showMessageDialog(null, "Open file process canceled");
               inputFile = null;
            }
   }
   
}
   