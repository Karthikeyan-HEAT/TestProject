package test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class test3
{

	public static void main(String[] args) throws IOException 
	{
		System.out.println("Enter the name of the file:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		File file =new File("C:\\\\Users\\\\RASEETHA\\\\Desktop\\\\"+s+".txt");
		BufferedWriter bw =null;
		if (file.exists())	
			{
				System.out.println("You want to add or overwrite data:");
				Scanner scnn=new Scanner(System.in);
				String sg=scnn.nextLine();
				sg=sg.toLowerCase();
				String sng="add";
				if(sg.equals(sng)) 
					{
						FileWriter fwriter1= new FileWriter(file,true);
						bw =new BufferedWriter(fwriter1);
					}
				else if(sg != sng) 
					 {
						FileWriter fwriter1= new FileWriter(file);
						bw =new BufferedWriter(fwriter1);
					 }
			  }
		if (!file.exists())
			{
					
				FileWriter fwriter1= new FileWriter(file);
				bw =new BufferedWriter(fwriter1);
			}
			  
		try 
			{
				System.out.println("Enter the Data:");
				Scanner scn=new Scanner(System.in);
				String st=scn.nextLine();
				bw.write(st);
				bw.newLine();
				bw.flush();
				bw.close();
			}
		catch(IOException e) 
			{
				e.printStackTrace();
			}
	}

}

