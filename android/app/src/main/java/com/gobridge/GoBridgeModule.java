package com.gobridge;

import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import go.bridge.Bridge;

public class GoBridgeModule extends ReactContextBaseJavaModule {

    public GoBridgeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "GoBridgeAndroid";
    }

    @ReactMethod
    public void sayHello(String name, Promise promise) {
        Log.d("GoBridgeModule", "run Bridge.sayHello()");
        try {
            String result = Bridge.sayHello(name);
            Log.d("Bridge.sayHello", result);

            promise.resolve(result);
        } catch (Exception e) {
            Log.e("GoBridgeModule", "Bridge.sayHello() error: " + e.toString());
            promise.reject(e);
        }
    }
}
