import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex11_Set_TreeSet {
	public static void main(String[] args) {
		//순서유지(x), 중복(x)
		HashSet<String> hs = new HashSet<>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		hs.add("A");
		System.out.println(hs.toString());
		
		//HashSet 확장 > LinkedHashSet (순서유지: 주소값으로) : Linked(객체 주소) >> node
		Set<String> hs2 = new LinkedHashSet<>();
		hs2.add("B");
		hs2.add("A");
		hs2.add("F");
		hs2.add("K");
		hs2.add("G");
		hs2.add("D");
		hs2.add("P");
		hs2.add("A");
		//Array 아님 (주소값 연결)
		System.out.println(hs2.toString());
		
		//자료구조 (순서(x), 중복(x), 정렬(o))
		//검색하거나 정렬을 필요로 하는 자료구조 (알고리즘)
		//TreeSet
		//데이터 트리(이진 트리): 정렬되고 많은 양의 데이터 저장 효율적
		//검색 속도 빠름
		
		//TreeSet를 사용해서 로또 구현
		//1~45 난수 >> 6개 >> 중복값(x) >> 정렬(o)
		//결과 출력 (Iterator)
		
		
		Set<Integer> ls = new TreeSet<>();
		
		while(ls.size() < 6) {
			int num = (int)(Math.random()*45 + 1);
			ls.add(num);
		}
		
		int sum = 0;
		Iterator<Integer> it = ls.iterator();
		while(it.hasNext()) {
			//System.out.println(it.next());
			sum+=it.next();
		}
		System.out.println(ls.toString());
		System.out.println(sum);
	}
}
