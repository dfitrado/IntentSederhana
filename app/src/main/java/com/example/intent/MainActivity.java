package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bKontak = (Button) findViewById(R.id.bKontak);
        Button bBrowser = (Button) findViewById(R.id.bBrowser);
        Button bGambar = (Button) findViewById(R.id.bGambar);
        Button bYoutube = (Button) findViewById(R.id.bYoutube);
        Button bKamera = (Button) findViewById(R.id.bKamera);
        Button bMusik = (Button) findViewById(R.id.bMusik);
        bKontak.setOnClickListener(operasi);
        bGambar.setOnClickListener(operasi);
        bBrowser.setOnClickListener(operasi);
        bYoutube.setOnClickListener(operasi);
        bKamera.setOnClickListener(operasi);
        bMusik.setOnClickListener(operasi);
    }

    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bKontak:bukaKontak();break;
                case R.id.bBrowser:bukaBrowser();break;
                case R.id.bGambar:bukaGambar();break;
                case R.id.bYoutube:bukaYoutube();break;
                case R.id.bKamera:bukaKamera();break;
                case R.id.bMusik:bukaMusik();break;
            }
        }
    };

    void bukaKontak() {
        Intent intentku = new Intent(getBaseContext(), kontak.class);
        startActivityForResult(intentku, 0);
    }

    void bukaYoutube() {
        Intent intentku = new Intent(Intent.ACTION_VIEW, Uri.parse("http://youtube.com"));
        startActivity(intentku);
    }

    void bukaBrowser() {
        Intent intentku = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intentku);
    }

    void bukaGambar() {
        Intent intentku = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(intentku);
    }

    void bukaMusik() {
        Intent intentku = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
        startActivity(intentku);
    }

    void bukaKamera() {
        Intent intentku = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intentku);
    }

}