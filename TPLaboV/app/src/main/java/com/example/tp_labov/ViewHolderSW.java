package com.example.tp_labov;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderSW extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name;
    TextView height;
    TextView mass;
    TextView hairColor;
    TextView skinColor;
    TextView eyeColor;
    TextView birthYear;
    TextView gender;
    MainActivity mainAct;
    public ViewHolderSW(@NonNull View itemView) {
        super(itemView);
       // this.mainAct;
        this.name = itemView.findViewById(R.id.tvName);
       this.height = itemView.findViewById(R.id.tvHeigth);
        this.mass = itemView.findViewById(R.id.tvMass);
        this.hairColor = itemView.findViewById(R.id.tvHairColor);
        this.skinColor = itemView.findViewById(R.id.tvSkinColor);
        this.eyeColor = itemView.findViewById(R.id.tvEyeColor);
        this.birthYear = itemView.findViewById(R.id. tvBirthyear);
        this.gender = itemView.findViewById(R.id.tvGender);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
       // Log.d("Se hizo click");
    }
}
