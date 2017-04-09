package com.tnnowu.android.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tnno Wu on 2017/4/9.
 */

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUrl;

    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        initView();
    }

    private void initView() {
        etUrl = (EditText) findViewById(R.id.et_url);
        btnConvert = (Button) findViewById(R.id.btn_convert);

        btnConvert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_convert:
                String str_url = "https://" + etUrl.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("url", str_url);
                // 当输入框为空时，提示用户
                if (str_url.equals("https://")) {
                    Toast.makeText(getApplicationContext(), "输入框不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ContentActivity.this, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
