package Quiz_;

class Past extends Modern{
	String color;
	String team;
	Past(int hp,int damage){
		super(hp,damage);
		team = "past"; 
	}
}
class Bowman extends Past implements I{
	Bowman(int hp ,int damage){
		super(100,75);
		team = "Past";
	}
	@Override
	public String toString() {
		return "Bowman";
	}
	

	@Override
	public void shoot(Modern u) {
		if(!(u instanceof Modern)) {
			 if(u.hp != 0) {
	                u.hp -= this.DAMAGE; 
	                System.out.println("Log: " + this.toString() + "���� " + u.toString() + "���� -75 �������� ���� �߽��ϴ�.");
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
	
class Swordman extends Past implements I{
	Swordman(int hp ,int damage){
		super(100,75);
		team = "Past";
	}
	@Override
	public String toString() {
		return "Bowman";
	}
	

	@Override
	public void shoot(Modern u) {
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
	
class Doctor extends Past implements I{
	Doctor(int hp ,int damage){
		super(100,75);
		team = "Past";
	}
	@Override
	public String toString() {
		return "Bowman";
	}
	

	@Override
	public void shoot(Modern u) {
		if(!(u instanceof Modern)) {
			 if(u.hp != 0) {
	                u.hp -= this.DAMAGE; 
	                System.out.println("Log: " + this.toString() + "���� " + u.toString() + "���� ���� �����Ͻ� �� �����ϴ�.");
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
	