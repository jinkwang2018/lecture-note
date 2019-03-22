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

 }// 생성자 end

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
 } // 시간제한이 끝나지 않았을 때 타이머 쓰레드를 종료.............흠.......... 이게 있어야되겟......

 // inner class Thread ( 한 손님의 제한 시간)
 class Timer1 extends Thread {
  int MenuRecipeNum; // 선택된 메뉴의 재료 갯수로 기본 시간을 주기 위한 변수
  int TimeRan; // 기본시간 + 랜덤으로 인내심 (0~8)
  int runtime; // 남은시간
  
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

 int LevelMenu(int level) { // 레벨에 따라서 불러올 수 있는 메뉴 갯수를 정해줌
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
  // menu 를 NPC클래스 호출시마다 새로 String 배열에 담음 => 근데 배열이 달라지지 않음
  String[] menu = new String[LevelMenu(Level)];
  Iterator it = new Recipe().getMenu_List().keySet().iterator();
  for (int i = 0; i < menu.length; i++) {
   menu[i] = (String) it.next();
   //System.out.println(menu[i]);
  }// menu 에 리스트를 담아줌

  int i = (int) (Math.random() * LevelMenu(Level));// LevelMenu 호출
  // 레벨에 따른 갯수만 가능하게 예) 레벨1 -> menu 배열의 0~4 에서만 랜덤
  // 레벨2 -> menu 배열의 0~6 에서만 랜덤

  return menu[i];
 }
}