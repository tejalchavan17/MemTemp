import java.util.*;
class MemTemp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int blocksize[]=new int[50];
		int blocks[]=new int[50];
		int procsize[]=new int[50];
		int i,pn,bn;
		System.out.println("Enter the no. of block");
		bn=sc.nextInt();
		System.out.println("Enter the no. of process");
		pn=sc.nextInt();
		System.out.println("Enter the size of each blocks");
		for(i=0;i<bn;i++)
			blocks[i]=sc.nextInt();
		System.out.println("Enter the size of each process");
		for(i=0;i<pn;i++)
			procsize[i]=sc.nextInt();
		for(i=0;i<bn;i++)
			blocksize[i]=blocks[i];
		System.out.println("----------First Fit:-----------");
		first(blocksize,procsize,bn,pn);
		for(i=0;i<bn;i++)
			blocksize[i]=blocks[i];
		System.out.println("-----------Best Fit:-----------");
		best(blocksize,procsize,bn,pn);
		for(i=0;i<bn;i++)
			blocksize[i]=blocks[i];
		System.out.println("----------Worst Fit:----------");
		worst(blocksize,procsize,bn,pn);
		
	}
	public static void first(int blocksize[],int procsize[],int bn,int pn)
	{
		int finish[]=new int[50];
		int i,j;
		for(i=0;i<pn;i++)
		{
			for(j=0;j<bn;j++)
			{
				if(blocksize[j]>=procsize[i])
				{
					System.out.println("("+procsize[i]+") "+"-->"+" ("+blocksize[j]+")");
					blocksize[j]=blocksize[j]-procsize[i];
					System.out.println("Remaining block size :"+blocksize[j]);
					finish[i]=1;
					break;
				}
			}
		}
		for(i=0;i<pn;i++)
		{
			if(finish[i]!=1)
				System.out.println("process"+i+" ("+procsize[i]+") "+"has to wait since blocksize is not sufficient");
		}
	}
	public static void best(int blocksize[],int procsize[],int bn,int pn)
	{
		int finish[]=new int[50];
		int i,j,min,te=0;
		for(i=0;i<pn;i++)
		{
			min=999;
			for(j=0;j<bn;j++)
			{
				if(blocksize[j]>=procsize[i])
				{
					if(blocksize[j]<min)
					{
						min=blocksize[j];
						te=j;
					}
				}
			}
			if(min!=999)
			{
				System.out.println("("+procsize[i]+") "+"-->"+" ("+blocksize[te]+")");
				blocksize[te]=blocksize[te]-procsize[i];
				System.out.println("Remaining block size :"+blocksize[te]);
				finish[i]=1;
			}
		}
		for(i=0;i<pn;i++)
		{
			if(finish[i]!=1)
				System.out.println("process"+i+" ("+procsize[i]+") "+"has to wait since blocksize is not sufficient");
		}
	}
	public static void worst(int blocksize[],int procsize[],int bn,int pn)
	{
		int finish[]=new int[50];
		int i,j,max,te=0,t;
		for(i=0;i<pn;i++)
		{
			max=0;
			for(j=0;j<bn;j++)
			{
				if(blocksize[j]>=procsize[i])
				{
					if(blocksize[j]>max)
					{
						max=blocksize[j];
						te=j;
					}
				}
			}
			if(max!=0)
			{
				System.out.println("("+procsize[i]+") "+"-->"+" ("+blocksize[te]+")");
				blocksize[te]=blocksize[te]-procsize[i];
				System.out.println("Remaining block size :"+blocksize[te]);
				finish[i]=1;
			}
		}
		for(i=0;i<pn;i++)
		{
			if(finish[i]!=1)
				System.out.println("process"+i+" ("+procsize[i]+") "+"has to wait since blocksize is not sufficient");
		}
	}
}
/*OUTPUT
tejal@ubuntu:~/Desktop/coa$ javac MemTemp.java
tejal@ubuntu:~/Desktop/coa$ java MemTemp
Enter the no. of block
5
Enter the no. of process
4
Enter the size of each blocks
100 500 200 300 600
Enter the size of each process
212 417 112 426
----------First Fit:-----------
(212) --> (500)
Remaining block size :288
(417) --> (600)
Remaining block size :183
(112) --> (288)
Remaining block size :176
process3 (426) has to wait since blocksize is not sufficient
-----------Best Fit:-----------
(212) --> (300)
Remaining block size :88
(417) --> (500)
Remaining block size :83
(112) --> (200)
Remaining block size :88
(426) --> (600)
Remaining block size :174
----------Worst Fit:----------
(212) --> (600)
Remaining block size :388
(417) --> (500)
Remaining block size :83
(112) --> (388)
Remaining block size :276
process3 (426) has to wait since blocksize is not sufficient*/

