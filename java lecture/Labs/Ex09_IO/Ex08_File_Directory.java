import java.io.File;

public class Ex08_File_Directory {
	//main ���α׷��� ������
	public static void main(String[] args) {
		//System.out.println(args.length);
		//System.out.println(args[0]);
		//System.out.println(args[1]);
		
		if(args.length != 1) {
			System.out.println("����: java ���ϸ� [���丮��]");
			System.exit(0); //���μ��� ��������
		}
		//java Ex08... C:\\Temp
		//args[0] = C:\\Temp ����
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			//�������� �ʰų� �Ǵ� ���丮�� �ƴ϶��
			System.out.println("��ȿ���� ���� ���");
			System.exit(0);
		}
		//�����ϴ� ���
		File[] files = f.listFiles(); //���� �ڿ� (������ ���� ��ü Ÿ������)
		for(int i = 0; i < files.length; i++) {
			String name = files[i].getName(); //������, ���ϸ�
			System.out.println(files[i].isDirectory() ? "DIR: " + name : name);
		}
	}
}
