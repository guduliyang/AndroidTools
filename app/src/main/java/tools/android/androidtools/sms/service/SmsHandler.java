package tools.android.androidtools.sms.service;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import tools.android.androidtools.sms.entity.SMS;

public class SmsHandler extends Handler {
    private static final String TAG = "SmsHandler";
    private Context context;

    public SmsHandler(Context context) {
        this.context = context;
    }

    @Override
    public void handleMessage(Message msg) {
        SMS sms = (SMS)msg.obj;
        Toast.makeText(context, sms.toString(), Toast.LENGTH_SHORT).show();
    }
}
