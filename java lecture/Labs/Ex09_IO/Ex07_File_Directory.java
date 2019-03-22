import java.io.File;

//File Ŭ����
//����(a.txt) ����, ����, ����
//���丮(����) ����, ����

//�ַ� ���: ��������, ��������

//C#: File, Directory Ŭ����
//������: C:\\, D:\\, C:\\Temp\\a.txt
//�����: ���� �߽�����

public class Ex07_File_Directory {
	public static void main(String[] args) {
		String path="C:\\Temp\\file.txt"; //������ ������� ���� ������
		File f = new File(path);
		//f.createNewFile() //���ϻ���
		String filename = f.getName();
		System.out.println("���ϸ�" + filename);
		
		System.out.println("��ü���: " + f.getPath());
		System.out.println("������: " + f.getAbsolutePath());
		System.out.println("���� ����: " + f.isDirectory());
		System.out.println("���� ����: " + f.isFile());
		System.out.println("���� ũ��: " + f.length() + "byte");
		System.out.println("�θ���: " + f.getParent());
		System.out.println("���� ���� ����: " + f.exists());
		
		//f.delete()   return type >> true, false
		//f.canRead() ��밡�� ����(�б��������� �ƴ���)
		
		
	}
}