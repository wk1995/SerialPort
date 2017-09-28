package com.myapplication2;

import android.app.Application;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Created by kqw on 2016/10/26.
 * MyApplication
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    public SerialPortFinder mSerialPortFinder = new SerialPortFinder();
    private SerialPort mSerialPort = null;

    public SerialPort getSerialPort() throws SecurityException, IOException, InvalidParameterException {
        if (mSerialPort == null) {
            mSerialPort = new SerialPort(new File("/dev/ttyS3"), 115200, 0);
        }
        return mSerialPort;
    }

    public void closeSerialPort() {
        if (mSerialPort != null) {
            mSerialPort.close();
            mSerialPort = null;
        }
    }
}
