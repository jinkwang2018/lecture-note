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
	                System.out.println("Log: " + this.toString() + "님이 " + u.toString() + "님을 -75 데미지로 공격 했습니다.");
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
	                System.out.println("Log: " + this.toString() + "님이 " + u.toString() + "님은 적을 공격하실 수 없습니다.");
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
	