package com.spynokia.soso.dtoastlibrary;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationManagerCompat;
import com.spynokia.soso.dtoastlibrary.inner.DovaToast;
import com.spynokia.soso.dtoastlibrary.inner.IToast;
import com.spynokia.soso.dtoastlibrary.inner.SystemToast;
import com.spynokia.soso.dtoastlibrary.inner.Util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Date: 2018/11/26
 * @Author: heweizong
 * @Description: 使用系统Toast的问题 {@link android.widget.Toast}：当通知权限被关闭时在华为等手机上Toast不显示。因此采取自定义Toast解决.
 * 优先使用系统Toast，如果通知权限被关闭，则使用DovaToast.
 */
public class DToast {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DURATION_SHORT, DURATION_LONG})
    public @interface Duration {
    }

    public static final int DURATION_SHORT = 2000;
    public static final int DURATION_LONG = 3500;

    public static IToast make(Context mContext) {
        if (mContext == null) return null;
        //如果有通知权限，直接使用系统Toast
        //MIUI系统没有通知权限时系统Toast也能正常展示
//        if (NotificationManagerCompat.from(mContext).areNotificationsEnabled() || Util.isMIUI()) {
//            return new SystemToast(mContext);
//        } else {//否则使用自定义Toast
//            return new DovaToast(mContext);
//        }
        //由于手动关闭低版本的MIUI通知权限也会导致Toast无法弹出，这里就单纯的判断是否开启了通知权限
        if (NotificationManagerCompat.from(mContext).areNotificationsEnabled()) {
            return new SystemToast(mContext);
        } else {//否则使用自定义Toast
            return new DovaToast(mContext);
        }
    }

    /**
     * 终止并清除所有弹窗
     */
    public static void cancel() {
        DovaToast.cancelAll();
        SystemToast.cancelAll();
    }

    /**
     * 清除与{@param mActivity}关联的ActivityToast，避免窗口泄漏
     */
    public static void cancelActivityToast(Activity mActivity) {
        DovaToast.cancelActivityToast(mActivity);
    }
}
