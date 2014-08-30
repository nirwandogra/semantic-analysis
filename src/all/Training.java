package all;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Training
{
	public static void Train_NaiveBayes() throws FileNotFoundException
	{
		String pos="E:\\wsp2\\minor\\data\\imdb1\\pos";
		String neg="E:\\wsp2\\minor\\data\\imdb1\\neg";
		//Scanner fileScanner = new Scanner(new File(path+".txt"));
		File[] files = new File(pos).listFiles();
		//showFiles(files);
		String str;int val=0;

		String []punc= {",",".", "!",":","\t" ,"\n","-","(",")","?"};
		int flag=0;
		for(int i=0;i<files.length;i++)
		{
			Scanner fileScanner=new Scanner(files[i]);
			while(fileScanner.hasNext())
			{
				str=fileScanner.next();
				flag=0;
				for(int j=0;j<punc.length;j++)
				{
					if(str==punc[j])
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
				{
					continue;
				}
				if(backgroundminor.posmap.get(str)==null)
				{
					backgroundminor.posmap.put(str,1);
				}
				else
				{
					val=backgroundminor.posmap.get(str);
					backgroundminor.posmap.put(str, val+1);
				}
			}
		}
		files = new File(neg).listFiles();
		val=0;
		for(int i=0;i<files.length;i++)
		{
			Scanner fileScanner=new Scanner(files[i]);
			while(fileScanner.hasNext())
			{
				str=fileScanner.next();
				if(backgroundminor.negmap.get(str)==null)
				{
					backgroundminor.negmap.put(str,1);
				}
				else
				{
					val=backgroundminor.negmap.get(str);
					backgroundminor.negmap.put(str, val+1);
				}
			}
		}
		Iterator it = backgroundminor.posmap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			backgroundminor.totalpositive+=(Integer)pairs.getValue();
			//		        it.remove(); // avoids a ConcurrentModificationException
		}
		it = backgroundminor.negmap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			backgroundminor.totalnegative+=(Integer)pairs.getValue();
			//		        it.remove(); // avoids a ConcurrentModificationException
		}
		backgroundminor.totalvocab=backgroundminor.totalnegative+backgroundminor.totalnegative;
		System.out.println( " neg pos total" + backgroundminor.totalnegative+" "+backgroundminor.totalpositive+" "+backgroundminor.totalvocab);
		for(int i=0;i<punc.length;i++)
		{
			backgroundminor.posmap.put(punc[i], 0);
			backgroundminor.negmap.put(punc[i], 0);
		}
		//System.out.println(" Terminate "+(posmap.get("good")-negmap.get("good")));
		//System.out.println(" Terminate "+(posmap.get("bad")-negmap.get("bad")));
		//int a=sc.nextInt();"c:\\file.txt"
		//String ss2=sc.nextLine();
		//			int val=0;
		//			System.out.println(" Hello World ");
		//			HashMap<String,Integer> mp=new HashMap<String, Integer>();
		//			String str="dfd nirwan dogra";
		//			if(mp.get(str)==null) {System.out.println("fgd");
		//			mp.put(str, 1);
		//			val=1;
		//			}
		//			{val=mp.get(str);mp.put(str, val+1);}
		//			val=mp.get(str);
		//			System.out.println(" value = "+val);
		//String[] ss=ss2.split(" ");
		//			String newstr=str.replace('n', 'x');
		//			newstr=str.replace(' ', 'x');
		//	System.out.println(" value = "+ss[1]);
		//		  int cnt=0;
		//		  String []a=new String[20000];
		//		  HashMap<String,Integer> mp=new HashMap<String,Integer>();
		//		  while(fileScanner.hasNext())
		//		  {
		//			  a[cnt]=fileScanner.next();
		//			///  System.out.println(" value = "+a[cnt]);
		//			  if(mp.get(a[cnt])==null)
		//			  {
		//				  mp.put(a[cnt],1);
		//			  }
		//			  else
		//			  {
		//				  mp.put(a[cnt],mp.get(a[cnt])+1);
		//			  }
		//		      cnt++;
		//		  }
		//		  fileScanner = new Scanner(new File(path+"_2"+".txt"));
		//		  int temp=cnt;
		//		  while(fileScanner.hasNext())
		//		  {
		//			  a[cnt]=fileScanner.next();
		//			  System.out.println(" value = "+a[cnt]);
		//			  if(mp.get(a[cnt])==null)
		//			  {
		//				  mp.put(a[cnt],1);
		//			  }
		//			  else
		//			  {
		//				  mp.put(a[cnt],mp.get(a[cnt])+1);
		//			  }
		//		      cnt++;
		//		  }
		//		  //System.out.println(" "+cnt);
		//		  //String []ss2=a[0].split(" ");
		//		 // System.out.println(" "+ss2[0]+"  "+ss2[1]+" "+ss2[2]);
		//		  //String newstr=a[0].replace(' ', 'x');
		//		  System.out.println(" 2nd loop Freq "+mp.get(a[temp]));
		//		  System.out.println(" 2nd loop Freq "+(a[temp])); 
	}
	public static void Train_Bigram() throws FileNotFoundException
	{
		String pos="E:\\wsp2\\minor\\data\\imdb1\\pos";
		String neg="E:\\wsp2\\minor\\data\\imdb1\\neg";
		//Scanner fileScanner = new Scanner(new File(path+".txt"));
		File[] files = new File(pos).listFiles();
		//showFiles(files);
		String str;int val=0;

		String []punc= {",",".", "!",":","\t" ,"\n","-","(",")","?"};
		int flag=0;
		String prev="";String str1="";
		for(int i=0;i<files.length;i++)
		{
			Scanner fileScanner=new Scanner(files[i]);
			while(fileScanner.hasNext())
			{
				str1=fileScanner.next();
				str=str1+prev;
				prev=str1;
				flag=0;
				for(int j=0;j<punc.length;j++)
				{
					if(str==punc[j])
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
				{
					continue;
				}
				if(backgroundminor.pos2map.get(str)==null)
				{
					backgroundminor.pos2map.put(str,1);
				}
				else
				{
					val=backgroundminor.pos2map.get(str);
					backgroundminor.pos2map.put(str, val+1);
				}
			}
		}
		files = new File(neg).listFiles();
		val=0;prev="";str1="";
		for(int i=0;i<files.length;i++)
		{
			Scanner fileScanner=new Scanner(files[i]);
			while(fileScanner.hasNext())
			{
				str1=fileScanner.next();
				str=str1+prev;
				prev=str1;
				if(backgroundminor.neg2map.get(str)==null)
				{
					backgroundminor.neg2map.put(str,1);
				}
				else
				{
					val=backgroundminor.neg2map.get(str);
					backgroundminor.neg2map.put(str, val+1);
				}
			}
		}
		Iterator it = backgroundminor.posmap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			backgroundminor.totalpositive+=(Integer)pairs.getValue();
			//		        it.remove(); // avoids a ConcurrentModificationException
		}
		it = backgroundminor.negmap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			backgroundminor.totalnegative+=(Integer)pairs.getValue();
			//		        it.remove(); // avoids a ConcurrentModificationException
		}
		backgroundminor.totalvocab=backgroundminor.totalnegative+backgroundminor.totalnegative;
		System.out.println( " neg pos total" + backgroundminor.totalnegative+" "+backgroundminor.totalpositive+" "+backgroundminor.totalvocab);
		for(int i=0;i<punc.length;i++)
		{
			backgroundminor.posmap.put(punc[i], 0);
			backgroundminor.negmap.put(punc[i], 0);
		}
		//System.out.println(" Terminate "+(posmap.get("good")-negmap.get("good")));
		//System.out.println(" Terminate "+(posmap.get("bad")-negmap.get("bad")));
		//int a=sc.nextInt();"c:\\file.txt"
		//String ss2=sc.nextLine();
		//			int val=0;
		//			System.out.println(" Hello World ");
		//			HashMap<String,Integer> mp=new HashMap<String, Integer>();
		//			String str="dfd nirwan dogra";
		//			if(mp.get(str)==null) {System.out.println("fgd");
		//			mp.put(str, 1);
		//			val=1;
		//			}
		//			{val=mp.get(str);mp.put(str, val+1);}
		//			val=mp.get(str);
		//			System.out.println(" value = "+val);
		//String[] ss=ss2.split(" ");
		//			String newstr=str.replace('n', 'x');
		//			newstr=str.replace(' ', 'x');
		//	System.out.println(" value = "+ss[1]);
		//		  int cnt=0;
		//		  String []a=new String[20000];
		//		  HashMap<String,Integer> mp=new HashMap<String,Integer>();
		//		  while(fileScanner.hasNext())
		//		  {
		//			  a[cnt]=fileScanner.next();
		//			///  System.out.println(" value = "+a[cnt]);
		//			  if(mp.get(a[cnt])==null)
		//			  {
		//				  mp.put(a[cnt],1);
		//			  }
		//			  else
		//			  {
		//				  mp.put(a[cnt],mp.get(a[cnt])+1);
		//			  }
		//		      cnt++;
		//		  }
		//		  fileScanner = new Scanner(new File(path+"_2"+".txt"));
		//		  int temp=cnt;
		//		  while(fileScanner.hasNext())
		//		  {
		//			  a[cnt]=fileScanner.next();
		//			  System.out.println(" value = "+a[cnt]);
		//			  if(mp.get(a[cnt])==null)
		//			  {
		//				  mp.put(a[cnt],1);
		//			  }
		//			  else
		//			  {
		//				  mp.put(a[cnt],mp.get(a[cnt])+1);
		//			  }
		//		      cnt++;
		//		  }
		//		  //System.out.println(" "+cnt);
		//		  //String []ss2=a[0].split(" ");
		//		 // System.out.println(" "+ss2[0]+"  "+ss2[1]+" "+ss2[2]);
		//		  //String newstr=a[0].replace(' ', 'x');
		//		  System.out.println(" 2nd loop Freq "+mp.get(a[temp]));
		//		  System.out.println(" 2nd loop Freq "+(a[temp])); 
	}
	public static void Train_Trigram() throws FileNotFoundException
	{
		String pos="E:\\wsp2\\minor\\data\\imdb1\\pos";
		String neg="E:\\wsp2\\minor\\data\\imdb1\\neg";
		//Scanner fileScanner = new Scanner(new File(path+".txt"));
		File[] files = new File(pos).listFiles();
		//showFiles(files);
		String str;int val=0;

		String []punc= {",",".", "!",":","\t" ,"\n","-","(",")","?"};
		int flag=0;
		String prev="";String str1="";String prev2="";
		for(int i=0;i<files.length;i++)
		{
			Scanner fileScanner=new Scanner(files[i]);
			while(fileScanner.hasNext())
			{
				str1=fileScanner.next();
				str=str1+prev+prev2;
				prev2=prev;
				prev=str1;
				flag=0;
				for(int j=0;j<punc.length;j++)
				{
					if(str==punc[j])
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
				{
					continue;
				}
				if(backgroundminor.pos3map.get(str)==null)
				{
					backgroundminor.pos3map.put(str,1);
				}
				else
				{
					val=backgroundminor.pos3map.get(str);
					backgroundminor.pos3map.put(str, val+1);
				}
			}
		}
		files = new File(neg).listFiles();
		val=0;prev="";str1="";
		for(int i=0;i<files.length;i++)
		{
			Scanner fileScanner=new Scanner(files[i]);
			while(fileScanner.hasNext())
			{
				str1=fileScanner.next();
				str=str1+prev+prev2;
				prev2=prev;
				prev=str1;
				flag=0;
				for(int j=0;j<punc.length;j++)
				{
					if(str==punc[j])
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
				{
					continue;
				}
				if(backgroundminor.neg3map.get(str)==null)
				{
					backgroundminor.neg3map.put(str,1);
				}
				else
				{
					val=backgroundminor.neg3map.get(str);
					backgroundminor.neg3map.put(str, val+1);
				}
			}
		}
		Iterator it = backgroundminor.posmap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			backgroundminor.totalpositive+=(Integer)pairs.getValue();
			//		        it.remove(); // avoids a ConcurrentModificationException
		}
		it = backgroundminor.negmap.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			backgroundminor.totalnegative+=(Integer)pairs.getValue();
			//		        it.remove(); // avoids a ConcurrentModificationException
		}
		backgroundminor.totalvocab=backgroundminor.totalnegative+backgroundminor.totalnegative;
		System.out.println( " neg pos total" + backgroundminor.totalnegative+" "+backgroundminor.totalpositive+" "+backgroundminor.totalvocab);
		for(int i=0;i<punc.length;i++)
		{
			backgroundminor.posmap.put(punc[i], 0);
			backgroundminor.negmap.put(punc[i], 0);
		}
		//System.out.println(" Terminate "+(posmap.get("good")-negmap.get("good")));
		//System.out.println(" Terminate "+(posmap.get("bad")-negmap.get("bad")));
		//int a=sc.nextInt();"c:\\file.txt"
		//String ss2=sc.nextLine();
		//			int val=0;
		//			System.out.println(" Hello World ");
		//			HashMap<String,Integer> mp=new HashMap<String, Integer>();
		//			String str="dfd nirwan dogra";
		//			if(mp.get(str)==null) {System.out.println("fgd");
		//			mp.put(str, 1);
		//			val=1;
		//			}
		//			{val=mp.get(str);mp.put(str, val+1);}
		//			val=mp.get(str);
		//			System.out.println(" value = "+val);
		//String[] ss=ss2.split(" ");
		//			String newstr=str.replace('n', 'x');
		//			newstr=str.replace(' ', 'x');
		//	System.out.println(" value = "+ss[1]);
		//		  int cnt=0;
		//		  String []a=new String[20000];
		//		  HashMap<String,Integer> mp=new HashMap<String,Integer>();
		//		  while(fileScanner.hasNext())
		//		  {
		//			  a[cnt]=fileScanner.next();
		//			///  System.out.println(" value = "+a[cnt]);
		//			  if(mp.get(a[cnt])==null)
		//			  {
		//				  mp.put(a[cnt],1);
		//			  }
		//			  else
		//			  {
		//				  mp.put(a[cnt],mp.get(a[cnt])+1);
		//			  }
		//		      cnt++;
		//		  }
		//		  fileScanner = new Scanner(new File(path+"_2"+".txt"));
		//		  int temp=cnt;
		//		  while(fileScanner.hasNext())
		//		  {
		//			  a[cnt]=fileScanner.next();
		//			  System.out.println(" value = "+a[cnt]);
		//			  if(mp.get(a[cnt])==null)
		//			  {
		//				  mp.put(a[cnt],1);
		//			  }
		//			  else
		//			  {
		//				  mp.put(a[cnt],mp.get(a[cnt])+1);
		//			  }
		//		      cnt++;
		//		  }
		//		  //System.out.println(" "+cnt);
		//		  //String []ss2=a[0].split(" ");
		//		 // System.out.println(" "+ss2[0]+"  "+ss2[1]+" "+ss2[2]);
		//		  //String newstr=a[0].replace(' ', 'x');
		//		  System.out.println(" 2nd loop Freq "+mp.get(a[temp]));
		//		  System.out.println(" 2nd loop Freq "+(a[temp])); 
	}
}
