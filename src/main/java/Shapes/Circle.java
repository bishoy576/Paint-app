/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.math.BigDecimal;
import javax.swing.*;
/**
 *
 * @author zedan.net
 */
public class Circle extends AbstractShape {
    private int horizontalRadius,verticalRadius,xdiff,ydiff;
    private Rectangle[] smallRectangles ;
    private int xdiffrio1,ydiffrio2;
    private Point draggingPoint ;
    private  Point   point2 , point3 , point4; 
    int length;
    int width;
    
    public Circle(Point point,int horizontalRaduis, int verticalRadius ) {
        
        super(point);
//        this.horizontalRadius= horizontalRaduis;
//        this.verticalRadius=verticalRadius;
        smallRectangles=new Rectangle[4];
        this.length=verticalRadius*2;
        this.width=horizontalRaduis*2;

    }  
    
     public Rectangle[] getSmallRectangles() {
        return smallRectangles;
    }

    public void setSmallRectangles(Rectangle[] smallRectangles) {
        this.smallRectangles = smallRectangles;
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
    public void deletedots(Graphics canvas)
    {
        for(Rectangle r: smallRectangles)
            {
            r.setFillColor(Color.white);
            r.setColor(Color.white);
            }
    }
    
    
    public void setDots ()
    {
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
   
    /**
     *
     * @param canvas
     */
    @Override
    public void drawdots(Graphics canvas)
    {
      Point dot1 = new Point(getPosition().x-4, getPosition().y-4);
    Point dot2 = new Point(getPosition().x-4, getPosition().y+length-4); // left corner (ltht)
    Point dot3 = new Point(getPosition().x-4+width, getPosition().y-4);// Top Right corner
    Point dot4 = new Point(getPosition().x+width-4,getPosition().y+length-4);// right corner
     

    smallRectangles[0].setPosition(dot1);
    smallRectangles[1].setPosition(dot2);
    smallRectangles[2].setPosition(dot3);
    smallRectangles[3].setPosition(dot4);

     for(Rectangle r: smallRectangles)
     {
     r.draw(canvas);
     } 
     
    }
    
      @Override
    public void resizeShape(Graphics canvas, int cornerNumber, Point currentPoint) {
        
        switch (cornerNumber) {
            case 0:
                System.out.println("Ana gowa point0 dlw2tyyy");
                //setPosition(currentCorPoint);
                if(currentPoint.x != getPosition().x)
                {
                    System.out.println("COndition 1  nowww");
                    int xshift = currentPoint.x-getPosition().x;
                    
                    width = width -xshift ;
                    Point p1 = new Point (getPosition().x+xshift,getPoint4().y);
                    smallRectangles[1].setPosition(p1);}
                if(currentPoint.y != getPosition().y)
                {
                    System.out.println("COndition 2");
                    int yshift =currentPoint.y-getPosition().y;
                    
                    
                    length = length - yshift ;
                    Point p2 = new Point (getPoint2().x,getPosition().y+yshift);
                    smallRectangles[2].setPosition(p2);
                }   setPosition(currentPoint);
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
                }   if(currentPoint.y != getPoint4().y)
                {
                    System.out.println("COndition 2");
                    int yshift =currentPoint.y-getPoint4().y;
                    
                    length = length + yshift ;
                    Point p4 = new Point (getPoint3().x,getPoint3().y+yshift);
                    smallRectangles[3].setPosition(p4);
                    
                    setPoint3(p4);
                }   setPoint4(currentPoint) ;
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
                }   if(currentPoint.y != getPoint2().y)
                {
                    System.out.println("COndition 2");
                    int yshift =currentPoint.y-getPoint2().y;
                    
                    
                    length = length - yshift ;
                    Point p6 = new Point (getPosition().x,getPoint2().y+yshift);
                    smallRectangles[0].setPosition(p6);
                    setPosition(p6);
                }   setPoint2(currentPoint);
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
                }   if(currentPoint.y != getPoint3().y)
                {
                    System.out.println("COndition 2");
                    int yshift =currentPoint.y-getPoint3().y;
                    
                    
                    length = length + yshift ;
                    Point p8 = new Point (getPoint4().x,getPoint3().y+yshift);
                    smallRectangles[1].setPosition(p8);
                    setPoint4(p8);
                }   setPoint3(currentPoint);
                break;
            default:
                break;
        }
        smallRectangles[cornerNumber].setPosition(currentPoint);
    }
    
    
    
    
    
    

    public int getHorizontalRadius() {
        return horizontalRadius;
    }

    public int getVerticalRadius() {
        return verticalRadius;
    }
    
   

    public void setHorizontalRadius(int horizontalRadius) {
        this.horizontalRadius = horizontalRadius;
    }

    public void setVerticalRadius(int verticalRadius) {
        this.verticalRadius = verticalRadius;
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
       
           
 Point arrayPoint[]={getPosition(),point2,point3,point4};
     Point min=getPosition();
     for(Point p : arrayPoint)
     {
         if(min.x>p.x)
         {
             min=p;
         }
         if(min.y>p.y)
         {
          min=p;
         }
     }
     Point newWidth = new Point();
     for (Point p: arrayPoint)
     {
         if(min.y==p.y&&min.x!=p.x)
         {
             newWidth=p;
         }
     }
         Point newHeight = new Point();
     for (Point p: arrayPoint)
     {
         if(min.x==p.x&&min.y!=p.y)
         {
             newHeight=p;
         }
     } 
    // this.setPosition(min);
    canvas.setColor(getFillColor());
 canvas.fillOval(min.x,min.y,newWidth.x-min.x,newHeight.y-min.y);
       canvas.setColor(getColor());
 canvas.drawOval(min.x,min.y,newWidth.x-min.x,newHeight.y-min.y);
       
       }
      
    
    @Override
     public void setDraggingPoint(Point draggingPoint) {
         
         //super.setDraggingPoint(draggingPoint); // hhseb l relative diffrence lkol no2ta mohma fel shape
          this.draggingPoint = draggingPoint ;                                      // lma agi arsm l shkl tany hrsm blnsba l dragging point
         xdiff=(draggingPoint.x)-(getPosition().x);
         ydiff=(draggingPoint.y)-(getPosition().y);
         
     }
    
 @Override
    public boolean contain(Point b) {
  
//         Polygon p = new Polygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
//     return p.contains(b);
        
          double p = ((double)Math.pow((b.x - (getPosition().x+width/2)), 2)
            / (double)Math.pow(width/2, 2))
           + ((double)Math.pow((b.y -(getPosition().y+length/2) ), 2)
              / (double)Math.pow(length/2, 2));
              if(p<=1)
              {
                  return true;
              }                      
              return false;
    
    }
    @Override
    public void moveTo(Point b) {
 
        Point k =new Point((b.x-xdiff),(b.y-ydiff));
        System.out.println(horizontalRadius);
        System.out.println(verticalRadius);
        setPosition(k);
    

    }
    
 

    @Override
    public JsonObject toJsonObject() {
         JsonObject jsonObject=new JsonObject();
        jsonObject.put("Type", "Oval");
        jsonObject.put("Centerx", getPosition().x);
        jsonObject.put("Centery", getPosition().y);
        jsonObject.put("vradius", length);
        jsonObject.put("hradius", width);
        
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
            int x=((BigDecimal) jo.get("Centerx")).intValue();
        int y=((BigDecimal) jo.get("Centery")).intValue();
        Point center=new Point(x,y);
        int vr=((BigDecimal) jo.get("vradius")).intValue();
        int hr=((BigDecimal) jo.get("hradius")).intValue();
        
        int redf=((BigDecimal) jo.get("redf")).intValue();
        int greenf=((BigDecimal) jo.get("greenf")).intValue();
        int bluef=((BigDecimal) jo.get("bluef")).intValue();
        Color fill=new Color(redf, greenf, bluef);
        
        int redb=((BigDecimal) jo.get("redb")).intValue();
        int greenb=((BigDecimal) jo.get("greenb")).intValue();
        int blueb=((BigDecimal) jo.get("blueb")).intValue(); 
        Color boarder =new Color(redb, greenb, blueb);
        
        setPosition(center);
        length=vr;
        width=hr;
        
        setColor(boarder);
        setFillColor(fill);
    }

    @Override
    public Point getDraggingPoint() {
        return this.draggingPoint ;
    }

    }
    
    

   
    
