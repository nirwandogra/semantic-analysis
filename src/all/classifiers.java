package all;

import java.io.IOException;

public class classifiers 
{	   
	public static int NaiveBayes(String test)
	{
		System.out.println("NEGATIVE "+backgroundminor.negative_value);
		System.out.println("POSITIVE "+backgroundminor.positive_value);
		char []punc= {',','.', '!',':','-','?','(',')'};
//		System.out.println("1");
		for(int i=0;i<punc.length;i++)
		{
			test=test.replace(punc[i], ' ');
		}
//		System.out.println("2");
		int ret=0,val1=0,val2=0;;
       
		String []sp=test.split(" ");
        int posv=backgroundminor.totalpositive;
        int negv=backgroundminor.totalnegative;
        int totv=backgroundminor.totalvocab;
        double posprob=Math.log(0.5),negprob=Math.log(0.5);
		for(int i=0;i<sp.length;i++)
		{
			val1=0;val2=0;
			if(backgroundminor.posmap.get(sp[i])!=null)
			{
				ret+=backgroundminor.posmap.get(sp[i]);
				val1=backgroundminor.posmap.get(sp[i]);
				System.out.println("  here "+val1+" val1 "+(totv+posv));
				System.out.println("1 "+Math.log((double)(val1+1)/(totv+posv)));
				posprob+=Math.log((double)(val1+1)/(totv+posv));
			}
			else
			{
				posprob+=Math.log((double)(1)/(posv+totv));
				System.out.println("2 "+Math.log((double)(1)/(totv+posv)));
			}
			if(backgroundminor.negmap.get(sp[i])!=null)
			{
				ret-=backgroundminor.negmap.get(sp[i]);
				val2=backgroundminor.negmap.get(sp[i]);
				negprob+=Math.log((double)(val2+1)/(totv+negv));
				System.out.println("3 "+Math.log((double)(val2+1)/(totv+negv)));
			}
			else
			{
				negprob+=Math.log((double)(1)/(negv+totv));
				System.out.println("4 "+Math.log((double)(1)/(negv+totv)));
			}
			System.out.println(""+sp[i]+" value :: pos "+val1+" neg "+val2);
		}
		System.out.println(""+test);
		backgroundminor.negative_value=+negprob;
		backgroundminor.positive_value=+posprob;
		System.out.println("po nai "+posprob);
		System.out.println("neg nai "+negprob);
		if(negprob>posprob)
		{
		   ret=-1;
		}
		else
		{
			ret=1;
		}
		System.out.println(" here is ret "+ret+" posprob "+posprob+" negprob "+negprob);
		return ret;
	}
	public static int Bigram(String test)
	{
		System.out.println("NEGATIVE "+backgroundminor.negative_value);
		System.out.println("POSITIVE "+backgroundminor.positive_value);
		char []punc= {',','.', '!',':','-','?','(',')'};
//		System.out.println("1");
		for(int i=0;i<punc.length;i++)
		{
			test=test.replace(punc[i], ' ');
		}
//		System.out.println("2");
		int ret=0,val1=0,val2=0;;
       
		String []sp=test.split(" ");
        int posv=backgroundminor.totalpositive;
        int negv=backgroundminor.totalnegative;
        int totv=backgroundminor.totalvocab;
        double posprob=Math.log(0.5),negprob=Math.log(0.5);
		for(int i=1;i<sp.length;i++)
		{
			String temp=sp[i]+sp[i-1];
			val1=0;val2=0;
			if(backgroundminor.pos2map.get(temp)!=null)
			{
				ret+=backgroundminor.pos2map.get(temp);
				val1=backgroundminor.pos2map.get(temp);
				System.out.println("  here "+val1+" val1 "+(totv+posv));
				System.out.println("1 "+Math.log((double)(val1+1)/(totv+posv)));
				posprob+=Math.log((double)(val1+1)/(totv+posv));
			}
			else
			{
				posprob+=Math.log((double)(1)/(posv+totv));
				System.out.println("2 "+Math.log((double)(1)/(totv+posv)));
			}
			if(backgroundminor.neg2map.get(temp)!=null)
			{
				ret-=backgroundminor.neg2map.get(temp);
				val2=backgroundminor.neg2map.get(temp);
				negprob+=Math.log((double)(val2+1)/(totv+negv));
				System.out.println("3 "+Math.log((double)(val2+1)/(totv+negv)));
			}
			else
			{
				negprob+=Math.log((double)(1)/(negv+totv));
				System.out.println("4 "+Math.log((double)(1)/(negv+totv)));
			}
			System.out.println(""+temp+" value :: pos "+val1+" neg "+val2);
		}
		System.out.println(""+test);
		backgroundminor.negative_value=backgroundminor.negative_value+negprob;
		backgroundminor.positive_value=backgroundminor.positive_value+posprob;
		System.out.println("po bigram "+posprob);
		System.out.println("neg bigram "+negprob);
		if(negprob>posprob)
		{	 
		   ret=-1;
		}
		else
		{
			ret=1;
		}
		System.out.println(" here is ret "+ret+" posprob "+posprob+" negprob "+negprob);
		return ret;
	}
	public static int Trigram(String test)
	{
		System.out.println("NEGATIVE "+backgroundminor.negative_value);
		System.out.println("POSITIVE "+backgroundminor.positive_value);
		char []punc= {',','.', '!',':','-','?','(',')'};
//		System.out.println("1");
		for(int i=0;i<punc.length;i++)
		{
			test=test.replace(punc[i], ' ');
		}
//		System.out.println("2");
		int ret=0,val1=0,val2=0;;
       
		String []sp=test.split(" ");
        int posv=backgroundminor.totalpositive;
        int negv=backgroundminor.totalnegative;
        int totv=backgroundminor.totalvocab;
        double posprob=Math.log(0.5),negprob=Math.log(0.5);
		for(int i=2;i<sp.length;i++)
		{
			String temp=sp[i]+sp[i-1]+sp[i-2];
			System.out.println(" FREQUENCY of  :"+temp+"->>>>" +backgroundminor.pos3map.get(temp));
			val1=0;val2=0;
			if(backgroundminor.pos3map.get(temp)!=null)
			{
				ret+=backgroundminor.pos3map.get(temp);
				val1=backgroundminor.pos3map.get(temp);
				System.out.println("  here "+val1+" val1 "+(totv+posv));
				System.out.println("1 "+Math.log((double)(val1+1)/(totv+posv)));
				posprob+=Math.log((double)(val1+1)/(totv+posv));
			}
			else
			{
				posprob+=Math.log((double)(1)/(posv+totv));
				System.out.println("2 "+Math.log((double)(1)/(totv+posv)));
			}
			if(backgroundminor.neg3map.get(temp)!=null)
			{
				ret-=backgroundminor.neg3map.get(temp);
				val2=backgroundminor.neg3map.get(temp);
				negprob+=Math.log((double)(val2+1)/(totv+negv));
				System.out.println("3 "+Math.log((double)(val2+1)/(totv+negv)));
			}
			else
			{
				negprob+=Math.log((double)(1)/(negv+totv));
				System.out.println("4 "+Math.log((double)(1)/(negv+totv)));
			}
			System.out.println(""+temp+" value :: pos "+val1+" neg "+val2);
		}
		System.out.println(""+test);
		backgroundminor.negative_value=backgroundminor.negative_value+negprob;
		backgroundminor.positive_value=backgroundminor.positive_value+posprob;
		System.out.println("po bigram "+posprob);
		System.out.println("neg bigram "+negprob);
		if(negprob>posprob)
		{	 
		   ret=-1;
		}
		else
		{
			ret=1;
		}
		System.out.println(" here is ret "+ret+" posprob "+posprob+" negprob "+negprob);
		return ret;
	}
}
