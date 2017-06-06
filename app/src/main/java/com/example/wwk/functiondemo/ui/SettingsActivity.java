package com.example.wwk.functiondemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wwk.functiondemo.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by wwk on 17/5/18.
 */

public class SettingsActivity extends BaseActivity implements View.OnClickListener {

    // Scan QR
    private LinearLayout mScanQR;
    // Result of scan
    private TextView mScanResult;
    // Share QR
    private LinearLayout mShareQR;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initializeView();
    }

    private void initializeView() {

        mScanQR = (LinearLayout) findViewById(R.id.scan_qr_code);
        mScanQR.setOnClickListener(this);
        mScanResult = (TextView) findViewById(R.id.scan_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scan_qr_code:
                // Open interface of scan for scan QR code or bar code
                Intent openCameraIntent = new Intent(this, CaptureActivity.class);
                startActivityForResult(openCameraIntent, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            mScanResult.setText(scanResult);
        }
    }
}
