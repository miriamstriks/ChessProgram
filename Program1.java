package chessboardProgram;

import static chessboardProgram.GeneralBoard.*;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.lang.Integer;

public class Program1 {
   
   // accepts vertices and integer board size and outputs board's lattice points
      public static void getLatticePoints(int[] xvertices, int[] yvertices){
   
            Polygon poly = new Polygon(xvertices, yvertices, xvertices.length);
            
            Polygon newPoly = dilate(poly,scale);
            
            //find max and min x and y values of dilated board
            int xMax=-1, xMin=Integer.MAX_VALUE, yMax=-1, yMin=Integer.MAX_VALUE;
            for(int i=0; i<newPoly.npoints; i++){
               if(newPoly.xpoints[i]<xMin)
                  xMin=newPoly.xpoints[i];
               if(newPoly.ypoints[i]<yMin)
                  yMin=newPoly.ypoints[i];
               if(newPoly.xpoints[i]>xMax)
                  xMax=newPoly.xpoints[i];
               if(newPoly.ypoints[i]>yMax)
                  yMax=newPoly.ypoints[i];
            }
            
            //count number of points within polygon
            int count=0;
            for(int x=xMin; x<=xMax; x++)
               for(int y=yMin; y<=yMax; y++)
                  if(newPoly.contains(x,y) && !(onBorder(newPoly,x,y)))
                     count++;          
            
            //test points within border formed by max & min points
            latticeX = new int[count];
            latticeY = new int[count];
            int index=0;
            
            //test whether point is within polygon but not on polygon's border
               for(int x=xMin; x<=xMax; x++)
                  for(int y=yMin; y<=yMax; y++)
                     if(newPoly.contains(x,y) && !(onBorder(newPoly,x,y))){
                        latticeX[index]=x;
                        latticeY[index]=y;
                        index++;   
                     }
         
            /* print lattice points
             * System.out.println("Lattice points:");
             * for(int j=0; j<count; j++)
             *    System.out.println(latticeX[j] + "," + latticeY[j] + " ");
             */
      }
         public static Polygon dilate(Polygon p, int scale){
            int n = p.npoints;
            int[] newXPoints = new int[n];
            int[] newYPoints = new int[n];
            
            for(int i=0; i<p.npoints; i++){
               newXPoints[i]=p.xpoints[i]*scale;
               newYPoints[i]=p.ypoints[i]*scale;
            }
            return new Polygon(newXPoints,newYPoints,n); 
         }
         
         public static boolean onBorder(Polygon poly, int x, int y){
            int x1, y1, x2, y2;
            Line2D.Double borderLine = new Line2D.Double();
            Point2D.Double p = new Point2D.Double();
            
            for(int i=0; i<poly.npoints; i++){
               x1 = poly.xpoints[i];
               y1 = poly.ypoints[i];
               x2 = poly.xpoints[(i+1)%(poly.npoints)];
               y2 = poly.ypoints[(i+1)%(poly.npoints)];
               borderLine.setLine((double)x1, (double)y1, (double)x2, (double)y2);
               p.setLocation((double)x,(double)y);
               if(borderLine.ptSegDist(p)==0.0)
                  return true;
            }
            return false;
         }
}
