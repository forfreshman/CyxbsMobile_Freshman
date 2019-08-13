package com.mredrock.cyxbs.freshman.weight;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.utils.interfaces.CustomDialogClicklistener;

public class CustomDialog extends Dialog implements View.OnClickListener{
    Context mContext;
    private TextView btnSure;
    private TextView btnCancle;
    private TextView title;
    private TextView message;
    private CustomDialogClicklistener customDialogClicklistener;

    public CustomDialog(@NonNull Context context, CustomDialogClicklistener clicklistener) {
        super(context, R.style.freshman_CustomDialog);
        this.mContext = context;
        this.customDialogClicklistener = clicklistener;
        initView();
    }

    public void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.freshman_dialog_communicate, null);
        title = (TextView) view.findViewById(R.id.title);
        message = (TextView) view.findViewById(R.id.message);
        btnSure = (TextView) view.findViewById(R.id.dialog_confirm_sure);
        btnCancle = (TextView) view.findViewById(R.id.dialog_confirm_cancel);
        btnSure.setOnClickListener(this);
        btnCancle.setOnClickListener(this);
        super.setContentView(view);
    }

    //对外提供设置标题的方法
    public CustomDialog setTile(String s) {
        title.setText(s);
        return this;
    }

    //对外提供设置提示信息的方法
    public CustomDialog setMessage(String s) {
        message.setText(s);
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_confirm_sure:
                CustomDialog.this.cancel();
                customDialogClicklistener.doConfirm();
                break;
            case R.id.dialog_confirm_cancel:
                CustomDialog.this.cancel();
                customDialogClicklistener.doCancel();
                break;
        }
    }
}

