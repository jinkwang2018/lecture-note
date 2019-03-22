package I_Love_Coffee;

import java.util.Iterator;

public class NPC {

 String menu;
 Timer1 timer;
 boolean falseOreder;

 NPC(int Level) {
  this.menu = MenuSelect(Level);
  this.timer = new Timer1(menu);
  this.falseOreder = false;
  timer.start();

 }// ������ end

 public void setFalseOreder(boolean falseOreder) {
  this.falseOreder = falseOreder;
 }

 // getter
 public int getTime() {
  return this.timer.runtime;
 }

 public String getMenu() {
  return this.menu;
 }

 public Thread getTimer() {
  return this.timer;
 } // �ð������� ������ �ʾ��� �� Ÿ�̸� �����带 ����.............��.......... �̰� �־�ߵǰ�......

 // inner class Thread ( �� �մ��� ���� �ð�)
 class Timer1 extends Thread {
  int MenuRecipeNum; // ���õ� �޴��� ��� ������ �⺻ �ð��� �ֱ� ���� ����
  int TimeRan; // �⺻�ð� + �������� �γ��� (0~8)
  int runtime; // �����ð�
  
  Timer1(String menu) {
   MenuRecipeNum = new Recipe().getMenu_List().get(menu).size();
   TimeRan = (int) (Math.random() * 5+5) + MenuRecipeNum;
   runtime = TimeRan;
  }

  public void run() {
	  System.out.println("run start" + this.toString());
   for (int i = TimeRan; i >= 0; i--) {
    if(falseOreder == true){
        i = 0;
        break;
    }
    runtime = i;
    try {
     Thread.sleep(1000);
    } catch (InterruptedException e) {
     e.printStackTrace();
    }
   }// for end
   System.out.println("run end" + this.toString());
  }// run end
 }

 int LevelMenu(int level) { // ������ ���� �ҷ��� �� �ִ� �޴� ������ ������
  int result = 0;
  switch (level) {
  case 1:
   result = 8;
   break;
  case 2:
   result = 10;
   break;
  case 3:
   result = 12;
   break;
  case 4:
   result = 14;
   break;
  case 5:
   result = 16;
   break;
  case 6:
   result = 17;
   break;
  case 7:
   result = 18;
   break;
  case 8:
   result = 19;
   break;
  case 9:
   result = 20;
   break;
  case 10:
   result = 20;
   break;
  }
  return result;
 }

 String MenuSelect(int Level) {
  // menu �� NPCŬ���� ȣ��ø��� ���� String �迭�� ���� => �ٵ� �迭�� �޶����� ����
  String[] menu = new String[LevelMenu(Level)];
  Iterator it = new Recipe().getMenu_List().keySet().iterator();
  for (int i = 0; i < menu.length; i++) {
   menu[i] = (String) it.next();
   //System.out.println(menu[i]);
  }// menu �� ����Ʈ�� �����

  int i = (int) (Math.random() * LevelMenu(Level));// LevelMenu ȣ��
  // ������ ���� ������ �����ϰ� ��) ����1 -> menu �迭�� 0~4 ������ ����
  // ����2 -> menu �迭�� 0~6 ������ ����

  return menu[i];
 }
}