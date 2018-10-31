package com.mi.shell;

import android.preference.Preference;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends PreferenceScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 加载xml文件为布局界面
        addPreferencesFromResource(R.xml.main);
        // 尝试获取ROOT权限
        ShellUtils.execCommand("echo su", true);
    }
    public boolean onPreferenceTreeClick(android.preference.PreferenceScreen preferenceScreen, Preference preference) {
        // 如果key值不为空，并且以sh /开头，那么取出其key值为shell命令直接执行
        if (preference.getKey() != null && preference.getKey().startsWith("sh /")) {
            ShellUtils.execCommand(preference.getKey(), true);
            return true;
        } else {
            // 如果key值为rest
            if (preference.getKey().equals("rest")) {
                Toast.makeText(MainActivity.this, "你点击了我", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }
}