package com.example.astghik.week_1_exercices_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE_DISP = "com.example.astghik.week_1_exercices_2.MESSAGE";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        EditText editText = findViewById(R.id.editTextDisp);
        editText.setText(message);

        button = findViewById(R.id.sendDisp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMassage(view);
            }
        });

    }

    public void sendMassage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = findViewById(R.id.editTextDisp);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_DISP, message);
        startActivity(intent);
    }
}
