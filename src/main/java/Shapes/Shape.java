/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Point;

/**
 *
 * @author zedan.net
 */
public interface Shape {
    public void setPosition(java.awt.Point position);
public java.awt.Point getPosition();
/* update shape specific properties (e.g., radius) */

/* colorize */
public void setColor(java.awt.Color color);
public java.awt.Color getColor();
public void setFillColor(java.awt.Color color);
public java.awt.Color getFillColor();
/* redraw the shape on the canvas */
public void draw(java.awt.Graphics canvas);
public boolean contain (java.awt.Point point);
 public Point getDraggingPoint();
  public void setDraggingPoint(Point xxpoint);
  public JsonObject toJsonObject();
public void fromJsonObject(JsonObject jo);
}
