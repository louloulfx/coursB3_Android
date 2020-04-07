package com.example.coursb3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public void changePage(View vew) {
        EditText edit = findViewById(R.id.edit);
        Toast.makeText(this, edit.getText().toString(), Toast.LENGTH_LONG).show();
        int random = Integer.parseInt(edit.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("EXTRA_RANDOM", random);
        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}
