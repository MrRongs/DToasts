# DToasts
1.0.2新版处理由于手动关闭低版本的MIUI通知权限也会导致Toast无法弹出，这里就单纯的判断是否开启了通知权限
需要自己创建一个ToastUtil的类
public class ToastUtil {

    public static void showAtButtom(Context mContext, String msg) {
        if (mContext == null) return;
        if (msg == null) return;
        IToast toast= DToast.make(mContext);
        TextView tv_text = (TextView) toast.getView().findViewById(R.id.tv_content);
        if (tv_text != null) {
            tv_text.setText(msg);
        }
        toast.setGravity(Gravity.BOTTOM| Gravity.CENTER,0,30).show();
    }


    public static void showAtCenter(Context mContext, String msg) {
        if (mContext == null) return;
        if (msg == null) return;
        View toastRoot = View.inflate(mContext, R.layout.layout_toast_center, null);
        TextView tv_text = (TextView) toastRoot.findViewById(R.id.tv_content);
        if (tv_text != null) {
            tv_text.setText(msg);
        }
        DToast.make(mContext)
                .setView(toastRoot)
                .setGravity(Gravity.CENTER, 0, 0)
                .show();
    }

    //退出APP时调用
    public static void cancelAll() {
        DToast.cancel();
    }
}
个人比较懒，没有把这个类整到一起~~~
如果应用中发现啥问题，请提出来，后期我做修改~~ 571566726@qq.com
