package com.example.expensetracking.Login;

public class LoginModel {
    String username ="anusha" ;
    String pw="anusha5678";

    public void verifyLogin(String email, String password, LoginInterface.presenterModelCallback callback) {
        if(email.matches(username) && password.matches(pw)){
            callback.onSuccess("SUCCESS");
        }else{
            callback.onFail("FAIL");
        }

    }
}
