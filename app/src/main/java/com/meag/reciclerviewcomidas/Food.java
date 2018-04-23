package com.meag.reciclerviewcomidas;

import java.io.Serializable;

public class Food implements Serializable{
private String name,description;
private int img;
private boolean bFav=false;

    public Food(String name, String description, int img) {
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setbFav(boolean fav) {
        this.bFav = fav;
    }

    public boolean getbFav() {
        return bFav;
    }
}
