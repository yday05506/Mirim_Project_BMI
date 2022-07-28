package kr.hs.emirim.s2106.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName, editKg, editHeight;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnResult = findViewById(R.id.btn_result);
        editName = findViewById(R.id.edit_name);
        editKg = findViewById(R.id.edit_kg);
        editHeight = findViewById(R.id.edit_height);
        btnResult.setOnClickListener(btnResultListener);
    }

    View.OnClickListener btnResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Class c = null;
            switch (btnResult.getId()) {
                case R.id.btn_result:
                    c = ResultActivity.class;
                    break;
            }
            Intent intent = new Intent(getApplicationContext(), c);
            intent.putExtra("성명", editName.getText().toString());
            intent.putExtra("체중", editKg.getText().toString());
            intent.putExtra("키", editHeight.getText().toString());
            startActivity(intent);
        }
    };
}