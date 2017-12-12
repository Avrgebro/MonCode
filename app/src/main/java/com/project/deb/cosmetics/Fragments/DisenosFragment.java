package com.project.deb.cosmetics.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.deb.cosmetics.Adapters.DesignAdapter;
import com.project.deb.cosmetics.Interfaces.OnLoadMoreListener;
import com.project.deb.cosmetics.Model.Design;
import com.project.deb.cosmetics.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisenosFragment extends Fragment {

    private View view;
    private RecyclerView rv;
    private ArrayList<Design> lafirme;

    private DesignAdapter da;

    public static int pageNumber;
    public DisenosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_disenos, container, false);

        rv = (RecyclerView) view.findViewById(R.id.RView);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(llm);

        pageNumber = 1;

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<Design> items = new ArrayList<Design>();
        lafirme = new ArrayList<Design>();

        items.add(new Design(R.drawable.absorb, "Absorb" ));//absorb
        items.add(new Design(R.drawable.mesh, "Mesh" ));//mesh
        items.add(new Design(R.drawable.meters, "Meters" ));//meters
        items.add(new Design(R.drawable.lineof_tree_dots, "Line of three dots" ));//lineoftreedots
        items.add(new Design(R.drawable.golden_curves, "Golden curves" ));//goldencurves
        items.add(new Design(R.drawable.spaces, "Spaces" ));//spaces
        items.add(new Design(R.drawable.greeks_and_frogs, "Greeks and frogs" ));//greeksandfrogs
        items.add(new Design(R.drawable.arround_the_muse, "Around the muse" ));//aroundthemuse
        items.add(new Design(R.drawable.following_the_trumpet, "Following the trumpet" ));//followingtrumpet
        items.add(new Design(R.drawable.fallen_wings, "Fallen wings" ));//fallenwings
        items.add(new Design(R.drawable.labyrinth, "Labyrinth" ));//labyrinth
        items.add(new Design(R.drawable.the_fall, "The fall" ));//thefall

        lafirme.add(items.get(0));
        lafirme.add(items.get(1));
        lafirme.add(items.get(2));

        da = new DesignAdapter(items, rv);

        rv.setAdapter(da);

        da.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                int size = lafirme.size();

                int toadd = 3;

                if((size + 3) > 12) toadd = 12 - size;

                for(int i=1 ; i<toadd; i++) lafirme.add(items.get(lafirme.size() + i));

            }
        });
    }
}
