package com.example.astghik.week_1_exercices_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.astghik.week_1_exercices_2.MESSAGE";
    private Button sendBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE_DISP);
        EditText editText = findViewById(R.id.editText);
        editText.setText(message);

        sendBut = findViewById(R.id.send);
        sendBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMassage(view);
            }
        });

    }

    public void sendMassage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }
}
