package com.example.youtubetvgecko;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;


public class MainActivity extends Activity {

    private GeckoView geckoView;
    private GeckoSession session;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().getDecorView().setSystemUiVisibility(
                5894
        );


        geckoView = new GeckoView(this);
        setContentView(geckoView);


        GeckoRuntime runtime =
                GeckoRuntime.create(this);


        session = new GeckoSession();
        session.open(runtime);


        geckoView.setSession(session);


        // YouTube TV web
        session.loadUri(
                "https://www.youtube.com/tv"
        );
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // tombol remote TV
        switch(keyCode){

            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                return super.onKeyDown(keyCode,event);
        }

        return super.onKeyDown(keyCode,event);
    }
}
