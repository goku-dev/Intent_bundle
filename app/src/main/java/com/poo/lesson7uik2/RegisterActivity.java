package com.poo.lesson7uik2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends BaseActivity {

    public static final String KEY_RESULT = "KEY_RESULT";
    private EditText edtUserNameRes, edtPassRes, edtCfPass;





    private void initData() {
        Intent intent = getIntent();
        if (intent == null) return;
        Bundle bundle = intent.getBundleExtra(LoginActivity.KEY_BUNDLE);
        if (bundle == null) return;
        Account account = (Account) bundle.getSerializable(LoginActivity.KEY_ACCOUNT);

        edtUserNameRes.setText(account.getUserName());
        edtPassRes.setText(account.getPassWord());


    }
     @Override
    protected void initView() {
         findViewById(R.id.bt_register,this);
        edtUserNameRes = findViewById(R.id.edt_mailres);
        edtPassRes = findViewById(R.id.edt_passres);
        edtCfPass = findViewById(R.id.edt_cfpass);
        initData();


    }

    @Override
    protected int getByID() {
        return R.layout.register;
    }


    @Override
    public void onClick(View v) {
        if (edtUserNameRes.getText().toString().isEmpty() ||
                edtPassRes.getText().toString().isEmpty() ||
                edtCfPass.getText().toString().isEmpty()) {
            Toast.makeText(this, "Bạn chưa nhập tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        } else if (!edtPassRes.getText().toString().equals(edtCfPass.getText().toString())) {
            Toast.makeText(this, "mật khẩu nhập lại không trùng khớp", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Intent intent = new Intent();
            intent.putExtra(KEY_RESULT, "đăng kí thành công");
            setResult(RESULT_OK, intent);
            finish();

        }


    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED, null);
        super.onBackPressed();
    }
}
