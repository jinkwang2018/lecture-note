import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputStream {

	public static void main(String[] args) {
		int sum=0;
		int score=0;
		FileInputStream fis=null;
		DataInputStream dis=null;
		try {
				fis =  new FileInputStream("score.txt");
				dis = new DataInputStream(fis);
				while(true) {
					score = dis.readInt();
					System.out.println("Score int Ÿ�� :" + score);
					sum+=score;
				}
		}catch (Exception e) {
			System.out.println("���ܹ߻� : " + e.getMessage());
			System.out.println("sum��� : " + sum);
		}finally {
			try {
					dis.close();
					fis.close();
					
			}catch (Exception e) {
				
			}
		}

	}

}
