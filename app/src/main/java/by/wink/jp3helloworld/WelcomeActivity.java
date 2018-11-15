package by.wink.jp3helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    Intent intent;
    String email = "";

    TextView emailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        emailTv = findViewById(R.id.email_tv);

        intent = getIntent();
        if(null!= intent && null!= intent.getExtras())
            email = intent.getStringExtra(MainActivity.EMAIL_KEY);



        emailTv.setText(email);




    }
}
