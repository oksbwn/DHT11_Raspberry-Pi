import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass {

	private static String line;
	private static String[] data;
	static int humidity=0;
	static int temperature=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Runtime rt= Runtime.getRuntime();
		Process p=rt.exec("python /home/pi/Desktop/dht.py");
		 BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 if((line = bri.readLine()) != null){
			 if(!(line.contains("ERR_CRC") || line.contains("ERR_RNG"))){

				 data=line.split("ABC");
			      	System.out.println(data[0]);
				 temperature=Integer.parseInt(data[0]);
				 humidity=Integer.parseInt(data[1]);
			 }
			 else 
				 System.out.println("Data Error");
		 }
	  
	      bri.close();
      	p.waitFor();
      	System.out.println("Temperature is : "+temperature+" 'C Humidity is :"+ humidity+" %RH");
      	System.out.println("Done.");
	}

}
