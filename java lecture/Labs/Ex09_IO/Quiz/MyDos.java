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
		// 이클립스에서 그냥 실행 해볼 수 있는 간단한 DOS 커맨드
		// 사용할 수 있는 명령어
 
		// CD 현재 디렉터리 이름을 보여주거나 바꿉니다.
		// DIR 디렉터리에 있는 파일과 하위 디렉터리 목록을 보여줍니다.
		// MD 디렉터리를 만듭니다.
		// MKDIR 디렉터리를 만듭니다.
		// RD 디렉터리를 지웁니다.
		// RMDIR 디렉터리를 지웁니다.
		// REN 파일 이름을 바꿉니다.
		// RENAME파일 이름을 바꿉니다.
		// TYPE 텍스트 파일의 내용을 보여줍니다.
		// EXIT 프로그램을 종료합니다.
 
		Scanner sc = new Scanner(System.in);
 
		String[] input = null;
 
		while (true) {
			System.out.print(path + ">");
			input = sc.nextLine().split(" "); //출력
 
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
						System.out.println("명령 구문이 올바르지 않습니다.");
					} else if (input.length == 2) {
						String pathTemp = defaultPath;
 
						if (!path.equals(defaultPath)) {
							pathTemp = path + File.separator + input[1];
						} else {
							pathTemp = defaultPath + File.separator + input[1];
						}
 
						file = new File(pathTemp);
						if (!deleteDirectory(file)) {
							System.out.println("지정된 파일을 찾을 수 없습니다.");
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
									+ "'은(는) 내부 또는 외부 명령, 실행할 수 있는 프로그램, 또는 배치 파일이 아닙니다");
				}
				System.out.println();
			}
 
		}
 
	}
 
	public static void readTextFile(String[] input) {
		File file = null;
		if (input.length <= 1) {
			System.out.println("명령 구문이 올바르지 않습니다.");
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
					System.out.println("지정된 파일을 찾을 수 없습니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
 
			} else {
				System.out.println("지정된 파일을 찾을 수 없습니다.");
			}
		}
	}
 
	public static void displayHelp(String[] input) {
		if (input.length <= 1) {
			System.out.println("CD\t현재 디렉터리 이름을 보여주거나 바꿉니다.\n"
					+ "DIR\t디렉터리에 있는 파일과 하위 디렉터리 목록을 보여줍니다.\n"
					+ "HELP\t도움말을 보여줍니다.\n" + "MD\t디렉터리를 만듭니다.\n"
					+ "MKDIR\t디렉터리를 만듭니다.\n" + "RD\t디렉터리를 지웁니다.\n"
					+ "RMDIR\t디렉터리를 지웁니다.\n" + "REN\t파일 이름을 바꿉니다.\n"
					+ "RENAME\t파일 이름을 바꿉니다.\n" + "TYPE\t텍스트 파일의 내용을 보여줍니다.\n"
					+ "EXIT\t프로그램을 종료합니다.\n");
		} else {
			System.out.println("명령어에 대한 도움말을 준비중입니다.");
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
			System.out.println("명령 구문이 올바르지 않습니다.");
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
				System.out.println("하위 디렉터리 또는 파일 " + input[1]
						+ "이(가) 이미 있습니다.");
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
				System.out.println("삭제 파일 : " + f.getName());
				f.delete();
			}
		}
		return file.delete();
	}
 
	public static void renameDirectory(String[] input) {
		if (input.length <= 2) {
			System.out.println("명령 구문이 올바르지 않습니다.");
		} else if (input.length == 3) {
			String oldFilePath = path + File.separator + input[1];
			String newFilePath = path + File.separator + input[2];
 
			File oldFile = new File(oldFilePath);
			File newFile = new File(newFilePath);
 
			if (!oldFile.exists()) {
				System.out.println("지정된 파일을 찾을 수 없습니다.");
			} else {
				if (newFile.exists()) {
					System.out.println("중복되는 파일 이름이 있거나 파일을\n찾을 수 없습니다.");
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
					System.out.println("지정된 경로를 찾을 수 없습니다");
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
				System.out.println("지정된 경로를 찾을 수 없습니다");
			}
		}
 
	}
 
}