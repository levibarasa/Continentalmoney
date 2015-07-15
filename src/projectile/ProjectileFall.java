/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectile;

import java.util.Scanner;

/**
 *
 * @author Levi Barasa
 */
public class ProjectileFall {
//variable initialization

    double height = 0.00;
    double horizontalLength = 0.00;
    //assume initial angle thetre is 60 degrees
    double theatre = 60;
    double tan;

    public ProjectileFall() {
    }
     //method to return the horizontal length before the ball settles

    public String horizontaLength() {
        //Input initial height
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the height of the building :");
        height = input.nextDouble();
        do {
            /*
             Since its Iscoceles triangle,
             horizontallength is twice that of each right angled triangle
             Decrement height and angle by 25 percent
             add new horizontalLength to the prevous cumulative horizontalLength
             before ball settles
             */
            tan = Math.tan(theatre);
            if (tan > 0) {
                double tanInverse = (1 / tan);
                double x = 0.75 * height * tanInverse;
                horizontalLength = 2 * x;

                height = height * 0.75;
                theatre = theatre * 0.75;
                horizontalLength += horizontalLength;
            } else {
                break;
            }

        } while (height > 0 && theatre > 0);
        return " Horizontal Length is : " + horizontalLength;
    }

    public static void main(String[] args) {
        ProjectileFall projectileFall = new ProjectileFall();
        System.out.println(projectileFall.horizontaLength());
    }
}
