package com.techienerd.quizgame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.techienerd.quizgame.R;
import com.techienerd.quizgame.adapter.CategoryAdapter;
import com.techienerd.quizgame.model.MCategory;
import com.techienerd.quizgame.model.MOption;
import com.techienerd.quizgame.model.MQuestion;
import com.techienerd.quizgame.tools.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/18/2017.
 */
public class CategoryActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    ArrayList<MOption> optionArrayList;
    ArrayList<MQuestion> questionArrayList;
    ArrayList<MCategory> categoryArrayList;
    MCategory mCategory;
    MQuestion mQuestion;
    MOption mOption;
    private TextView txtCount;

    private int pos;
    private TextView txtQues;
    CategoryAdapter adapter;
    DatabaseHelper db;
    private static CategoryActivity instance;

    public static CategoryActivity getInstance() {

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_category);
        instance = this;
        init();
        generateToMulti();
        prepareView();
    }

    private void init() {
        txtCount = (TextView) findViewById(R.id.txtCount);
        txtQues = (TextView) findViewById(R.id.tct);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        adapter = new CategoryAdapter(this);
        db=new DatabaseHelper(this);
    }
    public void prepareView() {
        Log.e("list"," size "+categoryArrayList.size());
        adapter.setData(categoryArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void generateToMulti() {
        questionArrayList = new ArrayList<>();
        optionArrayList = new ArrayList<>();
        categoryArrayList = new ArrayList<>();

        mCategory = new MCategory();

        mCategory.setType("English");
        mCategory.setId(1);

        mQuestion = new MQuestion();

        mQuestion.setQues("2+2=?");

        mOption = new MOption();
        mOption.setOption("2");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("7");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("8");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("4");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        // 2

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("5+5=?");

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("11");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        //3
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("2+5=?");
        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("7");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("12");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);

        //4
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("7+2=?");
        mOption = new MOption();
        mOption.setOption("5");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("6");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("9");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);
//5
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("8+2=?");
        mOption = new MOption();
        mOption.setOption("16");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("12");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("11");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("10");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);


        mCategory.setQuestionArrayList(questionArrayList);
        categoryArrayList.add(mCategory);

        //Math question

        questionArrayList = new ArrayList<>();
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();

        mCategory = new MCategory();
        mCategory.setType("Math");
        mCategory.setId(2);

        mQuestion.setQues("২+২ =?");

        mOption = new MOption();
        mOption.setOption("২");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৭");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৮");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৪");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        // 2

        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("৫+৫=?");

        mOption = new MOption();
        mOption.setOption("১০");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৯");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৫");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১১");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);

        //3
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("২+৫=?");
        mOption = new MOption();
        mOption.setOption("৯");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৭");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৫");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১২");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);

        //4
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("৭+২=?");
        mOption = new MOption();
        mOption.setOption("৫");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৬");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("৯");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১০");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);


        questionArrayList.add(mQuestion);
//5
        optionArrayList = new ArrayList<>();
        mQuestion = new MQuestion();
        mQuestion.setQues("৮+২=?");
        mOption = new MOption();
        mOption.setOption("১৬");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১২");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১১");
        mOption.setTag(0);

        optionArrayList.add(mOption);

        mOption = new MOption();
        mOption.setOption("১০");
        mOption.setTag(1);

        optionArrayList.add(mOption);

        mQuestion.setOptionArrayList(optionArrayList);

        questionArrayList.add(mQuestion);


        mCategory.setQuestionArrayList(questionArrayList);
        categoryArrayList.add(mCategory);


    }
}
