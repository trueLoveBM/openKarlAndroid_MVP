package com.karl.openkarlandroid_mvp.progress;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Dialog的进度控制
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private SweetAlertDialog sad;
    private Context context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;
    private String msg;//弹窗显示的提示信息

    public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener, boolean cancelable) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
        this.msg="正在加载...";
    }

    public ProgressDialogHandler(Context context,String msg, ProgressCancelListener mProgressCancelListener, boolean cancelable) {
        this(context,mProgressCancelListener,cancelable);
        this.msg=msg;
    }

    private void initProgressDialog() {
        if (sad == null) {
            sad = new SweetAlertDialog(context);
            sad.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
            sad.setTitleText(this.msg);
            sad.setCancelable(cancelable);

            if (cancelable) {
                sad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mProgressCancelListener.onCancelProgress();
                    }
                });
            }

            if (!sad.isShowing()) {
                sad.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (sad != null) {
            sad.dismiss();
            sad = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}