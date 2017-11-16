import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class resistance {
	public double CalculateResis(String r1,String r2,String r3,String r4,String r5,String r6){
		// Calculate resistance
		double temp = (Double.parseDouble(r1)+Double.parseDouble(r2))*Double.parseDouble(r4)*Double.parseDouble(r6);
		temp= temp/((Double.parseDouble(r3)+Double.parseDouble(r4))*Double.parseDouble(r1)*Double.parseDouble(r5));
		// return value
		return temp;
	}
	
	public static void main(String[] args) throws IOException{
		resistance obj =new  resistance ();
	int	count=0;
		double Resresult = 0.0;
	   double r1,r2,r3,r4,r5,r6;
	   double Volt=0;
	   System.out.println ("Reading File Name data.txt");
	   PrintWriter writer = new PrintWriter("good.txt", "UTF-8");
	   FileInputStream fstream = new FileInputStream("data.txt");
	   System.out.println ("Saving good designs to good.txt");
	   System.out.println ("The following are bad designs:");
	   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
// file read line by line
	   String strLine;
	   while ((strLine = br.readLine()) != null)   {
		   String[] words = strLine.split("\\s+");
		   for (int i = 0; i < words.length; i++) {
		       words[i] = words[i].replaceAll("[^\\w]", "");  // substring string to words
		   }
		   Resresult =  obj.CalculateResis(words[0],words[1],words[2],words[3],words[4],words[5]); // pass to functions
	   
		   
		   if(Resresult==7.5){  // if its correct output write to file else print this
			   count++;
			   writer.println(words[0]+"     "+words[1]+"     "+words[2]+"     "+words[3]+"     "+words[4]+"     "+words[5]);
				   }
				    else{
				    	System.out.println (words[0]+"     "+words[1]+"     "+words[2]+"     "+words[3]+"     "+words[4]+"     "+words[5]);
				    }
	   }
	   br.close();
	   writer.close();
	   
	}
}
