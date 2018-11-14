package by.wink.jp3helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    //Declare UI controllers
    EditText emailEt, passwordEt, phoneEt;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Link the View with the Activity (controller)
        setContentView(R.layout.activity_register_rl);

        // initialize UI controllers

        emailEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        phoneEt = findViewById(R.id.phone_et);
        registerBtn = findViewById(R.id.register_btn);



    }
}
