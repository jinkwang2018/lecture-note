
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
            System.out.println("로그인하실 ID를 입력하세요");
            id = sc.nextLine();
            if (!(user.containsKey(id))) {
                System.out.println("가입된 ID가 없습니다 다시 입력해주세요.");
                continue;
            } else {
                System.out.println("비밀번호를 입력하세요");
                pwd = sc.nextLine();
                if (user.get(id).pwd.equals(pwd)) {
                    use = user.get(id);
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                    continue;
                }
            }
            break;
        } while (true);
 
        return use;
    }// 사용자 바꾸기
 
    void join() {// 회원가입
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("가입하실 ID를 입력하세요");
            id = sc.nextLine();
            if (user.containsKey(id)) {
                System.out.println("중복된 ID가 있습니다 다시 입력해주세요.");
                continue;
            }
            System.out.println("비밀번호를 입력하세요");
            pwd = sc.nextLine();
            break;
        } while (true);
 
        user.put(id, new User(id, pwd));
 
    }
 
    void display(User u) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("현재 남은 좌석");
            u.All();
            System.out.println("1.조회 2.예약 3.예매취소 4.재로그인 ");
            switch (sc.nextLine()) {
            case "1":
                System.out.println("현재 예매하신 좌석");
                u.check();
                continue;
            case "2":
                System.out.println("자리의 행을 입력해주세요 ");
                String a = sc.nextLine();
                if(!(0<Integer.parseInt(a)&&Integer.parseInt(a)<5)) {
                    System.out.println("열은 1~4까지 입력해주세요");
                    continue;
                }
                System.out.println("자리의 열을 입력해주세요 ");
                String b = sc.nextLine();
                if(!(0<Integer.parseInt(b)&&Integer.parseInt(b)<9)) {
                    System.out.println("열은 1~8까지 입력해주세요");
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
                System.out.println("1~4번만 입력해주세요");
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
 
    void All() {// 조회
 
        for (boolean[] v : jari) {
            for (boolean o : v) {
                if (o == true) {
                    System.out.print("■ ");
                } else {
                    System.out.print("□ ");
                }
 
            }
            System.out.println();
        }
    }
 
    void check() {// 조회
 
        for (boolean[] v : myjari) {
            for (boolean o : v) {
                if (o == true) {
                    System.out.print("■ ");
                } else {
                    System.out.print("□ ");
                }
 
            }
            System.out.println();
        }
    }
 
    void reservation(int a, int b) {// 예약
            a--;
            b--;
            
        if (jari[a][b]==true) {
            System.out.println("이미 자리가 있습니다.");
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
            System.out.println("예매하신 자리가 없습니다.");
        }
    }// 예약 취소
}
 
public class theater {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        movie1 m = new movie1();
        User sa;
        do {
            System.out.println("1.회원가입 2.로그인 3.종료 ");
            switch (sc.nextLine()) {
            case "1":
                m.join();
                continue;
 
            case "2":
                sa = m.login();
                m.display(sa);
                continue;
            case "3":
                System.out.println("안녕히 가십시오");
                return;
 
            default:
                System.out.println("1~3번 입력해주세요");
                continue;
            }
        } while (true);
 
    }
 
}