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
        System.out.println(owner + "�� ī�带 ����ϴ�.");
        this.owner = owner;
    }
    public void use() {
        System.out.println(owner + "�� ī�带 ����մϴ�.");
    }
    public String getOwner() {
        return owner;
    }
}
public class IDCardFactory extends Factory {
        private List owners = new ArrayList();
        protected Product createProduct(String owner) { // �ν��Ͻ� ������ ���� �޼���
            return new IDCard(owner);// IDCard�� �ν��Ͻ��� �����ؼ� ��ǰ�� ����� ���� ����
    // new�� ����ؼ� ���� �ν��Ͻ��� ����ϴ� ��ſ�, �ν��Ͻ� ������ ���� �޼��带 ȣ���ؼ� 
    // ��ü���� Ŭ���� �̸��� ���� �ӹڿ��� ����Ŭ������ �����Ӱ� �����.
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

		        Product card1 = factory.create("ȫ�浿");

		        Product card2 = factory.create("�̼���");

		        Product card3 = factory.create("������");

		        card1.use();

		        card2.use();

		        card3.use();  
	}
}



