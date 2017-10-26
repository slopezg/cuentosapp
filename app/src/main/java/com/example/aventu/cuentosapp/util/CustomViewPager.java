package com.example.aventu.cuentosapp.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Santiago on 10/24/17.
 */

public class CustomViewPager extends ViewPager {

    private boolean isEnabled;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isEnabled = true;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(this.isEnabled) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(this.isEnabled) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}