//Prog.java
// Paint Prog v1.0
// author : Abhay Mittal
// Dated: 16/11/12
// Faculty No.: 11-PEB-005
// Roll No. : 002
// Enrollment No. GD8309
// contains the main function 

/*
Paint Program to create basic shapes (rectangle, oval, line, draw free hand drawing)
user can change pen size during free hand drawing, change color, background color and set fill

MyFigure.java contains the abstract class and inherited classes for the various shapes
PaintPanel.java contains the coding for the drawing area 
MainFrame.java contains the Frame of the application, the coding for the tool bar on the left and puts the drawing area in the frame

created with NotePad ++ 6.1.6
compiled using command prompt
*/


import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class Prog
{
	public static void main(String[] arr)
	{
		MainFrame app = new MainFrame();		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		app.setSize(1024,668);
	}
}
