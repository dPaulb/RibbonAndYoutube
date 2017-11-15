package com.dpaulb.paul.ribbonandyoutube.Model;

/**
 * Created by paul on 2017. 11. 15..
 */

public class Item {
    public int type;
    public String headerText, bottomText, imageURL;

    public Item(){

    }

    public Item(int type, String headerText, String bottomText, String imageURL) {
        this.type = type;
        this.headerText = headerText;
        this.bottomText = bottomText;
        this.imageURL = imageURL;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
