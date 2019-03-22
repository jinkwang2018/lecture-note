import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//�ѱ� 2Byte -> Stream ���� ��� �Ұ� (Byte ����)
//2Byte ���� -> Reader, Writer �߻� Ŭ����


public class Ex05_Reader_Writer_kor {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("Ex01_Stream.java");
			fw = new FileWriter("copy_Ex01.txt"); //���� ���� ���
			
			int data = 0;
			while((data = fr.read()) != -1) {
				//System.out.println(data + " : " + (char)data);
				//fw.write(data);
				if(data != '\n' && data != '\r' && data != '\t' && data != ' ') {
					fw.write(data); //Compressed data ���൥����
				}
			}
		}catch(Exception e) {
			System.out.println("������ �ִ�");
		}finally {
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
