package kr.hs.emirim.s2106.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView textComment;
    double bmi;
    ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        imgV = findViewById(R.id.imgv);
        Intent intent = getIntent();
        textComment = findViewById(R.id.text_result);
        String name = intent.getStringExtra("성명");
        double weight = Double.parseDouble(intent.getStringExtra("체중"));
        double height = Double.parseDouble(intent.getStringExtra("키"));
        bmi = weight / Math.pow(height/100, 2);
        String bmiResult = "";
        if(bmi < 18.5) {
            bmiResult = "저";
            imgV.setImageResource(R.drawable.body_1);
        }
        else if(bmi < 23) {
            bmiResult = "정상";
            imgV.setImageResource(R.drawable.body_2);
        }
        else if(bmi < 27) {
            bmiResult = "과";
            imgV.setImageResource(R.drawable.body_3);
        }
        else if(bmi < 32) {
            bmiResult = "1단계 비만";
            imgV.setImageResource(R.drawable.body_4);
        }
        else if(bmi < 37) {
            bmiResult = "2단계 비만";
            imgV.setImageResource(R.drawable.body_5);
        }
        else {
            bmiResult = "고도비만";
            imgV.setImageResource(R.drawable.body_6);
        }
        textComment.setText(name + "님의 BMI 지수는 " + String.format("%.2f", bmi) + "입니다. \n따라서 " + bmiResult + "체중입니다.");

        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(btnHomeListener);
    }

    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}