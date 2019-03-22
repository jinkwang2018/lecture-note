import java.io.Serializable;
import java.util.*;

/*
��      ¥: 2018-02-23
�ۼ��ڸ�: ������
��      ��: �Խñ� ���
*/

public class Post implements Serializable{

	private List<String> content; // �Խñ� ����Ʈ
	private String date;          // �Խñ� ��¥
	private String writer;        // �Խñ� �ۼ���
	private int contentNum;       // �Խñ� ����

	
	Post(){
		this.content = null;
		this.date = "";
		this.writer = "";
		this.contentNum =0;
	}
	
	
	public void printContent() {

		for (String s : content) {
			System.out.println(s);
		}

	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	public void printPost() { //�Խñ� ���
		System.out.printf("--[No. %d]--------------------------\n", this.contentNum);
		System.out.println("�ۼ��ڸ� : " + this.writer);
		System.out.println("�ۼ���    : " + this.date);
		System.out.println();
		
		for(String s : content) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("-----------------------------------");
		
	}
	
	public void printNotice() { //������ ���� �������� ���
		System.out.println("---------------��������---------------");
		System.out.println("�ۼ���    : " + this.date);
		System.out.println();
		
		for(String s : content) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("-----------------------------------");
	}
}
