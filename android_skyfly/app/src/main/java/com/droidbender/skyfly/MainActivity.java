package com.droidbender.skyfly;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import butterknife.ButterKnife;
import com.droidbender.skyfly.character.CharacterFragment;
import com.droidbender.skyfly.comments.CommentFragment;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate (Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    View decorView = getWindow().getDecorView();
    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
    decorView.setSystemUiVisibility(uiOptions);
  }

  @Override public boolean dispatchKeyEvent (KeyEvent e) {

    if (e.getKeyCode() == KeyEvent.KEYCODE_SPACE) {
      if (e.getAction() == MotionEvent.ACTION_DOWN) {
        ((CharacterFragment) getFragmentManager().findFragmentById(R.id.fragment_character)).start();
        ((CommentFragment) getFragmentManager().findFragmentById(R.id.fragment_comment)).start();
      }
      return true;
    }
    return super.dispatchKeyEvent(e);
  }

  ;
}
