import java.io.DataOutputStream;
import java.io.FileOutputStream;

//보조 스트림
//Java API : 8기본 타입 (타입별로 read ,write) 클래스
//DataOutPutStream , DataInputStream 
//데이터 작업 ,채팅 ...
public class Ex13_DataOutPutStream {
	public static void main(String[] args) {
		int[] score = {100,60,55,94,12};
		
		try {
				FileOutputStream fos = new FileOutputStream("score.txt");
				DataOutputStream dos = new DataOutputStream(fos);
				for(int i = 0 ; i < score.length ;i++) {
					dos.writeInt(score[i]); //정수값 write > read(DataInputStream)
					//dos.writeUTF(str)
				}
				dos.close();
				fos.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
