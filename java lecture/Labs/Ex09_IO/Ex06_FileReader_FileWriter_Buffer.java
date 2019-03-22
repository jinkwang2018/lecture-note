import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

//문자 처리 시에도 Buffer 사용 I/O 성능 향상
//Buffer 장점: Line 단위 read, writer
public class Ex06_FileReader_FileWriter_Buffer {
	public static void main(String[] args){
		/*
		FileWriter fw = new FileWriter("a.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("로또");
		bw.newLine(); //장점
		bw.write("1,2,3,4,5");
		bw.flush();
		*/
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			br = new BufferedReader(fr);
			
			String line = "";
			//br.readLine() >> POINT
			for(int i = 0; (line = br.readLine()) != null; i++) {
				//System.out.println(line);
				if(line.indexOf(";") != -1) {
					System.out.println(line);
				}
			}
		}catch(Exception e) {
			
		}finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
