//PaintPanel.java
// author : Abhay Mittal
// Dated: 16/11/12
// Faculty No.: 11-PEB-005
// Enrollment No. GD8309
// Roll No. : 002
// contains the coding for drawing area 

import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.event.*;

public class PaintPanel extends JPanel
{
	MyFigure[] shape;
    private MyFigure[] shapes = new MyFigure[1000];
	private int shapeCount = 0;
	int fl,clr=0;
	private int index;
	public void setIndex(int x)
	{index=x;}
	public int getIndex()
	{return index;}
	public void setThickness(int x)
	{shape[3].setThickness(x);}
	
	public void setClear(int clear)
	{
		clr=clear;
		shapeCount=0;
		repaint();
	}
	PaintPanel()
	{
		shape=new MyFigure[4];
		shape[0]=new Oval();
		shape[1]=new Rectangle();
		shape[2]=new Line();
		shape[3]=new Pen();
		index = 0;
		setBackground(Color.WHITE);
		addMouseListener(new MouseClickHandler());
		addMouseMotionListener(new MouseClickHandler());
	}
	public void setColor(Color col)
	{
		for(int i=0;i<shape.length;i++)
		shape[i].setColor(col);
	}
	public void setfl(int x )
	{
		shape[0].setfl(x);
		shape[1].setfl(x);
		shape[2].setfl(x);
	}
	public int getfl()
	{return shape[index].getfl();}	
	class MouseClickHandler extends MouseAdapter implements MouseMotionListener
	{
		public void mousePressed(MouseEvent event)
		{
			shape[index].setX1(event.getX());
			shape[index].setY1(event.getY());
		}
		public void mouseDragged(MouseEvent event)
		{
			shape[index].setX2(event.getX());
			shape[index].setY2(event.getY());
			if(index==3)
			{
				try{
				shapes[shapeCount++]=(MyFigure)shape[index].clone();
				shape[3].setX1(shape[3].getX2());
				shape[3].setY1(shape[3].getY2());
				}
				catch(Exception e)
				{System.out.println("Object Cloning not supported");}
			}
			repaint();
		}
		public void mouseMoved(MouseEvent event)
		{}
		public void mouseReleased(MouseEvent event)
		{
			shape[index].setX2(event.getX());
			shape[index].setY2(event.getY());
			try{
			shapes[shapeCount++]=(MyFigure)shape[index].clone();
			}
			catch(Exception e)
			{System.out.println("Object Cloning not supported");}
			repaint();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		shape[index].setfl(this.getfl());
		if(clr==0)
		{
			if(shapeCount==1000) shapeCount=0;
			for(int i=0;i<shapeCount;i++)
			shapes[i].draw(g);
			shape[index].draw(g);
		}
		if(clr==1)
		{
			clr=0;
		}
	}
}
