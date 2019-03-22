import java.io.File;
import java.util.ArrayList;

public class Ex10_File_Sublist {
	static int totalfiles=0; //static 함수가 공유하는 static자원
	static int totaldirs=0;
public static void main(String[] args) {
	if(args.length != 1) {
		System.out.println("사용법 : java [파일명] [경로명]");
		System.out.println("예시   : java Ex10_File C:\\Temp");
		System.exit(0); //프로세스 종료
	}
	File f = new File(args[0]); //"C:\\Temp"
		
	if(!f.exists() || !f.isDirectory()) {
		System.out.println("유효하지 않은 디렉토리");
		System.exit(0);
	}
	//정상적인 경로 판단
	printFileList(f);
	System.out.println("총 파일수 :" + totalfiles);
	System.out.println("총 폴더수 :" + totaldirs);
}
	static void printFileList(File dir) {
		System.out.println("[Full Path :" +  dir.getAbsolutePath()  + "]");
		
		ArrayList<Integer> subDir = new ArrayList<>();
		File[] files = dir.listFiles(); //하위정보
		
		//C:\\Temp  >  [0] a.txt
		//             [1] TEST
		//             [2] c.jpg
		
		for(int i = 0 ; i < files.length ; i++) {
			String filename = files[i].getName(); //파일명 or 폴더명
			System.out.println(files[i]);
			if(files[i].isDirectory()) {
				filename = "<DIR>[" + filename  +"]";
				subDir.add(i); //폴더인 경우에 add() 
				//[0][3][4][10]
			}else {
				filename = filename +"  /  "+ files[i].length() + "Byte";
			}
			System.out.println("  " + filename);
	}
	//////////////////////////////////////////////////////////////
	
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;
			
		//누적값
		totaldirs += dirNum; //폴더 개수 누적
		totalfiles += fileNum;//파일 개수 누적
		
		System.out.println("[Current dirNum] : " + dirNum);
		System.out.println("[Current fileNum] : " + fileNum);
		System.out.println("********************************");
		
		for(int j = 0 ; j < subDir.size(); j++) {
			int index = subDir.get(j);
			// 1  3  4
			//[0][1][2]
			printFileList(files[index]);
		}
		
		
		/*
		 C:\\Temp
		 files배열
		 [0] > 1.txt
		 [1] > TEST
		 [2] > TEST2
		 [3] > 2.jpg
		 [4] > NEW

			 subDir 컬렉션 > [0] => 1
			              [1] => 2
			              [2] => 4	
		*/
	}
}


