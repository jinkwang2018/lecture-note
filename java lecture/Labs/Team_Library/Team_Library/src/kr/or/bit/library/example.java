package kr.or.bit.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class rental{
	
}
public class example {

	public static void main(String[] args) {
		String path = "c:\\Temp\\rentalList.txt";
		File f = new File(path);
		FileReader fr = null;
		BufferedReader br = null;
		if (f.exists()) {
			try {
				fr = new FileReader(path);
				br = new BufferedReader(fr);
				String line = "";
				for (int i = 0; (line = br.readLine()) != null; i++) {
					String[]str = line.split("@");
					if (str[4].equals("³ª")) {
						System.out.println(line);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {

			}

	}

}
}