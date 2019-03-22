import java.util.ArrayList;
import java.util.Iterator;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;

public class Ex08_Generic_Quiz {
	public static void main(String[] args) {
		//1. Emp 클래스를 사용해서 사원 3명을 생성하세요
		//단 ArrayList<T> 제너릭을 사용하세요
		ArrayList<Emp> earr = new ArrayList<>();
		
		earr.add(new Emp(1, "김", "군인"));
		earr.add(new Emp(2, "이", "IT"));
		earr.add(new Emp(3, "박", "영업"));
		
		
		//2. 사원의 정보 (사번, 이름, 직종)을 개선된 for문을 사용해서 출력하세요
		//단 toString() 사용 금지
		for(Emp e : earr) {
			System.out.println(e.getEmpno() + "/" + e.getEname() + "/" + e.getJob());
		}
		
		System.out.println();
		
		//3. 사원의 정보 (사번, 이름, 직종)을 일반 for문을 사용해서 출력하세요
		//단 toString() 사용 금지
		for(int i = 0; i < earr.size(); i++) {
			System.out.println(earr.get(i).getEmpno() + "/" + earr.get(i).getEname() + "/" + earr.get(i).getJob());
		}
		
		System.out.println();
		
		//4. CopyEmp 라는 클래스를 만드세요(Emp와 같은데)
		//job member field 대신에>>
		//private int sal; 로 바꾸어 만드세요(getter, setter 구현)
		//kr.or.bit.CopyEmp 로 하세요
		//ArrayList<> 제너릭 사용해서 사원 3명 만드세요
		//아래 데이터 사용
		//100, "김", 1000
		//200, "이", 2000
		//300, "박", 3000
		ArrayList<CopyEmp> carr = new ArrayList<>();
		carr.add(new CopyEmp(100, "김", 1000));
		carr.add(new CopyEmp(200, "이", 2000));
		carr.add(new CopyEmp(300, "박", 3000));
		
		//5. 200번 사원의 급여를 5000으로 수정해서 출력하세요 (일반 for문 안에서...)
		for(int i = 0; i < carr.size(); i++) {
			if(carr.get(i).getEmpno() == 200) {
				carr.get(i).setSal(5000);
				System.out.println(carr.get(i).toString());
			}
		}
		
		System.out.println();
		
		//6. 300번 사원의 이름을 "궁금해"로 수정해서 출력하세요 (일반 for문 안에서...)
		for(CopyEmp c : carr) {
			if(c.getEmpno() == 300) {
				c.setEname("궁금해");
				System.out.println(c.toString());
			}
		}
		
		System.out.println();
		
		//7.사원정보를 Iterator 인터페이스를 사용해서 출력하세요
		/*
		ArrayList<Integer> intlist = new ArrayList<>();
		intlist.add(44);
		intlist.add(55);
		intlist.add(66);
		
		Iterator<Integer> list2 = intlist.iterator();
		while(list2.hasNext()) {
			System.out.println("[" + list2.next() + "");
		}
		*/
		Iterator<CopyEmp> it = carr.iterator();
		while(it.hasNext()) {
			//next() 이동해서 값을 return
			//System.out.println(it.next().getEmpno());
			//System.out.println(it.next().getEname());
			//System.out.println(it.next().getSal());
			CopyEmp e = it.next();
			System.out.println(e.getEmpno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
		}
		
		
	}
}
