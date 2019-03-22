import java.io.DataOutputStream;
import java.io.FileOutputStream;

//���� ��Ʈ��
//Java API : 8�⺻ Ÿ�� (Ÿ�Ժ��� read ,write) Ŭ����
//DataOutPutStream , DataInputStream 
//������ �۾� ,ä�� ...
public class Ex13_DataOutPutStream {
	public static void main(String[] args) {
		int[] score = {100,60,55,94,12};
		
		try {
				FileOutputStream fos = new FileOutputStream("score.txt");
				DataOutputStream dos = new DataOutputStream(fos);
				for(int i = 0 ; i < score.length ;i++) {
					dos.writeInt(score[i]); //������ write > read(DataInputStream)
					//dos.writeUTF(str)
				}
				dos.close();
				fos.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
