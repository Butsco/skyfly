package com.droidbender.skyfly.comments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.droidbender.skyfly.R;
import com.droidbender.skyfly.comments.model.Comment;
import java.util.Random;
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;

public class CommentFragment extends Fragment {

  @Bind (android.R.id.list) RecyclerView recyclerView;

  private CommentAdapter commentAdapter;

  private LinearLayoutManager linearLayoutManager;

  private Handler handler = new Handler();

  private Runnable commentRunnable = new Runnable() {

    @Override public void run () {

      int addPosition = 0;
      commentAdapter.add(getComment(), addPosition);
      recyclerView.scrollToPosition(addPosition);
      handler.postDelayed(this, new Random().nextInt(1000) + new Random().nextInt(500) + 250);
    }
  };

  @Nullable @Override public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_comments, null);
    ButterKnife.bind(this, view);

    return view;
  }

  @Override public void onViewCreated (View view, Bundle savedInstanceState) {

    super.onViewCreated(view, savedInstanceState);

    commentAdapter = new CommentAdapter(getActivity());
    linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);

    recyclerView.setAdapter(commentAdapter);
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setItemAnimator(new FadeInRightAnimator(new OvershootInterpolator(1f)));
    recyclerView.getItemAnimator().setAddDuration(250);
  }

  public void start () {

    stopShowingComments();
    startShowingComments();
  }

  private void startShowingComments () {

    handler.postDelayed(commentRunnable,1500);
    handler.postDelayed(new Runnable() {

      @Override public void run () {
        handler.removeCallbacks(commentRunnable);
      }
    },28000);
  }

  private void stopShowingComments () {

    handler.removeCallbacks(commentRunnable);
  }

  private Comment getComment () {

    Comment comment = SampleComments.generateComment();
    handler.postDelayed(new MyRemoveRunnable(comment), comment.timeout);
    return comment;
  }

  private class MyRemoveRunnable implements Runnable {

    Comment comment;

    public MyRemoveRunnable (Comment comment) {

      this.comment = comment;
    }

    @Override public void run () {

      for (int i = 0; i < commentAdapter.comments.size(); i++) {
        if (comment == commentAdapter.comments.get(i)) {
          commentAdapter.remove(i);
        }
      }
    }
  }
}
