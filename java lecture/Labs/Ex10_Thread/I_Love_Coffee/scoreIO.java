package I_Love_Coffee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class scoreIO {
	scoreIO(){
		if (!new File("saving.txt").exists()) {
			try {
				FileWriter fw = new FileWriter("saving.txt");
				fw.write("************************\r\n");
				fw.write("이름 	점수  \r\n");
				fw.write("************************\r\n");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void Saving(String name, int score){
		String saving = "" + name + "    \t" + score + "\r\n";
		//char input[] = new char[saving.length()];
		//saving.getChars(0, saving.length(), input, 0);
		FileWriter fw1;
		try {
			fw1 = new FileWriter("saving.txt", true);
			fw1.write(saving);
			fw1.flush();
			fw1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String View() {
		String userdir = System.getProperty("user.dir");
		String scoredata = "";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(userdir+"\\saving.txt"));
			String data;
			while ((data = br.readLine()) != null) {
				scoredata += data + "\r\n";
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scoredata;
	}
}
