package Quiz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
 
public class MyDos {
	static String defaultPath = "C:" + File.separator;
	static String path = defaultPath;
 
	public static void main(String[] args) {
		// ��Ŭ�������� �׳� ���� �غ� �� �ִ� ������ DOS Ŀ�ǵ�
		// ����� �� �ִ� ��ɾ�
 
		// CD ���� ���͸� �̸��� �����ְų� �ٲߴϴ�.
		// DIR ���͸��� �ִ� ���ϰ� ���� ���͸� ����� �����ݴϴ�.
		// MD ���͸��� ����ϴ�.
		// MKDIR ���͸��� ����ϴ�.
		// RD ���͸��� ����ϴ�.
		// RMDIR ���͸��� ����ϴ�.
		// REN ���� �̸��� �ٲߴϴ�.
		// RENAME���� �̸��� �ٲߴϴ�.
		// TYPE �ؽ�Ʈ ������ ������ �����ݴϴ�.
		// EXIT ���α׷��� �����մϴ�.
 
		Scanner sc = new Scanner(System.in);
 
		String[] input = null;
 
		while (true) {
			System.out.print(path + ">");
			input = sc.nextLine().split(" "); //���
 
			if (input[0].equalsIgnoreCase("exit")) {
				System.exit(0);
				return;
			}
 
			if (!input[0].equals("")) {
				if (input[0].equalsIgnoreCase("dir")) {
					searchDirectory(input);
				} else if (input[0].equalsIgnoreCase("cd")) {
					changeDirectory(input);
				} else if (input[0].equalsIgnoreCase("cd..")) {
					changeDirectory(input);
				} else if (input[0].equalsIgnoreCase("md")
						|| input[0].equalsIgnoreCase("mkdir")) {
					makeDirectory(input);
				} else if (input[0].equalsIgnoreCase("rd")
						|| input[0].equalsIgnoreCase("rmdir")) {
					File file = null;
					if (input.length <= 1) {
						System.out.println("��� ������ �ùٸ��� �ʽ��ϴ�.");
					} else if (input.length == 2) {
						String pathTemp = defaultPath;
 
						if (!path.equals(defaultPath)) {
							pathTemp = path + File.separator + input[1];
						} else {
							pathTemp = defaultPath + File.separator + input[1];
						}
 
						file = new File(pathTemp);
						if (!deleteDirectory(file)) {
							System.out.println("������ ������ ã�� �� �����ϴ�.");
						}
					}
				} else if (input[0].equalsIgnoreCase("ren")
						|| input[0].equalsIgnoreCase("rename")) {
					renameDirectory(input);
				} else if (input[0].equalsIgnoreCase("type")) {
					readTextFile(input);
				} else if (input[0].equalsIgnoreCase("help")) {
					displayHelp(input);
				} else {
					System.out.println("'"
									+ input[0]
									+ "'��(��) ���� �Ǵ� �ܺ� ���, ������ �� �ִ� ���α׷�, �Ǵ� ��ġ ������ �ƴմϴ�");
				}
				System.out.println();
			}
 
		}
 
	}
 
	public static void readTextFile(String[] input) {
		File file = null;
		if (input.length <= 1) {
			System.out.println("��� ������ �ùٸ��� �ʽ��ϴ�.");
		} else if (input.length == 2) {
			String pathTemp = defaultPath;
			pathTemp = path + File.separator + input[1];
 
			file = new File(pathTemp);
			if (file.exists()) {
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String data = "";
					while ((data = br.readLine()) != null) {
						System.out.println(data);
					}
				} catch (FileNotFoundException e) {
					System.out.println("������ ������ ã�� �� �����ϴ�.");
				} catch (IOException e) {
					e.printStackTrace();
				}
 
			} else {
				System.out.println("������ ������ ã�� �� �����ϴ�.");
			}
		}
	}
 
	public static void displayHelp(String[] input) {
		if (input.length <= 1) {
			System.out.println("CD\t���� ���͸� �̸��� �����ְų� �ٲߴϴ�.\n"
					+ "DIR\t���͸��� �ִ� ���ϰ� ���� ���͸� ����� �����ݴϴ�.\n"
					+ "HELP\t������ �����ݴϴ�.\n" + "MD\t���͸��� ����ϴ�.\n"
					+ "MKDIR\t���͸��� ����ϴ�.\n" + "RD\t���͸��� ����ϴ�.\n"
					+ "RMDIR\t���͸��� ����ϴ�.\n" + "REN\t���� �̸��� �ٲߴϴ�.\n"
					+ "RENAME\t���� �̸��� �ٲߴϴ�.\n" + "TYPE\t�ؽ�Ʈ ������ ������ �����ݴϴ�.\n"
					+ "EXIT\t���α׷��� �����մϴ�.\n");
		} else {
			System.out.println("��ɾ ���� ������ �غ����Դϴ�.");
		}
	}
 
	public static void searchDirectory(String[] input) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a hh:mm");
		File file = null;
		File[] files = null;
 
		if (input.length <= 1) {
			file = new File(path);
			files = file.listFiles();
 
			if (!path.equals(defaultPath)) {
 
			}
 
			for (int i = 0; i < files.length; i++) {
				String attr = "";
				String size = "";
				File fi = files[i];
 
				if (fi.isHidden()) {
					continue;
				}
 
				if (fi.isDirectory()) {
					attr = "<DIR>";
 
				} else {
					size = fi.length() + "";
				}
 
				System.out.printf("%s    %5s %8s %s %n",
								sdf.format(fi.lastModified()), 
								attr, 
								size,
								fi.getName());
			}
 
		}
	}
 
	public static void makeDirectory(String[] input) {
		File file = null;
		if (input.length <= 1) {
			System.out.println("��� ������ �ùٸ��� �ʽ��ϴ�.");
		} else if (input.length == 2) {
			String pathTemp = defaultPath;
			if (!path.equals(defaultPath)) {
				pathTemp = path + File.separator + input[1];
			} else {
				pathTemp = defaultPath + File.separator + input[1];
			}
 
			file = new File(pathTemp);
			if (!file.exists()) {
				file.mkdirs();
			} else {
				System.out.println("���� ���͸� �Ǵ� ���� " + input[1]
						+ "��(��) �̹� �ֽ��ϴ�.");
			}
		}
	}
 
	public static boolean deleteDirectory(File file) {
		if (!file.exists()) {
			return false;
		}
 
		File[] files = file.listFiles();
		for (File f : files) {
			if (file.isDirectory()) {
				deleteDirectory(f);
			} else {
				System.out.println("���� ���� : " + f.getName());
				f.delete();
			}
		}
		return file.delete();
	}
 
	public static void renameDirectory(String[] input) {
		if (input.length <= 2) {
			System.out.println("��� ������ �ùٸ��� �ʽ��ϴ�.");
		} else if (input.length == 3) {
			String oldFilePath = path + File.separator + input[1];
			String newFilePath = path + File.separator + input[2];
 
			File oldFile = new File(oldFilePath);
			File newFile = new File(newFilePath);
 
			if (!oldFile.exists()) {
				System.out.println("������ ������ ã�� �� �����ϴ�.");
			} else {
				if (newFile.exists()) {
					System.out.println("�ߺ��Ǵ� ���� �̸��� �ְų� ������\nã�� �� �����ϴ�.");
				} else {
					oldFile.renameTo(newFile);
				}
			}
		}
	}
 
	public static void changeDirectory(String[] input) {
		File file = null;
 
		if (input[0].equalsIgnoreCase("cd")) 
		{
			if (input.length <= 1) 
			{
				System.out.println(path);
			}else if (input.length == 2) 
			{
				String tempPath = path;
				if (!path.equals(defaultPath)) 
				{
					tempPath += File.separator + input[1];
				} else 
				{
					tempPath += input[1];
				}
				file = new File(tempPath);
				if (file.isDirectory()) 
				{
					path = tempPath;
					//System.out.println("************" + path);
				} else {
					System.out.println("������ ��θ� ã�� �� �����ϴ�");
				}
			}
 
		} else if (input[0].equalsIgnoreCase("cd..")) {
			if (input.length <= 1) {
				int pos = path.lastIndexOf(File.separator);
				if (!path.equals(defaultPath) && pos > 2) {
					path = path.substring(0, pos);
				} else {
					path = path.substring(0, pos + 1);
				}
			} else {
				System.out.println("������ ��θ� ã�� �� �����ϴ�");
			}
		}
 
	}
 
}