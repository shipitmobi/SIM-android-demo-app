package com.example.gdata.dapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import     com.shipit.android.SIM_ActTracker;
import     com.shipit.android.SIM_Docker;
import     com.shipit.android.SIM_Cfg;

public class MainActivity extends AppCompatActivity {

    public final SIM_Docker shipit = SIM_Docker.sharedInstance();
    public final SIM_Cfg cfg_local = SIM_Cfg.sharedInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ProjectID from GCM SenderID Configuration (4)

        cfg_local.projID = "401062355927";

//From shipit dashboard

        cfg_local.SIM_AppKey = "c2a2a6b4ee99039b87fcccef6eecfcc9";
//Enable Push Notification (can also use shipit_setPush(boolean))

        cfg_local.pushEnable = true;

//Enable RichPush Notification (can also use shipit_setRichPush(boolean))

        cfg_local.richPushEnable = true;

//To DEV mode, default is PROD

        cfg_local.buildType = "PROD";

        shipit.init(this);

//To enable user's app movement

        SIM_ActTracker.init(this.getApplication());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
