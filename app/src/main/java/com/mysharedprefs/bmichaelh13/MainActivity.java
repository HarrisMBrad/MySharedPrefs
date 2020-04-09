package com.mysharedprefs.bmichaelh13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private TextView result;
    private EditText enterMessage;
    private SharedPreferences ogPrefs;
    private static final String PREFS_NAME = "ogPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMessage = findViewById(R.id.enterNameId);
        result = findViewById(R.id.resultsTxtViewId);

        saveButton = findViewById(R.id.saveBtnId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ogPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = ogPrefs.edit();

                editor.putString("message", enterMessage.getText().toString());
                editor.commit();
            }
        });

        //get data back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);

        if (prefs.contains("message")) {
            String message = prefs.getString("message", "not found");
            result.setText("Message: " + message);


        }

    }
}
