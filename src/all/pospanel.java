package all;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class pospanel extends JPanel 
{
	pospanel(backgroundminor parent)
	{
		setSize(600,600);
		int width=(int) getSize().getWidth();
		int height=(int) getSize().getHeight();
		JButton prev=new JButton();
		prev.setBounds( 70, height-70, width/2, 30);
		prev.addActionListener(parent);
		prev.setText("Back");
		prev.setBackground(Color.black);
		add(prev);
		setBackground(Color.green);
		System.out.println(parent.prev.getText()+" fdjf here ");
		
	}
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paint(g);
		Image im=new ImageIcon("E:\\wsp2\\nirwan\\src\\logo.png").getImage();
		Font small = new Font("Helvetica", Font.BOLD, 40);
		FontMetrics metr = getFontMetrics(small);
		g.drawImage(im,50,0 , this);
		g.setColor(Color.black);
		g.setFont(small);
		g.drawString(" Positive Review :", 0, 400);
	}
//    public static void main(String []args)
//    {
//    	JFrame jf=new JFrame();
//    	pospanel jp=new pospanel();
//    	jf.setSize(400,500);
//    	jf.add(jp);
//    	jf.setVisible(true);
//    }
}
