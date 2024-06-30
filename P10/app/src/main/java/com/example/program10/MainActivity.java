package com.example.program10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_CODE = 101;
    private EditText editTextPhoneNumber;
    private EditText editTextMessage;
    private TextView textViewReceivedMessages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextMessage = findViewById(R.id.editTextMessage);
        textViewReceivedMessages = findViewById(R.id.textViewReceivedMessages);
        // Request SMS permissions if not granted

        if (!checkSMSPermission()) {
            requestSMSPermission();
        }
        // Register SMS receiver
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(smsReceiver, intentFilter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(smsReceiver);
    }
    // Button click listener for sending SMS
    public void sendMessage(View view) {
        String phoneNumber =
                editTextPhoneNumber.getText().toString().trim();
        String message = editTextMessage.getText().toString();

        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Please enter a valid phone number",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, "Invalid phone number format",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Failed to send message",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    // Check if SMS permission is granted

    private boolean checkSMSPermission() {
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED;
    }
    // Request SMS permission
    private void requestSMSPermission() {
        ActivityCompat.requestPermissions(this, new
                String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CODE);
    }
    // SMS receiver
    private final BroadcastReceiver smsReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus != null) {
                    for (Object pdu : pdus) {
                        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                        String senderPhoneNumber = smsMessage.getDisplayOriginatingAddress();
                        String messageBody = smsMessage.getMessageBody();
                        textViewReceivedMessages.append("From: " +
                                senderPhoneNumber + "\n");
                        textViewReceivedMessages.append("Message: " +
                                messageBody + "\n\n");
                    }
                }
            }
        }
    };
}
