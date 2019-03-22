package Quiz;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Weight_Manager {
    public Scanner keyboard = new Scanner(System.in);
    public String str_name="�⺻��";
    public String str_weight="�⺻��";
    public String str_password="�⺻��";
    String[] txt_data=null;
    File f;
    File fd= new File("C://WeightMgData/"); //������ �����ɰ�
   
    public static void main(String[] args) {
    	Weight_Manager wm = new Weight_Manager();
        int choiceInt;
       
        while (true) {
 
            try {
                wm.showMenu();
                choiceInt = wm.keyboard.nextInt();
                wm.keyboard.nextLine(); //?���� �Է��� ���� ����
                System.out.println();
 
                if (choiceInt < 1 || choiceInt > 5) // �־��� �޴��� ������ �����
                    throw new MenuChoiceException(choiceInt); // �����س��� Exception�߻�
 
                switch (choiceInt) {
                case 1: wm.inputWeight();break;
                case 2: wm.searchWeight();break;
                case 3: wm.changeWeight();break;
                case 4: wm.changePassword();break;
                case 5:
                    System.out.println("���α׷��� �����մϴ�.");
                    return;
                    // System.exit(0);
                }// switch�� �ݱ�
            } catch (MenuChoiceException e) {
                e.showWrongChoice();
                System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.");
                System.out.println();
           
            } catch(IOException e){
                System.out.println(e + "�����߻�");
               
            } catch(Exception e){
                 String temp = wm.keyboard.nextLine();  //���Է��� ���� Ű����� �Է¹��� ���� ���ڷ� �ٽ� ����
                 System.out.println("�Է��Ͻ� "+temp+"�� ���ڰ� �ƴմϴ�.");
                System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.");
                System.out.println();
            }// catch���ݱ�
 
        }// while�� �ݱ�
    }
 
    //===========================================�޴��� �����ִ� �޼���
    public void showMenu() {
       
        str_name="�⺻��";
        str_weight="�⺻��";
        str_password="�⺻��";
       
        System.out.println("\n���� ���׿� �°� �Է��Ͽ� �ֽʽÿ�");
        System.out.println("======> ������ �Է���  1��");
        System.out.println("======> ������ �˻���  2��");
        System.out.println("======> ������ ������  3��");
        System.out.println("======> ��й�ȣ������ 4��");
        System.out.println("======> ���α׷������ 5��");
        System.out.println("�� �Է����� Enter�� �����ֽʽÿ�");
        System.out.print("�޴� ���� : ");
    }
    //==============================================================
 
    //===============================================//������ �Է��ϱ�
    public void inputWeight() throws IOException{
        boolean fileExist;
       
        System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�.");
        System.out.print("�̸� : "); 
        this.str_name = keyboard.nextLine();
        System.out.println();
       
        File f= new File("C://WeightMgData/"+this.str_name+".txt"); //����� ���ϰ�ü ����
        if( !f.exists()){      
       
            System.out.println("�����Ը� �Է��Ͽ� �ֽʽÿ�.");
            System.out.print("������ : ");
            this.str_weight = keyboard.nextLine();
            System.out.println();
            System.out.println("��й�ȣ�� �Է��Ͽ� �ֽʽÿ�.");
            System.out.print("��й�ȣ : ");
            this.str_password = keyboard.nextLine();
            System.out.println();
           
            showResult(); //�Է��� �� �����ֱ�
               
            //File fd= new File("C://WeightMgData/");
            //File f= new File("C://WeightMgData/"+this.str_name+".txt"); //���ϻ���
            if (!fd.exists()) fd.mkdir(); // C://WeightMgData/���� ����
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.str_weight+":");  //������ ���Ͽ� ����
            bw.write(this.str_password);
           
            bw.close();
            System.out.println("___�Է��� �Ϸ�Ǿ�_..[ C://WeightMgData/"+this.str_name+".txt ]._��(��) �����Ǿ����ϴ�.");
        }else{
            System.out.println("���� ["+this.str_name+"] ����ڰ� �����մϴ�.");
            System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.");
            System.out.println();
        }
           
    }//inputWeight�ݱ�
 
   
    //===============================================//������ �˻��ϱ�
    public void searchWeight() throws IOException{
 
        boolean passcheck = fileCheck();
       
        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t" + this.str_name + "���� �����Դ� "+ txt_data[0] + " kg �Դϴ�.");
            System.out.println("*****************************************************************");
            System.out.println();
       
        } else {
                return;        
        }
        System.out.println();
    }//searchWeight() �ݱ�
   
    //===============================================//������ �����ϱ�
    public void changeWeight() throws IOException{
               
        boolean passcheck = fileCheck();       
       
        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t"+this.str_name+"���� �����Դ� "+this.txt_data[0]+" kg �Դϴ�.");
            System.out.println("*****************************************************************");
            System.out.println("\t\t������ �����Ը� �Է��Ͽ� �ֽʽÿ�.");
            System.out.print("\t\t������ ������ : ");
            this.str_weight = keyboard.nextLine();
           
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            //int str_num = txt_data[1].length();
            //System.out.println(str_num);
            bw.write(this.str_weight+":");
            //bw.write(this.str_weight, 1, str_num-1);
            bw.write(this.str_password);
           
            bw.close();            
        }else{
            return;        
        }
       
        showResult();
       
    }//changeWeight() �ݱ�
   
    //===============================================//�н����� �����ϱ�   
    public void changePassword() throws IOException{
 
        boolean passcheck = fileCheck();       
       
        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t"+this.str_name+"���� ��й�ȣ�´� "+this.str_password+" �Դϴ�.");
            System.out.println("*****************************************************************");
            System.out.println("\t\t������ �н����带 �Է��Ͽ� �ֽʽÿ�.");
            System.out.print("\t\t������ �н����� : ");
            this.str_password = keyboard.nextLine();
           
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.str_weight+":");
            bw.write(this.str_password);
            bw.close();    
           
        }else{
            return;        
        }  
       
        showResult();
       
    }//changePassword()�ݱ�
   
    public boolean fileCheck() throws IOException{  
        //�˻�, ������ ����, �н����� ����� �Է¹��� �̸��� ���� �������翩��üũ ,�Է¹��� �н����忡 ���� üũ
        FileReader fr=null;
        BufferedReader br=null;
        String cmp_data;        //txt���Ͽ��� ���� �о����
        boolean boo = false;    //���� üũ
       
        System.out.println("�˻��� �̸��� �Է��Ͽ� �ֽʽÿ�.");
        System.out.print("�̸� : ");
        this.str_name = keyboard.nextLine();   
        System.out.println();
       
        f= new File(fd.getAbsolutePath()+"/"+this.str_name+".txt"); //�Է¹����̸����� ���ϰ�� ����
       
        if(f.exists()){ //������ �����ϸ�
            fr= new FileReader(f);  //���� ���� �غ�
            br= new BufferedReader(fr);
            cmp_data = br.readLine(); //�о�� ���Ͽ��� ������ cmp_data�� �����Ѵ�.
            txt_data = cmp_data.split(":"); // ':' �� �ɰ� txt_data�迭�� ����
            //System.out.println(txt_data.length); //txt_data�迭 ũ�� ����
            br.close(); //�ݱ�   
                       
           
           
            //int cnt = 2;  //��й�ȣ üũ�� 3ȸ�� �Ѵ�.
            //while(cnt>0){
            for( int cnt = 3;cnt>0;cnt--){ 
               
                System.out.println("��й�ȣ�� �Է��Ͽ� �ֽʽÿ�.");
                System.out.print("��й�ȣ : ");
                this.str_password = keyboard.nextLine();
                System.out.println();
               
                if (txt_data[1].equals(this.str_password)) {
                    this.str_weight = txt_data[0];
                    boo =  true;
                    break;
                } else {
                   
                    if(cnt > 1) {
                    System.out.println("�Է��Ͻ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
                    System.out.print((cnt-1) + "���� ��ȸ�� ���ҽ��ϴ�. �ùٸ� ");
                    }else{
 
                    System.out.println("�Է��Ͻ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
                    System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.");
                    System.out.println("======================================");
                    System.out.println();
                   
                    }
 
                    /*System.out.print("��й�ȣ : ");
                    this.str_password = keyboard.nextLine();
                    --cnt;*/
                }              
            }                              
        }else{//f.getName()
            System.out.println(str_name+"�� ��(��) �������� �ʽ��ϴ�.");
            boo = false;
            }          
        return boo;
    }
   
           
public void showResult(){   //�Է¹��� ���� �����ֱ�
    System.out.println();
    System.out.println("*****************************************************************");
    System.out.println("\t�̸� : "+this.str_name +", \t������ : "+ this.str_weight + ",\t ��й�ȣ : "+this.str_password);
    System.out.println("*****************************************************************");
    System.out.println();
}
   
   
   
}//WeightManagExam000 class�ݱ�
 
 
 
class MenuChoiceException extends Exception { //�߸��� ������ �ϰԵǸ� ������ Exception
    int wrongChoice; // �߸��� �Է°������ϱ� ���� ����
 
    public MenuChoiceException(int choice) // �Է°��� �޴� ������
    {
        super("�߸��� ������ �̷������ϴ�.");
        // Exception(String message)
        wrongChoice = choice; // ���� ���� ���ڰ��� �������� wrongChoice�� ����
    }
 
    public void showWrongChoice() {
        System.out.println(wrongChoice + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
    }
   
 
}// class MenuChoiceException �ݱ�
