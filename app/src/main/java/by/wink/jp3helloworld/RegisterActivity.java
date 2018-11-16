package by.wink.jp3helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity{

    private static final int PASSWORD_MIN_LENGTH = 6;
    private static final int PHONE_LENGTH = 10;
    //Declare UI controllers
    EditText emailEt, passwordEt, phoneEt;
    Button registerBtn;

    boolean isMailValid = false;
    boolean isPhoneValid = false;
    boolean isPasswordValid = false;

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

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.isEnabled()){
                    Intent intent = new Intent(RegisterActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });

        emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isMailValid = isValidEmail(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    enableButton();


            }
        });


        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isPasswordValid = isValidPwd(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    enableButton();
            }
        });


        phoneEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isPhoneValid = isValidPhone(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    enableButton();
            }

        });










    }


    private boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());

    }

    private boolean isValidPwd(String password) {
        if (password.length() >= PASSWORD_MIN_LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isValidPhone(String phone) {
        return (phone.length() == PHONE_LENGTH);
    }

    private void enableButton(){
        if(isMailValid && isPasswordValid && isPhoneValid) registerBtn.setEnabled(true);
        else registerBtn.setEnabled(false);

    }
}
