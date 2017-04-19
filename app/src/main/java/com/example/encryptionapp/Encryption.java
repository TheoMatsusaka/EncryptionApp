package com.example.encryptionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.math.BigInteger;
import java.security.SecureRandom;

import static android.R.attr.publicKey;


/**
 * Created by csaper6 on 4/17/17.
 */

public class Encryption extends AppCompatActivity {
    SecureRandom random = new SecureRandom();
    private BigInteger modulus;
    private BigInteger publickey;
    private BigInteger privateKey;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int num = intent.getIntExtra("BASE_NUMBER", 0);
        encrypt(num);

    }

    private void encrypt(int numBase) {
        BigInteger primeOne = BigInteger.probablePrime(numBase, random);
        BigInteger primeTwo = BigInteger.probablePrime(numBase, random);
        while(primeTwo==primeOne)
        {
            primeTwo = BigInteger.probablePrime(numBase,random);
        }
        BigInteger phiOne = getPrimePhi(primeOne);
        BigInteger phiTwo = getPrimePhi(primeOne);

    }

    private BigInteger getPrimePhi(BigInteger num) {
        return num.subtract(new BigInteger("1"));
    }

    private void RSA(int N) {
        BigInteger p = BigInteger.probablePrime(N/2, random);
        BigInteger q = BigInteger.probablePrime(N/2, random);
        BigInteger phi = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));

        modulus    = p.multiply(q);
        publickey  = new BigInteger("65537");
        privateKey = publickey.modInverse(phi);
    }



}
