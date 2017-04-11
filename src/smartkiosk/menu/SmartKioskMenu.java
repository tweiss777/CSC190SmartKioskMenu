/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartkiosk.menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList; // ArrayList library will be used to store our Dish objects.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javafx.scene.control.Label;

/**
 *
 * @author talweiss
 */

public class SmartKioskMenu extends Application {
    ArrayList<Dish> dishList = new ArrayList<Dish>();
    int index = 0; //determines which dish you are at.
    @Override
    public void start(Stage primaryStage) {
        //code for your file (section completed)
        try{
            String path = "/resources/config.txt";
            InputStream stream = SmartKioskMenu.class.getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
            System.out.println("File found");
            String line;
            System.out.println("beginning to iterate through the file");
            while((line = reader.readLine()) != null){
                String name = line;
                line = reader.readLine();
                String description = line;
                line = reader.readLine();
                String price = line;
                line = reader.readLine();
                String imageName = line;
                    
                    
                System.out.println("Name :"+name);
                System.out.println("Description: "+ description);
                System.out.println("Price: " + price);
                  

                    
                Dish dish = new Dish(name, description, imageName, price);
                dishList.add(dish);
                
            }
        }
        
        catch(Exception e){
            System.out.println("File not found!");
        }
        
        
        //code for your labels and buttons and views
        GridPane grid = new GridPane();
        grid.setVgap(5);
        Image img = new Image("resources/"+dishList.get(0).getImageName());//test imagee
        ImageView imageView = new ImageView();//image view object
        imageView.setImage(img);
        imageView.setFitHeight(450);
        imageView.setFitWidth(400);
        Button next = new Button();//button object for next 
        Button prev = new Button();//button object for prev
        Label Name = new Label(dishList.get(0).getName());
        Label Description = new Label("Description: " + dishList.get(0).getDescrip());
        Label Price = new Label("Price: " + dishList.get(0).getPrice());
        Description.setWrapText(true);
        //set the labels for next and prev button and add it to the gridPane
        next.setText("next ->");
        prev.setText("<- prev");
        grid.add(imageView,0,0);
        grid.add(prev,0,2);
        grid.add(next,1,2);
        grid.add(Name,0,1);
        grid.add(Description, 1,0);
        grid.add(Price,1,1);
        
        prev.setDisable(true);
        
                
        //code for event handlers
        
        //create event handlers for next and prev
        
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        next.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                index++; 
                if(index > 0){
                    prev.setDisable(false);
                }
                Name.setText(dishList.get(index).getName());
                Description.setText("Description: "+dishList.get(index).getDescrip());
                Price.setText("Price: " + dishList.get(index).getPrice());
                Image img = new Image("resources/"+dishList.get(index).getImageName());
                imageView.setImage(img);
                //now check if the index is greater than the arraysize and if it is disable it
                if(index == dishList.size()-1){
                    //disable next
                    next.setDisable(true);
                    
                }
            }
        
    });
        
        prev.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                index--; 
                if(index < 1){
                    next.setDisable(false);
                }
                Name.setText(dishList.get(index).getName());
                Description.setText("Description: "+dishList.get(index).getDescrip());
                Price.setText("Price: " + dishList.get(index).getPrice());
                Image img = new Image("resources/"+dishList.get(index).getImageName());
                imageView.setImage(img);
                //now check if the index is greater than the arraysize and if it is disable it
                if(index == 0){
                    //disable next
                    prev.setDisable(true);
                    
                }
            }
        
    });
        
//        StackPane root = new StackPane();
//        //root.getChildren().add(btn);
//        root.getChildren().add(next);
//        root.getChildren().add(prev);
        
        Scene scene = new Scene(grid, 600, 520);
        
        primaryStage.setTitle("Smart Kiosk Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
