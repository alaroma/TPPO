package com.example.artamonova_a.tppo_1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import java.io.IOException;

public class CreateLabel extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.activity_create_label);
        imageView = findViewById(R.id.imageView2);

        ImageButton camera = findViewById(R.id.imageButton);
        camera.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 0);
            }
        });

        ImageButton galery = findViewById(R.id.imageButton3);
        galery.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0:
                    Bitmap selectedImage = (Bitmap) imageReturnedIntent.getExtras().get("data");
                    imageView.setImageBitmap(selectedImage);
                    break;
                case 1:
                    Uri selectedImage2 = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage2);
                    break;
            }
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(CreateLabel.this, Main2Activity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}