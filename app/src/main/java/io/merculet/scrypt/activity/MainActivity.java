package io.merculet.scrypt.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

import io.merculet.scrypt.jni.R;
import io.merculet.scrypt.util.HashUtils;
import io.tongxin.scrypt.SignUtils;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        button = (Button) findViewById(R.id.sample_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String pw = tv.getText().toString().trim();
                Log.i("MainActivity", "begin scrypt: " + pw);
                byte[] password = new byte[0];
                try {
                    if (TextUtils.isEmpty(pw)) {
                        password = "123456".getBytes("UTF-8");
                    } else {
                        password = pw.getBytes("UTF-8");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] salt = new byte[0];
                try {
                    salt = "abcdefg".getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] scrypt = SignUtils.scryptN(password,salt,131072,8,1,32);
                String str = HashUtils.encodeBase64(scrypt);
                Log.i("MainActivity", "end scrypt: " + str);
                tv.setText(str);
            }
        });
    }
}
