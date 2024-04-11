/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import java.awt.*;
import java.math.BigDecimal;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author zedan.net
 */
public class LineSegment extends AbstractShape {

    private Point position2;
    private Point draggingPoint;
    private Rectangle[] smallRectangles;

    @Override
    public Shapes.Rectangle[] getSmallRectangles() {
        return smallRectangles;
    }

    public void setSmallRectangles(Shapes.Rectangle[] smallRectangles) {
        this.smallRectangles = smallRectangles;
    }

    public int getCurrentCorner() {
        return currentCorner;
    }

    public void setCurrentCorner(int currentCorner) {
        this.currentCorner = currentCorner;
    }
    private int currentCorner;

    @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

    @Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

    public LineSegment(Point position, Point position2) {
        super(position);
        this.position2 = position2;
        smallRectangles = new Rectangle[2];
    }

    public void setPosition2(Point position) {
        this.position2 = position;
    }

    public Point getPosition2() {
        return position2;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawLine(getPosition().x, getPosition().y, position2.x, position2.y);

    }

    @Override
    public boolean contain(Point b) {
        double x1 = Math.pow(Math.abs(b.x - this.getPosition().x), 2);
        double y1 = Math.pow(Math.abs(b.y - this.getPosition().y), 2);
        double min1 = Math.sqrt(x1 + y1);
        double x2 = Math.pow(Math.abs(b.x - this.position2.x), 2);
        double y2 = Math.pow(Math.abs(b.y - this.position2.y), 2);
        double min2 = Math.sqrt(x2 + y2);
        double fin = min1 + min2;

        double x3 = Math.pow(Math.abs(this.getPosition().x - this.position2.x), 2);
        double y3 = Math.pow(Math.abs(this.getPosition().y - this.position2.y), 2);
        double min3 = Math.sqrt(x3 + y3);
        System.out.println(fin + " here" + min3);

        return (int) fin == (int) min3;
    }

    @Override
    public void moveTo(Point nextpoint) {
        Point p = getPosition();
        p.translate((int) (nextpoint.x - draggingPoint.x),
                (int) (nextpoint.y - draggingPoint.y));

        position2.translate((int) (nextpoint.x - draggingPoint.x),
                (int) (nextpoint.y - draggingPoint.y));
    }

    @Override
    public void drawdots(Graphics canvas) {
        Point oo1 = new Point(getPosition().x - 4, getPosition().y - 4);
        Point oo2 = new Point(position2.x - 4, position2.y - 4);

        smallRectangles[0].setPosition(oo1);
        smallRectangles[1].setPosition(oo2);

        for (Rectangle r : smallRectangles) {
            r.draw(canvas);
        }

    }

    @Override
    public void setDots() {
        Point oo1 = new Point(getPosition().x - 4, getPosition().y - 4);
        Point oo2 = new Point(position2.x - 4, position2.y - 4);

        Rectangle r1 = new Rectangle(8, 8, oo1);
        Rectangle r2 = new Rectangle(8, 8, oo2);

        smallRectangles[0] = r1;
        smallRectangles[1] = r2;

    }

    @Override
    public void resizeShape(Graphics canvas, int cornerNumber, Point currentPoint) {
        if (cornerNumber == 0) {
            setPosition(currentPoint);
        } else if (cornerNumber == 1) {
            position2 = currentPoint;
        }

        smallRectangles[cornerNumber].setPosition(currentPoint);

    }

    @Override
    public void deletedots(Graphics canvas) {
        for (Rectangle r : smallRectangles) {
            r.setFillColor(Color.white);
            r.setColor(Color.WHITE);
        }
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("Type", "Line");
        jsonObject.put("Point1x", getPosition().x);
        jsonObject.put("Point1y", getPosition().y);
        jsonObject.put("Point2x", position2.x);
        jsonObject.put("Point2y", position2.y);
        jsonObject.put("redb", getColor().getRed());
        jsonObject.put("greenb", getColor().getGreen());
        jsonObject.put("blueb", getColor().getBlue());
        return jsonObject;
    }

    @Override
    public void fromJsonObject(JsonObject jo) {
        int Point1x = ((BigDecimal) jo.get("Point1x")).intValue();
        int Point1y = ((BigDecimal) jo.get("Point1y")).intValue();
        Point pos1 = new Point(Point1x, Point1y);

        int Point2x = ((BigDecimal) jo.get("Point2x")).intValue();
        int Point2y = ((BigDecimal) jo.get("Point2y")).intValue();
        Point pos2 = new Point(Point2x, Point2y);

        int redb = ((BigDecimal) jo.get("redb")).intValue();
        int greenb = ((BigDecimal) jo.get("greenb")).intValue();
        int blueb = ((BigDecimal) jo.get("blueb")).intValue();
        Color border = new Color(redb, greenb, blueb);

        setPosition(pos1);
        position2 = pos2;

        setColor(border);

    }

}
