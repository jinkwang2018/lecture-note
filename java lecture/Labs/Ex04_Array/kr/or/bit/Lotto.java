package kr.or.bit;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//1. 1~45������ ������ �߻����� 6���� �迭�� ��������
//2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�
//3. �迭�� �ִ� 6���� ���� ���� ������ ���Ľ�Ű����
//4. �ζ� �迭�� ����� 30~35 ���̰� �ƴѰ�� ������
//������ ����� ������ class �����ϼ���
//member field , method (���) , �޴� 

public class Lotto {
    private Scanner scanner;
    private Random r;
    private int[] numbers;
 
    public Lotto(){
        scanner = new java.util.Scanner(System.in);
        r = new java.util.Random();
        numbers = new int[6];
    }
    
    public void SelectLottoNumber(){
        loop1 : while(true)
        {
            //menu show 
            String selection = showMenu(scanner); //showMenu �Լ� ȣ��
            switch(selection)
            {
                case "1" : 
                    do{
                        //�ǹ�ȣ ����
                        selectBasicNumber(r,numbers); //selectBasicNumber ȣ��
                    }
                    while(!checkAverage(numbers)); //
                    showNumbers(numbers); //ȭ�鿡 ���
                    break;
                case "2" :
                    System.out.println("Good lucky");
                    break loop1;
                default :
                    System.out.println("Not Operation");
                    break;
            }    
        }
    }
    //��ȣ ����(�ߺ��� ���� �Լ�)
    private void selectBasicNumber(java.util.Random r ,int[] numbers)
    {
        for(int i = 0 ; i < numbers.length ; i++)
        {
            numbers[i] = r.nextInt(45) + 1;
            for(int j = 0 ; j <i ; j++)
            {
                if(numbers[i] == numbers[j]){
                    i--; //key point 
                    break;
                }
            }
            
        }
    }
    //���(���)
    private void showNumbers(int[] numbers)
    {
        System.out.println("������ ��ȣ : ");
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length ; i++)
        {
            System.out.printf("[%2d]",numbers[i]);
        }
        System.out.println();
    }
    //����(��� �Լ�)
    private  boolean checkAverage(int[] numbers)
    {
        int sum;
        int average;
        sum =0;
        for(int i =0 ; i < numbers.length ; i++)
        {
            sum += numbers[i];
        }
        average = sum/numbers.length;
        //System.out.println("��� : " + average);
        
        return (average >=5 && average <=10);    // 5,6,7,8,9,10 => true    
    }
    //�޴� ���� ���(�Լ�)
    private  String showMenu(Scanner scanner)
    {        
        System.out.println("******************************");
        System.out.println("1. ��÷ ���� ��ȣ ���� : ");
        System.out.println("2. ����.^^");
        System.out.println("******************************");
        System.out.print("���ϴ� �۾��� ��ȣ�� ���� :");
        String selection =     scanner.nextLine();
        return selection;
    }
} 