/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.math.BigDecimal;


/**
 *
 * @author 20100
 */
public class Triangle extends AbstractShape {
 private Point point2 , point3 ;
 private Point draggingPoint ;
    private Rectangle[] smallRectangles ;
      private int currentCorner; 

 @Override
    public Rectangle[] getSmallRectangles() {
        return smallRectangles;
    }

    public void setSmallRectangles(Rectangle[] smallRectangles) {
        this.smallRectangles = smallRectangles;
    }

    public int getCurrentCorner() {
        return currentCorner;
    }

    public void setCurrentCorner(int currentCorner) {
        this.currentCorner = currentCorner;
    }


   

 @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

 

    public Triangle(Point point2, Point point3, Point position) {
        super(position);
        this.point2 = point2;
        this.point3 = point3;
        smallRectangles = new Rectangle[3];
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }
 


    @Override
    public void draw(Graphics canvas) {
        
        canvas.setColor(getColor());
        canvas.drawPolygon(new int[]{ getPosition().x , getPoint2().x , getPoint3().x }, new int[]{ getPosition().y , getPoint2().y , getPoint3().y }, 3);
        canvas.setColor(getFillColor());
        canvas.fillPolygon(new int[]{ getPosition().x , getPoint2().x , getPoint3().x }, new int[]{ getPosition().y , getPoint2().y , getPoint3().y }, 3);
         }

    @Override
    public boolean contain(Point point) {
        Polygon p  =  new Polygon( new int[]{ getPosition().x , getPoint2().x , getPoint3().x }
                , new int [] {getPosition().y , getPoint2().y , getPoint3().y}, 3) ;
        
       if( p.contains(point) ) {
        
        return true ;
    }
       
         return false ;
      
        
    }



    @Override
    public void moveTo(Point nextpoint) {
     
      Point p = getPosition() ;
      p.translate((int)(nextpoint.x - draggingPoint.x),
              (int)(nextpoint.y - draggingPoint.y));
        point2.translate((int)(nextpoint.x - draggingPoint.x),
              (int)(nextpoint.y - draggingPoint.y));
        point3.translate((int)(nextpoint.x - draggingPoint.x),
              (int)(nextpoint.y - draggingPoint.y));
    }

@Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

 @Override
    public void deletedots(Graphics canvas)
    {
        for(Rectangle r: smallRectangles)
            {
            r.setFillColor(Color.white);
            r.setColor(Color.WHITE);
            }
    }
 
 @Override
    public void setDots ()
    {
     Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
     Point oo2 = new Point(point2.x-4, point2.y-4);
     Point oo3 = new Point(point3.x-4, point3.y-4);

    Rectangle r1= new Rectangle(8, 8, oo1);
    Rectangle r2= new Rectangle(8, 8, oo2);
    Rectangle r3= new Rectangle(8, 8, oo3);
    


    smallRectangles[0]=r1;
    smallRectangles[1]=r2;
    smallRectangles[2]=r3;
   

    }
        
 
    
 @Override
    public void drawdots(Graphics canvas)
    {
     Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
     Point oo2 = new Point(point2.x-4, point2.y-4);
     Point oo3 = new Point(point3.x-4, point3.y-4);     
    smallRectangles[0].setPosition(oo1);
    smallRectangles[1].setPosition(oo2);
    smallRectangles[2].setPosition(oo3);
     
     for(Rectangle r: smallRectangles)
     {
     r.draw(canvas);
     }
     
     
    }
 @Override
     public void resizeShape(Graphics canvas, int cornerNumber, Point currentPoint)
    {
     switch (cornerNumber) {
         case 0:
             setPosition(currentPoint);
             break;
         case 1:
             point2 = currentPoint;
             break;
         case 2:
             point3 = currentPoint;
             break;
         default:
             break;
     }
            
        
        smallRectangles[cornerNumber].setPosition(currentPoint);
       // System.out.println(cornerNumber+"index in Triangle");
    
    }
        @Override
    public JsonObject toJsonObject() {
                JsonObject jsonObject = new JsonObject();
        jsonObject.put("Type", "Triangle");
        jsonObject.put("Point1x", getPosition().x);
        jsonObject.put("Point1y", getPosition().y);
        jsonObject.put("Point2x", point2.x);
        jsonObject.put("Point2y", point2.y);
        jsonObject.put("Point3x", point3.x);
        jsonObject.put("Point3y", point3.y);
        jsonObject.put("redb", getColor().getRed());
        jsonObject.put("greenb", getColor().getGreen());
        jsonObject.put("blueb",getColor().getBlue());
        jsonObject.put("redf", getFillColor().getRed());
        jsonObject.put("greenf", getFillColor().getGreen());
        jsonObject.put("bluef", getFillColor().getBlue());
        return jsonObject;
    }

    @Override
    public void fromJsonObject(JsonObject jo) {
        int Point1x=((BigDecimal) jo.get("Point1x")).intValue();
        int Point1y=((BigDecimal) jo.get("Point1y")).intValue();
        Point x = new Point(Point1x, Point1y);
        int Point2x=((BigDecimal) jo.get("Point2x")).intValue();
        int Point2y=((BigDecimal) jo.get("Point2y")).intValue();
        Point y=new Point(Point2x, Point2y);
        int Point3x=((BigDecimal) jo.get("Point3x")).intValue();
        int Point3y=((BigDecimal) jo.get("Point3y")).intValue();
        Point z=new Point(Point3x, Point3y);
        int redf=((BigDecimal) jo.get("redf")).intValue();
        int greenf=((BigDecimal) jo.get("greenf")).intValue();
        int bluef=((BigDecimal) jo.get("bluef")).intValue();
        Color fill=new Color(redf, greenf, bluef);
        int redb=((BigDecimal) jo.get("redb")).intValue();
        int greenb=((BigDecimal) jo.get("greenb")).intValue();
        int blueb=((BigDecimal) jo.get("blueb")).intValue(); 
        Color boarder =new Color(redb, greenb, blueb);
       point2=y;
       point3=z;
       setPosition(x);
       setColor(boarder);
       setFillColor(fill);
    }
}
