package tools.android.androidtools.sms.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import tools.android.androidtools.R;
import tools.android.androidtools.sms.service.SmsService;
import tools.android.androidtools.util.Permission;

public class SettingAction implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final String TAG = "SettingAction";
    private static SettingAction settingAction;
    private Activity activity;
    private ViewPager viewPager;
    private Switch moniter;
    private Switch autoStart;
    private EditText phone1;
    private EditText phone2;
    private EditText url;
    private Button btnSave;
    private Button btnSync;

    private SettingAction(Activity activity, ViewPager viewPager) {
        this.activity = activity;
        this.viewPager = viewPager;
    }

    public static SettingAction getSettingAction(Activity activity, ViewPager viewPager) {
        if(settingAction==null){
            synchronized (SettingAction.class){
                if(settingAction==null){
                    settingAction = new SettingAction(activity, viewPager);
                }
            }
        }
        return settingAction;
    }

    public void run(){
        moniter = (Switch)viewPager.findViewById(R.id.moniter);
        autoStart = (Switch)viewPager.findViewById(R.id.auto_start);
        phone1 = (EditText)viewPager.findViewById(R.id.editText_phone1);
        phone2 = (EditText)viewPager.findViewById(R.id.editText_phone2);
        url = (EditText)viewPager.findViewById(R.id.editText_url);
        btnSave = (Button)viewPager.findViewById(R.id.btn_save);
        btnSync = (Button)viewPager.findViewById(R.id.btn_sync);
        moniter.setOnCheckedChangeListener(this);
        autoStart.setOnCheckedChangeListener(this);
        btnSave.setOnClickListener(this);
        btnSync.setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.moniter:
                Intent smsIntent = new Intent(activity, SmsService.class);
                if(isChecked){
                    Permission.getSms(activity);
                    activity.startService(smsIntent);
                    Toast.makeText(activity, "已启动短信监听服务", Toast.LENGTH_SHORT).show();
                }else {
                    activity.stopService(smsIntent);
                    Toast.makeText(activity, "已停止短信监听服务", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.auto_start:
                if(isChecked){
                    Log.i(TAG, "onCheckedChanged: 开机启动被选中");
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                Log.i(TAG, "onClick: 保存配置");
                break;
            case R.id.btn_sync:
                break;
        }
    }
}
