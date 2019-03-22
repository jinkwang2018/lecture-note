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
    JFrame frm = new JFrame("주사위"); // 도화지
    ImageIcon ic; // 주사위 사진 이미지
    JLabel lbImage; // 이미지
    JButton button; // 버튼
    int diceNumber; //주사위 랜덤값 저장하는 변수
    boolean check = false; 
    JFrame frm1 = new JFrame("땅 설명서"); // 도화지 땅가격 설명서씀
    public Dice() {
        // 초기에 도화지에 버튼 한개와 주사위 1 이미지 넣음
        frm.setLayout(new FlowLayout());
        ic = new ImageIcon("0.jpg"); // 이미지 1
        lbImage = new JLabel(ic);
        button = new JButton("주사위 굴리기!");
        frm.setSize(350, 400); // 크기 가로 350 ,세로 350
        frm.add(button);
        frm.add(lbImage);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int dice = (int) (Math.random() * 6 + 1); // 랜덤 1~6
                
                ic = new ImageIcon(dice+".png"); // 이미지 1~6까지 랜덤
                lbImage.setIcon(ic);
                frm.setSize(350, 400); // 크기 350, 400
                frm.add(lbImage); // 이미지 추가
                frm.setVisible(true); // player클래스에 있는 move에 함수 1을 넣어줌
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기창
                
                diceNumber = dice; //랜덤값을  diceNumber 변수에 넣어줌
                
            }
        });
        //폰트설정
        Font font = new Font("궁서", Font.BOLD, 20);
        Font font1 = new Font("돋움", Font.PLAIN, 20);
        frm1.setLayout(new FlowLayout(30, 30, 20));
 
        frm1.setSize(800, 850); //크기 가로 800  , 세로  850
        //땅가격 설명서
        JLabel jLabel0,jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11,
                jLabel12, jLabel13, jLabel14, jLabel15, jLabel16;
 
        jLabel0 = new JLabel("[세금] : 100만원, [월급] : 50만원");
        jLabel0.setFont(font);
        frm1.add(jLabel0);
        
        jLabel1 = new JLabel("[도시][땅가격][땅통행료][호텔가격][호텔통행료][빌딩가격][빌딩통행료]");
        jLabel1.setFont(font);
        frm1.add(jLabel1);
 
        jLabel2 = new JLabel("[홍콩]   [10만원]          [30만원]    [20만원]   [40만원]      [30만원]    [55만원]");
        jLabel2.setFont(font1);
        frm1.add(jLabel2);
 
        jLabel3 = new JLabel("[싱가폴] [20만원]          [40만원]    [30만원]   [50만원]      [40만원]    [65만원]");
        jLabel3.setFont(font1);
        frm1.add(jLabel3);
 
        jLabel4 = new JLabel("[아테네] [30만원]          [50만원]    [40만원]   [60만원]      [50만원]    [75만원]");
        jLabel4.setFont(font1);
        frm1.add(jLabel4);
 
        jLabel5 = new JLabel("[베를린] [40만원]          [60만원]    [50만원]   [80만원]      [60만원]    [90만원]");
        jLabel5.setFont(font1);
        frm1.add(jLabel5);
 
 
        jLabel6 = new JLabel("[하와이] [55만원]          [80만원]    [70만원]  [100만원]      [80만원]   [120만원]");
        jLabel6.setFont(font1);
        frm1.add(jLabel6);
 
        jLabel7 = new JLabel("[리스본] [60만원]          [85만원]    [80만원]  [120만원]      [90만원]   [130만원]");
        jLabel7.setFont(font1);
        frm1.add(jLabel7);
 
        jLabel8 = new JLabel("[제주도] [80만원]         [100만원]    [90만원]  [130만원]     [100만원]   [140만원]");
        jLabel8.setFont(font1);
        frm1.add(jLabel8);
 
        jLabel9 = new JLabel("[시드니] [50만원]          [70만원]    [60만원]   [90만원]      [70만원]   [100만원]");
        jLabel9.setFont(font1);
        frm1.add(jLabel9);
 
        jLabel10 = new JLabel("[도쿄]   [70만원]         [110만원]   [100만원]  [140만원]     [110만원]   [150만원]");
        jLabel10.setFont(font1);
        frm1.add(jLabel10);
 
        jLabel11 = new JLabel("[파리]   [75만원]             [120만원]   [110만원]  [150만원]     [120만원]   [160만원]");
        jLabel11.setFont(font1);
        frm1.add(jLabel11);
 
        jLabel12 = new JLabel("[로마]   [85만원]             [125만원]   [120만원]  [160만원]     [130만원]   [170만원]");
        jLabel12.setFont(font1);
        frm1.add(jLabel12);
 
        jLabel13 = new JLabel("[런던]   [90만원]             [130만원]   [130만원]  [170만원]     [140만원]   [180만원]");
        jLabel13.setFont(font1);
        frm1.add(jLabel13);
 
        jLabel14 = new JLabel("[뉴욕]  [100만원]             [140만원]   [140만원]  [180만원]     [150만원]   [190만원]");
        jLabel14.setFont(font1);
        frm1.add(jLabel14);
 
        jLabel15 = new JLabel("[LA]    [110만원]             [150만원]   [150만원]  [190만원]     [160만원]   [200만원]");
        jLabel15.setFont(font1);
        frm1.add(jLabel15);
 
        jLabel16 = new JLabel("[서울]  [120만원]             [160만원]   [160만원]  [200만원]     [170만원]   [200만원]");
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
