import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
public class Ex12_PrintWrite_String_Find {
	
	String baseDir = "C:\\Temp"; //검색할 디렉토리
	String word = "HELLO"; //검색할 단어
	String save = "result.txt"; //검색 결과가 저장된 파일명
	
	public Ex12_PrintWrite_String_Find() throws IOException{
		
		File dir = new File(baseDir); //C:\\Temp
		
		if(!dir.isDirectory()){
				System.out.println("baseDir :" + "is not directory or exist" );
				System.exit(0);
		}
		//PrintWriter p = new PrintWriter("")
		PrintWriter writer = new PrintWriter(new FileWriter(save));
		BufferedReader br = null;
		
		File[] files = dir.listFiles(); //C:\\Temp  하위 자원(파일 ,폴더)
		for(int i = 0 ; i < files.length ; i++){
			if(!files[i].isFile()){
				continue; //파일이 아닌 경우 skip
			}
			
			br = new BufferedReader(new FileReader(files[i]));
			
			//각 파일의 데이터를 라인단위를 읽어서
			String line = "";
			while((line = br.readLine()) != null){
				if(line.indexOf(word) != -1){
					writer.write(word  + "=" + files[i].getAbsolutePath() + "\n");
				}
			}
			writer.flush();
		}
		
		br.close();
		writer.close();
	}
	
	public static void main(String[] args) {
		try {
			Ex12_PrintWrite_String_Find StringFind = new Ex12_PrintWrite_String_Find();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
}
