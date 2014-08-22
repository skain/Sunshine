package com.example.skain.sunshine;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by skain on 8/22/2014.
 */
public class Utils {
    public static Void MakeToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        return null;
    }
}
