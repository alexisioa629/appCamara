package com.example.appfoto;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
// librerias importadas
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button btn;
    private ImageView imagView;
    Intent i;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        inicializa();
    }

    public void inicializa() {
        btn = (Button) findViewById(R.id.btnCaptura);
        btn.setOnClickListener(this);// objeto de implements de clicklistener
        imagView = (ImageView) findViewById(R.id.imagen);


    }

    @Override
    public void onClick(View v) {
        i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode,resultCode,data);
    if(resultCode== Activity.RESULT_OK){
        Bundle extra= data.getExtras();
        bitmap= (Bitmap)extra.get("data");
        imagView.setImageBitmap(bitmap);
    }
    }

}
