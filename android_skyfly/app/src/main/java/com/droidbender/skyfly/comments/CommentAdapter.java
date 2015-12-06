package com.droidbender.skyfly.comments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.droidbender.skyfly.R;
import com.droidbender.skyfly.comments.model.Comment;
import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

  public ArrayList<Comment> comments = new ArrayList<>();

  private Context context;

  public CommentAdapter (Context context) {

    this.context = context;
  }

  @Override public CommentViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {

    return new CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.view_comment, parent, false));
  }

  @Override public void onBindViewHolder (CommentViewHolder holder, int position) {

    holder.setComment(comments.get(position));
  }

  @Override public int getItemCount () {

    return comments.size();
  }

  public void remove (int position) {

    if (position < comments.size()) {
      comments.get(position).person = null;
      notifyItemChanged(position);
    }
  }

  public void add (Comment comment, int position) {

    comments.add(position, comment);
    notifyItemInserted(position);
  }
}
