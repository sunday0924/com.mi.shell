package com.mi.shell;

import android.os.Bundle;
import android.preference.Preference;

public class demo_2 extends PreferenceScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.demo_2);
    }
    public boolean onPreferenceTreeClick(android.preference.PreferenceScreen preferenceScreen, Preference preference) {
        //  String key = preference.getKey();
        if (preference.getKey() != null && preference.getKey().startsWith("sh /")) {
            ShellUtils.execCommand(preference.getKey(), true);
        }
        return false;
    }
}
