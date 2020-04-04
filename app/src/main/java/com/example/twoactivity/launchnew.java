package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class launchnew extends AppCompatActivity {

    TextView textmessage;
    EditText editText;
    public  static final String EXTRA_REPLY="com.example.twoactivity.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launchnew);
        textmessage=findViewById(R.id.textmessage);
        editText=findViewById(R.id.editText);
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textmessage.setText(message);

    }

    public void returnreply(View view) {
        String reply=editText.getText().toString();
        Intent replyINtent=new Intent();
        replyINtent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyINtent);
        finish();


    }
}
