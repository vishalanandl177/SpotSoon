package com.vishalanand.spotsoon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vishalanand.spotsoon.R;
import com.vishalanand.spotsoon.VideoAdapter;
import com.vishalanand.spotsoon.VideoHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment {

    private List<VideoHolder> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private VideoAdapter mAdapter;

    public VideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_videos, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        mAdapter = new VideoAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
        return v;
    }

    private void prepareMovieData() {
        VideoHolder holder = new VideoHolder("Image Location 1", "Justin Bieber", "ksdgfksdgfksdfkjsfkjsksjkjs", "the current time");
        movieList.add(holder);
        holder = new VideoHolder("Image Location ", "Enrique iglesias", "ksdgfksdgfksdfkjsfkjsksjkjs", "the current time");
        movieList.add(holder);
        holder = new VideoHolder("Image Location", "ALizee jacotey", "ksdgfksdgfksdfkjsfkjsksjkjs", "the current time");
        movieList.add(holder);
        mAdapter.notifyDataSetChanged();
    }

}
