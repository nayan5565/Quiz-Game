package com.techienerd.quizgame.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.techienerd.quizgame.R;
import com.techienerd.quizgame.model.MScore;
import com.techienerd.quizgame.tools.DatabaseHelper;
import com.techienerd.quizgame.tools.Global;

import java.util.Collections;

/**
 * Created by Nayan on 7/18/2017.
 */
public class OptionActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtCount;
    private Button btnNext;
    private int pos;
    private TextView txtQues, txtType, txtWrong, txtQuestionPos;
    private boolean isTrue;
    private LinearLayout layOption;
    private int correct, wrong;
    private int index, quesPos=1;
    private int parentId;
    private int bestScore;
    private MScore mScore;
    private DatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_option);
        init();
        changeButtonColor();
        prepareDisplay();
    }

    private void init() {
        mScore = new MScore();
        index = getIntent().getIntExtra("index", 0);
        Global.parentId = getIntent().getIntExtra("parentId", 0);
        parentId = Global.parentId;
        Log.e("id", " is " + parentId);
        txtCount = (TextView) findViewById(R.id.txtCount);
        txtType = (TextView) findViewById(R.id.txtType);
        txtWrong = (TextView) findViewById(R.id.txtWrong);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(this);

        txtQues = (TextView) findViewById(R.id.tct);
        txtQuestionPos = (TextView) findViewById(R.id.txtQuestionPosition);
        txtQues.setTextColor(Color.WHITE);
        txtType.setText(CategoryActivity.getInstance().categoryArrayList.get(index).getType());
        db = new DatabaseHelper(this);
        layOption = (LinearLayout) findViewById(R.id.layOption);
        txtQuestionPos.setText(quesPos + " out of " + CategoryActivity.getInstance().questionArrayList.size());

    }

    public void changeButtonColor() {
        if (!isTrue)
            btnNext.setBackgroundColor(0xffff0000);
    }

    public void prepareDisplay() {
        if (pos >= CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size()) {
            Log.e("step", "one");
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            final Dialog dialog = new Dialog(this);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dia_game_over);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Button btnOk = (Button) dialog.findViewById(R.id.btnOK);
            final TextView txtMark = (TextView) dialog.findViewById(R.id.txtScore);
            TextView txtBestScore = (TextView) dialog.findViewById(R.id.txtBestScore);
            bestScore = db.getBestScores(parentId);
            int score = correct * (100 / CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().size());
            if (score > bestScore) {
                bestScore = score;
                mScore.setParentId(Global.parentId);
                mScore.setBestScore(bestScore);

                db.addBestScore(mScore);
            }


            Log.e("score", "best " + bestScore);
            Log.e("score", "present " + score);

            txtMark.setText("Congratulation!Your score is " + score + " out of 100");
            txtBestScore.setText("Best score " + bestScore + "");
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
//                    correct = 0;
//                    wrong = 0;
//                    quesPos=1;
//                    txtQuestionPos.setText(quesPos + " out of " + CategoryActivity.getInstance().questionArrayList.size());
//                    txtCount.setText(correct + " : ");
//                    txtWrong.setText(wrong + "");
//                    Collections.shuffle(CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList());
//                    prepareDisplay();
                    dialog.dismiss();
                }
            });
            dialog.show();
            pos = 0;
            return;
        } else {
            Log.e("step", "two");
            txtQues.setText(CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getQues());
            layOption.removeAllViews();
            for (int i = 0; i < CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().size(); i++) {
                addCheckbox(CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(i).getOption(), i);
            }

        }

    }


    public void addCheckbox(String text, final int id) {

        final CheckBox checkBox = new CheckBox(this);
        checkBox.setText(text);
        checkBox.setTextColor(Color.WHITE);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTrue = true;
                btnNext.setBackgroundColor(0xff00ff00);
                if (CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(id).getTag() == 1) {
                    correct++;

                } else {
                    wrong++;
                }
                for (int i = 0; i < layOption.getChildCount(); i++) {
                    layOption.getChildAt(i).setClickable(false);
                }
                txtCount.setText(correct + " : ");
                txtWrong.setText(wrong + "");
                if (checkBox.isChecked() && CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(id).getTag() == 1) {
                    checkBox.setTextColor(Color.GREEN);
                } else {

                    for (int i = 0; i < CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().size(); i++) {
                        if (CategoryActivity.getInstance().categoryArrayList.get(index).getQuestionArrayList().get(pos).getOptionArrayList().get(i).getTag() == 1) {
                            ((CheckBox) layOption.getChildAt(i)).setTextColor(Color.GREEN);
                        }
                    }
                    checkBox.setTextColor(Color.RED);
                }

            }
        });

        layOption.addView(checkBox);
    }


    @Override
    public void onClick(View v) {

        if (!isTrue)
            return;


        if (v.getId() == R.id.btnNext) {
            pos++;
            quesPos++;
            if (quesPos>5){
                quesPos=5;
            }
            txtQuestionPos.setText(quesPos + " out of " + CategoryActivity.getInstance().questionArrayList.size());
            isTrue = false;
            prepareDisplay();
            for (int i = 0; i < layOption.getChildCount(); i++) {
                layOption.getChildAt(i).setClickable(true);
            }
            if (!isTrue)
                changeButtonColor();


        }


    }
}
