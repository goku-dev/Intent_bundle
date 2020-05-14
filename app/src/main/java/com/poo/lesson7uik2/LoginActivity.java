package com.poo.lesson7uik2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class LoginActivity extends BaseActivity {
    public static final String KEY_BUNDLE = "KEY_BUNDLE";
    public static final String KEY_ACCOUNT = "KEY_ACCOUNT";
    public static final int REQUEST_REGISTER = 101;
    public static final String KEY_USERNAME ="user name" ;
    public static final String KEY_PASS ="pass" ;
    private EditText edtUserName, edtPassword;


    @Override
    protected void initView() {
        edtUserName = findViewById(R.id.edt_mail);
        edtPassword = findViewById(R.id.edt_pass);
        findViewById(R.id.bt_signin, this);
        findViewById(R.id.bt_resLogin, this);
    }

    @Override
    protected int getByID() {
        return R.layout.act_login;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_signin) {
            login();
        } else {
            register();
        }
    }

    private void register() {
        Intent intent = new Intent();
        intent.setAction("ACTION_REGISTER");
        Bundle bundle = new Bundle();
//        bundle.putString(KEY_USERNAME,edtUserName.getText().toString());
//        bundle.putString(KEY_PASS,edtPassword.getText().toString());
        Account account = new Account(edtUserName.getText().toString(),edtPassword.getText().toString());
        bundle.putSerializable(KEY_ACCOUNT,account);


        intent.putExtra(KEY_BUNDLE, bundle);
        startActivityForResult(intent, REQUEST_REGISTER);


//        App.getInstance().setUserName(edtUserName.getText().toString());
//        App.getInstance().setPassWord(edtPassword.getText().toString());
//
//        startActivity(new Intent(this, RegisterActivity.class));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_REGISTER) {
            if (resultCode == RESULT_OK) {
                String value = data.getStringExtra(RegisterActivity.KEY_RESULT);
                Toast.makeText(this, value, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "bạn đăng kí không thành công", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void login() {
        if (edtUserName.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "bạn chưa nhập tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "đăng nhập thành công", Toast.LENGTH_LONG).show();
        }
    }


}
