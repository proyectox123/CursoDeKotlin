package com.example.mho.examplekotlin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Mauricio Hernández on 09-Nov-17.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText password;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.loginPass);
        login = findViewById(R.id.loginSend);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = Validations.validatePassword(password);
                Log.d(TAG, "OnClick: "+isValid);
                if(isValid){
                    startActivity(new Intent(MainActivity.this, ListActivity.class));
                    return;
                }

                Toast.makeText(MainActivity.this,
                        "Incorrect password!",
                        Toast.LENGTH_LONG).show();
            }
        });

        BasicPOJO basicPOJO = new BasicPOJO("Title", "Desc1");
        BasicPOJO basicPOJO2 = new BasicPOJO("Title");

        Log.d(TAG, "basicPOJO: "+basicPOJO.toString());
        Log.d(TAG, "basicPOJO2: "+basicPOJO2.toString());
    }
}
