package chessboardProgram;

import static chessboardProgram.GeneralBoard.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ReadInput {
   
   public static void readInputFile(File inputFile){
      try{
         Scanner inFile = new Scanner(inputFile);
         String line=null;
         //count number of boards
         int count=0;
         while(inFile.hasNextLine()){
            if(inFile.nextLine().length()<=0)
               break;
            count++; 
         }
         boards = new Board[count];
         
         //count types of pieces
         count=0;
         while(inFile.hasNextLine()){
            if(inFile.nextLine().length()<=0)
               break;
            count++;
         }
         pieceType = new Piece[count];
         
         //count numbers of pieces
         count=0;
         while(inFile.hasNextLine()){
            if(inFile.nextLine().length()<=0)
               break;
            count++; 
         }
         numPieces = new int[count];
         
         //count scales
         count=0;
         while(inFile.hasNextLine()){
            if(inFile.nextLine().length()<=0)
               break;
            count++;   
         }
         scales = new Range[count];
         
         //close and reopen file
         inFile.close();
         inFile = new Scanner(inputFile);
         
         //store board types
         int numVertices = 0, index=-1;
         while(!(line=inFile.nextLine()).isEmpty()){
            index++;
            String [] boardInfo = line.split(" ");
            numVertices = Integer.parseInt(boardInfo[1]);
            xvertices = new int[numVertices];
            yvertices = new int[numVertices];
                
            for(int i=0; i<numVertices; i++){
               xvertices[i]=Integer.parseInt(boardInfo[i+2]);
               yvertices[i]=Integer.parseInt(boardInfo[i+2+numVertices]);
            }
            
            boards[index]= new Board(boardInfo[0],xvertices,yvertices);    
         }
         
         //store piece types
         String[] pieceInfo=null;
         int numPoints = 0;
         index=-1;
         while(!(line=inFile.nextLine()).isEmpty()){
            index++;         
            pieceInfo = line.split(" ");
            numPoints = Integer.parseInt(pieceInfo[1]);
            moveX = new int[numPoints];
            moveY = new int[numPoints];
                
            for(int i=0; i<numPoints; i++){
               moveX[i]=Integer.parseInt(pieceInfo[i+2]);
               moveY[i]=Integer.parseInt(pieceInfo[i+2+numPoints]);
            }
            
            pieceType[index]= new Piece(pieceInfo[0],moveX,moveY);
         }
         
         //store numbers of pieces to place
         index=-1;
         while(!(line=inFile.nextLine()).isEmpty()){
            index++;
            numPieces[index]=Integer.parseInt(line);
         }
         
         //store scales
         index=-1;
         while(inFile.hasNextLine() && !(line=inFile.nextLine()).isEmpty()){
            index++;
            String[] rangeInfo = line.split(" ");
            scales[index] = new Range(Integer.parseInt(rangeInfo[0]),Integer.parseInt(rangeInfo[1]));
         }

         inFile.close();
         
         for(int i=0; i<pieceType.length; i++){
            System.out.print(pieceType[i].getName() + " ");
            for(int j=0; j<pieceType[i].getXs().length; j++)
               System.out.print(pieceType[i].getXs()[j] + " ");
            for(int j=0; j<pieceType[i].getYs().length; j++)
               System.out.print(pieceType[i].getYs()[j] + " ");
            System.out.println();
         }
      
      }catch(FileNotFoundException e){
         JOptionPane.showMessageDialog(null, "Input file not found.");
      }
   }
}
