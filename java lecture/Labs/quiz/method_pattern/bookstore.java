package method_pattern;

public class BookStore {
	 
    private List<Book> bookList  .........    
 
    private void å�����Է�(Book book) { //1
        //å ���� �Է� ����
    }
 
    private void ���ڵ���(Book book) { //2
        //���ڵ� ��� ����
    }
 
    private void �����ϱ�(Book book) {   //3                                               
        //â�� �ֱ� ����
    } 
 
    //å �԰���� �޼ҵ�
    public void å�԰�(Book book) {
        
    }
}

public class NameSortingBookStore extends BookStore {                             
    
    public void å�԰�(Book book) {

        super.å�����Է�(book); //1��
        super.���ڵ���(book); //2��
        super.å�����ϱ�(book); //3��
        super.�����ϱ�(book); //4��
    }
 
    private void å�����ϱ�(List<Book> booklist, Book book) {   
        //�̸������� å �����ϱ�
    }     
}
//������ ������� ������ �����ϴ� ����� �ٲٰ� �ʹ�.
//����
public abstract class AbstractBookStore {
	 
    private List<Book> bookList  .........    
 
    private void å�����Է�(Book book) { //1
        //å ���� �Է� ����
    }
 
    private void ���ڵ���(Book book) { //2
        //���ڵ� ��� ����
    }
 
    private void �����ϱ�(Book book) {   //4                                                 
        //â�� �ֱ� ����
    } 
 
    //å �԰���� �޼ҵ�
    public void å�԰�(Book book) {
         public abstract void å�����ϱ�(List<Book> booklist, Book book); //3
    }
}
    /*
    * ������ ������ å�� �����ϴ� ����
    */
public class NameSortingBookStore extends AbstractBookStore {                   
        
        @Override
        public void å�����ϱ�(List<Book> booklist, Book book) {
            //�̸������� å �����ϱ�
        }     
    }
    /*
    * ������ ������ å�� �����ϴ� ����
    */
public class PublicationDaySortingBookStore extends AbstractBookStore {               
        
        @Override
        public void å�����ϱ�(List<Book> booklist, Book book) {
            //������ ������ å �����ϱ�
        }     
    }


  

public class bookstore {

}
