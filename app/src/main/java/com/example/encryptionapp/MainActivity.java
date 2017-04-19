package com.example.encryptionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    BigInteger publicKey;
    BigInteger privateKey;
    BigInteger modulus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createEncryption();
    }

    private void createEncryption() {
        int num = 0;
        Intent intent = new Intent();
        intent.putExtra("BASE_NUMBER", num);
    }


}
