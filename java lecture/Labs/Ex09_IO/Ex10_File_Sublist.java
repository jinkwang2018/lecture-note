import java.io.File;
import java.util.ArrayList;

public class Ex10_File_Sublist {
	static int totalfiles=0; //static �Լ��� �����ϴ� static�ڿ�
	static int totaldirs=0;
public static void main(String[] args) {
	if(args.length != 1) {
		System.out.println("���� : java [���ϸ�] [��θ�]");
		System.out.println("����   : java Ex10_File C:\\Temp");
		System.exit(0); //���μ��� ����
	}
	File f = new File(args[0]); //"C:\\Temp"
		
	if(!f.exists() || !f.isDirectory()) {
		System.out.println("��ȿ���� ���� ���丮");
		System.exit(0);
	}
	//�������� ��� �Ǵ�
	printFileList(f);
	System.out.println("�� ���ϼ� :" + totalfiles);
	System.out.println("�� ������ :" + totaldirs);
}
	static void printFileList(File dir) {
		System.out.println("[Full Path :" +  dir.getAbsolutePath()  + "]");
		
		ArrayList<Integer> subDir = new ArrayList<>();
		File[] files = dir.listFiles(); //��������
		
		//C:\\Temp  >  [0] a.txt
		//             [1] TEST
		//             [2] c.jpg
		
		for(int i = 0 ; i < files.length ; i++) {
			String filename = files[i].getName(); //���ϸ� or ������
			System.out.println(files[i]);
			if(files[i].isDirectory()) {
				filename = "<DIR>[" + filename  +"]";
				subDir.add(i); //������ ��쿡 add() 
				//[0][3][4][10]
			}else {
				filename = filename +"  /  "+ files[i].length() + "Byte";
			}
			System.out.println("  " + filename);
	}
	//////////////////////////////////////////////////////////////
	
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;
			
		//������
		totaldirs += dirNum; //���� ���� ����
		totalfiles += fileNum;//���� ���� ����
		
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
		 files�迭
		 [0] > 1.txt
		 [1] > TEST
		 [2] > TEST2
		 [3] > 2.jpg
		 [4] > NEW

			 subDir �÷��� > [0] => 1
			              [1] => 2
			              [2] => 4	
		*/
	}
}


