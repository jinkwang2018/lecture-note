package papago;
//네이버 Papago NMT API (Reference: https://developers.naver.com/docs/nmt/reference/)
/*
파일명: APIpapagoTranslate.java
작성일시: 2018-03-25
작성내용: 네이버 Papago NMT API활용 번역 페이지 작성
작성자: 강성훈
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

//from json-simple-1.1.1.jar
//String -> JSON 파서를 위한 jar파일
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class APIpapagoTranslate {
    //inputText: 번역할 내용(1회 최대 5,000자), source: 번역 대상 언어 코드, target: 번역 결과 언어 코드
    public String translate(String inputText, String source, String target) {
    	
        String clientId = "FoBjSZSiiHDcHAIGjVPO";//애플리케이션 클라이언트 아이디값;
        String clientSecret = "E9MiOAdH5O";//애플리케이션 클라이언트 시크릿값;
        try {
            //URLEncoder는 일반 문자열을 웹에서 통용되는 'x-www-form-urlencoded' 형식으로 변환하는 역할
            String text = URLEncoder.encode(inputText, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL); //URL(String spec) : 문자열 spec이 지정하는 자원에 대한 URL 객체 생성
            //해당 주소의 페이지로 접속을 하고, 단일 HTTP 접속을 하기위해 형 변환(캐스팅)
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            //POST방식으로 요청(기본값은 GET)
            con.setRequestMethod("POST");
            //Request 헤더에 클라이언트 아이디값, 시크릿값을 정의
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            //post request 내용
            String postParams = "source=" + source + "&target=" + target + "&text=" + text;
            //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션을 정의
            con.setDoOutput(true);
            //POST 데이터를 이용한 DataOutputStream 객체 생성
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams); //해당 주소로 postParams 내용을 write
            wr.flush(); //스트림의 버퍼를 비움
            wr.close(); //스트림을 닫음
            int responseCode = con.getResponseCode(); //HTTP응답의 상태코드
            BufferedReader br; //BufferedReader 변수 선언
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream())); 
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream())); 
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine); //번역결과를 line단위로 append
            }
            br.close(); //버퍼를 닫음
            //System.out.println(response.toString()); //확인용
            
            //JSONParser 코드 추가 (String -> Object 용도)
            JSONParser parser = new JSONParser(); //JSONParser 객체 생성
            Object obj = parser.parse(response.toString()); //문자열 결과를 객체로 받음 (String to Object)
            JSONObject jsonObj = (JSONObject) obj; //결과 객체를 JSON객체로 캐스팅 (Object to JSONObject)
            JSONObject msgObj = (JSONObject) jsonObj.get("message"); //해당 JSON객체의 key가 message인 value를 다시 JSON 캐스팅
            JSONObject resultObj = (JSONObject) msgObj.get("result"); //앞의 JSON객체의 key가 result인 value를 다시 JSON 캐스팅
            String translatedText = (String) resultObj.get("translatedText"); //최종적으로 앞의 JSON객체의 key가 translatedText인 value를 String 캐스팅 >> 번역된 문장
            //System.out.println("번역된 문장: " + translatedStr); // 최종 확인용
            
            return translatedText; //최종적으로 번역된 내용의 String값을 return
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}