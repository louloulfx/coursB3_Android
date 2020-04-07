package com.example.coursb3_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changePage(View vew) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123 && resultCode == Activity.RESULT_OK && data != null) {

            TextView text = findViewById(R.id.textview);
            int retour = data.getIntExtra("EXTRA_RANDOM", 1);
            text.setText(Integer.toString(retour));
            Toast.makeText(this, Integer.toString(retour), Toast.LENGTH_LONG).show();
            new CountDownTimer((retour * 1000), 1000) {
                TextView text = findViewById(R.id.textview);
                @Override
                public void onTick(long millisUntilFinished) {
                    long retour = (millisUntilFinished / 1000);
                    text.setText(Long.toString(retour));
                }

                @Override
                public void onFinish() {
                    text.setText("Créer un décompte");
                }
            }.start();
        }
    }


}
