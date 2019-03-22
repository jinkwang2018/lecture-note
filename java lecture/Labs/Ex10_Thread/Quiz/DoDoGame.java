package Quiz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class DoDoGame extends JFrame{
    private JButton btnStart = null; //���۹�ư
    private Mole[][] btnMole = null; //�δ��� ��ư
    
    public DoDoGame(){
        //����â �����
        createWindow();
    }
    
    /**
     * ����â �����
     */
    private void createWindow(){
        //window ����
        this.setTitle("�δ��� ����");        //â ���� ����
        this.setSize(300,350);            //â ũ�� ����
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //â���� x ��ư ������ �����ϵ��� ������
        
        //���̾ƿ� �����ϱ�
        makeLayout();
    }
    
    /**
     * ���̾ƿ� �����ϱ�
     */
    private void makeLayout()
    {
        //Panel�� ����� ���̾ƿ��� BorderLayout���� ����(Swing)
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        
        //���� ��ư ����
        btnStart = new JButton("����");
        //���۹�ư �̺�Ʈ ����
        btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                //���۹�ư�� ������ ��� �δ��� ��� ����
                start();
            }
        });
        //���۹�ư �� ���� ��ġ
        jp.add(btnStart,"North");
        
        //��ư ���� ��� ����3, ����3ĭ�� GridLayout���� ����
        JPanel btnArea = new JPanel(new GridLayout(3,3));
        
        
        //�δ��� ��ư �����ؼ� ��ư������ �߰�
        btnMole = new Mole[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                btnMole[i][j] = new Mole((i*3)+j);
                btnArea.add(btnMole[i][j]);
            }
        }
        
        //��ư ������ ȭ�� ����� ��ġ
        jp.add(btnArea, "Center");
        //â�� ��ü �г� �߰�
        this.add(jp);
        //����â�� ���̰� ����
        this.setVisible(true);
    }
    
    /**
     * �δ��� ��� ����
     */
    private void start(){
        //���۹�ư ��Ȱ��ȭ
        btnStart.setEnabled(false);
        
        //������ �δ��� Thread (Mole) start 
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                //Mole�� Runnable�� ������ ��ü�̹Ƿ� Thread�� ���� ������
                Thread t = new Thread(btnMole[i][j]);
                t.start();
            }
        }
    }
}