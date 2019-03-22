package ChattClient;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CreateRoomDisplay extends JDialog implements ActionListener, ItemListener
{
  private ClientThread client;
  private String roomName, str_password;
  private int roomMaxUser, isRock;

  private JFrame main;
  private Container c;
  private JTextField tf;
  private JPanel radioPanel;
  private JRadioButton radio1, radio2, radio3, radio4, rock, unrock;
  private JPasswordField password;
  private JButton ok, cancle;

  public CreateRoomDisplay(JFrame frame, ClientThread client){
    super(frame, true);
    main = frame;
    setTitle("��ȭ�� ����");
    this.client = client;
    isRock = 0;
    roomMaxUser = 2;
    str_password = "0";

    c = getContentPane();
    c.setLayout(null);

    JLabel label;
    label = new JLabel("������");
    label.setBounds(10, 10, 100, 20);
    label.setForeground(Color.blue);
    c.add(label);

    tf = new JTextField();
    tf.setBounds(10, 30, 270, 20);
    c.add(tf);

    label = new JLabel("�ִ��ο�");
    label.setForeground(Color.blue);
    label.setBounds(10, 60, 100, 20);
    c.add(label);

    radioPanel = new JPanel();
    radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
    ButtonGroup group = new ButtonGroup();
    radio1 = new JRadioButton("2��");
    radio1.setSelected(true);
    radio1.addItemListener(this);
    group.add(radio1);
    radio2 = new JRadioButton("3��");
    radio2.addItemListener(this);
    group.add(radio2);
    radio3 = new JRadioButton("4��");
    radio3.addItemListener(this);
    group.add(radio3);
    radio4 = new JRadioButton("5��");
    radio4.addItemListener(this);
    group.add(radio4);
    radioPanel.add(radio1);
    radioPanel.add(radio2);
    radioPanel.add(radio3);
    radioPanel.add(radio4);
    radioPanel.setBounds(10, 80, 280, 20);
    c.add(radioPanel);

    label = new JLabel("��������");
    label.setForeground(Color.blue);
    label.setBounds(10, 110, 100, 20);
    c.add(label);

    radioPanel = new JPanel();
    radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
    group = new ButtonGroup();
    unrock = new JRadioButton("����");
    unrock.setSelected(true);
    unrock.addItemListener(this);
    group.add(unrock);
    rock = new JRadioButton("�����");
    rock.addItemListener(this);
    group.add(rock);
    radioPanel.add(unrock);
    radioPanel.add(rock);
    radioPanel.setBounds(10, 130, 280, 20);
    c.add(radioPanel);

    label = new JLabel("��й�ȣ");
    label.setForeground(Color.blue);
    label.setBounds(10, 160, 100, 20);
    c.add(label);

    password = new JPasswordField();
    password.setBounds(10, 180, 150, 20);
    password.setEditable(false);
    c.add(password);

    ok = new JButton("Ȯ ��");
    ok.setForeground(Color.blue);
    ok.setBounds(75, 220, 70, 30);
    ok.addActionListener(this);
    c.add(ok);

    cancle = new JButton("�� ��");
    cancle.setForeground(Color.blue);
    cancle.setBounds(155, 220, 70, 30);
    cancle.addActionListener(this);
    c.add(cancle);

    Dimension dim = getToolkit().getScreenSize();
    setSize(300, 300);
    setLocation(dim.width/2 - getWidth()/2,
                dim.height/2 - getHeight()/2);
    show();

    addWindowListener(
      new WindowAdapter() {
        public void windowActivated(WindowEvent e) {
          tf.requestFocusInWindow();
        }
      }
    );

    addWindowListener(
      new WindowAdapter(){
        public void windowClosing(WindowEvent e){
          dispose();
        }
      }
    );
  }

  public void itemStateChanged(ItemEvent ie){
    if (ie.getSource() == unrock){
      isRock = 0;
      str_password = "0";
      password.setText("");
      password.setEditable(false);
    } else if (ie.getSource() == rock) {
      isRock = 1;
      password.setEditable(true);
    } else if (ie.getSource() == radio1) {
      roomMaxUser = 2;
    } else if (ie.getSource() == radio2) {
      roomMaxUser = 3;
    } else if (ie.getSource() == radio3) {
      roomMaxUser = 4;
    } else if (ie.getSource() == radio4) {
      roomMaxUser = 5;
    }
  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == ok){
      if(tf.getText().equals("")){
        JOptionPane.showMessageDialog(main, "�������� �Է��ϼ���",
                        "��ȭ�� ����.", JOptionPane.ERROR_MESSAGE);
      } else { 
        roomName = tf.getText();
        if(isRock == 1){
          str_password = password.getText();
        }
        if(isRock ==1 && str_password.equals("")){
          JOptionPane.showMessageDialog(main, "��й�ȣ�� �Է��ϼ���",
                        "��ȭ�� ����.", JOptionPane.ERROR_MESSAGE);
        } else {
          client.requestCreateRoom(roomName, roomMaxUser,
                                   isRock, str_password);
          dispose();
        }
      }
    } else {
      dispose();
    }
  }
}
