package com.example.expensetracking.Signup.View.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.expensetracking.R;
import com.example.expensetracking.Signup.View.Interfaces.SignUpInterface;
import com.example.expensetracking.Signup.View.Presenter.SignUpPresenter;
import com.example.expensetracking.Utilities.DataBaseHelper;

public class RegisterView extends AppCompatActivity implements SignUpInterface.view {
    Button btn_register;
    EditText et_userName, et_userEmail, et_userPhone, et_userPassword;

    DataBaseHelper dataBaseHelper;

    SignUpPresenter signupPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);

        et_userEmail=findViewById(R.id.et_userEmail);
        et_userName=findViewById(R.id.et_userName);
        et_userPassword=findViewById(R.id.et_userPassword);
        et_userPhone=findViewById(R.id.et_userPhone);

        btn_register=findViewById(R.id.btn_register);

        signupPresenter=new SignUpPresenter(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=et_userEmail.getText().toString();
                String username=et_userName.getText().toString();
                String password=et_userPassword.getText().toString();
                String phone=et_userPhone.getText().toString();

                signupPresenter.signUp(username,email,password,phone);

            }
        });

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();

    }
}

