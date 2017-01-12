package com.example.valkiv.passwordgenerator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity{

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        submitButtonAction();
        selectedCustomPass();
    }

    public void submitButtonAction() {
        context = this;
        String MyPreferences = "MyPref";
        final SharedPreferences sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        Button submit = (Button) findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                int selectedRadioId = radioGroup.getCheckedRadioButtonId();

                EditText editText = (EditText) findViewById(R.id.passLength);
                String passLength = editText.getText().toString();
                //int passLen = Integer.parseInt(passLength);

                if (selectedRadioId == -1 || passLength.equals("0") || passLength.equals("")) {
                    Toast.makeText(getApplicationContext(), "Select type of password and length", Toast.LENGTH_LONG).show();
                } else {
                    RadioButton radioSelected = (RadioButton) findViewById(selectedRadioId);
                    String radioSel = (String) radioSelected.getText();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    switch (radioSel) {
//                        case "Password with letters and special symbols":
////                            editor.putString("radio", "1");
//                            selectedCustomPass();
//                            break;
                        case "Password only with letters":
                            editor.putString("radio", "2");
                            break;
                        case "Password only with small letters":
                            editor.putString("radio", "3");
                            break;
                        case "Password only with big letters":
                            editor.putString("radio", "4");
                            break;
                        case "Password only with special symbols":
                            editor.putString("radio", "5");
                            break;
                        case "Password only with digits":
                            editor.putString("radio", "6");
                            break;
                    }
                    editor.putString("passLength", passLength);
                    editor.commit();

                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void selectedCustomPass() {
        context = this;
        Button button = (Button) findViewById(R.id.buttonCustomPass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CustomPassActivity.class);
                startActivity(intent);
            }
        });
    }
}
