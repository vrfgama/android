package br.usjt.ciclodevidaactivity_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.usjt.ciclodevidaactivity_2.Util.StatusTracker;
import br.usjt.ciclodevidaactivity_2.Util.Utils;

public class ActivityC extends AppCompatActivity {

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        mActivityName = getString(R.string.title_activity_activity_c);
        mStatusView = (TextView)findViewById(R.id.status_view_c);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_c);
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy));
        mStatusTracker.clear();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityC.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityB.class);
        startActivity(intent);
    }

    public void finishActivityC(View v) {
        ActivityC.this.finish();
    }

}
