package Quiz_;
interface I{
	    void shoot(User u);
		void skill();
}
public class Modern extends User{
	
	String team;
	Modern(int hp,int damage){
		super(hp,damage);
		team = "modern"; 
	}
}
class User {
    final int MAX_HP;
    final int DAMAGE;
    int hp;
    
    User(int hp, int damage) {
        this.MAX_HP = hp;
        this.DAMAGE = damage;
        this.hp = this.MAX_HP;
    }
    public void stat() {
        System.out.print("�� ĳ����: " + this.toString()+ "\t" + "���� ü��: " + hp + " / ");
    }
    public boolean death() {
        return (this.hp <= 0) ? true : false;
    }
}

class Sniper extends Modern implements I{
	Sniper(int hp ,int damage){
		super(100,75);
		
	}
	@Override
	public String toString() {
		return "Sniper";
	}
	

	@Override
	public void shoot(User u) {
		if(!(u instanceof Modern)) {
			 if(u.hp != 0) {
	                u.hp -= this.DAMAGE; 
	                System.out.println("Log: " + this.toString() + "���� " + u.toString() + "���� -20 �������� ���� �߽��ϴ�.");
	            }
	            else {
	                System.out.println("Log: " + this.toString() + "�� " + u.toString() + "���� �̹� �׾����ϴ�.");
	            }
	            return;
	        }
	        System.out.println("Log: " + u.toString() + "���� "  + u.toString() + "�� �����Ͻ� �� �����ϴ�.");
			
		}
	@Override
    public void skill() {
        if(this.death()) return;
        System.out.println("Log: " + this.toString() + "���� ������ ��� ��ġ�� 5�ʰ� �� �� �ֽ��ϴ�.");
    }
		
	}
	

class Assaulter extends Modern implements I{
	Assaulter(int hp ,int damage){
		super(100,20);
		
	}
	@Override
	public String toString() {
		return "Assaulter";
	}
	@Override
	public void shoot(User u) {
		if(!(u instanceof Modern)) {
			 if(u.hp != 0) {
	                u.hp -= this.DAMAGE; 
	                System.out.println("Log: " + this.toString() + "���� " + u.toString() + "���� -20 �������� ���� �߽��ϴ�.");
	            }
	            else {
	                System.out.println("Log: " + this.toString() + "�� " + u.toString() + "���� �̹� �׾����ϴ�.");
	            }
	            return;
	        }
	        System.out.println("Log: " + u.toString() + "���� "  + u.toString() + "�� �����Ͻ� �� �����ϴ�.");
			
		}
	@Override
    public void skill() {
        if(this.death()) return;
        System.out.println("Log: " + this.toString() + "���� ������ �޸��ϴ�.");
    }
		
	}

class Healer extends Modern implements I{
	Healer(int hp ,int damage){
		super(100,0);
	}
	@Override
    public void shoot(User u) {
        if(this.death()) return;
        System.out.println("Log: " + u.toString() + "���� ���� �����Ͻ� �� �����ϴ�.");
    }
    @Override
    public void skill() {
        if(this.death()) return;
        System.out.println("Log: " + this.toString() + "���� 5�ʰ� ���ط� ���� �����Դϴ�.");
    }
    public void heal(User user) {
        if(this.death()) return;
        if( user instanceof Modern ) {
            if(user.hp > 0) {
                user.hp = (user.hp + 50 > user.MAX_HP) ? user.MAX_HP : user.hp + 50;
                System.out.println("Log: " + this.toString() + "���� " + user.toString() + "�� +50 ġ���ϼ̽��ϴ�.");
            }
            else {
                System.out.println("Log: " + this.toString() + "�� " + user.toString() + "���� �̹� �׾����ϴ�.");
            }
            return;
        }
        System.out.println("Log: " + this.toString() + "�� " + user.toString() + "�� �����Դϴ�.");
    }
    @Override
    public String toString() {
        return "�ǹ���(M)";
    }
}



	

	
