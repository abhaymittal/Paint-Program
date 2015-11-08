//MyFigure.java
// author : Abhay Mittal
// Dated: 16/11/12
// Faculty No.: 11-PEB-005
// Roll No. : 002
// Enrollment No. GD8309
//contains the abstract class MyFigure from which classes Rectangle, Oval, Line and Pen are inherited

import java.awt.Color;
import java.awt.Graphics;

abstract public class MyFigure implements Cloneable
{
	int x1,y1,x2,y2;
	int fl;
	protected Color col=Color.BLACK;
	protected int thick=0;
	public void setThickness(int x)
	{thick=x;}
	public void setX1(int x)
	{x1=x;}
	public int getX1()
	{return x1;}
	public int getX2()
	{return x2;}
	public int getY1()
	{return y1;}
	public int getY2()
	{return y2;}
	public void setX2(int x)
	{x2=x;}
	public void setY1(int y)
	{y1=y;}
	public void setY2(int y)
	{y2=y;}
	public void setfl(int x)
	{fl=x;}
	public int getfl()
	{return fl;}
	public void setColor(Color colr)
	{col = colr;}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	abstract public void draw(Graphics g);

}

class Rectangle extends MyFigure
{
	Rectangle()
	{
		setX1(0);
		setX2(0);
		setY1(0);
		setY2(0);
		setColor(Color.BLACK);
	}
	MyFigure e;
	@Override
	public void draw(Graphics g)
	{
		g.setColor(col);
		int x=Math.min(getX1(),getX2());
		int y=Math.min(getY1(),getY2());
		if(getfl()==1)
		g.fillRect(x,y,Math.abs(getX2()-getX1()),Math.abs(getY2()-getY1()));
		else
		g.drawRect(x,y,Math.abs(getX2()-getX1()),Math.abs(getY2()-getY1()));
	}
}

class Oval extends MyFigure
{
	Oval()
	{
		setX1(0);
		setX2(0);
		setY1(0);
		setY2(0);
		setColor(Color.BLACK);
	}
	@Override
	public void draw(Graphics g)
	{
		g.setColor(col);		
		int x=Math.min(getX1(),getX2());
		int y=Math.min(getY1(),getY2());
		if(getfl()==1)
		g.fillOval(x,y,Math.abs(getX2()-getX1()),Math.abs(getY2()-getY1()));
		g.drawOval(x,y,Math.abs(getX2()-getX1()),Math.abs(getY2()-getY1()));
	}
}

class Line extends MyFigure
{
	Line()
	{
		setX1(0);
		setX2(0);
		setY1(0);
		setY2(0);
		setColor(Color.BLACK);
	}
	@Override
	public void draw(Graphics g)
	{
		g.setColor(col);
		g.drawLine(getX1(),getY1(),getX2(),getY2());
	}
}

class Pen extends MyFigure
{
	Pen()
	{
		setX1(0);
		setX2(0);
		setY1(0);
		setY2(0);
		setColor(Color.BLACK);
		setThickness(0);
	}
	@Override
	public void draw(Graphics g)
	{
		g.setColor(col);
		for(int i=0;i<=thick;i++)
		{g.drawLine(getX1()+i,getY1(),getX2()+i,getY2());
		g.drawLine(getX1(),getY1()+i,getX2(),getY2()+i);
		}		
	}
}
