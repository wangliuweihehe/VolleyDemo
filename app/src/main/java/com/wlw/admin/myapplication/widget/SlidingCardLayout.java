package com.wlw.admin.myapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wlw.admin.myapplication.R;
import com.wlw.admin.myapplication.SlidingAdapter;

public class SlidingCardLayout extends FrameLayout {

   private int mHeaderViewHeight;
    public SlidingCardLayout(@NonNull Context context) {
        this(context, null);
    }

    public SlidingCardLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingCardLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.widget_card, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new SlidingAdapter());

        TextView header = findViewById(R.id.header);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SlidingCardLayout);
        header.setText(a.getText(R.styleable.SlidingCardLayout_android_text));
        header.setBackgroundColor(a.getColor(R.styleable.SlidingCardLayout_android_colorBackground, Color.GREEN));
        a.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeaderViewHeight=findViewById(R.id.header).getMeasuredHeight();
    }

    public int getHeaderHeight() {
        return mHeaderViewHeight;
    }
}
