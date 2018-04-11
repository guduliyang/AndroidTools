package tools.android.androidtools.sms.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;

public class SmsService extends Service {
    private static final String SMS_URI_INBOX = "content://sms/inbox"; // 收件箱
    private SmsObserver smsObserver;

    public SmsService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Uri uri = Uri.parse(SMS_URI_INBOX);
        smsObserver = new SmsObserver(new SmsHandler(this),this);
        getContentResolver().registerContentObserver(uri,true,smsObserver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getContentResolver().unregisterContentObserver(smsObserver);
    }

}
