package kr.or.bit;
/*
�츮 ȸ��� ����⸦ �ֹ� ���� �Ǹ� �ϴ� ȸ���Դϴ�
�츮 ȸ��� ����⸦ �����ϴ� ���赵�� �ۼ��Ϸ��� �մϴ�
[�䱸����]
1. ����⸦ �����ϸ� ������� �̸��� ��ȣ�� �ο��ؾ� �մϴ� <����>
2. ����Ⱑ ����Ǹ� ������� �̸��� ��ȣ�� �°� �ο��Ǿ����� Ȯ�� �۾��� �ʿ��մϴ�. (������� Ȯ��) <���>
3. �������� ������� ������� ������� �Ѵ�� (����)�� Ȯ���� �� �ֽ��ϴ�. <���>

�� ���� ��� �ڵ�� ���赵 ����ð� ����� 3�� ���� ����Ȯ���ϰ� ������� Ȯ��...

 */
// ��� �Ʒ� �ۼ��� �ڵ�� �����Ǿ�� �մϴ� -> ������ ��� ���Ŀ� �ٽ� ����
/*
public class AirPlane {
	private int airnum; //**private ����ؼ� �Լ��� Ŭ���� �� ������ ��Ʈ�� �ϴ���
	private String airname;
	private static int airtotalcount;
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		airtotalcount++;
		System.out.printf("��ȣ[%d], �̸�[%s]\n", airnum, airname);
	}
	
	public void airPlaneTotalCount() {
		System.out.println("�� ���� ����� ��: " + airtotalcount);
	}
}
*/

public class AirPlane {
	private int airnum; //**private ����ؼ� �Լ��� Ŭ���� �� ������ ��Ʈ�� �ϴ���
	private String airname;
	private static int airtotalcount;
	
	//public AirPlane() {} �������� ���� �ſ��� why) �������� �ʱ�ȭ int num, String name
	
	public AirPlane(int airnum, String airname) {
		this.airnum = airnum;
		this.airname = airname;
		airtotalcount++;
	}
	
	public void airPlaneInfo() {
		System.out.printf("��ȣ[%d], �̸�[%s]\n", airnum, airname);
	}
	
	public void airPlaneTotalCount() {
		System.out.println("�� ���� ����� ��: " + airtotalcount);
	}
}

//���� �ۼ��� �ڵ�

/*
public class AirPlane {
	public String name;
	public int no;
	public static int amount;
	
	public void check(String name, int no) {
		if (this.name == name && this.no == no) {
			System.out.printf("������� �̸�: %s / ��ȣ: %d �°� �ο��Ǿ����ϴ�.\n", name, no);
		}else {
			System.out.println("��ϵ��� ���� ������Դϴ�.");
		}
	}
	
	public int count() {
		return amount++;
	}
}
*/