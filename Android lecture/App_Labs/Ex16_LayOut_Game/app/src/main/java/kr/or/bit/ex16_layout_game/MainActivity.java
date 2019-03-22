package kr.or.bit.ex16_layout_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final int DIALOG_NEW_YES_NO = 1;

    TextView tvResult;
    TextView TextViewValue[] = new TextView[3];
    int com_Array[] = new int[3];
    int resut_arr[] = new int[3];
    int play_cnt, inputPos;
    boolean isPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewValue[0] = (TextView) findViewById(R.id.TextViewValue1);
        TextViewValue[1] = (TextView) findViewById(R.id.TextViewValue2);
        TextViewValue[2] = (TextView) findViewById(R.id.TextViewValue3);
        tvResult = (TextView) findViewById(R.id.TextViewAttack2);

        // 초기화
        init_com();

    }


    // <- 백스페이스 버튼이 클릭되었을때 호출되는 메서드
    public void clickBtnDelListener(View target) {

		/*
		* for(int i=2;i>=0;i--){
		  	if(TextViewValue[i].getText().toString().trim().length()==1){
		  		TextViewValue[i].setText(" "); break;
		  	}
		  }
		 */

		/*
		  if(TextViewValue[2].getText().toString().trim().length()==1){
		  	TextViewValue[2].setText(" ");
		  }else if(TextViewValue[1].getText().toString().trim().length()==1){
		  	TextViewValue[1].setText(" ");
		  }else if(TextViewValue[0].getText().toString().trim().length()==1){
		  	TextViewValue[0].setText(" ");
		  }
		 */

        if (inputPos > 0) {
            if (TextViewValue[--inputPos].getText().toString().trim().length() == 1) {
                TextViewValue[inputPos].setText(" ");
            }
        }
    }

    //숫자 버튼을 클릭되었을때 호출되는 메서드
    public void clickBtnNumListener(View target) {

        Button btnNum = ((Button) target);
        String strNum = btnNum.getText().toString();

		/*
		for (TextView v : TextViewValue) {
			if (v.getText().toString().trim().equals(strNum)) {
				return;
			}
		}*/

        // TextViewValue[0].setText(strNum);

		/*
		if (TextViewValue[0].getText().toString().trim().length() != 1) {
			TextViewValue[0].setText(strNum);
		} else if (TextViewValue[1].getText().toString().trim().length() != 1) {
			TextViewValue[1].setText(strNum);
		} else if (TextViewValue[2].getText().toString().trim().length() != 1) {
			TextViewValue[2].setText(strNum);
			Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
					Toast.LENGTH_SHORT).show();
		}*/


        if (isPlay) {
            if (inputPos < 3) {

                for (TextView v : TextViewValue) {
                    if (v.getText().toString().trim().equals(strNum)) {
                        return;
                    }
                }
                TextViewValue[inputPos].setText(strNum);
                inputPos++;

            } else {
                Toast.makeText(getApplicationContext(), "공격버튼을 눌러주세요",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
                    Toast.LENGTH_SHORT).show();
        }

    }

    //새게임 버튼이 클릭되었을때 호출되는 메서드
    public void clickBtnNewListener(View target) {
        init_com();
    }


    //게임 초기화
    public void init_com() {

        play_cnt = 0; // 공격횟수 초기화;
        for (TextView v : TextViewValue) {
            v.setText(" ");
        }
        // 중복되지 않는 3개의 난수 저장.
        int i = 0;
        do {
            // int r = (int)(Math.random()*9)+1;
            int r = (int) (Math.random() * 10);
            com_Array[i] = r;

            for (int j = 0; j < i; j++) { // 중복되는 값 검사.
                if (com_Array[i] == com_Array[j]) {
                    i--; // 중복값이 있으면 i변수를 -1.
                    break; // 반복문 종료
                }// if
            }// for

            i++;

        } while (i < 3); // 3회전

        // 기존에 있는 결과값 클리어
        tvResult.setText("");
        // tvResult.append(Arrays.toString(com_Array));
        tvResult.append("\n");
        tvResult.setText("새 게임을 시작합니다.\n");
        tvResult.append("공격할 숫자 3개를 선택하시고 [공격] 버튼을 눌러주세요!\n");
        inputPos = 0;
        play_cnt = 0;
        isPlay = true;

    }


    //공격버튼을 눌렀을때 호출되는 메서드
    public void attack(View target) {

        resut_arr = new int[3]; // 결과 초기화

        if (isPlay) {
            // 입력값 체크 (입력받은 숫자가 3개가 아니면 메시지창 출력)
            if (inputPos != 3) {
                Toast.makeText(getApplicationContext(), "공격할 숫자 3개를 선택해주세요!",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            int user_Array[] = new int[3];
            for (int i = 0; i < TextViewValue.length; i++) {
                user_Array[i] = Integer.parseInt(TextViewValue[i].getText()
                        .toString());
            }

            // 결과 검사
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (com_Array[i] == user_Array[j]) {
                        if (i == j) { // 서로 같은 숫자가 있고 그 숫자의 자리가 같으면 스트라이크 처리
                            resut_arr[0]++; // 스트라이크
                        } else { // 서로 같은 숫자가 있고 그 숫자의 자리가 다르면 볼 처리
                            resut_arr[1]++; // 볼
                        }// if
                    }// if
                }// for
            }// for

            // 아웃 계산
            resut_arr[2] = 3 - (resut_arr[0] + resut_arr[1]); // 아웃!

            // 입력값을 표시하는 텍스트필드 초기화
            for (TextView v : TextViewValue) {
                v.setText(" ");
            }
            inputPos = 0;

            play_cnt++;// 플레이 카운트 증가

            // 결과값 출력
            String strResult = play_cnt + "회전: " + Arrays.toString(user_Array)
                    + "  " + resut_arr[0] + " Strike!!   " + resut_arr[1]
                    + " Ball!!   " + resut_arr[2] + " Out!! \n";

            //tvResult.append(strResult);
            appendResult(strResult);


            if (resut_arr[0] == 3) {

				/*
				  Toast.makeText(getApplicationContext(), "You Win!!",
				  Toast.LENGTH_SHORT).show();
				 */
                //tvResult.append("You Win!!\n\n");

                appendResult("You Win!!\n\n");
                isPlay = false;
                dialogNewGame("You Win!!").show();

            }// if

            if (play_cnt == 9) { // 한경기에 9회전까지
				/*
				 Toast.makeText(getApplicationContext(), "You Lose!!",
				 Toast.LENGTH_SHORT).show();
				 */
                //tvResult.append("You Lose!!\n\n");
                // showDialog(DIALOG_NEW_YES_NO);

                appendResult("You Lose!!\n\n");
                isPlay = false;
                dialogNewGame("You Lose!!").show();

            }// if

            //ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
            //result_scrollView.scrollTo(0, tvResult.getHeight());

        } else {
            Toast.makeText(getApplicationContext(), "게임을 새로 시작해주세요!",
                    Toast.LENGTH_SHORT).show();
        }//if




    }//attack();


    //결과 뷰에 결과 출력
    public void appendResult(String str){
        tvResult.append(str);
        ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
        result_scrollView.scrollTo(0, tvResult.getHeight());
    }



    //대화상자 생성
    public Dialog dialogNewGame(String result) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결과")
                .setMessage(result + "\n게임을 새로 시작하시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("예", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        init_com();

                    }

                })
                .setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                ScrollView result_scrollView = (ScrollView) findViewById(R.id.result_scrollView);
                                result_scrollView.scrollTo(0, tvResult.getHeight());
                                dialog.cancel();
                            }

                        });

        AlertDialog alert = builder.create();

        return alert;
    }

}
