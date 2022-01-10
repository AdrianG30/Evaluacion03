package com.renato.ec03;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class StoryCardViewHolder extends RecyclerView.ViewHolder{
    public NetworkImageView storyImage;
    public TextView storyTitle;
    public TextView storyPrice;

    public  StoryCardViewHolder(@NonNull View itemView){
        super(itemView);
        storyImage=itemView.findViewById(R.id.story_image);
        storyTitle=itemView.findViewById(R.id.stories_title);

    }
}
