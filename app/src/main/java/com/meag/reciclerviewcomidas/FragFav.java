package com.meag.reciclerviewcomidas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragFav.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragFav extends Fragment {

    private View v;
    private RecyclerView rv;
    private FoodAdapter adapter;
    private ArrayList<Food> foods;
    private LinearLayoutManager lManager;
    private OnFragmentInteractionListener mListener;

    public FragFav() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_frag_fav, container, false);
        if(getArguments() != null) {
            Bundle args = getArguments();
            foods = (ArrayList<Food>) args.getSerializable("foods");
        }
        rv=v.findViewById(R.id.recyclerfood);
        rv.setHasFixedSize(true);
        lManager=new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(lManager);
        adapter=new FoodAdapter(foods);
        rv.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void prepareFood() {
        this.foods=new ArrayList<>();

    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public RecyclerView getRv() {
        return rv;
    }

    public void setRv(RecyclerView rv) {
        this.rv = rv;
    }
}
