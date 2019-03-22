package Quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
 
/**
 * Mole 클래스는 각각의 두더지에 해당함
 * JButton을 상속받아 버튼으로 사용되며 Runnable을 구현하여 쓰레드로도 사용됨
 */
public class Mole extends JButton implements Runnable{
    private boolean isCaught = false;     //잡혔냐
    private boolean isNow = false;         //튀어나온 상태
    
    private int ID = 0;    //각각의 두더지 구분하기 위해 지정함(사용은 안함)
    
    public Mole(int ID){
        this.ID = ID;
        //해당 두더지가 눌렸을 때 이벤트
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //현재 두더지가 나온 상태이며 아직 잡히지 않은 상태에 두더지가 눌린경우
                if(isNow && !isCaught){
                    //잡힌 상태로 바꿈
                    isCaught = true;
                }
            }
        });
    }
    
    @Override
    public void run() {
        
        while(!isCaught){ //잡힐때 까지 계속함
            try {
                //두더지가 언제 튀어나올지 모르도록 랜덤의 시간동안 sleep 시킴
                Thread.sleep(100*((int)(Math.random()*15)+1));
                
                //두더지 나옴 처리
                this.setText("어흥"); //버튼에 "어흥" 이라고 표시
                isNow = true; //지금 나왔음을 표시
                Thread.sleep(500); //두더지는 0.5초동안 나와있음.
                
                //두더지 들어감 처리
                this.setText(""); //버튼의 "어흥"을 지움
                isNow = false; //두더지 들어갔음
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //두더지가 잡혔음을 표시
        this.setText("잡혔다!");
    }
    
    
}
 