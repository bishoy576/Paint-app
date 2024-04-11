/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author 20100
 */
public interface Resize {
     public void drawdots(Graphics canvas);
     public void setDots();

    /**
     *
     * @param canvas
     * @param cornerNumber
     * @param currentPoint
     */
    public void resizeShape(Graphics canvas, int cornerNumber, Point currentPoint);
     public void deletedots(Graphics canvas);
     public Rectangle[] getSmallRectangles();
    
}
