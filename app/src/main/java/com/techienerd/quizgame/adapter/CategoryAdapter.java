package com.techienerd.quizgame.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techienerd.quizgame.R;
import com.techienerd.quizgame.activity.CategoryActivity;
import com.techienerd.quizgame.activity.OptionActivity;
import com.techienerd.quizgame.model.MCategory;

import java.util.ArrayList;

/**
 * Created by Nayan on 7/18/2017.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MCategory> categoryArrayList;
    private MCategory mCategory;
    View view;


    public CategoryAdapter(Context context) {
        this.context = context;
//        mItems = new ArrayList<>();
        categoryArrayList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MCategory> allQuestionArrayList) {
        this.categoryArrayList = allQuestionArrayList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.category_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mCategory = categoryArrayList.get(position);
        holder.textView.setText(mCategory.getType());
        holder.textView.setTextColor(Color.WHITE);

    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textContents);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCategory = categoryArrayList.get(getAdapterPosition());
                    Intent intent = new Intent(context, OptionActivity.class);
                    intent.putExtra("index", getAdapterPosition());
                    intent.putExtra("parentId", mCategory.getId());
                    context.startActivity(intent);
                    CategoryActivity.getInstance().destroy();
                }
            });
        }
    }
}
