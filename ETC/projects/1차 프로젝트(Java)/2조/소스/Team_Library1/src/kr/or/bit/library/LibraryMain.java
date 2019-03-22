package kr.or.bit.library;

import java.io.File;
import java.util.Scanner;

/** 
클래스명 : LibraryMain
날짜 : 2018-02-23
작성자명 : 김태웅
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
				System.out.println("<1>도서 목록   <2>도서 검색   <3>로그인   <4>회원가입   <5>종료");
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
					System.out.println("정상적인 접근 바랍니다.");
				}
			} while( !(input.toUpperCase().equals("EXIT")) && !input.equals("3") );
			// 사용자가 exit 명령어를 치거나 로그인을 하고자 할 때, 아래의 if문을 수행
			
			// S.2
			if(register instanceof Manager) {
				do {
					System.out.println("<1>도서 목록   <2>도서 검색   <3>도서 추가   <4>도서 삭제   <5>현재 대여 목록    <6>회원 목록");
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
						System.out.println("정상적인 접근 바랍니다.");
					}
				} while( !(input.toUpperCase().equals("EXIT")));
				// 사용자가 exit 명령어를 치거나 로그인을 하고자 할 때, 아래의 if문을 수행
				
			} else if (register instanceof User){
				do {
					System.out.println("<1>도서 목록   <2>도서 검색   <3>도서 대여   <4>도서 읽기   <5>내 대여 목록");
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
						System.out.print("대여할 e-Book 시리얼 번호: ");
						input = sc.nextLine();
						try {
							library.modify(library.getUser().rentBook(Integer.parseInt(input), library.getTimes())); // 준수형 탓
						}catch(Exception e)  {
							System.out.println("e-Book 시리얼 번호 확인해주세요");
						}
						break;
					case "4":
						System.out.println("************ e-Book Read  ************");
						System.out.print("접근할 e-Book 시리얼 번호: ");
						input = sc.nextLine();
						try {
							((User)register).readBook(Integer.parseInt(input));
						}catch(Exception e)  {
							System.out.println("e-Book 시리얼 번호 확인해주세요");
						}
						break;
					case "5":
						System.out.println("*********** My e-Book List  ***********");
						RentalBook.printList(library.rentBookList(register));
						break;
					case "exit":break;
					default:
						System.out.println("정상적인 접근 바랍니다.");
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
		System.out.println("<1>이름으로 찾기   <2>인기 순으로 찾기");
		String sort = sc.nextLine();
		if(sort.equals("2")) {
			library.searchPopular();
		}else {
			library.searchTitle();
		}
	}
}
