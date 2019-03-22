import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {
	public static void main(String[] args) {
		/*
		Format Ŭ����
		 
		ȭ����� ó��
		DecimalFormat df = new DecimalFormat("#,###.0");
		String result = df.format(1234567.89);
		System.out.println(result);
		
		��¥ ���� ó��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String strDate = sdf.format(new Date());
		System.out.println(strDate);
		
		���ڿ� ó��
		String message = "ȸ�� Id :{0} \nȸ�� �̸� : {1} \nȸ�� ��ȭ��ȣ : {2}";
		String result = MessageFormat.format(message, userId, userName, userTel);
		*/
		
		File dir = new File("C:\\Temp");
		File[] files = dir.listFiles(); //��� �ڿ�(���� �Ǵ� ����)
		
		for(int i = 0; i < files.length; i++) {
			File file = files[i];
			String name = file.getName(); //������, ���ϸ�
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String atrribute = "";
			String size = "";
			
			if(files[i].isDirectory()) {
				atrribute = "<DIR>";
			}else { //�������� ����(a.txt, copy.jpg ...)
				size = file.length() + "byte";
				atrribute = file.canRead() ? "R" : "";
				atrribute += file.canWrite() ? "W" : "";
				atrribute += file.isHidden() ? "H" : "";
			}
			System.out.printf("%s   %3s   %10s   %s   \n",
							df.format(file.lastModified()),
							atrribute,
							size,
							name);
		}
	}
}
