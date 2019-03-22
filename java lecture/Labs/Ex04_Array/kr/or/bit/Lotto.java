package kr.or.bit;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
//2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요
//3. 배열에 있는 6개의 값을 낮은 순으로 정렬시키세요
//4. 로또 배열의 평균이 30~35 사이가 아닌경우 재추출
//위에서 만드시 내용을 class 설계하세요
//member field , method (기능) , 메뉴 

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
            String selection = showMenu(scanner); //showMenu 함수 호출
            switch(selection)
            {
                case "1" : 
                    do{
                        //실번호 추출
                        selectBasicNumber(r,numbers); //selectBasicNumber 호출
                    }
                    while(!checkAverage(numbers)); //
                    showNumbers(numbers); //화면에 출력
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
    //번호 추출(중복값 배제 함수)
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
    //출력(기능)
    private void showNumbers(int[] numbers)
    {
        System.out.println("선택한 번호 : ");
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length ; i++)
        {
            System.out.printf("[%2d]",numbers[i]);
        }
        System.out.println();
    }
    //검증(기능 함수)
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
        //System.out.println("평균 : " + average);
        
        return (average >=5 && average <=10);    // 5,6,7,8,9,10 => true    
    }
    //메뉴 설정 기능(함수)
    private  String showMenu(Scanner scanner)
    {        
        System.out.println("******************************");
        System.out.println("1. 당첨 예상 번호 추출 : ");
        System.out.println("2. 종료.^^");
        System.out.println("******************************");
        System.out.print("원하는 작업을 번호를 선택 :");
        String selection =     scanner.nextLine();
        return selection;
    }
} 