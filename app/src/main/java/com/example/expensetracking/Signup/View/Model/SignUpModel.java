package com.example.expensetracking.Signup.View.Model;

import android.content.Context;

import com.example.expensetracking.GlobalContext.GlobalApplication;
import com.example.expensetracking.Signup.View.Interfaces.SignUpInterface;
import com.example.expensetracking.Utilities.DataBaseHelper;

public class SignUpModel {
    DataBaseHelper dataBaseHelper;

    public void verifyRegister(String username, String email, String password, String phone, SignUpInterface.modelpresentercallback callback) {

        dataBaseHelper = new DataBaseHelper(GlobalApplication.getAppContext());

        long result= dataBaseHelper.insert(username, email, password, phone);
        callback.result(result);

    }
}
