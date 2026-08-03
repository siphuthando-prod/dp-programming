/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.shape.triangle;

import za.ac.tut.shape.Shape;

/**
 *
 * @author S. X Mabuza
 */
public class Triangle extends Shape {
    public Triangle(String name){
        super(name);
    }
    
    @Override
    public void draw(){
        System.out.println("Drawing a " + this.name);
    }
}
