package com.example.expensetracking.Login;

public interface LoginInterface {

    interface view{
        void showToast(String msg);

    }

    interface presenter{
        void signIn(String email, String password);

    }

    interface presenterModelCallback{
        void onSuccess(String msg);
        void onFail(String msg);
    }


}
