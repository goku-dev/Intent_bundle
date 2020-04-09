package com.poo.lesson7uik2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UtilityActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CALL = 101;
    private EditText edtPhone;
    private ImageView ivPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_uitility);

        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //câu lệnh giúp hiển thi dialog hỏi quyền người dùng
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }


        initView();
    }

    private void initView() {
        edtPhone = findViewById(R.id.edt_phoneNumber);
        ivPhoto = findViewById(R.id.iv_photo);

        findViewById(R.id.bt_call).setOnClickListener(this);
        findViewById(R.id.bt_pickImage).setOnClickListener(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                finish();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_call) {
            doCall();
        } else if (v.getId() == R.id.bt_pickImage) {

            doPick();
        }
    }

    private void doPick() {


    }

    private void doCall() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + edtPhone.getText().toString()));
        startActivity(intent);
    }
}
