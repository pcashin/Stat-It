package com.app.sports.stats.sportstat.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.backendless.Backendless;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bLogout;
    private EditText etEmail, etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Backendless Test Code
         */

        final String APP_ID = "D1E00395-C124-3ECE-FF99-1B2070F9E400";
        final String SECRET_KEY = "D51F230C-BDF1-7C2B-FF49-7AEA8B3EC500";
        String appVersion = "v1";
        Backendless.initApp( this, APP_ID, SECRET_KEY, appVersion );

        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText)findViewById(R.id.etUsername);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogout:

                startActivity(new Intent(this, Login.class));

                break;
        }
    }
}
