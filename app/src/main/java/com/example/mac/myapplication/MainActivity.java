package com.example.mac.myapplication;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    public TextView scView;
    public TextView textView;
    public int n;
    public int score = 0;
    public Button button;


    private int rn(){
        Random random  = new Random();
        int  x= random.nextInt(100);
        return x;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.hard){
            Intent hard = new Intent(this,Main2Activity.class);
            startActivity(hard);

        }
        if (item.getItemId()==R.id.main1){
            Intent main1 = new Intent(this,Main5Activity.class);
            startActivity(main1);

        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView3);
        n= rn();
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scView = findViewById(R.id.textView4);
                EditText editText = findViewById(R.id.textView);
                String n1 = editText.getText().toString();


                try{
                    int n2 = Integer.parseInt(n1);
                    if (n2 > n && n2-n > 10 ){
                        textView.setText("猜大了，坤坤对你很失望！扣一分");
                        score--;
                        scView.setText("得分：" + score);

                    }
                    else if (n2 < n && n-n2 >10){
                        textView.setText("猜小了，坤坤对你很失望！扣一分");
                        score--;
                        scView.setText("得分：" + score);

                    }
                    else if(n2 > n && n2-n <= 10){
                        textView.setText("猜大了但是很接近了！还是扣一分");
                        score--;
                        scView.setText("得分：" + score);
                    }
                    else if(n2 < n && n-n2 <= 10){
                        textView.setText("猜小了但是很接近了！还是扣一分");
                        score--;
                        scView.setText("得分：" + score);
                    }
                    else {
                        textView.setText("恭喜你，蔡徐坤！");
                        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("恭喜你，蔡徐坤！");
                        builder.setMessage("是否继续蔡徐坤的挑战？“好的”保留分数进入下一轮，“不行”分数清零重新开始");
                        builder.setCancelable(false);
                        builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                score += 10;
                                scView.setText("得分：" + score);

                                if(score >= 20){
                                    textView.setText("你赢了！不如去挑战一下hard模式？");
                                }
                                else {
                                    textView.setText("下一轮挑战开始，律师函上的数字刷新了！");
                                }
                            }
                        });
                        builder.setNegativeButton("不行", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                score = 0;
                                scView.setText("得分：" + score);
                                textView.setText("游戏已经重新开始，律师函上的数字刷新了！");

                            }
                        });
                        builder.show();
                        n = rn();
                    }
                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("要猜数字！");
                    builder.setCancelable(false);
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }

            }
        });

    }








}
