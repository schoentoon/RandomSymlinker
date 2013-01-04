package com.schoentoon.randomsymlinker;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import android.content.Context;
import android.widget.Toast;

public final class Helpers {
  public static final void setSymlink(Context context) {
    File random = new File("/dev/random");
    boolean isDefault = false;
    try {
      isDefault = random.getAbsolutePath().equals(random.getCanonicalPath());
    } catch (IOException e) {
    }
    if (isDefault) {
      try {
        Process p = Runtime.getRuntime().exec("su");
        DataOutputStream os=new DataOutputStream(p.getOutputStream());
        os.writeBytes("mv /dev/random /dev/random_old\n");
        os.writeBytes("ln -s /dev/urandom /dev/random\n");
        os.flush();
      } catch (Exception e) {
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
      } finally {
        Toast.makeText(context, "Succesfully symlinked /dev/urandom to /dev/random", Toast.LENGTH_SHORT).show();
      }
    } else {
      Toast.makeText(context, "Symlink is already set.", Toast.LENGTH_SHORT).show();
    }
  }
}
