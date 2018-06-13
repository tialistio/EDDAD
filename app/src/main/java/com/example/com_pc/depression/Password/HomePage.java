package com.example.com_pc.depression.Password;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.com_pc.depression.R;

public class HomePage extends pwBaseActivity implements OnClickListener {
    public static final String TAG = "MainActivity";

    private Button btOnOff;
    private Button btChange;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_setting);

        btOnOff = (Button) findViewById(R.id.bt_on_off);
        btOnOff.setOnClickListener(this);

        btChange = (Button) findViewById(R.id.bt_change);
        btChange.setText(R.string.change_passcode);
        btChange.setOnClickListener(this);

       updateUI();
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btOnOff)) {
            int type = pwLockManager.getInstance().getAppLock().isPasscodeSet() ? pwAppLock.DISABLE_PASSLOCK
                    : pwAppLock.ENABLE_PASSLOCK;
            Intent intent = new Intent(this, AppLockActivity.class);
            intent.putExtra(pwAppLock.TYPE, type);
            startActivityForResult(intent, type);
        } else if (view.equals(btChange)) {
            Intent intent = new Intent(this, AppLockActivity.class);
            intent.putExtra(pwAppLock.TYPE, pwAppLock.CHANGE_PASSWORD);
            intent.putExtra(pwAppLock.MESSAGE,
                    getString(R.string.enter_old_passcode));
            startActivityForResult(intent, pwAppLock.CHANGE_PASSWORD);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case pwAppLock.DISABLE_PASSLOCK:
                break;
            case pwAppLock.ENABLE_PASSLOCK:
            case pwAppLock.CHANGE_PASSWORD:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, getString(R.string.setup_passcode),
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
      updateUI();
    }

    private void updateUI() {
        if (pwLockManager.getInstance().getAppLock().isPasscodeSet()) {
            btOnOff.setText(R.string.disable_passcode);
            btChange.setEnabled(true);
        } else {
            btOnOff.setText(R.string.enable_passcode);
            btChange.setEnabled(false);
        }
    }
}
