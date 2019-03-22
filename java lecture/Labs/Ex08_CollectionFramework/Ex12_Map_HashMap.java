import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
Map �������̽� ������ Ŭ����
Map > (Ű, ��) �ֱ��� �迭
ex) ������ȣ: 02, ����
key: �ߺ�(x)
value: �ߺ�(o)

Generic ����
HashTable(������): ����ȭ ����
HashMap(�Ź���) : ����ȭ ���� ���� ���� (�ʿ��ϸ� ��� ����) ���� ���...

���� �ǹ� ���� (����ȭ) >> ���� ���� ���μ����� ���� Thread >> stack �ϳ��� ������ >> Sequential
 */
public class Ex12_Map_HashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		map.put("superman", "1007");
		
		//Collection �ڷᱸ�� (������ ���� �� �ִ�) >> ���α׷� ����Ǵ� ���� 
		//>> �޸�(�ֹ߼�) >> ���α׷� ���� >> ������ ���� (���ϱ��) ������.txt (����, ����)
		//>> RDBMS (������ DB) ������Ʈ 
		//Ȱ��: ȸ��ID, ȸ��PW
		
		System.out.println(map.containsKey("tiger")); //key ���� ��ҹ��� ����
		System.out.println(map.containsKey("scott"));
		System.out.println(map.containsValue("1004"));
		
		//(key, value)
		//key ���� ������ value �� ����ϴ� ���� ����
		System.out.println(map.get("Tiger")); //key ������ value �˻�
		System.out.println(map.get("hong")); //key�� ������ null���� ����
		
		//put
		map.put("Tiger", 1008); //���� (key ���� ��� put value: overwrite)
		System.out.println(map.get("Tiger"));
		
		Object returnvalue = map.remove("superman");
		System.out.println(returnvalue); //value�� return
		System.out.println("size: " + map.size());
		System.out.println(map.toString());
		
		//KeySet (key ���� ����)
		Set set = map.keySet(); //�ߺ�(x), ����(x)
		//Set �������̽� �����ϰ� �ִ� ��ü�� new �ϰ� �� ���� key ��� �� �ּҰ��� return
		//���
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//����ؼ� ���
		//map.values();
		Collection vlist = map.values();
		System.out.println(vlist.toString());
		
		
	}
}
