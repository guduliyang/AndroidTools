package tools.android.androidtools.sms.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;

import tools.android.androidtools.sms.entity.SMS;

public class SmsReader{
    private static final String SMS_URI_INBOX = "content://sms/inbox"; // 收件箱
    private Uri uri = Uri.parse(SMS_URI_INBOX);
    private String[] projection = null;                    //返回的列
    private String selection = null;// "read=?";                  //查询条件（相当于where后边的值）
    private String[] selectionArgs = null;//new String[] {"0"};  //查询条件的值
    private String sortOrder = "date desc";              //排序条件
    private Context context;

    public SmsReader(Context context) {
        this.context = context;
    }

    public SMS getLastOne() {
        Cursor cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        cursor.moveToFirst();
        SMS sms = toSms(cursor);
        if (cursor!=null)cursor.close();
        return sms;
    }

    public List<SMS> getAll() {
        Cursor cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        List<SMS> smsList = new ArrayList<>();
        while (cursor.moveToNext()){
            smsList.add(toSms(cursor));
        }
        if (cursor!=null)cursor.close();
        return smsList;
    }

    private SMS toSms(Cursor cursor){
        SMS sms = new SMS();
        sms.setMODEL(Build.MODEL);
        if(cursor!=null){
            boolean over = false;
            int i=0;
            while (!over){
                try {
                    String s = cursor.getColumnName(i);
                    switch (s) {
                        case "thread_id":
                            sms.setThread_id(cursor.getString(i++));
                            break;
                        case "address":
                            sms.setAddress(cursor.getString(i++));
                            break;
                        case "date":
                            sms.setDate(cursor.getLong(i++));
                            break;
                        case "read":
                            sms.setRead(cursor.getInt(i++));
                            break;
                        case "status":
                            sms.setStatus(cursor.getInt(i++));
                            break;
                        case "type":
                            sms.setType(cursor.getInt(i++));
                            break;
                        case "body":
                            sms.setBody(cursor.getString(i++));
                            break;
                        case "service_center":
                            sms.setService_center(cursor.getString(i++));
                            break;
                        case "sub_id":
                            sms.setSub_id(cursor.getInt(i++));
                            break;
                        case "sim_id":
                            sms.setSim_id(cursor.getInt(i++));
                            break;
                        default:
                            i++;
//                        Log.i(TAG, cursor.getColumnName(i) + ":" + cursor.getString(i++));
                    }
                } catch (Exception e) {
                    over = true;
                }
            }
        }
        return sms;
    }
}
