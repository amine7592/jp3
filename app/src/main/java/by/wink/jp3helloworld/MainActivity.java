package by.wink.jp3helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PASSWORD_MIN_LENGTH = 6;
    public static final String EMAIL_KEY = "email";

    EditText usernameEt;
    EditText passwordEt;

    Button loginBtn;
    Button registerBtn;


    //Antoher way to define clickListener

    View.OnClickListener registerBtnCL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO do something
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
           // showMessage(getString(R.string.button_clicked));

        }
    };





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "onCreate");


        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(registerBtnCL);



        /*
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO do something
                showMessage(getString(R.string.button_clicked));
            }
        });*/


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


    private void showMessage(String message){

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.d("Login",message);
    }


    private void showErrorMessage(String error) {
        showMessage(error);

        Log.e("Login",error);

    }


    private void showSuccessMessage() {
        showMessage(getString(R.string.success_login));
        Log.d("Login","success");
    }

    //region LifeCycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart");


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume");


    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause");

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy");

    }


    //endregion



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_btn) {
            String email = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();

            if (!isValidEmail(email)) {
                showErrorMessage(getString(R.string.error_email));

                return;
            }

            if (!isValidPwd(password)) {
                showErrorMessage(getString(R.string.error_password));
                return;
            }

            showSuccessMessage();
            Intent intent = new Intent(this,WelcomeActivity.class);

            /* Another way to set Extras data

            Bundle extras = new Bundle();
            extras.putString(EMAIL_KEY,email);
            intent.putExtras(extras);

            */


            intent.putExtra(EMAIL_KEY,email);
            startActivity(intent);

        }
    }
}
