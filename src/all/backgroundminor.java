package all;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class backgroundminor extends JFrame implements ActionListener  
{
	static JTextArea jtext;
	static JButton jbut=new JButton("Submit");
	static JPanel panel1=new JPanel();
	static pospanel pos=null;
	static negpanel neg=null;
	static JPanel panel2=new JPanel();
	static JButton prev=new JButton();
	static HashMap<String ,Integer> posmap=new HashMap<String ,Integer>();
	static HashMap<String ,Integer> negmap=new HashMap<String ,Integer>();
	static HashMap<String ,Integer> pos2map=new HashMap<String ,Integer>();
	static HashMap<String ,Integer> neg2map=new HashMap<String ,Integer>();
	static HashMap<String ,Integer> pos3map=new HashMap<String ,Integer>();
	static HashMap<String ,Integer> neg3map=new HashMap<String ,Integer>();
	static int gfl=0;
	static double negative_value=0;
	static double positive_value=0;
	static int totalnegative=0,totalpositive=0,totalvocab=0;;


	protected backgroundminor() throws IOException
	{
		setSize(600,600);
		int width=(int) getSize().getWidth();
		int height=(int) getSize().getHeight();
		prev=new JButton(); 
		prev.setText("Back");
		prev.setBackground(Color.black);
		prev.setBounds( 60, height-70, width/2, 30);
		prev.addActionListener(this);
		pospanel pos1=new pospanel(this);
		negpanel neg1=new negpanel(this);
		pos=pos1;neg=neg1;
		Training tr=new Training();
		tr.Train_Bigram();
	    tr.Train_NaiveBayes();
	    tr.Train_Trigram();
	    //   JLabel label = new JLabel("", image, JLabel.CENTER);
		JPanel panel = new JPanel(new BorderLayout());
		panel.setLayout(null);
		// panel.add( label );

		//	     prev=new JButton();
		//	     
		//	    
		//	     prev.setText("Back");
		//	     prev.setBackground(Color.black);
		//	     prev.setBounds( 60, height-70, width/2, 30);
		//	     prev.addActionListener(this);



		panel1.setSize(600,600);
		panel1.setBackground(Color.red);
		panel1.add(prev);
		//panel1.add(label);


		panel2.setLayout(null);
		panel2.setSize(600,600);
		//panel2.add(label);

		jtext=new JTextArea("");
		jtext.setBackground(new Color(0,255,255));
		setLayout(null);
		jtext.setBounds(0, 0 , width-5,(int)(2*height/3) );
		//		 jtext.addActionListener(this);
		jbut=new JButton("Submit");
		jbut.setBackground(Color.black);
		jbut.setBounds(0, (int)(2*height/3+(5)), width-10, (int)(height/5));
		jbut.addActionListener(this);

		panel2.add(jbut);panel2.add(jtext);
		add(panel2);
		System.out.println(" insided ");
		//add(panel);
		setVisible(true);
		//setSize(50,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setTitle(" NLP USING BIGRAM AND UNIGRAM  ");
	}
	public static void main(String []args) throws IOException
	{
		backgroundminor b=new backgroundminor(); 
	}
	//   public static void Train() throws FileNotFoundException
	//   {
	//
	//		String pos="E:\\wsp2\\nirwan\\src\\data\\imdb1\\pos";
	//		String neg="E:\\wsp2\\nirwan\\src\\data\\imdb1\\neg";
	//		//Scanner fileScanner = new Scanner(new File(path+".txt"));
	//		File[] files = new File(pos).listFiles();
	//		//showFiles(files);
	//		String str;int val=0;
	//		String []punc= {"," , "." , " "};
	//		for(int i=0;i<punc.length;i++)
	//		{
	//			posmap.put(punc[i], 1);
	//			negmap.put(punc[i], 1);
	//		}
	//		int flag=0;
	//		for(int i=0;i<files.length;i++)
	//		{
	//			Scanner fileScanner=new Scanner(files[i]);
	//			while(fileScanner.hasNext())
	//			{
	//				str=fileScanner.next();
	//				flag=0;
	//				for(int j=0;j<punc.length;j++)
	//				{
	//					if(str==punc[j])
	//					{
	//					   flag=1;
	//					   break;
	//					}
	//				}
	//				if(flag==1)
	//				{
	//					continue;
	//				}
	//				if(posmap.get(str)==null)
	//				{
	//					posmap.put(str,1);
	//				}
	//				else
	//				{
	//					val=posmap.get(str);
	//					posmap.put(str, val+1);
	//				}
	//			}
	//		}
	//		files = new File(neg).listFiles();
	//		val=0;
	//		for(int i=0;i<files.length;i++)
	//		{
	//			Scanner fileScanner=new Scanner(files[i]);
	//			while(fileScanner.hasNext())
	//			{
	//				str=fileScanner.next();
	//				if(negmap.get(str)==null)
	//				{
	//					negmap.put(str,1);
	//				}
	//				else
	//				{
	//					val=negmap.get(str);
	//					negmap.put(str, val+1);
	//				}
	//			}
	//		}
	//		//System.out.println(" Terminate "+(posmap.get("good")-negmap.get("good")));
	//		//System.out.println(" Terminate "+(posmap.get("bad")-negmap.get("bad")));
	//		//int a=sc.nextInt();"c:\\file.txt"
	//		//String ss2=sc.nextLine();
	////		int val=0;
	////		System.out.println(" Hello World ");
	////		HashMap<String,Integer> mp=new HashMap<String, Integer>();
	////		String str="dfd nirwan dogra";
	////		if(mp.get(str)==null) {System.out.println("fgd");
	////		mp.put(str, 1);
	////		val=1;
	////		}
	////		{val=mp.get(str);mp.put(str, val+1);}
	////		val=mp.get(str);
	////		System.out.println(" value = "+val);
	//		//String[] ss=ss2.split(" ");
	////		String newstr=str.replace('n', 'x');
	////		newstr=str.replace(' ', 'x');
	//	//	System.out.println(" value = "+ss[1]);
	////	  int cnt=0;
	////	  String []a=new String[20000];
	////	  HashMap<String,Integer> mp=new HashMap<String,Integer>();
	////	  while(fileScanner.hasNext())
	////	  {
	////		  a[cnt]=fileScanner.next();
	////		///  System.out.println(" value = "+a[cnt]);
	////		  if(mp.get(a[cnt])==null)
	////		  {
	////			  mp.put(a[cnt],1);
	////		  }
	////		  else
	////		  {
	////			  mp.put(a[cnt],mp.get(a[cnt])+1);
	////		  }
	////	      cnt++;
	////	  }
	////	  fileScanner = new Scanner(new File(path+"_2"+".txt"));
	////	  int temp=cnt;
	////	  while(fileScanner.hasNext())
	////	  {
	////		  a[cnt]=fileScanner.next();
	////		  System.out.println(" value = "+a[cnt]);
	////		  if(mp.get(a[cnt])==null)
	////		  {
	////			  mp.put(a[cnt],1);
	////		  }
	////		  else
	////		  {
	////			  mp.put(a[cnt],mp.get(a[cnt])+1);
	////		  }
	////	      cnt++;
	////	  }
	////	  //System.out.println(" "+cnt);
	////	  //String []ss2=a[0].split(" ");
	////	 // System.out.println(" "+ss2[0]+"  "+ss2[1]+" "+ss2[2]);
	////	  //String newstr=a[0].replace(' ', 'x');
	////	  System.out.println(" 2nd loop Freq "+mp.get(a[temp]));
	////	  System.out.println(" 2nd loop Freq "+(a[temp])); 
	//   }
	public static int classify(String test)
	{
		int ret=0;
		String []sp=test.split(" ");
		for(int i=0;i<sp.length;i++)
		{
			if(posmap.get(sp[i])!=null)
			{
				ret+=posmap.get(sp[i]);
			}
			if(negmap.get(sp[i])!=null)
			{
				ret-=negmap.get(sp[i]);
			}
		}
		return ret;
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		//		System.out.println(" Painting ::");
		//		Font small = new Font("Helvetica", Font.BOLD, 40);
		//		FontMetrics metr = getFontMetrics(small);
		//		g.setColor(Color.black);
		//		g.setFont(small);
		//		if(gfl==1)
		//		{
		//			System.out.println(" Pfdfd ::");
		//			getGraphics().drawString(" Positive ", 100, 200);
		//		}
		//		else if(gfl==-1)
		//		{
		//			getGraphics().drawString(" Negative ", 100, 200);
		//		}
	}
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		negative_value=0;
		positive_value=0;
		JButton p= (JButton)(e.getSource());
		System.out.println(" YEAH !"+p.getText());
		if((JButton)e.getSource()==prev || p.getText()=="Back")
		{
			System.out.println(" ggddg ");
			remove(pos);remove(neg);
			add(panel2);  
			gfl=0;
		}
		else
		{
			negative_value=0;
			positive_value=0;
			String val=jtext.getText();
			System.out.println(" here "+val);
			classifiers cs =new classifiers();
			int value=cs.NaiveBayes(val);
			//int value=cs.Bigram(val);
			//int value3=cs.Trigram(val);
			System.out.println(" negative "+negative_value);
			System.out.println(" positive "+positive_value);
			//System.out.println(" Review "+value3);
			System.out.println(" hello ");
			remove(panel2);
			remove(pos);
			remove(neg);
			
			//Graphics g=panel1.getGraphics();
			if(value>0) {add(pos);gfl=1;}
			else {add(neg);gfl=-1;}
		}
		negative_value=0;
		positive_value=0;
		repaint();
		System.out.println(" Adding ");
	}
}
