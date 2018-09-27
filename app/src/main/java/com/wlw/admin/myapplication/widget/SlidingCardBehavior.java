package com.wlw.admin.myapplication.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

public class SlidingCardBehavior extends CoordinatorLayout.Behavior<SlidingCardLayout> {
    public SlidingCardBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int mInitialOffset;

    @Override
    public boolean onMeasureChild(@NonNull CoordinatorLayout parent, @NonNull SlidingCardLayout child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        int offset = getChildMeasureOffset(parent, child);
        int height = View.MeasureSpec.getSize(parentHeightMeasureSpec) - offset;
        child.measure(parentWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
        return true;
    }

    private int getChildMeasureOffset(CoordinatorLayout parent, SlidingCardLayout child) {
        int offset = 0;
        for (int i = 0; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);
            if (view != child && view instanceof SlidingCardLayout) {
                offset += ((SlidingCardLayout) view).getHeaderHeight();
            }
        }
        return offset;
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull SlidingCardLayout child, int layoutDirection) {
        parent.onLayoutChild(child, layoutDirection);
        SlidingCardLayout previous = getPreviousChild(parent, child);
        if (previous != null) {
            int offset = previous.getHeaderHeight() + previous.getTop();
            child.offsetTopAndBottom(offset);
        }
        mInitialOffset = child.getTop();
        return true;
    }

    private SlidingCardLayout getPreviousChild(CoordinatorLayout parent, SlidingCardLayout child) {
        int cardIndex = parent.indexOfChild(child);
        for (int i = cardIndex - 1; i >= 0; i--) {
            View v = parent.getChildAt(i);
            if (v instanceof SlidingCardLayout) {
                return (SlidingCardLayout) v;
            }
        }
        return null;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SlidingCardLayout child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        boolean isVertical = (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        return isVertical && child == directTargetChild;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SlidingCardLayout child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        consumed[1] = scroll(child, dy, mInitialOffset, mInitialOffset + child.getHeight() - child.getHeaderHeight());
        shiftSliding(consumed[1], coordinatorLayout, child);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SlidingCardLayout child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        //移动范围
        int shift = scroll(child, dyUnconsumed, mInitialOffset, mInitialOffset + child.getHeight() - child.getHeaderHeight());
        shiftSliding(shift, coordinatorLayout, child);
    }

    private void shiftSliding(int shift, CoordinatorLayout coordinatorLayout, SlidingCardLayout child) {
        if (shift == 0)
            return;
        if (shift > 0) {//往上推
            SlidingCardLayout current = child;
            SlidingCardLayout cardLayout = getPreviousChild(coordinatorLayout, current);
            while (cardLayout != null) {
                int offset = getHeaderOverlap(current, cardLayout);
                if (offset > 0)
                    cardLayout.offsetTopAndBottom(-offset);
                current = cardLayout;
                cardLayout = getPreviousChild(coordinatorLayout, current);
            }

        } else {//往下推
            SlidingCardLayout current = child;
            SlidingCardLayout cardLayout = getNextChild(coordinatorLayout, current);
            while (cardLayout != null) {
                int offset = getHeaderOverlap(current, cardLayout);
                if (offset > 0)
                    cardLayout.offsetTopAndBottom(offset);
                current = cardLayout;
                cardLayout = getNextChild(coordinatorLayout, current);
            }
        }
    }

    private int getHeaderOverlap(SlidingCardLayout above, SlidingCardLayout below) {
        return above.getTop() + above.getHeaderHeight() - below.getTop();
    }

    private SlidingCardLayout getNextChild(CoordinatorLayout coordinatorLayout, SlidingCardLayout current) {
        int cardIndex = coordinatorLayout.indexOfChild(current);
        for (int i = cardIndex + 1; i < coordinatorLayout.getChildCount(); i++) {
            View v = coordinatorLayout.getChildAt(i);
            if (v instanceof SlidingCardLayout)
                return (SlidingCardLayout) v;
        }
        return null;
    }

    private int scroll(SlidingCardLayout child, int dy, int minOffset, int maxOffset) {
//        //控制自己的上下移动
        int initialOffset = child.getTop();
        int offset = clamp(initialOffset - dy, minOffset, maxOffset) - initialOffset;
        child.offsetTopAndBottom(offset);
        return -offset;
    }

    private int clamp(int i, int minOffset, int maxOffset) {
        if (i > maxOffset)
            return maxOffset;
        else if (i < minOffset)
            return minOffset;
        else
            return i;
    }
}
