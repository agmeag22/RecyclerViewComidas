package com.meag.reciclerviewcomidas;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragFood.OnFragmentInteractionListener,FragFav.OnFragmentInteractionListener  {

    FragFood fragFood;
    FragFav fragFav;
    Button btnfood,btnfav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnfood = (Button)findViewById(R.id.btnfragfood);
        btnfav = (Button)findViewById(R.id.btnfragfav);

        btnfood.setOnClickListener(this);
        btnfav.setOnClickListener(this);

        fragFood=new FragFood();


        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.replace(R.id.contenedor,fragFood);
        transition.commit();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnfragfood:

                FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.contenedor,fragFood);
                transition.addToBackStack(null);
                transition.commit();
                Log.d("BOTON", "onClick: SE PRESIONO EL BOTON COMIDA");
                break;

            case R.id.btnfragfav:
                FragFav fragFav=new FragFav();
                FragmentTransaction transition1 = getSupportFragmentManager().beginTransaction();
                transition1.replace(R.id.contenedor,fragFav);
                transition1.addToBackStack(null);
                ArrayList<Food> filterfood = new ArrayList(fragFood.getFoods());
                Bundle args = new Bundle();
                Iterator<Food> it = filterfood.iterator();
                while (it.hasNext()){
                    if(!it.next().getbFav()){
                        it.remove();
                    }
                }
                args.putSerializable("foods", filterfood);
                fragFav.setArguments(args);

                transition1.commit();


                Log.d("BOTON", "onClick: SE PRESIONO EL BOTON FAVORITOS");
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
