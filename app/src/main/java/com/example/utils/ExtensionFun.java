package com.example.utils;





import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class ExtensionFun {

    void loadURL(String url) {
        Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse(url));
      //  startActivity(intent);
    }


}
