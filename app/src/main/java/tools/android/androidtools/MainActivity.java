package tools.android.androidtools;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import tools.android.androidtools.sms.activity.SettingAction;
import tools.android.androidtools.sms.utils.MyPagerAdapter;
import tools.android.androidtools.util.Permission;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private ViewPager viewPager;
    private List<View> viewList;
    private BottomNavigationView navigationView;
    private SettingAction settingAction ;
    private Context context = this;
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewPager();
        setNavigationView();
    }

    private void setViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater = LayoutInflater.from(this);
        View home = inflater.inflate(R.layout.home, null);
        View setting = inflater.inflate(R.layout.setting, null);
        View information = inflater.inflate(R.layout.information, null);
        viewList = new ArrayList<>();
        viewList.add(home);
        viewList.add(setting);
        viewList.add(information);
        viewPager.setAdapter(new MyPagerAdapter(viewList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationView.getMenu().getItem(position).setChecked(true);
                switch (position){
                    case 0:
                        Log.i(TAG, "onPageSelected: Home");
                        break;
                    case 1:
                        Log.i(TAG, "onPageSelected: Setting");
                        Permission.getSms(activity);
                        settingAction =  SettingAction.getSettingAction(activity,viewPager);
                        settingAction.run();
                        break;
                    case 2:
                        Log.i(TAG, "onPageSelected: information");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setNavigationView() {
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_setting:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_information:
                        viewPager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        });
    }

}
