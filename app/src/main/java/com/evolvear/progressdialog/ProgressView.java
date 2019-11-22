package com.evolvear.progressdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

public class ProgressView {

    private Dialog dialog;
    private static ProgressView instance = null;

    public static ProgressView getInstance() {
        if (instance == null)
            instance = new ProgressView();

        return instance;
    }

    public void showProgressDialog(Context context, String msg) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_progress_view);

        TextView text = dialog.findViewById(R.id.tv_message);
        text.setText(msg);

        dialog.show();
    }

    public boolean isDialogShowing() {
        if (dialog != null)
            return dialog.isShowing();
        else
            return false;
    }

    public void dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
