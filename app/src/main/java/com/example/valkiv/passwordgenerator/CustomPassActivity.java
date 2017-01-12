package com.example.valkiv.passwordgenerator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custompass);
        customPassSubmit();
    }

    public void customPassSubmit() {

        final Context context = this;
        Button button = (Button) findViewById(R.id.buttonSubmitCustomPass);
        final SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText bigLetters = (EditText) findViewById(R.id.bigLetters);
                EditText smallLetters = (EditText) findViewById(R.id.smallLetters);
                EditText symbols = (EditText) findViewById(R.id.symbols);
                EditText digits = (EditText) findViewById(R.id.digits);

                if (bigLetters.getText().toString().equals("") || smallLetters.getText().toString().equals("") || symbols.getText().toString().equals("") || digits.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please, fill all fields", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("radio", "1");
                    editor.putString("bigLetters", bigLetters.getText().toString());
                    editor.putString("smallLetters", smallLetters.getText().toString());
                    editor.putString("symbols", symbols.getText().toString());
                    editor.putString("digits", digits.getText().toString());
                    editor.commit();

                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
