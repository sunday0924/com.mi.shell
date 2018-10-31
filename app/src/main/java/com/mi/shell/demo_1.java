package com.mi.shell;

import android.os.Bundle;
import android.preference.Preference;

public class demo_1 extends PreferenceScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.demo_1);
    }
    public boolean onPreferenceTreeClick(android.preference.PreferenceScreen preferenceScreen, Preference preference) {
        //  String key = preference.getKey();
        if (preference.getKey() != null && preference.getKey().startsWith("sh /")) {
            ShellUtils.execCommand(preference.getKey(), true);
        }
        return false;
    }
}
