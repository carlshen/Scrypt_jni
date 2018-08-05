package io.merculet.scrypt.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

import io.merculet.scrypt.jni.R;
import io.merculet.scrypt.util.HashUtils;
import io.merculet.scrypt.util.SignUtils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);


        byte[] password = new byte[0];
        try {
            password = "123456".getBytes("UTF-8");
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
        Log.i("MainActivity",str);
        tv.setText(str);
    }
}
