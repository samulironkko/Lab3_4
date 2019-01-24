package com.example.lab3_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_button_id).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent countDownIntent = new Intent(this, CountDownActivity.class);
        String aika = ((EditText)findViewById(R.id.edit_text_id)).getText().toString();
        countDownIntent.putExtra("aika", aika);
        startActivity(countDownIntent);
    }
}
