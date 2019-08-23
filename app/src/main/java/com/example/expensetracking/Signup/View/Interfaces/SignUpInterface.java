package com.example.expensetracking.Signup.View.Interfaces;

public interface SignUpInterface {

    interface view {
        void showToast(String msg);
    }

    interface presenter {
        void signUp(String username, String email, String password, String phone);
    }


    interface modelpresentercallback {
        void result(Long result);
    }

}
