package com.example.tp_labov;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdapterSW extends RecyclerView.Adapter<ViewHolderSW> {
    List<StarWarsModel> personas;
   // private MainActivity mainAct;
    private Handler handler;
    public AdapterSW(List<StarWarsModel> personas, Handler handler){
        this.personas=personas;
        this.handler = handler;
    }
    public void setPersonas(List<StarWarsModel> personas)
    {
        this.personas = personas;
    }
    @NonNull
    @Override
    //genera un item
    public ViewHolderSW onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //genera el layout
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.persona,parent,false);
        return new ViewHolderSW(v);
    }

    @Override
    //le agrega los datos
    public void onBindViewHolder(@NonNull ViewHolderSW holder, int position) {
        StarWarsModel p=this.personas.get(position);

        holder.name.setText(p.getName());

        holder.height.setText(p.getHeight());

        holder.mass.setText(p.getMass());

        holder.hairColor.setText(p.getHairColor());

        holder.skinColor.setText(p.getSkinColor());

        holder.eyeColor.setText(p.getEyeColor());

        holder.birthYear.setText(p.getBirthYear());

        holder.gender.setText(p.getGender());

    }

    @Override
    //cantidad de elementos que va a dibujar
    public int getItemCount() {
        return this.personas.size();
    }
}
