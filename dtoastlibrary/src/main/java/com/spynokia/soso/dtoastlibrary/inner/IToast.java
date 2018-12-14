package com.spynokia.soso.dtoastlibrary.inner;

import android.view.View;

import com.spynokia.soso.dtoastlibrary.DToast;


/**
 * @Date: 2018/11/20
 * @Author: heweizong
 * @Description:
 */
public interface IToast {
    void show();

    void cancel();

    IToast setView(View mView);

    View getView();

    IToast setDuration(@DToast.Duration int duration);

    IToast setGravity(int gravity);

    IToast setGravity(int gravity, int xOffset, int yOffset);

    IToast setAnimation(int animation);

    IToast setPriority(int mPriority);

}
