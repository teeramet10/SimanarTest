package com.example.barbie.simanartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {
    Button btnShow;
    ImageView imgPicasso;
    ImageView imgNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        btnShow=(Button) findViewById(R.id.btnshow);
        imgPicasso= (ImageView) findViewById(R.id.piccasso);
        imgNormal=(ImageView)findViewById(R.id.normal);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ImageActivity.this).load(R.drawable.elsa).fit().into(imgPicasso);
                imgNormal.setImageDrawable(getResources().getDrawable(R.drawable.gundam));
            }
        });
    }
}
