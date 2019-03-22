import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//��ǻ�� ���� �۾� (DISK ���� read, write)
//1.File �۾� (DISK) (read, write) byte ����
//�� ���� ������ �ذ��ϱ� ���ؼ�
//Buffer �޸� (���� �� �а���)
//������: file �۾��Ҷ� �߰��� Buffer ���

//File I/O ���ɰ���
//Line ���� ó��

//JAVA API
//���� ��Ʈ��(input, output �߻�Ŭ���� ����� Ŭ������ ��ü�� �����ؾ����� ��밡��)
//BufferedInputStream
//BufferedOutputStream

public class Ex04_Stream_File_Buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt"); //���� ���� ��� ������ �ִ�
			bos = new BufferedOutputStream(fos);
			
			for(int i = 0; i < 10; i++) {
				bos.write('A');
			}
			/*
			java buffer ũ��: 8kByte => 8192Byte
			1.buffer �ȿ� ������ 8kByte ä��� �ڵ����� ���� (��û�ڿ��� �ش�)
			2.buffer ������ ���� ���: flush() ����ȣ��
			3.bos.close(); ���ο��� flush() ȣ��
			 */
			//bos.flush();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				bos.close(); //buffer close(flush() ����)
				fos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
