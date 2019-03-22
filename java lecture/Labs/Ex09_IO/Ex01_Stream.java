import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
I/O

1.stream (�������, ��������, �߰��Ű�ü)
2.stream ������� ũ�� (���ỡ��: �⺻������ 1Byte) >> Byte ����� >> Byte[] �迭
3.JAVA API�� �����ϴ� Ŭ����
I/O �۾�
Byte ó��
InputStream(�߻�), OutputStream(�߻�)
�� ���� �߻�Ŭ���� ��� (������) Ŭ������

���(memory)
ByteArrayInputStream, ByteArrayOutputStream

���(file)
FileInputStream, FileOutputStream

�߰������� ���� Ŭ����
Buffer (I/O) �������
...BufferedInputStream, BufferedOutputStream ���...




 */
public class Ex01_Stream {
	public static void main(String[] args) {
		//Memory (�迭)
		//byte (-128 ~ 127): ������
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		//System.out.println(inSrc[5]);
		byte[] outsrc = null; //outsrc �޸𸮸� ������ ���� �ʴ�
		
		ByteArrayInputStream input = null; //�迭 ������ read
		ByteArrayOutputStream output = null; //�迭 ������ write
		
		input = new ByteArrayInputStream(inSrc);
		//������ insrc �迭�ּ� read �� �� �ֵ���
		output = new ByteArrayOutputStream(); //write �ϴ� ��� (memory)
		
		System.out.println("output befre: " + Arrays.toString(outsrc));
		
		//���İ��� ���� (�ϱ�)
		int data = 0;
		while((data = input.read()) != -1 ) { //�� �̻� read() ���ٸ� return -1
			System.out.println("data: " + data);
			//System.out.println("input.read()" +input.read());
			//input.read() ���������� next() ����� ������ �ִ�
			
			output.write(data);
			//write ���: ByteArrayOutputStream��ü  read() >> write
		}
		outsrc = output.toByteArray();
		//�ڱⰡ ������ �ִ� ���� �迭�� ����
		//bye[] outsrc = null; ���� �ּҰ� �Ҵ�
		System.out.println("outsrc: After >" + Arrays.toString(outsrc));
		
		
	}
}
