package com.example.expensetracking.Signup.View.Presenter;


import com.example.expensetracking.Signup.View.Interfaces.SignUpInterface;
import com.example.expensetracking.Signup.View.Model.SignUpModel;
import com.example.expensetracking.Signup.View.View.RegisterView;

public class SignUpPresenter implements SignUpInterface.presenter {
    private final RegisterView view;
    SignUpModel signUpModel;

    public SignUpPresenter(RegisterView registerView) {
        this.view=registerView;

        signUpModel=new SignUpModel();
    }


    @Override
    public void signUp(String username, String email, String password, String phone) {
        if(username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()){
            view.showToast("Fill the credentials");
        }else{
            signUpModel.verifyRegister(username, email,password,phone, new SignUpInterface.modelpresentercallback() {
                @Override
                public void result(Long result) {
                    if(result==-1){
                        view.showToast("Error in inserting");
                    }else{
                        view.showToast("Successful");
                    }

                }
            });
        }
    }
}
