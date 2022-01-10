package com.renato.ec03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import com.renato.ec03.network.StoryEntry;

public class HomeFragment extends Fragment {
    @Override
    public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.home_fragment, container, false);
        setUpToolbar(view);

        RecyclerView recyclerView= view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, GridLayoutManager.VERTICAL, false));
        StoryCardRecyclerViewAdapter adapter=new StoryCardRecyclerViewAdapter(
                StoryEntry.initStoryEntryList(getResources()));
        recyclerView.setAdapter(adapter);
        int largePadding=getResources().getDimensionPixelSize(R.dimen.story_grid_spacing);
        int smallPadding=getResources().getDimensionPixelSize(R.dimen.story_grid_spacing_small);
        recyclerView.addItemDecoration(new StoryGridItemDecoration(largePadding, smallPadding));
        return view;
    }
    private void setUpToolbar(View view ){
        Toolbar toolbar=view.findViewById(R.id.app_bar);
        AppCompatActivity activity= (AppCompatActivity) getActivity();
        if(activity!=null){
            activity.setSupportActionBar(toolbar);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        super.onCreateOptionsMenu(menu,menuInflater);
    }

}
