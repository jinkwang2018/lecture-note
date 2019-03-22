
package HashMap_Quiz;


import java.util.HashMap;
import java.util.Scanner;
 
class movie1 {
    HashMap<String, User> user = new HashMap<>();
    String id = "";
    String pwd = "";
 
    User login() {
        Scanner sc = new Scanner(System.in);
        User use = null;
        do {
            System.out.println("�α����Ͻ� ID�� �Է��ϼ���");
            id = sc.nextLine();
            if (!(user.containsKey(id))) {
                System.out.println("���Ե� ID�� �����ϴ� �ٽ� �Է����ּ���.");
                continue;
            } else {
                System.out.println("��й�ȣ�� �Է��ϼ���");
                pwd = sc.nextLine();
                if (user.get(id).pwd.equals(pwd)) {
                    use = user.get(id);
                } else {
                    System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
                    continue;
                }
            }
            break;
        } while (true);
 
        return use;
    }// ����� �ٲٱ�
 
    void join() {// ȸ������
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("�����Ͻ� ID�� �Է��ϼ���");
            id = sc.nextLine();
            if (user.containsKey(id)) {
                System.out.println("�ߺ��� ID�� �ֽ��ϴ� �ٽ� �Է����ּ���.");
                continue;
            }
            System.out.println("��й�ȣ�� �Է��ϼ���");
            pwd = sc.nextLine();
            break;
        } while (true);
 
        user.put(id, new User(id, pwd));
 
    }
 
    void display(User u) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("���� ���� �¼�");
            u.All();
            System.out.println("1.��ȸ 2.���� 3.������� 4.��α��� ");
            switch (sc.nextLine()) {
            case "1":
                System.out.println("���� �����Ͻ� �¼�");
                u.check();
                continue;
            case "2":
                System.out.println("�ڸ��� ���� �Է����ּ��� ");
                String a = sc.nextLine();
                if(!(0<Integer.parseInt(a)&&Integer.parseInt(a)<5)) {
                    System.out.println("���� 1~4���� �Է����ּ���");
                    continue;
                }
                System.out.println("�ڸ��� ���� �Է����ּ��� ");
                String b = sc.nextLine();
                if(!(0<Integer.parseInt(b)&&Integer.parseInt(b)<9)) {
                    System.out.println("���� 1~8���� �Է����ּ���");
                    continue;
                }
                u.reservation(Integer.parseInt(a), Integer.parseInt(b));
                continue;
            case "3":
                u.reservationcancel();
                continue;
            case "4":
                return;
            default:
                System.out.println("1~4���� �Է����ּ���");
                continue;
            }
        } while (true);
    }
 
}
 
class User {
    String id;
    String pwd;
    int a, b;
    static boolean[][] jari = new boolean[4][8];
    boolean[][] myjari = new boolean[4][8];
 
    User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }
 
    void All() {// ��ȸ
 
        for (boolean[] v : jari) {
            for (boolean o : v) {
                if (o == true) {
                    System.out.print("�� ");
                } else {
                    System.out.print("�� ");
                }
 
            }
            System.out.println();
        }
    }
 
    void check() {// ��ȸ
 
        for (boolean[] v : myjari) {
            for (boolean o : v) {
                if (o == true) {
                    System.out.print("�� ");
                } else {
                    System.out.print("�� ");
                }
 
            }
            System.out.println();
        }
    }
 
    void reservation(int a, int b) {// ����
            a--;
            b--;
            
        if (jari[a][b]==true) {
            System.out.println("�̹� �ڸ��� �ֽ��ϴ�.");
        } else {
            this.a = a;
            this.b = b;
            myjari[a][b] = !(myjari[a][b]);
            jari[a][b] = myjari[a][b];
        }
    }
 
    void reservationcancel() {
        if(myjari[this.a][this.b]==true) {
        myjari[this.a][this.b] = !(myjari[this.a][this.b]);
        jari[this.a][this.b] = myjari[this.a][this.b];
        }else {
            System.out.println("�����Ͻ� �ڸ��� �����ϴ�.");
        }
    }// ���� ���
}
 
public class theater {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        movie1 m = new movie1();
        User sa;
        do {
            System.out.println("1.ȸ������ 2.�α��� 3.���� ");
            switch (sc.nextLine()) {
            case "1":
                m.join();
                continue;
 
            case "2":
                sa = m.login();
                m.display(sa);
                continue;
            case "3":
                System.out.println("�ȳ��� ���ʽÿ�");
                return;
 
            default:
                System.out.println("1~3�� �Է����ּ���");
                continue;
            }
        } while (true);
 
    }
 
}