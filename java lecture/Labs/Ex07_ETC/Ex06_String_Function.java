import java.util.StringTokenizer;

//String 클래스 (다양한 함수)
//개발에서 많이 사용 (데이터 대부분 문자열 데이터: 조합처리)
//String 클래스는 static 함수도 제공한다 (public)
//String 클래스 new를 통해서 사용가능한 일반함수도 가지고 있다 (public)
public class Ex06_String_Function {
	public static void main(String[] args) {
		String str = ""; //문자열의 초기화
		
		String[] strarr = {"aaa", "bbb", "ccc"};
		for(String s : strarr) {
			System.out.println(s);
		}
		
		//String 클래스 함수
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
		System.out.println(filename.indexOf(",")); //시작 위치(index)
		System.out.println(filename.indexOf("java"));
		//활용 (내가 원하는 단어가 당신이 제시한 문장에 포함되어 있다면
		System.out.println(filename.lastIndexOf("a"));
		System.out.println(filename.lastIndexOf("javb")); //배열에서 -1 없다는 표현
		//return -1 (값이 없다)
		
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
		//aaaaa.hwp, bbbbbb.mpeg 일수도 있다
		//여기서 파일명과 확장명을 분리해서 출력하시오.
		
		//ex)
		
		int dot = filename2.indexOf(".");
		String front = filename2.substring(0, dot);
		String end = filename2.substring(dot+1, filename2.length());
		String end2 = filename2.substring(++dot);
		
		System.out.println("원본: " + filename2);
		System.out.println("파일명: " + front + " / 확장명: " + end);
		System.out.println("파일명: " + front + " / 확장명: " + end2);
		
		//replace
		String s4 = "ABCD";
		String result4 = s4.replace("A", "안녕");
		System.out.println(result4);
		
		System.out.println(s4.charAt(0));
		System.out.println(s4.charAt(3));
		System.out.println(s4.endsWith("CD"));
		System.out.println(s4.equalsIgnoreCase("aBcD"));
		
		//POINT: split
		String s6 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearry = s6.split(",");
		for(String s : namearry) {
			System.out.println(s);
		}
		String filename3 = "bit.hwp";
		String[] arry = filename3.split("\\."); //정규표현식을 문자처럼 인식 \
		System.out.println(arry.length);
		for(String s : arry) {
			System.out.println(s);
		}
		//정규표현식
		//Java, JavaScript, DB .....
		//010-{\d4}-0000
		//010-000-0000 문자가 정규표현 형식에 일치하는가 (false)
		//추후 카페에 공지 (과제: 정규표현식 5개 만들어오기) 정규표현식 검증하는 사이트?
		
		String s7 = "a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7, "/,.-");
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//넌센스 quiz
		String s8 = "홍        길                 동";
		//저장 > "홍길동" 공백제거 저장
		System.out.println(s8.replace(" ", ""));
		
		String s9 = "             홍길동                        ";
		System.out.println(">" + s9 + "<");
		System.out.println(">" + s9.trim() + "<");
		
		String s10 = "     홍        길         동            ";
		//System.out.println(">" + s10.replace(" ", "") + "<");
		String re = s10.trim();
		String re2 = re.replace(" ", "");
		System.out.println(re2); //무식해요
		//여러개의 함수를 적용할때는
		//method chain 기법
		System.out.println(s10.trim().replace(" ", ""));
		
		//Quiz-1
		//String snumstr = "";
		int sum = 0;
		String[] numarr = {"1", "2", "3", "4", "5"};
		//문제: 배열에 있는 문자값들의 합을 sum 변수에 담아서 출력하세요
		//내가 쓴 코드
		for(String s : numarr) {
			sum += Integer.parseInt(s);
		}
		System.out.println("합: " + sum);
		
		//Quiz-2
		//내가 짠 코드
		String jumin = "123456-1234567";
		//문제: 주민번호의 합을 구하세요
		sum = 0;
		String num = jumin.replace("-", "");
		for(int i = 0; i < num.length(); i++) {
			sum += Integer.parseInt(num.substring(i, i+1));
		}
		System.out.println("합: " + sum);

		///////////////////////////////////////////////////
		//강사님 코드
		//Quiz-2
		//위 주민번호의 합을 구하세요
		 int sum2 = 0;
		 for(int i = 0 ; i < jumin.length() ; i++){
				 String numstr = jumin.substring(i,i+1);
				 if(numstr.equals("-"))continue;
				 sum2+= Integer.parseInt(numstr);
			 }
		  System.out.println("주민번호합 :  " + sum2);

	    //주민번호의 합을 구하세요 _2
 	    //String jumin2 = jumin.replace("-", "").split(regex);
		   String[] numarr2 = jumin.replace("-", "").split("");
		   int sum3 =0;
		   for(String i : numarr2){
			   sum3 += Integer.parseInt(i);
		   }
		   System.out.println("주민번호합2 : " + sum3);

		
	   //주민번호의 합을 구하세요 _3
		   String jumin4 = jumin.replace("-", "");
		   int sum4 = 0;
		   for(int i = 0; i < jumin4.length() ; i++){
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("주민번호합3 : " + sum4);

		
		   //format (web) String 클래스 static 함수 > format 
		   //prinf() cmd 모드
		   String str5 = String.format("%d-%s",10,"AA");
		   System.out.println(str5);
		   //static : valueof , format
	}
}
