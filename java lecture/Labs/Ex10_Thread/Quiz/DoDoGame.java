package Quiz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class DoDoGame extends JFrame{
    private JButton btnStart = null; //시작버튼
    private Mole[][] btnMole = null; //두더지 버튼
    
    public DoDoGame(){
        //게임창 만들기
        createWindow();
    }
    
    /**
     * 게임창 만들기
     */
    private void createWindow(){
        //window 설정
        this.setTitle("두더쥐 게임");        //창 제목 설정
        this.setSize(300,350);            //창 크기 설정
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //창에서 x 버튼 누르면 종료하도록 설정함
        
        //레이아웃 설정하기
        makeLayout();
    }
    
    /**
     * 레이아웃 설정하기
     */
    private void makeLayout()
    {
        //Panel을 만들고 레이아웃은 BorderLayout으로 설정(Swing)
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        
        //시작 버튼 생성
        btnStart = new JButton("시작");
        //시작버튼 이벤트 설정
        btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                //시작버튼을 눌렀을 경우 두더지 잡기 시작
                start();
            }
        });
        //시작버튼 맨 위에 배치
        jp.add(btnStart,"North");
        
        //버튼 영역 잡고 가로3, 세로3칸의 GridLayout으로 설정
        JPanel btnArea = new JPanel(new GridLayout(3,3));
        
        
        //두더지 버튼 생성해서 버튼영역에 추가
        btnMole = new Mole[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                btnMole[i][j] = new Mole((i*3)+j);
                btnArea.add(btnMole[i][j]);
            }
        }
        
        //버튼 영역은 화면 가운데에 배치
        jp.add(btnArea, "Center");
        //창에 전체 패널 추가
        this.add(jp);
        //게임창이 보이게 설정
        this.setVisible(true);
    }
    
    /**
     * 두더지 잡기 시작
     */
    private void start(){
        //시작버튼 비활성화
        btnStart.setEnabled(false);
        
        //각각의 두더지 Thread (Mole) start 
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                //Mole이 Runnable을 구현한 객체이므로 Thread를 통해 실행함
                Thread t = new Thread(btnMole[i][j]);
                t.start();
            }
        }
    }
}