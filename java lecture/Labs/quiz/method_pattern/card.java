package method_pattern;
public abstract class Product {
    public abstract void use();
}
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
public class IDCard extends Product {
    private String owner;
    IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }
    public void use() {
        System.out.println(owner + "의 카드를 사용합니다.");
    }
    public String getOwner() {
        return owner;
    }
}
public class IDCardFactory extends Factory {
        private List owners = new ArrayList();
        protected Product createProduct(String owner) { // 인스턴스 생성을 위한 메서드
            return new IDCard(owner);// IDCard의 인스턴스를 생성해서 제품을 만드는 일을 실현
    // new를 사용해서 실제 인스턴스를 사용하는 대신에, 인스턴스 생성을 위한 메서드를 호출해서 
    // 구체적인 클래스 이름에 의한 속박에서 상위클래스를 자유롭게 만든다.
        }
        protected void registerProduct(Product product) {
            owners.add(((IDCard)product).getOwner());
        }
        public List getOwners() {
            return owners;
        }
    }
public class card {
	public static void main(String[] args) {

		        Factory factory = new IDCardFactory();

		        Product card1 = factory.create("홍길동");

		        Product card2 = factory.create("이순신");

		        Product card3 = factory.create("강감찬");

		        card1.use();

		        card2.use();

		        card3.use();  
	}
}



