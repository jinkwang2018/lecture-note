import java.util.StringTokenizer;

//String Ŭ���� (�پ��� �Լ�)
//���߿��� ���� ��� (������ ��κ� ���ڿ� ������: ����ó��)
//String Ŭ������ static �Լ��� �����Ѵ� (public)
//String Ŭ���� new�� ���ؼ� ��밡���� �Ϲ��Լ��� ������ �ִ� (public)
public class Ex06_String_Function {
	public static void main(String[] args) {
		String str = ""; //���ڿ��� �ʱ�ȭ
		
		String[] strarr = {"aaa", "bbb", "ccc"};
		for(String s : strarr) {
			System.out.println(s);
		}
		
		//String Ŭ���� �Լ�
		String ss = "hello";
		String concatstr = ss.concat(" world");
		System.out.println(concatstr);
		
		//boolean bo = ss.contains("el");
		//boolean bo = ss.contains("e");
		boolean bo = ss.contains("elo");
		System.out.println(bo);
		
		String ss2 = "a b c d"; //[a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length());
		String filename = "hello java, world";
		System.out.println(filename.indexOf(",")); //���� ��ġ(index)
		System.out.println(filename.indexOf("java"));
		//Ȱ�� (���� ���ϴ� �ܾ ����� ������ ���忡 ���ԵǾ� �ִٸ�
		System.out.println(filename.lastIndexOf("a"));
		System.out.println(filename.lastIndexOf("javb")); //�迭���� -1 ���ٴ� ǥ��
		//return -1 (���� ����)
		
		//length(), indexof(), substring(), replace(), split()...
		String result = "superman";
		System.out.println(result.substring(0));
		System.out.println(result.substring(2));
		System.out.println(result.substring(0,  0));
		System.out.println(result.substring(0,  1));
		System.out.println(result.substring(1,  1)); //index endIndex - 1
		System.out.println(result.substring(2,  3));
		
		
		/*
		Returns a string that is a substring of this string.
		The substring begins at the specified beginIndex and
		extends to the character at index endIndex - 1.
		Thus the length of the substring is endIndex-beginIndex. 
		 */
		
		//Quiz
		String filename2 = "bit.png";
		//aaaaa.hwp, bbbbbb.mpeg �ϼ��� �ִ�
		//���⼭ ���ϸ�� Ȯ����� �и��ؼ� ����Ͻÿ�.
		
		//ex)
		
		int dot = filename2.indexOf(".");
		String front = filename2.substring(0, dot);
		String end = filename2.substring(dot+1, filename2.length());
		String end2 = filename2.substring(++dot);
		
		System.out.println("����: " + filename2);
		System.out.println("���ϸ�: " + front + " / Ȯ���: " + end);
		System.out.println("���ϸ�: " + front + " / Ȯ���: " + end2);
		
		//replace
		String s4 = "ABCD";
		String result4 = s4.replace("A", "�ȳ�");
		System.out.println(result4);
		
		System.out.println(s4.charAt(0));
		System.out.println(s4.charAt(3));
		System.out.println(s4.endsWith("CD"));
		System.out.println(s4.equalsIgnoreCase("aBcD"));
		
		//POINT: split
		String s6 = "���۸�,��Ƽ,�����,������,������";
		String[] namearry = s6.split(",");
		for(String s : namearry) {
			System.out.println(s);
		}
		String filename3 = "bit.hwp";
		String[] arry = filename3.split("\\."); //����ǥ������ ����ó�� �ν� \
		System.out.println(arry.length);
		for(String s : arry) {
			System.out.println(s);
		}
		//����ǥ����
		//Java, JavaScript, DB .....
		//010-{\d4}-0000
		//010-000-0000 ���ڰ� ����ǥ�� ���Ŀ� ��ġ�ϴ°� (false)
		//���� ī�信 ���� (����: ����ǥ���� 5�� ��������) ����ǥ���� �����ϴ� ����Ʈ?
		
		String s7 = "a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7, "/,.-");
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//�ͼ��� quiz
		String s8 = "ȫ        ��                 ��";
		//���� > "ȫ�浿" �������� ����
		System.out.println(s8.replace(" ", ""));
		
		String s9 = "             ȫ�浿                        ";
		System.out.println(">" + s9 + "<");
		System.out.println(">" + s9.trim() + "<");
		
		String s10 = "     ȫ        ��         ��            ";
		//System.out.println(">" + s10.replace(" ", "") + "<");
		String re = s10.trim();
		String re2 = re.replace(" ", "");
		System.out.println(re2); //�����ؿ�
		//�������� �Լ��� �����Ҷ���
		//method chain ���
		System.out.println(s10.trim().replace(" ", ""));
		
		//Quiz-1
		//String snumstr = "";
		int sum = 0;
		String[] numarr = {"1", "2", "3", "4", "5"};
		//����: �迭�� �ִ� ���ڰ����� ���� sum ������ ��Ƽ� ����ϼ���
		//���� �� �ڵ�
		for(String s : numarr) {
			sum += Integer.parseInt(s);
		}
		System.out.println("��: " + sum);
		
		//Quiz-2
		//���� § �ڵ�
		String jumin = "123456-1234567";
		//����: �ֹι�ȣ�� ���� ���ϼ���
		sum = 0;
		String num = jumin.replace("-", "");
		for(int i = 0; i < num.length(); i++) {
			sum += Integer.parseInt(num.substring(i, i+1));
		}
		System.out.println("��: " + sum);

		///////////////////////////////////////////////////
		//����� �ڵ�
		//Quiz-2
		//�� �ֹι�ȣ�� ���� ���ϼ���
		 int sum2 = 0;
		 for(int i = 0 ; i < jumin.length() ; i++){
				 String numstr = jumin.substring(i,i+1);
				 if(numstr.equals("-"))continue;
				 sum2+= Integer.parseInt(numstr);
			 }
		  System.out.println("�ֹι�ȣ�� :  " + sum2);

	    //�ֹι�ȣ�� ���� ���ϼ��� _2
 	    //String jumin2 = jumin.replace("-", "").split(regex);
		   String[] numarr2 = jumin.replace("-", "").split("");
		   int sum3 =0;
		   for(String i : numarr2){
			   sum3 += Integer.parseInt(i);
		   }
		   System.out.println("�ֹι�ȣ��2 : " + sum3);

		
	   //�ֹι�ȣ�� ���� ���ϼ��� _3
		   String jumin4 = jumin.replace("-", "");
		   int sum4 = 0;
		   for(int i = 0; i < jumin4.length() ; i++){
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("�ֹι�ȣ��3 : " + sum4);

		
		   //format (web) String Ŭ���� static �Լ� > format 
		   //prinf() cmd ���
		   String str5 = String.format("%d-%s",10,"AA");
		   System.out.println(str5);
		   //static : valueof , format
	}
}
