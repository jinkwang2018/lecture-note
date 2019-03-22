import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_KeyPoint {
	public static void main(String[] args) {
		//정적배열(Array)
		//사원 1명을 만드세요
		Emp e = new Emp(100, "김유신", "군인");
		System.out.println(e.toString());
		
		//정적배열(Array) 사용
		//사원 2명 만드세요
		Emp[] emplist = {new Emp(10, "김씨", "IT"), new Emp(20, "박씨", "SALES")};
		
		for(Emp em : emplist) {
			System.out.println(em.toString());
		}
		/////////////////// 기존 배열 (정적) 복습 ///////////////////////
		
		//ArrayList를 사용해서 사원 2명을 만드세요
		ArrayList elist = new ArrayList();
		
		elist.add(new Emp(1,"김","IT"));
		elist.add(new Emp(2,"박","영업"));
		
		System.out.println(elist.toString());
		
		//for문 사용해서 사원 데이터 정보 출력
		for(int i = 0; i < elist.size(); i++) {
			//System.out.println(elist.get(i).toString());
			//System.out.println(((Emp)elist.get(i)).toString());
			Emp m = (Emp)elist.get(i);
			System.out.println(m.getEmpno() + " / " + m.getEname() + " / " + m.getJob());
		}
		
		//개선된 for문
		for(Object obj : elist) {
			Emp m = (Emp)obj;
			System.out.println(m.getEmpno());
		}
		
		//Object 불편해서 쓰기 싫어요...실제 사용은 제너릭(generic)
		//generic (100%)
		ArrayList<Emp> elist2 = new ArrayList<Emp>();
		elist2.add(new Emp(1, "A", "IT"));
		elist2.add(new Emp(2, "B", "SALES"));
		
		for(Emp em : elist2) {
			System.out.println(em.getEmpno() + "/" + em.getEname() + "/" + em.getJob());
		}
	}
}
