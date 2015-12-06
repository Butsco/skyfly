package com.droidbender.skyfly.comments;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.droidbender.skyfly.comments.model.Comment;

public class CommentViewHolder extends RecyclerView.ViewHolder {

  TextView text1;

  TextView text2;

  ImageView icon;

  public CommentViewHolder (View itemView) {

    super(itemView);
    text1 = (TextView) itemView.findViewById(android.R.id.text1);
    text2 = (TextView) itemView.findViewById(android.R.id.text2);
    icon = (ImageView) itemView.findViewById(android.R.id.icon);
  }

  public void setComment (Comment comment) {

    if (comment.person == null) {
      itemView.setVisibility(View.GONE);
      return;
    }

    Glide.with(itemView.getContext()).load(Uri.parse(comment.person.url)).into(icon);
    text1.setText(comment.person.name);
    text2.setText(comment.text);
  }
}
