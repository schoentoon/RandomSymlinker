package com.schoentoon.randomsymlinker;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button set_now = (Button) findViewById(R.id.set_now);
    set_now.setOnClickListener(new OnClickListener() {
      public void onClick(View v) {
        Helpers.setSymlink(MainActivity.this);
      }
    });
    CheckBox on_boot = (CheckBox) findViewById(R.id.on_boot);
    final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
    on_boot.setChecked(settings.getBoolean("on_boot", false));
    on_boot.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      public void onCheckedChanged(CompoundButton button, boolean selected) {
        settings.edit()
                .putBoolean("on_boot", selected)
                .commit();
      }
    });
  }
}
