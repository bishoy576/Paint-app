/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import json_simple.JsonObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.math.BigDecimal;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author zedan.net
 */
public class Rectangle extends AbstractShape  {
private int length , width ;
private Point draggingPoint ;
private Rectangle[] smallRectangles ;
private int currentCorner; 
private  Point   point2 , point3 , point4; 


    public void setSmallRectangles(Rectangle[] smallRectangles) {
        this.smallRectangles = smallRectangles;
    }

    public int getCurrentCorner() {
        return currentCorner;
    }

    public void setCurrentCorner(int currentCorner) {
        this.currentCorner = currentCorner;
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

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }


@Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

@Override
    public void setDraggingPoint(Point draggingpoint) {
        this.draggingPoint = draggingpoint;
    }

    public Rectangle(int length, int width, Point position) {
        super(position);
        this.length = length;
        this.width = width;
         smallRectangles = new Rectangle[4];
    }

    public Rectangle(Point point2, Point point3, Point point4, Point position) {
        super(position);
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }


    @Override
    public void draw(Graphics canvas) {
         this.point2 = new Point(getPosition().x+this.width , getPosition().y);
         this.point4 = new Point (getPosition().x,getPosition().y+this.length);
         this.point3 = new Point (getPosition().x+this.width,getPosition().y+this.length);
        canvas.setColor(getColor());
       canvas.drawPolygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
        canvas.setColor(getFillColor());
       canvas.fillPolygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
      }

    @Override
    public boolean contain(Point b) {
        
         Polygon p = new Polygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
           return p.contains(b);
    }

   

    @Override
    public void moveTo(Point nextpoint) {
        
      Point p = getPosition();
      p.translate((int)(nextpoint.x - draggingPoint.x ),
              (int)(nextpoint.y - draggingPoint.y)  );   
    }
        @Override
    public void drawdots(Graphics canvas) {
        Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
    Point oo2 = new Point(getPosition().x-4, getPosition().y+length-4); // left corner (ltht)
    Point oo3 = new Point(getPosition().x-4+width, getPosition().y-4);// Top Right corner
    Point oo4 = new Point(getPosition().x+width-4,getPosition().y+length-4);// right corner
     

    smallRectangles[0].setPosition(oo1);
    smallRectangles[1].setPosition(oo2);
    smallRectangles[2].setPosition(oo3);
    smallRectangles[3].setPosition(oo4);

     for(Rectangle r: smallRectangles)
     {
     r.draw(canvas);
     } 
    }
    
        @Override
    public void setDots() {
        
        
    Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
    Point oo2 = new Point(getPosition().x-4, getPosition().y-4+length); // left corner (ltht)
    Point oo3 = new Point(getPosition().x-4+width, getPosition().y-4);// Top Right corner
    Point oo4 = new Point(getPosition().x+width-4,getPosition().y+length-4);// right corner


    Rectangle r1= new Rectangle(8, 8, oo1);
    Rectangle r2= new Rectangle(8, 8, oo2);
    Rectangle r3= new Rectangle(8, 8, oo3);
    Rectangle r4= new Rectangle(8, 8, oo4);
    
    smallRectangles[0]=r1;
    smallRectangles[1]=r2;
    smallRectangles[2]=r3;
    smallRectangles[3]=r4;

    }

    @Override
    public void resizeShape(Graphics canvas, int cornerNumber, Point currentPoint) {
    switch (cornerNumber) {
        case 0:
           // System.out.println("Ana gowa point0 dlw2tyyy");
            //setPosition(currentCorPoint);
            if(currentPoint.x != getPosition().x)
            {
               // System.out.println("COndition 1  nowww");
                int xshift = currentPoint.x-getPosition().x;
               
                width = width -xshift ;
                Point p1 = new Point (getPosition().x+xshift,getPoint4().y);
                smallRectangles[1].setPosition(p1);}
            if(currentPoint.y != getPosition().y)
            {
               // System.out.println("COndition 2");
                int yshift =currentPoint.y-getPosition().y;
                
                    
                length = length - yshift ;
                Point p2 = new Point (getPoint2().x,getPosition().y+yshift);
                smallRectangles[2].setPosition(p2);
            }
            setPosition(currentPoint);
            break;
        case 1:
            System.out.println("Ana gowa point4 dlw2tyyy");
            if(currentPoint.x != getPoint4().x)
            {
                System.out.println("COndition 1  nowww");
                int xshift = currentPoint.x-getPoint4().x;
                
                width = width - xshift ;
                Point p3 = new Point (getPosition().x+xshift,getPosition().y);
                smallRectangles[0].setPosition(p3);
               
                setPosition(p3);
            }
            if(currentPoint.y != getPoint4().y)
            {
                System.out.println("COndition 2");
                int yshift =currentPoint.y-getPoint4().y;
                
                length = length + yshift ;
                Point p4 = new Point (getPoint3().x,getPoint3().y+yshift);
                smallRectangles[3].setPosition(p4);
                
                setPoint3(p4);
            }
            setPoint4(currentPoint) ;
            break;
        case 2:
            System.out.println("Ana gowa point2 dlw2tyyy");
            if(currentPoint.x != getPoint2().x)
            {
                System.out.println("COndition 1  nowww");
                int xshift = currentPoint.x-getPoint2().x;
               
                width = width + xshift ;
                Point p5 = new Point (getPoint2().x+xshift,getPoint3().y);
                smallRectangles[3].setPosition(p5);
                setPoint3(p5);
            }
            if(currentPoint.y != getPoint2().y)
            {
                System.out.println("COndition 2");
                int yshift =currentPoint.y-getPoint2().y;
                
                    
                length = length - yshift ;
                Point p6 = new Point (getPosition().x,getPoint2().y+yshift);
                smallRectangles[0].setPosition(p6);
                setPosition(p6);
            }
            setPoint2(currentPoint);
            break;
        case 3:
            System.out.println("Ana gowa point3 dlw2tyyy");
            if(currentPoint.x != getPoint3().x)
            {
                System.out.println("COndition 1  nowww");
                int xshift = currentPoint.x-getPoint3().x;
               
                width = width + xshift ;
                Point p7 = new Point (getPoint3().x+xshift,getPoint2().y);
                smallRectangles[3].setPosition(p7);
                setPoint2(p7);
            }
            if(currentPoint.y != getPoint3().y)
            {
                System.out.println("COndition 2");
                int yshift =currentPoint.y-getPoint3().y;
                
                    
                length = length + yshift ;
                Point p8 = new Point (getPoint4().x,getPoint3().y+yshift);
                smallRectangles[1].setPosition(p8);
                setPoint4(p8);
            }
            setPoint3(currentPoint);
            break;  
        default:
            break;
    }  
        smallRectangles[cornerNumber].setPosition(currentPoint);
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
    public Rectangle[] getSmallRectangles() {
        return smallRectangles ;
    }
          @Override
    public JsonObject toJsonObject() {
                  JsonObject jsonObject=new JsonObject();
        jsonObject.put("Type", "Rectangle");
        jsonObject.put("Pointx",getPosition().x) ;
        jsonObject.put("Pointy",getPosition().y) ;
        jsonObject.put("Length", length);
        jsonObject.put("Width", width);
        
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
        
        int Pointx=((BigDecimal) jo.get("Pointx")).intValue();
        int Pointy=((BigDecimal) jo.get("Pointy")).intValue();
        Point point=new Point(Pointx, Pointy);
        int l=((BigDecimal) jo.get("Length")).intValue();
        int w=((BigDecimal) jo.get("Width")).intValue();
        
        int redf=((BigDecimal) jo.get("redf")).intValue();
        int greenf=((BigDecimal) jo.get("greenf")).intValue();
        int bluef=((BigDecimal) jo.get("bluef")).intValue();
        Color fill=new Color(redf, greenf, bluef);
        
        int redb=((BigDecimal) jo.get("redb")).intValue();
        int greenb=((BigDecimal) jo.get("greenb")).intValue();
        int blueb=((BigDecimal) jo.get("blueb")).intValue(); 
        Color boarder =new Color(redb, greenb, blueb);
        
        setPosition(point);
        length=l;
        width=w;
        setColor(boarder);
        setFillColor(fill);
        
    }
}