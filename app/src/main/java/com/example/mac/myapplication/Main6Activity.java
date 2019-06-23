package com.example.mac.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class Main6Activity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioButton g1_radio1;
    private RadioButton g1_radio2;
    private RadioButton g1_radio3;
    private RadioButton g2_radio1;
    private RadioButton g2_radio2;
    private RadioButton g2_radio3;
    private Button buttonOk;
    private TextView textView;
    private EditText editText1;
    private EditText editText2;

    private String str_result1 = "石头";
    private String str_result2 = "石头";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
//        textView.setText("测试结果");

        //2.找到相对应的控件
        _FindView();
        //3.设置监听器
        radioGroup1.setOnCheckedChangeListener(new _RadioGroupListener1());
        radioGroup2.setOnCheckedChangeListener(new _RadioGroupListener2());
        buttonOk.setOnClickListener(new _ButtonClickListener());
    }
    private void _FindView(){
        radioGroup1 = findViewById(R.id.L6_radioGroup1);
        radioGroup2 = findViewById(R.id.L6_radioGroup2);
        g1_radio1 = findViewById(R.id.L6_g1_radiobt1);
        g1_radio2 = findViewById(R.id.L6_g1_radiobt2);
        g1_radio3 = findViewById(R.id.L6_g1_radiobt3);
        g2_radio1 = findViewById(R.id.L6_g2_radiobt1);
        g2_radio2 = findViewById(R.id.L6_g2_radiobt2);
        g2_radio3 = findViewById(R.id.L6_g2_radiobt3);
        buttonOk = findViewById(R.id.L6_buttonOK);
        textView = findViewById(R.id.L6_textResult);
        editText1 = findViewById(R.id.L6_edit1);
        editText2 = findViewById(R.id.L6_edit2);

        //默认选择一个，不然在没有选择的情况下会闪退
        g1_radio1.setChecked(true);
        g2_radio1.setChecked(true);

    }

    //RadioGroup1监听函数
    class _RadioGroupListener1 implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(g1_radio1.isChecked())   str_result1 = "石头";
            else if(g1_radio2.isChecked())  str_result1 = "剪刀";
            else if(g1_radio3.isChecked())  str_result1 = "布";
        }
    }

    //RadioGroup2监听函数
    class _RadioGroupListener2 implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(g2_radio1.isChecked())   str_result2 = "石头";
            else if(g2_radio2.isChecked())   str_result2 = "剪刀";
            else if(g2_radio3.isChecked())  str_result2 = "布";
        }
    }

    //按键监听函数
    class _ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String result = null;
            if(str_result1 == "石头"){
                if(str_result2 == "石头") result = "打平手！";
                else if(str_result2 == "剪刀")    result = "A赢了！";
                else if(str_result2 == "布")  result = "B赢了！";
            }
            else if(str_result1 == "剪刀") {
                if (str_result2 == "石头") result = "B赢了！";
                else if (str_result2 == "剪刀") result = "打平手！";
                else if (str_result2 == "布") result = "A赢了！";

            }
            else if(str_result1 == "布"){
                if (str_result2 == "石头") result = "A赢了！";
                else if (str_result2 == "剪刀") result = "B赢了！";
                else if (str_result2 == "布") result = "打平手！";
            }


            String UserA = editText1.getText().toString();
            String UserB = editText2.getText().toString();
            String winner = null;
            System.out.println("UserName = " + UserA + ",UserNameB = " + UserB + ",winner = " + winner);

            //判断有没有正确的输入用户名
            //if(UserA == null || UserB == null)
            //if(UserA == ""   && UserB == ""  )
            //用上面两个方法行不通都不好用
            //所以换成通过判断字符串长度来判定字符串为空
            if(UserA.length() == 0 || UserB.length()==0) {
                System.out.println("还没有输入姓名");
                Toast.makeText(Main6Activity.this,"请输入姓名",Toast.LENGTH_LONG).show();
            }
            else {

//              if(result == "A赢了！")    winner = editText1.getText().toString();
//              else if(result == "B赢了！")   winner = editText2.getText().toString();
                //用下面contains文本包含更方便快捷 也不容易出错
                if (result.contains("A")) winner = UserA + " 赢了";
                else if (result.contains("B")) winner = UserB + "赢了";
                else winner = "打平手！";

                textView.setText(winner);
                System.out.println(winner);
            }
//
        }
    }
}
