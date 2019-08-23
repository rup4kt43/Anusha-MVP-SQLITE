package com.example.expensetracking.Login;

public class LoginPresenter implements LoginInterface.presenter {

    LoginInterface.view view;
    LoginModel loginmodel;

    public LoginPresenter(LoginView loginView) {
        this.view = loginView;

        loginmodel=new LoginModel();

    }

    @Override
    public void signIn(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            view.showToast("Field cannot be empty");
        } else {
            loginmodel.verifyLogin(email, password, new LoginInterface.presenterModelCallback() {
                @Override
                public void onSuccess(String msg) {
                    view.showToast(msg);
                }

                @Override
                public void onFail(String msg) {
                        view.showToast(msg);
                }
            });

        }
    }

}

