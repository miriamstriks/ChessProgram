package chessboardProgram;

public class Board {
   
   private String name;
   private int[] xvertices;
   private int[] yvertices;
   
   public Board(String n){
      name=n;
   }
   
   public Board(String n, int[] x, int[] y){
      name=n;
      xvertices=x;
      yvertices=y;
   }
   
   public Board(int[] x, int[] y){
      xvertices=x;
      yvertices=y;
   }
   
   public String getName(){
      return name;
   }
   
   public int[] getXs(){
      return xvertices;
   }
      
   public int[] getYs(){
      return yvertices;
   }    
      
   public void setName(String n){
      name=n;
   }
   
   public void setXs(int[] x){
      xvertices=x;
   }
      
   public void setYs(int[] y){
      yvertices=y;
   }   

}
