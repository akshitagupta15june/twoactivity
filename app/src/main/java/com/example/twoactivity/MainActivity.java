package com.example.twoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.twoactivity.extra.MESSAGE";
    EditText editText_main;
    public  static  final int TEXT_REQUEST=1;
    TextView textmessagereply;
    TextView textheadereply;


    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textheadereply=findViewById(R.id.textheadereply);
        textmessagereply=findViewById(R.id.textmessagereply);
        editText_main=findViewById(R.id.editText_main);
    }

    public void launchnewact(View view) {

        Log.d(LOG_TAG,"Button Clicked");
        Intent intent=new Intent(this,launchnew.class);
        String message=editText_main.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST)
        {
            if(resultCode==RESULT_OK)
            {
                String reply=data.getStringExtra(launchnew.EXTRA_REPLY);
                textheadereply.setVisibility(View.VISIBLE);
                textmessagereply.setText(reply);
                textmessagereply.setVisibility(View.VISIBLE);
            }
        }

    }
}
