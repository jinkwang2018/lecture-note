import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
 
 
//PrintWriter Ŭ������ ����ϸ� [�������] ����
//System.out.printf() //String.foramt()
public class Ex11_PrintWriter {
	public static void main(String[] args) {
		try{
			//������� (���� ���� ���)
			PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt");
			pw.println("**************************************");
			pw.println("*      HOMEWORK                      *");
			pw.println("**************************************");
			pw.printf("%3s  : %5d  %5d  %5d  %5.1f ", "�ƹ���",10,30,50, (float)((10+30+50)/3));
			pw.println();
			pw.close(); //���Ͽ� write close()
			
			//read
			FileReader fr = new FileReader("C:\\Temp\\homework.txt");
			BufferedReader br = new BufferedReader(fr);
			String s="";
			while((s = br.readLine()) != null){
				System.out.println(s);
			}
			
			br.close();
			fr.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			//System.out.println("finally");
		}
	}
}
