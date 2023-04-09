package com.example.myapplication4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class secondActivity extends Activity {
    Button btn4;
    Button btn6,btn5;
    Intent intent2;
    Bundle bundle1;
    EditText text2,text3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        text2= findViewById(R.id.editText2);
        text3= findViewById(R.id.editText3);
        bundle1=this.getIntent().getExtras();
        intent2=new Intent();
        String str=bundle1.getString("text");
        String str1=bundle1.getString("text1");
        text2.setText(str);
        text3.setText(str1);
        btn4=findViewById(R.id.button4);
        btn4.setOnClickListener(new btnclock2());

        btn5=findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle1.putString("text",text2.getText().toString());
                bundle1.putString("text1",text3.getText().toString());
                intent2.putExtras(bundle1);
            }
        });

        btn6=(Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText("");
                text3.setText("");
            }
        });
    }
    class btnclock2 implements View.OnClickListener
    {
        public void onClick(View view)
        {
            intent2.setClass(secondActivity.this,MainActivity.class);
            startActivityForResult(intent2,0);
        }
    }
}
