package com.evolvear.progressdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;

        Button btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressView.getInstance().showProgressDialog(context, getString(R.string.loading));
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (ProgressView.getInstance().isDialogShowing()) {
            ProgressView.getInstance().dismissDialog();
            return;
        }
        super.onBackPressed();
    }
}
