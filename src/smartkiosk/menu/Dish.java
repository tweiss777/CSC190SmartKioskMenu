/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartkiosk.menu;

import javafx.scene.image.Image;

/**
 *
 * @author talweiss
 */
public class Dish {
    //Class variables
    protected String name;
    protected String description;
    protected String price;
    protected String imageName;

    //Constructor for the object
    public Dish(String name, String description,String imageName, String price){
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getDescrip(){
        return description;
    }

    public String getPrice(){
        return price;
    }
    
    public String getImageName(){
        return imageName;
    }
}
