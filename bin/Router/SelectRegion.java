import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SelectRegion 
{
	String reg="";
	public String RegionV(int dis)
	{
		reg="";
		try
		{
			File directory = new File (".");
			System.out.println ("Current directory's canonical path: " + directory.getCanonicalPath()); 
			System.out.println ("Current directory's absolute  path: " + directory.getAbsolutePath());
			File f=new File("Region.txt");
			FileInputStream fis=new FileInputStream(f.getAbsolutePath());
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String str=br.readLine();
			while(str!=null)
			{
				StringTokenizer st=new StringTokenizer(str,"=");
				System.out.println(str);
				String ss=st.nextToken();
				int val=Integer.parseInt(st.nextToken());
				System.out.println("distanceV"+dis);
				System.out.println("V"+val);

				if(dis>(val-50) && dis<=(val+50))
				{
					reg=ss;
					break;
				}
				str=br.readLine();
			}
	}
		catch (Exception e)
		{
		 e.printStackTrace();
		}
		
		return(reg);
	}
	public String RegionN(int dis)
	{
		reg="";
		try
		{
			File f=new File("Region.txt");
			FileInputStream fis=new FileInputStream(f.getAbsolutePath());
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String str=br.readLine();
			while(str!=null)
			{
				StringTokenizer st=new StringTokenizer(str,"=");
				System.out.println(str);
				String ss=st.nextToken();
				int val=Integer.parseInt(st.nextToken());
				System.out.println("distanceN"+dis);
				System.out.println("N"+val);

				if(dis>(val-50) && dis<=(val+50))
				{
					reg=""+val;
					break;
				}
				str=br.readLine();
			}
	}
		catch (Exception e)
		{
		 e.printStackTrace();
		}
		
		return(reg);
	}
}
