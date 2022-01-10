package com.renato.ec03;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.renato.ec03.network.ImageRequester;
import com.renato.ec03.network.StoryEntry;

import java.util.List;
public class StoryCardRecyclerViewAdapter extends RecyclerView.Adapter<StoryCardViewHolder>{
    private List<StoryEntry> storyList;
    private ImageRequester imageRequester;
    StoryCardRecyclerViewAdapter(List<StoryEntry> storyList){
        this.storyList =storyList;
        imageRequester= ImageRequester.getInstance();
    }
    @NonNull
    @Override
    public StoryCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.story_card,parent, false);
        return new StoryCardViewHolder(layoutView);
    }
    @Override
    public void onBindViewHolder(@NonNull StoryCardViewHolder holder,int position){
        if(storyList!=null& position<storyList.size()){
            StoryEntry story= storyList.get(position);
            holder.storyTitle.setText(story.title);
            imageRequester.setImageFromUrl(holder.storyImage, story.url);
        }
    }
    @Override
    public int getItemCount(){
        return storyList.size();
    }
}
