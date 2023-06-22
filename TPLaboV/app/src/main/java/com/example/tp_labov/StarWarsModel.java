package com.example.tp_labov;
import androidx.annotation.NonNull;

public class StarWarsModel {
    String name; //"Luke Skywalker",
    String height;// "172",
    String mass;// "77",
    String hairColor;// "blond",
    String skinColor;// "fair",
    String eyeColor;// "blue",
    String birthYear;// "19BBY",
    String gender;// "male",
    StarWarsModel(){}
    StarWarsModel(String name,
                  String height,
                  String mass,
                  String hairColor,
                  String skinColor,
                  String eyeColor,
                  String birthYear,
                  String gender){
        setName(name);
        setHeight(height);
        setMass(mass);
        setHairColor(hairColor);
        setSkinColor(skinColor);
        setEyeColor(eyeColor);
        setBirthYear(birthYear);
        setGender(gender);

    }
    public String getName() {return this.name;}
    public void setName(String nameR) {this.name = nameR;}

    public String getHeight() {return this.height;}
    public void setHeight(String heightR) {this.height = heightR;}

    public String getMass() {return this.mass;}
    public void setMass(String massR) {this.mass = massR;}

    public String getHairColor() {return this.hairColor;}
    public void setHairColor(String hairColorR) {this.hairColor = hairColorR;}

    public String getSkinColor() {return this.skinColor;}
    public void setSkinColor(String skinColorR) {this.skinColor = skinColorR;}

    public String getEyeColor() {return this.eyeColor;}
    public void setEyeColor(String eyeColorR) {this.eyeColor = eyeColorR;}

    public String getGender() {return this.gender;}
    public void setGender(String genderR) {this.gender = genderR;}

    public String getBirthYear() {return this.birthYear;}
    public void setBirthYear(String birthYearR) {this.birthYear = birthYearR;}

    @NonNull
    @Override
    public String toString()
    {

        String objString =
                " Nombre: "+this.name+
                        "Altura: "+this.height.toString()+
                        "masa: "+this.mass.toString()+
                        " Color de pelo: "+this.hairColor+
                        " Color de piel: "+this.skinColor+
                        " Color de ojos: "+this.eyeColor+
                        " Genero: "+this.gender+
                        " Cumpleaños: "+this.birthYear
                        ;

        return objString;
    }

}
