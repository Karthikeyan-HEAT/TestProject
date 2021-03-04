package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class test8
{
	public static void main(String[] args) throws IOException 
	{
		System.out.println("Enter the name of the file:");
		Scanner filename = new Scanner(System.in);
		String fileName = filename.nextLine();
		String directory = System.getProperty("user.home");
		String path = "";
		path = directory+File.separator+fileName+".txt";
		File file = new File(path);
		BufferedWriter bw = null;
		String old_data = "";
		add_or_overWrite (old_data, bw, file );
	}
	public static void add_or_overWrite(String old_data, BufferedWriter bw, File file ) throws IOException
	{
		if (file.exists()) {
		// File already exists in the directory 
		System.out.println("You want to add or overwrite data:");
		Scanner add_or_overwrite = new Scanner(System.in);
		String add_or_Overwrite = add_or_overwrite.nextLine();
		add_or_Overwrite = add_or_Overwrite.toLowerCase();
		String add = "add";
			if (add_or_Overwrite.equals(add)) {	
				// user want to add data into the file
				System.out.println("You want to add before or later:");
				Scanner before_or_later = new Scanner(System.in);
				String before_or_Later = before_or_later.nextLine();
				before_or_Later = before_or_Later.toLowerCase();
				String before = "before";
				if (before_or_Later.equals(before)) {
					// user want to add new data before old data
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String line = "";
					while ((line=br.readLine()) != null) {
							old_data = old_data+line+"\n";
					}
					FileWriter fw = new FileWriter(file);
					bw=new BufferedWriter(fw);
				} else if (before_or_Later != before) {
					// user want to add new data after old data
					FileWriter fwriter1 = new FileWriter(file,true);
					bw = new BufferedWriter(fwriter1);
				}						
			} else if (add_or_Overwrite != add) {
				// user want to overwrite the file
				FileWriter fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
			}
		} else {
			// user entered file name is not exists in the directory 
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
		}
			writeFile(old_data, bw);
	}
	public static void writeFile(String old_data, BufferedWriter bw )
	{
		try{
			System.out.println("Enter the Data:");
			Scanner datA = new Scanner(System.in);
			String data = datA.nextLine();
			bw.write(data);
			if (old_data != "") {
				bw.newLine();
			}
			bw.write(old_data);
			bw.newLine();
			bw.flush();
			bw.close();
		}catch (IOException e) {
				e.printStackTrace();
		}
	}

}



