package Quiz;

import java.io.File;
import java.util.ArrayList;

public class MyDos2 {
	public static void main(String[] args) throws Exception {
		//args[0] > C:\Temp
		//args[1] > mkdir
		//args[2] > newDir  String[] arr = {"C:\Temp","mkdir","newDir"};
		
		//System.out.println(args[3])
		
		//java ExDos C:\Temp mkdir newDir
		//args[0] >> "C:\Temp"
		//args[1] >> "dir"
		
		
        //java ExDos C:\Temp rename file.txt file2.txt
        //java ExDos C:\Temp delete new.txt
        
        if(args.length != 3 && args.length != 4) {
            System.out.println("���� : [java���ϸ�] [���丮���] mkdir [�������丮��]");
            System.out.println("���� : [java���ϸ�] [���丮���] rename [���ϸ�] [���ο� ���ϸ�]");
            System.out.println("���� : [java���ϸ�] [���丮���] delete [���ϸ�]");
            System.exit(0);
        }
        
        File f = new File(args[0]);
        if(!f.exists() || !f.isDirectory()) { //�������� �ʰų� ���丮 �ƴ϶��
            System.out.println("��ȿ���� ���� ���丮�Դϴ�");
            System.exit(0);
        }
        
        if(args[1].equals("mkdir")) 
        {
            String path = "";
            path = f + "\\" + args[2]; //C:\\Temp\\newDir
            File newfile = new File(path);
            if(newfile.exists()) {
                System.out.println("�̹� �����ϴ� ���丮�Դϴ�");
            }
            else {
                newfile.mkdir();
            }
        }
        
        else if(args[1].equals("rename")) 
        {
            String oldpath = "";
            String newpath = "";
            
            oldpath = f + "\\" + args[2];
            File oldfile = new File(oldpath);
            newpath = f + "\\" + args[3];
            File newfile = new File(newpath);
            if(newfile.exists()) {
                System.out.println("�̹� �����ϴ� ���ϸ��Դϴ�");
            }
            else {
                oldfile.renameTo(newfile);
            }
        }
        
        else if(args[1].equals("delete")) 
        {
            String path = "";
            path = f + "\\" + args[2];
            File newfile = new File(path);
            if(!newfile.exists()) {
                System.out.println("�������� �ʴ� �����Դϴ�");
            }
            else {
                newfile.delete();
            }
        }
        
        PrintFileList(f);
    }
    
    static void PrintFileList(File dir) {
        ArrayList subDir = new ArrayList();
        File[] files = dir.listFiles();
        
        for(int i=0; i<files.length; i++) {
            String filename = files[i].getName();
            if(files[i].isDirectory()) {
                filename = "[" + filename + "]";
                subDir.add(i + "");
            }
            else {
                filename = filename;
            }
            System.out.println(filename);
        }
        
        int DirNum = subDir.size();
        int FileNum = files.length - DirNum;
        
        System.out.println("FileNum : " + FileNum + " �� ���ϰ� " + "DirNum : " + DirNum + " �� ���丮");
    }
}
