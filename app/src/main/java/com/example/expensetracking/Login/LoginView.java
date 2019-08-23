package com.example.expensetracking.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensetracking.R;
import com.example.expensetracking.Signup.View.View.RegisterView;

public class LoginView extends AppCompatActivity implements LoginInterface.view {
    EditText et_email, et_password;
    Button btn_login;
    TextView tv_register, tv_account;
    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        tv_account = findViewById(R.id.tv_account);
        tv_register = findViewById(R.id.tv_register);

        presenter = new LoginPresenter(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                presenter.signIn(email, password);
            }
        });


        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginView.this, RegisterView.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();


    }
}