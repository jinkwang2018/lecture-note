package kr.or.bit.library;

import java.io.File;
import java.util.Scanner;

/** 
Ŭ������ : LibraryMain
��¥ : 2018-02-23
�ۼ��ڸ� : ���¿�
*/
public class LibraryMain {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		File init = new File("C:\\Temp\\library");
		init.mkdir();
		init = new File("C:\\Temp\\library\\Books");
		init.mkdir();
		init = new File("C:\\Temp\\library\\Users");
		init.mkdir();
		
		Library library = new Library();
		Register register;
		
		String input = null;
		
		System.out.println("*************************************************");
		System.out.println("**************** e-Book Library  ****************");
		System.out.println("*************************************************");
		loop : while(true) {
			register = null;
			do {
				// S.1
				System.out.println("<1>���� ���   <2>���� �˻�   <3>�α���   <4>ȸ������   <5>����");
				input = sc.nextLine();
				switch(input) {
				case "1":
					eBookList(library);
					break;
				case "2":
					eBookSearch(library);
					break;
				case "3":
					System.out.println("************ Login System  ************");
					register = library.login();
					break;
				case "4":
					System.out.println("*********** Register System  ***********");
					library.register();
					break;
				case "5":				
					break loop;
				default:
					System.out.println("�������� ���� �ٶ��ϴ�.");
				}
			} while( !(input.toUpperCase().equals("EXIT")) && !input.equals("3") );
			// ����ڰ� exit ��ɾ ġ�ų� �α����� �ϰ��� �� ��, �Ʒ��� if���� ����
			
			// S.2
			if(register instanceof Manager) {
				do {
					System.out.println("<1>���� ���   <2>���� �˻�   <3>���� �߰�   <4>���� ����   <5>���� �뿩 ���    <6>ȸ�� ���");
					input = sc.nextLine();
					switch(input) {
					case "1":
						eBookList(library);
						break;
					case "2":
						eBookSearch(library);
						break;
					case "3":
						System.out.println("************ Add e-Book  ************");
						((Manager)register).addBook(library.getBookMap());
						break;
					case "4":
						System.out.println("*********** Delete e-Book  ***********");
						library.bookListDel(((Manager)register).delBook());
						
						break;
					case "5":
						System.out.println("*********** All Rent List  ***********");
						RentalBook.printList(library.rentBookList(register));
						break;
					case "6":
						System.out.println("*********** All User List  ***********");
						library.allUserPrint();
						break;
					case "exit":break;
					default:
						System.out.println("�������� ���� �ٶ��ϴ�.");
					}
				} while( !(input.toUpperCase().equals("EXIT")));
				// ����ڰ� exit ��ɾ ġ�ų� �α����� �ϰ��� �� ��, �Ʒ��� if���� ����
				
			} else if (register instanceof User){
				do {
					System.out.println("<1>���� ���   <2>���� �˻�   <3>���� �뿩   <4>���� �б�   <5>�� �뿩 ���");
					input = sc.nextLine();
					switch(input) {
					case "1":
						eBookList(library);
						break;
					case "2":
						eBookSearch(library);
						break;
					case "3":
						System.out.println("************ e-Book Rent  ************");
						System.out.print("�뿩�� e-Book �ø��� ��ȣ: ");
						input = sc.nextLine();
						try {
							library.modify(library.getUser().rentBook(Integer.parseInt(input), library.getTimes())); // �ؼ��� ſ
						}catch(Exception e)  {
							System.out.println("e-Book �ø��� ��ȣ Ȯ�����ּ���");
						}
						break;
					case "4":
						System.out.println("************ e-Book Read  ************");
						System.out.print("������ e-Book �ø��� ��ȣ: ");
						input = sc.nextLine();
						try {
							((User)register).readBook(Integer.parseInt(input));
						}catch(Exception e)  {
							System.out.println("e-Book �ø��� ��ȣ Ȯ�����ּ���");
						}
						break;
					case "5":
						System.out.println("*********** My e-Book List  ***********");
						RentalBook.printList(library.rentBookList(register));
						break;
					case "exit":break;
					default:
						System.out.println("�������� ���� �ٶ��ϴ�.");
					}
				} while( !(input.toUpperCase().equals("EXIT")));
			
			} else {
				System.out.println();
			}
		}
	}
	
	public static void eBookList(Library library) {
		System.out.println("************ e-Book List  ************");
		library.bookListPrint();
	}
	public static void eBookSearch(Library library) {
		System.out.println("*********** e-Book Search  ***********");
		System.out.println("<1>�̸����� ã��   <2>�α� ������ ã��");
		String sort = sc.nextLine();
		if(sort.equals("2")) {
			library.searchPopular();
		}else {
			library.searchTitle();
		}
	}
}
