package com.techienerd.quizgame;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.techienerd.quizgame.activity.CategoryActivity;
import com.techienerd.quizgame.tools.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtStart, txtHighScore;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        txtStart = (TextView) findViewById(R.id.txtStart);
        txtStart.setOnClickListener(this);
        txtHighScore = (TextView) findViewById(R.id.txtHighScore);
        txtHighScore.setOnClickListener(this);
        db = new DatabaseHelper(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtStart) {
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.txtHighScore) {
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dia_high_score);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
            TextView txtEp = (TextView) dialog.findViewById(R.id.txtEP);
            txtEp.setText(db.getBestScores(1) + "");
            TextView txtBp = (TextView) dialog.findViewById(R.id.txtBP);
            txtBp.setText(db.getBestScores(2) + "");
            dialog.show();
        }

    }
}
