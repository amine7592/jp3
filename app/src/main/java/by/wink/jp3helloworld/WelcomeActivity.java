package by.wink.jp3helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    Intent intent;
    String email = "";
    TextView emailTv;
    ImageButton sendMailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        emailTv = findViewById(R.id.email_tv);
        sendMailBtn = findViewById(R.id.sendmail_btn);

        intent = getIntent();
        if(null!= intent && null!= intent.getExtras())
            email = intent.getStringExtra(MainActivity.EMAIL_KEY);



        emailTv.setText(email);
        sendMailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:" + email);
                Intent sendMailIntent = new Intent(Intent.ACTION_SENDTO,uri);

                startActivity(sendMailIntent);
            }
        });





    }
}
