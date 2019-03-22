package BlueMarble;
 
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
class Dice extends JFrame {
    JFrame frm = new JFrame("�ֻ���"); // ��ȭ��
    ImageIcon ic; // �ֻ��� ���� �̹���
    JLabel lbImage; // �̹���
    JButton button; // ��ư
    int diceNumber; //�ֻ��� ������ �����ϴ� ����
    boolean check = false; 
    JFrame frm1 = new JFrame("�� ����"); // ��ȭ�� ������ ������
    public Dice() {
        // �ʱ⿡ ��ȭ���� ��ư �Ѱ��� �ֻ��� 1 �̹��� ����
        frm.setLayout(new FlowLayout());
        ic = new ImageIcon("0.jpg"); // �̹��� 1
        lbImage = new JLabel(ic);
        button = new JButton("�ֻ��� ������!");
        frm.setSize(350, 400); // ũ�� ���� 350 ,���� 350
        frm.add(button);
        frm.add(lbImage);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int dice = (int) (Math.random() * 6 + 1); // ���� 1~6
                
                ic = new ImageIcon(dice+".png"); // �̹��� 1~6���� ����
                lbImage.setIcon(ic);
                frm.setSize(350, 400); // ũ�� 350, 400
                frm.add(lbImage); // �̹��� �߰�
                frm.setVisible(true); // playerŬ������ �ִ� move�� �Լ� 1�� �־���
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ�â
                
                diceNumber = dice; //��������  diceNumber ������ �־���
                
            }
        });
        //��Ʈ����
        Font font = new Font("�ü�", Font.BOLD, 20);
        Font font1 = new Font("����", Font.PLAIN, 20);
        frm1.setLayout(new FlowLayout(30, 30, 20));
 
        frm1.setSize(800, 850); //ũ�� ���� 800  , ����  850
        //������ ����
        JLabel jLabel0,jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11,
                jLabel12, jLabel13, jLabel14, jLabel15, jLabel16;
 
        jLabel0 = new JLabel("[����] : 100����, [����] : 50����");
        jLabel0.setFont(font);
        frm1.add(jLabel0);
        
        jLabel1 = new JLabel("[����][������][�������][ȣ�ڰ���][ȣ�������][��������][���������]");
        jLabel1.setFont(font);
        frm1.add(jLabel1);
 
        jLabel2 = new JLabel("[ȫ��]   [10����]          [30����]    [20����]   [40����]      [30����]    [55����]");
        jLabel2.setFont(font1);
        frm1.add(jLabel2);
 
        jLabel3 = new JLabel("[�̰���] [20����]          [40����]    [30����]   [50����]      [40����]    [65����]");
        jLabel3.setFont(font1);
        frm1.add(jLabel3);
 
        jLabel4 = new JLabel("[���׳�] [30����]          [50����]    [40����]   [60����]      [50����]    [75����]");
        jLabel4.setFont(font1);
        frm1.add(jLabel4);
 
        jLabel5 = new JLabel("[������] [40����]          [60����]    [50����]   [80����]      [60����]    [90����]");
        jLabel5.setFont(font1);
        frm1.add(jLabel5);
 
 
        jLabel6 = new JLabel("[�Ͽ���] [55����]          [80����]    [70����]  [100����]      [80����]   [120����]");
        jLabel6.setFont(font1);
        frm1.add(jLabel6);
 
        jLabel7 = new JLabel("[������] [60����]          [85����]    [80����]  [120����]      [90����]   [130����]");
        jLabel7.setFont(font1);
        frm1.add(jLabel7);
 
        jLabel8 = new JLabel("[���ֵ�] [80����]         [100����]    [90����]  [130����]     [100����]   [140����]");
        jLabel8.setFont(font1);
        frm1.add(jLabel8);
 
        jLabel9 = new JLabel("[�õ��] [50����]          [70����]    [60����]   [90����]      [70����]   [100����]");
        jLabel9.setFont(font1);
        frm1.add(jLabel9);
 
        jLabel10 = new JLabel("[����]   [70����]         [110����]   [100����]  [140����]     [110����]   [150����]");
        jLabel10.setFont(font1);
        frm1.add(jLabel10);
 
        jLabel11 = new JLabel("[�ĸ�]   [75����]             [120����]   [110����]  [150����]     [120����]   [160����]");
        jLabel11.setFont(font1);
        frm1.add(jLabel11);
 
        jLabel12 = new JLabel("[�θ�]   [85����]             [125����]   [120����]  [160����]     [130����]   [170����]");
        jLabel12.setFont(font1);
        frm1.add(jLabel12);
 
        jLabel13 = new JLabel("[����]   [90����]             [130����]   [130����]  [170����]     [140����]   [180����]");
        jLabel13.setFont(font1);
        frm1.add(jLabel13);
 
        jLabel14 = new JLabel("[����]  [100����]             [140����]   [140����]  [180����]     [150����]   [190����]");
        jLabel14.setFont(font1);
        frm1.add(jLabel14);
 
        jLabel15 = new JLabel("[LA]    [110����]             [150����]   [150����]  [190����]     [160����]   [200����]");
        jLabel15.setFont(font1);
        frm1.add(jLabel15);
 
        jLabel16 = new JLabel("[����]  [120����]             [160����]   [160����]  [200����]     [170����]   [200����]");
        jLabel16.setFont(font1);
        frm1.add(jLabel16);
 
        frm1.setVisible(true);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public int diceNum(){
        int dice = diceNumber;
        diceNumber=0;
        return dice;
        
    }
}
