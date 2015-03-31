package chessboardProgram;

public class Range {

   private int from;
   private int to;
   
   public Range(){
      from = 0;
      to = 0;
   }
   
   public Range (int f, int t){
      from = f;
      to = t;
   }
   
   public int getLow(){
      return from;
   }
   
   public int getHigh(){
      return to;
   }
   
   public void setLow(int low){
      from = low;
   }
   
   public void setHigh(int hi){
      to = hi;
   }
}
