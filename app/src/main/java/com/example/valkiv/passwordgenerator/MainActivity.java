package com.example.valkiv.passwordgenerator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonGenerate();
    }

    public void buttonGenerate() {
        button = (Button) findViewById(R.id.button_generate);
        textView = (TextView) findViewById(R.id.password_view);

        final SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = "";
                if (sharedPreferences.contains("passLength") && sharedPreferences.contains("radio")) {
                    String passLength = sharedPreferences.getString("passLength", "");
                    int passLen = Integer.parseInt(passLength);
                    String createPassMethod = sharedPreferences.getString("radio", "");
                    int passMethod = Integer.parseInt(createPassMethod);
                    switch (passMethod) {
                        case 1:
                            password = new PassGenerator().createPass(passLen);
                            break;
                        case 2:
                            password = new PassGenerator().createPassOnlyLetters(passLen);
                            break;
                        case 3:
                            password = new PassGenerator().createPassOnlySmallLetters(passLen);
                            break;
                        case 4:
                            password = new PassGenerator().createPassOnlyBigLetters(passLen);
                            break;
                        case 5:
                            password = new PassGenerator().createPassOnlySpecialSymbols(passLen);
                            break;
                        case 6:
                            password = new PassGenerator().createPassOnlyDigits(passLen);
                            break;
                    }
                } else {
                    password = new PassGenerator().createPass(8);
                }
                textView.setText(password);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemMenu:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

}
