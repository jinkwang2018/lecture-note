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
        System.out.print("내 캐릭터: " + this.toString()+ "\t" + "현재 체력: " + hp + " / ");
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
	                System.out.println("Log: " + this.toString() + "님이 " + u.toString() + "님을 -20 데미지로 공격 했습니다.");
	            }
	            else {
	                System.out.println("Log: " + this.toString() + "님 " + u.toString() + "님은 이미 죽었습니다.");
	            }
	            return;
	        }
	        System.out.println("Log: " + u.toString() + "님은 "  + u.toString() + "를 공격하실 수 없습니다.");
			
		}
	@Override
    public void skill() {
        if(this.death()) return;
        System.out.println("Log: " + this.toString() + "님은 적들의 모든 위치를 5초간 볼 수 있습니다.");
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
	                System.out.println("Log: " + this.toString() + "님이 " + u.toString() + "님을 -20 데미지로 공격 했습니다.");
	            }
	            else {
	                System.out.println("Log: " + this.toString() + "님 " + u.toString() + "님은 이미 죽었습니다.");
	            }
	            return;
	        }
	        System.out.println("Log: " + u.toString() + "님은 "  + u.toString() + "를 공격하실 수 없습니다.");
			
		}
	@Override
    public void skill() {
        if(this.death()) return;
        System.out.println("Log: " + this.toString() + "님이 빠르게 달립니다.");
    }
		
	}

class Healer extends Modern implements I{
	Healer(int hp ,int damage){
		super(100,0);
	}
	@Override
    public void shoot(User u) {
        if(this.death()) return;
        System.out.println("Log: " + u.toString() + "님은 적을 공격하실 수 없습니다.");
    }
    @Override
    public void skill() {
        if(this.death()) return;
        System.out.println("Log: " + this.toString() + "님은 5초간 피해량 감소 상태입니다.");
    }
    public void heal(User user) {
        if(this.death()) return;
        if( user instanceof Modern ) {
            if(user.hp > 0) {
                user.hp = (user.hp + 50 > user.MAX_HP) ? user.MAX_HP : user.hp + 50;
                System.out.println("Log: " + this.toString() + "님은 " + user.toString() + "를 +50 치유하셨습니다.");
            }
            else {
                System.out.println("Log: " + this.toString() + "님 " + user.toString() + "님은 이미 죽었습니다.");
            }
            return;
        }
        System.out.println("Log: " + this.toString() + "님 " + user.toString() + "는 적군입니다.");
    }
    @Override
    public String toString() {
        return "의무병(M)";
    }
}



	

	
