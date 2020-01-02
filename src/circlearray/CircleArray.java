/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlearray;


/*
 * CIT-242 Project 1; RGB Color Grid
 * Student: Soroush Aghajani
 * Date: 1/31/2019
 * this program will generate 25 circle and hold them in a 2d array and read the int data of color from a text file
 * gridpane is used to place all the circles
 */

import static java.awt.Color.BLACK;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
    

public class CircleArray extends Application {
static int count = 0;
    @Override
    public void start(Stage primaryStage) {
//creating 2d array of type circle to hold the circles
// creating 3d arrat of type integer to hold colors integer for each circle
//creating a gridPane

        Circle[][] circle = new Circle[5][5];
        int[][][] color = new int[5][5][3];
        Object[][][] object = new Object[5][5][3];
        String[][][] stringColor = new String[5][5][3];
        String [] stringco = new String[75];
        GridPane root = new GridPane();
        int pop;
        
String push ;

//try to open the infortmation file and read the data for color
        try {
            java.io.File file = new java.io.File("colorData.txt");
            Scanner scaner = new Scanner(file); 
            //scaner.useDelimiter(",|W|s|w|S\r\n");

            for (int i = 0; i < circle.length; i++) {
                for (int j = 0; j < circle[i].length; j++) {
                    //assign the circles into the 2d array and set their stroke to black
                    circle[i][j] = new Circle(20);
                    circle[i][j].setStroke(Color.BLACK);

                  
                        //read the integeres from file and assign them in 3d color array
                        String pushd = null;
                               pushd = scaner.nextLine();
                               
                               String temp [] = pushd.split("\\s*(=>|,|\\s)\\s*");
// casting string to integer and adding to the color array
                        color[i][j][2] = Integer.parseInt(temp[0]);
                         color[i][j][1] = Integer.parseInt(temp[1]);
                          color[i][j][0] = Integer.parseInt(temp[2]);

                }
            }
 } catch (FileNotFoundException ex) {
            System.out.println("cannot be opend");
            Logger.getLogger(CircleArray.class.getName()).log(Level.SEVERE, null, ex);
        }
        //placing the circles on the gridPane
        for (int q = 0; q < circle.length; q++) {
            for (int r = 0; r < circle[q].length; r++) {
                circle[q][r].setFill(Color.rgb(color[q][r][2], color[q][r][1], color[q][r][0]));
                root.add(circle[q][r], r, q);
            }

        }

        Scene scene = new Scene(root, 200, 200);

        primaryStage.setTitle(
                "Circle Array");
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
