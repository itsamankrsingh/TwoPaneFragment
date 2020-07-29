package com.aman.twopanefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class OptionFragment extends Fragment implements OptionAdapter.OnOptionListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<OptionalList> lists;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.recycler_optional_fragment, container, false);

        recyclerView=view.findViewById(R.id.recycler_optional_fragment);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

        lists=new ArrayList<>();

        for(int i=1;i<=10;i++) {
            OptionalList list = new OptionalList("Background "+i);
            lists.add(list);
        }


        adapter=new OptionAdapter(lists,container.getContext(), this);

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void OnOptionClick(int position) {
        Toast.makeText(getContext(), "Clicked " + (position + 1), Toast.LENGTH_SHORT).show();
    }
}