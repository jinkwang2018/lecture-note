import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

//��Ʈ��ũ �۾��� �� �� �ִ� �ڿ�
//JAVA API ����
//Ŭ������ ���ؼ�
//URL Ŭ���� (���ͳ� �� �ּҸ� �ٷ�� Ŭ����)
//URLConnection Ŭ����(����� URL �ּҷ� ���� �پ��� ������ �۾�)
//http://image3.kangcom.com/2018/02/b_pic/201802028179.jpg
public class Ex01_URLConnection {
	public static void main(String[] args) throws IOException {
		String urlstr = "http://www.kangcom.com/images/banner/chocolate_150.jpg";
		URL url = new URL(urlstr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		
		FileOutputStream fos = new FileOutputStream("copy1.jpg"); //���� ���� (������Ʈ ����)
		
		byte[] buffer = new byte[2048];
		int n = 0;
		int count = 0;
		
		URLConnection uc = url.openConnection();
		int filesize = uc.getContentLength();
		
		System.out.println("����ũ��: " + filesize);
		System.out.println("��������: " + uc.getContentType());
		
		while((n = bis.read(buffer)) != -1) {
			fos.write(buffer, 0, buffer.length);
			fos.flush();
			System.out.println("n: " + n);
			count += 1;
		}
		System.out.println("count: " + count);
		fos.close();
		bis.close();
	}
}
