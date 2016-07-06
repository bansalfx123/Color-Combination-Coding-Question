import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ParseInput {

	static int blue_counter = 0;
	static int green_counter = 0;
	
	static ColorComb color_method = new ColorComb();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferreader = null;
		String CurrentLine;
		bufferreader = new BufferedReader(new FileReader("C:/Users/Mohit/Workspace/Bhavin/src/input.txt"));
		CurrentLine = bufferreader.readLine();
		CurrentLine = CurrentLine.toLowerCase();
		String[] splited = CurrentLine.split(",");
		
		try {
			
			for(int i =0 ; i < splited.length ; i++){
				splited[i] = splited[i].trim();
				
				if (splited[i].equals("blue")){
					blue_counter++;
				}else if(splited[i].equals("green")){
					green_counter++;
				}else{
					color_method.addelement(splited[i]);
				}
			}	
			VerifyOutput(blue_counter,green_counter);
			
		} finally {
			try {
				if (bufferreader != null)bufferreader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void VerifyOutput(int blue_counter, int green_counter) {
		// TODO Auto-generated method stub
		boolean check = true;
		for(int i =0 ; i < color_method.globalindex ; i++){
			if(color_method.colorarray[i] == null ){
				check = false;
			}
		}
	
		if(check && (blue_counter%2==0) && (green_counter%2==0)){
			PrintSolution();
		}else{
			System.out.println("Cannot unlock master panel");
		}

	}
	
	public static void PrintSolution(){
		System.out.println("Answer is:");
		System.out.print("Blue");
		for(int j =0 ; j < color_method.globalindex ; j++){
			System.out.print(" ");
			System.out.print(color_method.colorarray[j]);
			
		}
		System.out.print(" Green");
	}

}
