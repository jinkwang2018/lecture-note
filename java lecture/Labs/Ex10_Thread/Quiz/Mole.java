package Quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
 
/**
 * Mole Ŭ������ ������ �δ����� �ش���
 * JButton�� ��ӹ޾� ��ư���� ���Ǹ� Runnable�� �����Ͽ� ������ε� ����
 */
public class Mole extends JButton implements Runnable{
    private boolean isCaught = false;     //������
    private boolean isNow = false;         //Ƣ��� ����
    
    private int ID = 0;    //������ �δ��� �����ϱ� ���� ������(����� ����)
    
    public Mole(int ID){
        this.ID = ID;
        //�ش� �δ����� ������ �� �̺�Ʈ
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //���� �δ����� ���� �����̸� ���� ������ ���� ���¿� �δ����� �������
                if(isNow && !isCaught){
                    //���� ���·� �ٲ�
                    isCaught = true;
                }
            }
        });
    }
    
    @Override
    public void run() {
        
        while(!isCaught){ //������ ���� �����
            try {
                //�δ����� ���� Ƣ����� �𸣵��� ������ �ð����� sleep ��Ŵ
                Thread.sleep(100*((int)(Math.random()*15)+1));
                
                //�δ��� ���� ó��
                this.setText("����"); //��ư�� "����" �̶�� ǥ��
                isNow = true; //���� �������� ǥ��
                Thread.sleep(500); //�δ����� 0.5�ʵ��� ��������.
                
                //�δ��� �� ó��
                this.setText(""); //��ư�� "����"�� ����
                isNow = false; //�δ��� ����
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //�δ����� �������� ǥ��
        this.setText("������!");
    }
    
    
}
 