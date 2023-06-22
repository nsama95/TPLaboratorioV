package com.example.tp_labov;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParserJson {
    //determinamos si el json es de objetos o una lista
    public static List<StarWarsModel> parsearJSON(String str) throws JSONException {
        List<StarWarsModel> perList= new ArrayList<>();
        try {
            JSONObject objJSON = new JSONObject(str);
            JSONArray perArray = objJSON.getJSONArray("results");

            //Log.d("hola"+perArray);
            for(int i=0;i<perArray.length();i++){
                JSONObject perJson = perArray.getJSONObject(i);
                StarWarsModel per= new StarWarsModel();
                per.setName(perJson.getString("name"));
                per.setHeight(perJson.getString("height"));
                per.setMass(perJson.getString("mass"));
                per.setHairColor(perJson.getString("hair_color"));
                per.setSkinColor(perJson.getString("skin_color"));
                per.setEyeColor(perJson.getString("eye_color"));
                per.setBirthYear(perJson.getString("birth_year"));
                per.setGender(perJson.getString("gender"));

                perList.add(per);

            }
            MainActivity.listPerAux.addAll(perList);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Log.d("hola", String.valueOf(perList));
        return perList;
    }

}
