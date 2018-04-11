package tools.android.androidtools.sms.service;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import tools.android.androidtools.sms.entity.SMS;

public class SmsObserver extends ContentObserver {
    private final String TAG = "SmsObserver";
    private Handler handler;
    private Context context;
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public SmsObserver(Handler handler) {
        super(handler);
        this.handler = handler;
    }

    public SmsObserver(Handler handler, Context context) {
        super(handler);
        this.context = context;
        this.handler = handler;
    }

    @Override
    public void onChange(boolean selfChange) {
        Log.i(TAG, "onChange: sms change .");
        SMS sms = new SmsReader(context).getLastOne();
        if(sms.getRead()==0){
            Message message = handler.obtainMessage();
            message.obj = sms;
            handler.sendMessage(message);
        }
    }
}
