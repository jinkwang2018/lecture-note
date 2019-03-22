import kr.or.bit.Book;
import kr.or.bit.Employee;

public class Ex14_Constructor {
	public static void main(String[] args) {
		Book book = new Book("홍길동전", 1000);
		book.bookInfo();
		
		System.out.println(book.getName());
		
		Book book2 = new Book("전우치전", 3000);
		book2.bookInfo();
		System.out.println(book2.getPrice());
		
		//////////////////////////////////////
		Employee e1 = new Employee();
		e1.employeeInfo();
		
		e1.setEmpno(201801);
		e1.setJob("IT");
		e1.employeeInfo();
		
		//Array 배열을 사용해서 3명의 사원을 만들어보세요(int[] arr = {10, 20, 30})
		//그 정보를 출력해 보세요
		Employee[] emplist = {new Employee(1, "김씨", "영업"),
				new Employee(2, "이씨", "회계"),
				new Employee(3, "박씨", "인사")};
		
		for(Employee e : emplist) {
			e.employeeInfo();
		}
	}
}
