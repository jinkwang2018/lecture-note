import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
Map 인터페이스 구현한 클래스
Map > (키, 값) 쌍구조 배열
ex) 지역번호: 02, 서울
key: 중복(x)
value: 중복(o)

Generic 지원
HashTable(구버전): 동기화 보장
HashMap(신버전) : 동기화 강제 하지 않음 (필요하면 사용 가능) 성능 고려...

현재 의미 없다 (동기화) >> 현재 단일 프로세스에 단일 Thread >> stack 하나만 가지고 >> Sequential
 */
public class Ex12_Map_HashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		map.put("superman", "1007");
		
		//Collection 자료구조 (데이터 가질 수 있다) >> 프로그램 실행되는 동안 
		//>> 메모리(휘발성) >> 프로그램 종료 >> 데이터 보존 (파일기반) 도서관.txt (구조, 관리)
		//>> RDBMS (관계형 DB) 엑셀시트 
		//활용: 회원ID, 회원PW
		
		System.out.println(map.containsKey("tiger")); //key 값은 대소문자 구문
		System.out.println(map.containsKey("scott"));
		System.out.println(map.containsValue("1004"));
		
		//(key, value)
		//key 값을 가지고 value 얻어서 사용하는 것이 목적
		System.out.println(map.get("Tiger")); //key 가지고 value 검색
		System.out.println(map.get("hong")); //key가 없으면 null값을 리턴
		
		//put
		map.put("Tiger", 1008); //가능 (key 같은 경우 put value: overwrite)
		System.out.println(map.get("Tiger"));
		
		Object returnvalue = map.remove("superman");
		System.out.println(returnvalue); //value값 return
		System.out.println("size: " + map.size());
		System.out.println(map.toString());
		
		//KeySet (key 들의 집합)
		Set set = map.keySet(); //중복(x), 순서(x)
		//Set 인터페이스 구현하고 있는 객체를 new 하고 그 곳에 key 담고 그 주소값을 return
		//출력
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//사용해서 출력
		//map.values();
		Collection vlist = map.values();
		System.out.println(vlist.toString());
		
		
	}
}
