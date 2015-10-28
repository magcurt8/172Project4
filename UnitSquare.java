import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.ArrayList;

public class UnitSquare extends JPanel{
    private ArrayList<LineSegment> lines;
    public Point p0;
    public Point p1;
    private BinaryTree tree;
    private boolean firstPoint;
    final int xStart = 20;
    final int yStart = 20;
    final int width = 300;
    double drawLineX1, drawLineX2, drawLineY1, drawLineY2;
    LineSegment drawLine;

    public UnitSquare()
    {
        lines = new ArrayList<LineSegment>();
        p0 = null;
        p1 = null;
        firstPoint = false;  
    }

    public void addLine(LineSegment l)
    {
    	drawLineX1 = l.p1.x;
    	drawLineY1 = 1-l.p1.y;
    	drawLineX2 = l.p2.x;
    	drawLineY2 = 1-l.p2.y;
    	
    	drawLine = new LineSegment(drawLineX1, drawLineY1, drawLineX2, drawLineY2);
    	
        lines.add(drawLine);
        repaint();
    }

    public void setTree(BinaryTree tree)
    {
        this.tree = tree;
    }

    public void checkPoints()
    {
        if(p0 != null && p1 != null)
        { 
            String s;
            LineSegment res1 = tree.search(tree.getNode(), p0, p1);
            if(res1 == null)
                s = ("Points "+ p0+" and "+ p1 +" are in the same region");
            else
                s = ("Points "+p0+" and "+p1+" are separated by line " + res1.p1.x + " " + res1.p1.y + " " + res1.p2.x + " " + res1.p2.y);
            System.out.println(s);
        }
    }

    public void addPoint(MouseEvent e)
    {
        if(e.getX() > width+xStart || e.getY() > width+yStart || e.getX() < xStart || e.getY() < yStart)
            return;  // not a valid point

        // If p0 is selected, then select p1. Otherwise select the opposite of the last one selected. 
        if(p0 != null && p1 == null)
            firstPoint = false;
        else
            firstPoint = !firstPoint;

        if(firstPoint){
            p0 = new Point(((double)e.getX()-xStart)/width, ((double)e.getY()-yStart)/width);
            p1=null;}
        else
            p1 = new Point(((double)e.getX()-xStart)/width, ((double)e.getY()-yStart)/width);

        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.white);
        g.setColor(Color.black);
        g.drawString("Please select two points to compare and see Output window.",10,350);
        g.drawRect(xStart,yStart,width,width);

        // Draw any lines needed
        for(LineSegment l : lines)
        {
            g.drawLine((int)(width*l.p1.x)+xStart, (int)(width*(1-l.p1.y))+yStart, (int)(width*l.p2.x)+xStart, (int)(width*(1-l.p2.y))+yStart);
        }

        // Draw points if they are selected
        if(p0!=null)
            g.fillOval((int)(p0.x), (int)(p0.y),5,5);
        if(p1!=null)
            g.fillOval((int)(p1.x), (int)(p1.y),5,5);
    }

}
