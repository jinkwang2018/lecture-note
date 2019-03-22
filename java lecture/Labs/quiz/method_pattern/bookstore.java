package method_pattern;

public class BookStore {
	 
    private List<Book> bookList  .........    
 
    private void 책정보입력(Book book) { //1
        //책 정보 입력 구현
    }
 
    private void 바코드등록(Book book) { //2
        //바코드 등록 구현
    }
 
    private void 진열하기(Book book) {   //3                                               
        //창고에 넣기 구현
    } 
 
    //책 입고과정 메소드
    public void 책입고(Book book) {
        
    }
}

public class NameSortingBookStore extends BookStore {                             
    
    public void 책입고(Book book) {

        super.책정보입력(book); //1번
        super.바코드등록(book); //2번
        super.책정렬하기(book); //3번
        super.진열하기(book); //4번
    }
 
    private void 책정렬하기(List<Book> booklist, Book book) {   
        //이름순으로 책 정렬하기
    }     
}
//서점이 만들어질 때마다 정렬하는 방법을 바꾸고 싶다.
//변경
public abstract class AbstractBookStore {
	 
    private List<Book> bookList  .........    
 
    private void 책정보입력(Book book) { //1
        //책 정보 입력 구현
    }
 
    private void 바코드등록(Book book) { //2
        //바코드 등록 구현
    }
 
    private void 진열하기(Book book) {   //4                                                 
        //창고에 넣기 구현
    } 
 
    //책 입고과정 메소드
    public void 책입고(Book book) {
         public abstract void 책정렬하기(List<Book> booklist, Book book); //3
    }
}
    /*
    * 도서명 순서로 책을 정렬하는 서점
    */
public class NameSortingBookStore extends AbstractBookStore {                   
        
        @Override
        public void 책정렬하기(List<Book> booklist, Book book) {
            //이름순으로 책 정렬하기
        }     
    }
    /*
    * 출판일 순서로 책을 정렬하는 서점
    */
public class PublicationDaySortingBookStore extends AbstractBookStore {               
        
        @Override
        public void 책정렬하기(List<Book> booklist, Book book) {
            //출판일 순으로 책 정렬하기
        }     
    }


  

public class bookstore {

}
