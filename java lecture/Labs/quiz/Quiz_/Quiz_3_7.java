package Quiz_;

public class Quiz_3_7 {
	public static void main(String[]args) {
		int fahrenheit = 100;
		float celcius = (float)(((int)(((((float)(fahrenheit-32)*5)/9)*100)+0.5))/100.0); 
		System.out.println("fahrenheit : " + fahrenheit);
		System.out.println("celcius : " + celcius);										   
		//화씨온도 -32를 한값을 float type으로 바꾼 뒤 5를 곱하고 9를 나누면 섭씨 온도 값이 나온다.
    }   //그값에 100을 곱하고(소수점 둘째까지 소수점 위로 올림) 0.5를 더한뒤(반올림) 
	    //인티저값으로 바꾸고(소수점 둘째이하의 값을 버림) 100으로 나누어 주면(소수점 둘째자리까지 만들기) 
	    //소수점 둘째자리까지의 값만 나오게 된다.
}		
