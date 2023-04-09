package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn,btn1,btn2;
    Intent intent;
    Bundle bundle1,bundle2;
    EditText text,text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button1);
        btn1=findViewById(R.id.button2);
        btn2=findViewById(R.id.button3);
        intent=new Intent();
        bundle1=new Bundle();
        text=findViewById(R.id.editText);
        text1=findViewById(R.id.editText1);

        bundle2=this.getIntent().getExtras();
        if(bundle2!=null)
        {
            String str=bundle2.getString("text");
            String str1=bundle2.getString("text1");
            text.setText(str);
            text1.setText(str1);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(MainActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle1.putString("text",text.getText().toString());
                bundle1.putString("text1",text1.getText().toString());
                intent.putExtras(bundle1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
                text1.setText("");
            }
        });
    }
}