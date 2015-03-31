package chessboardProgram;

public class Piece {
   
   private String name;
   private int[] xMoves;
   private int[] yMoves;
   
   public Piece(String n){
      name=n;
   }
   
   public Piece(String n, int[] x, int[] y){
      name=n;
      xMoves=x;
      yMoves=y;
   }
   
   public Piece(int[] x, int[] y){
      xMoves=x;
      yMoves=y;
   }
   
   public String getName(){
      return name;
   }
   
   public int[] getXs(){
      return xMoves;
   }
      
   public int[] getYs(){
      return yMoves;
   }    
      
   public void setName(String n){
      name=n;
   }
   
   public void setXs(int[] x){
      xMoves=x;
   }
      
   public void setYs(int[] y){
      yMoves=y;
   }   

}

