import kr.or.bit.Book;
import kr.or.bit.Employee;

public class Ex14_Constructor {
	public static void main(String[] args) {
		Book book = new Book("ȫ�浿��", 1000);
		book.bookInfo();
		
		System.out.println(book.getName());
		
		Book book2 = new Book("����ġ��", 3000);
		book2.bookInfo();
		System.out.println(book2.getPrice());
		
		//////////////////////////////////////
		Employee e1 = new Employee();
		e1.employeeInfo();
		
		e1.setEmpno(201801);
		e1.setJob("IT");
		e1.employeeInfo();
		
		//Array �迭�� ����ؼ� 3���� ����� ��������(int[] arr = {10, 20, 30})
		//�� ������ ����� ������
		Employee[] emplist = {new Employee(1, "�达", "����"),
				new Employee(2, "�̾�", "ȸ��"),
				new Employee(3, "�ھ�", "�λ�")};
		
		for(Employee e : emplist) {
			e.employeeInfo();
		}
	}
}
