package com.schoentoon.randomsymlinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BootReceiver extends BroadcastReceiver {
  public void onReceive(Context context, Intent intent) {
    final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
    if (settings.getBoolean("on_boot", false))
      Helpers.setSymlink(context);
  }
}
