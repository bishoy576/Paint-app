/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Map;

/**
 *
 * @author zedan.net
 */

public abstract class AbstractShape  implements Shape,Moveable,Resize{
   
   private Point position ;
   private Color color ;
   private Color fillColor ;

    public AbstractShape(Point position) {
        this.position = position;
    }



   @Override
   public abstract boolean contain (Point point);
     

    @Override
    public void setPosition(Point position) {
       this.position = position ;
    }

    @Override
    public Point getPosition() {
       return position;
    }

  

    @Override
    public void setColor(Color color) {
     this.color=color ;
    }

    @Override
    public Color getColor() {
      return color ;
    }

    @Override
    public void setFillColor(Color color) {
       this.fillColor = color ;
    }

    @Override
    public Color getFillColor() {
     return fillColor ;
    }
        
   @Override
   public abstract void draw (Graphics canvas);   

}
