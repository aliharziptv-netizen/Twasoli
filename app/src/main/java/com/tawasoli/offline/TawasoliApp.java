package com.tawasoli.offline;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import com.google.android.material.color.DynamicColors;
import com.tawasoli.offline.nearby.NearbyManager;
import com.tawasoli.offline.ui.CrashActivity;
import com.tawasoli.offline.utils.Notifier;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TawasoliApp extends Application {
    @Override public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            String n = Application.getProcessName();
            if (n != null && n.endsWith(":crash")) return;
        }
        installCrashScreen();
        DynamicColors.applyToActivitiesIfAvailable(this);
        Notifier.createChannels(this);
        NearbyManager.init(this);
    }
    private void installCrashScreen() {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            try {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String s = sw.toString();
                if (s.length() > 8000) s = s.substring(0, 8000);
                startActivity(new Intent(this, CrashActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .putExtra("trace", s));
                Thread.sleep(500);
            } catch (Throwable ignored) {}
            Process.killProcess(Process.myPid());
            System.exit(10);
        });
    }
}