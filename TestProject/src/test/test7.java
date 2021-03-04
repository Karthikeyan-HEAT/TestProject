package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class test7
{
	public static void main(String[] args) throws IOException 
	{
		System.out.println("Enter the name of the file:");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String directory = System.getProperty("user.home");
		String path = "";
		path = directory+File.separator+s+".txt";
		File file = new File(path);
		BufferedWriter bw = null;
		String result = "";
		if (file.exists()){
			// File already exists in the directory 
			System.out.println("You want to add or overwrite data:");
			Scanner scnn = new Scanner(System.in);
			String sg = scnn.nextLine();
			sg = sg.toLowerCase();
			String sng = "add";
			if(sg.equals(sng)) {	
				// user want to add data into the file
				System.out.println("You want to add before or later:");
				Scanner scnnn = new Scanner(System.in);
				String sgn = scnnn.nextLine();
				sgn = sgn.toLowerCase();
				String sngn = "before";
				if(sgn.equals(sngn)){
					// user want to add new data before old data
					FileReader fwriter2 = new FileReader(file);
					BufferedReader br = new BufferedReader(fwriter2);
					String line = "";
					while((line=br.readLine()) != null){
							result = result+line+"\n";
					}
					FileWriter fwriter1 = new FileWriter(file);
					bw=new BufferedWriter(fwriter1);
				}else if(sgn != sngn){
					// user want to add new data after old data
					FileWriter fwriter1 = new FileWriter(file,true);
					bw = new BufferedWriter(fwriter1);
				}
						
			}else if(sg != sng){
				// user want to overwrite the file
				FileWriter fwriter1 = new FileWriter(file);
				bw = new BufferedWriter(fwriter1);
			}
		}else {
			// user entered file name is not exists in the directory 
			FileWriter fwriter1 = new FileWriter(file);
			bw = new BufferedWriter(fwriter1);
		}
		writeFile(result, bw);
	}
	public static void writeFile(String result, BufferedWriter bw )
	{
		try{
			System.out.println("Enter the Data:");
			Scanner scn = new Scanner(System.in);
			String st = scn.nextLine();
			bw.write(st);
			if(result != "") {
				bw.newLine();
			}
			bw.write(result);
			bw.newLine();
			bw.flush();
			bw.close();
		}catch(IOException e){
				e.printStackTrace();
		}
	}

}


