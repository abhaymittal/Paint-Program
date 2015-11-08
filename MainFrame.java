//MainFrame.java
// author : Abhay Mittal
// Dated: 16/11/12
// Faculty No.: 11-PEB-005
// Roll No. : 002
// Enrollment No. GD8309
// contains the coding for the frame of the application, the tool panel on the left and puts the drawing area in the frame

import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
	JPanel toolPanel;
	private PaintPanel panel;
	private JCheckBox fill;
	private JButton[] button;
	private Color color;
	private Color bgcolor;
	private JComboBox penSize;
	private JTextField ps;
	private static final Integer[] psize={1,2,3,4,5,10};
	public MainFrame()
	{
		super("Paint");
		button = new JButton[8];
		toolPanel = new JPanel();
		ps= new JTextField("Pen Size");
		ps.setFont(new Font("Serif",Font.PLAIN,16));
		ps.setEditable(false);
		panel=new PaintPanel();
		add(toolPanel,BorderLayout.WEST);
		add (panel,BorderLayout.CENTER);
		toolPanel.setLayout(new GridLayout(12,1,1,1));
		button[0]=new JButton("Oval");
		button[0].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pvisible(false);
				panel.setIndex(0);
			}
		});
		toolPanel.add(button[0]);
		button[1]=new JButton("Rectangle");
		button[1].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pvisible(false);
				panel.setIndex(1);
			}
		});
		toolPanel.add(button[1]);
		button[2]=new JButton("Line");
		button[2].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pvisible(false);
				panel.setIndex(2);
			}
		});
		toolPanel.add(button[2]);
		button[3]=new JButton("Pen");
		button[3].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				pvisible(true);
				panel.setIndex(3);
			}
		});
		toolPanel.add(button[3]);
		button[4]=new JButton("Background Color");
		button[4].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Color col = JColorChooser.showDialog(MainFrame.this,"choose background color",Color.WHITE);
				if(col!=null)
				panel.setBackground(col);
			}
		});
		toolPanel.add(button[4]);
		button[5]=new JButton("Color");
		button[5].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				panel.setColor(JColorChooser.showDialog(MainFrame.this,"choose a color",Color.WHITE));
			}
		});
		toolPanel.add(button[5]);
		fill=new JCheckBox("fill");
		toolPanel.add(fill);
		fill.addItemListener(
		new ItemListener()
		{
			public void itemStateChanged(ItemEvent event)
			{
				if(fill.isSelected())
				{panel.setfl(1);}
				else
				{panel.setfl(0);}
			}
		}
		);
		button[6]=new JButton("Clear");
		button[6].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{panel.setClear(1);}
		});
		toolPanel.add(button[6]);
		penSize=new JComboBox(psize);
		penSize.setMaximumRowCount(5);
		penSize.addItemListener(
		new ItemListener()
		{
			public void itemStateChanged(ItemEvent event)
			{
				if(event.getStateChange() == ItemEvent.SELECTED)
				panel.setThickness(penSize.getSelectedIndex());
			}
		});
		toolPanel.add(ps);
		toolPanel.add(penSize);
		pvisible(false);
		button[7]=new JButton("About");
		button[7].addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					JOptionPane.showMessageDialog(MainFrame.this,String.format("Paint Program v 1.0\n\nDeveloper's Name: Abhay Mittal\nClass: B.Tech 2nd Yr (CSE)\nFaculty No.: 11-PEB-005\nRoll No.: 002\nCollege: Z.H.C.E.T, A.M.U."));
				}
				catch (Exception e)
				{System.out.println(e);}
			}
			
		});
		toolPanel.add(button[7]);
		}
		public void pvisible(boolean b)
		{
		ps.setVisible(b);
		penSize.setVisible(b);
		}
}
