/******************************************************************************
 * Class:   Triangle
 * 
 * Purpose: Used as the model to represent a triangle and its 3 sides. This 
 *          class determines the triangle type (right, obtuse, or acute), and
 *          calculates the area and perimeter of the triangle.
 *          
 * Author:  Ryan Rickgauer
 *****************************************************************************/

public class Triangle {
    
    private double a;           // side a
    private double b;           // side b
    private double c;           // side c
    private double a2;          // a squared
    private double b2;          // b squared
    private double c2;          // c squared
    private double area;        // area of the triangle
    private String type;        // triangle type (right, acute, obtuse)
    private double perimeter;   // perimetero of triangle
    
    public Triangle() {
        a = 1;
        b = 1;
        c = 1;
        
        // calculate squares
        a2 = a * a;
        b2 = b * b;
        c2 = c * c;
        
        // perform calculations
        determineType();       
        calculateArea();       
        calculatePerimeter();   
    }
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        
        // calculate squares
        a2 = a * a;
        b2 = b * b;
        c2 = c * c;
        
        // perform calculations
        determineType();        
        calculateArea();        
        calculatePerimeter();   
        
    }
    
    public void setA(double a) {
        this.a = a;             // update a
        a2 = a * a;             // calculate a squared
        determineType();        // update triangle type
        calculateArea();        // update area
        calculatePerimeter();   // update perimeter
        
    }
    
    public void setB(double b) {
        this.b = b;             // update b
        b2 = b * b;             // calculate b squared
        determineType();        // update triangle type
        calculateArea();        // update area
        calculatePerimeter();   // update perimeter
    }
    
    public void setC(double c) {
        this.c = c;             // update c
        c2 = c * c;             // calculate c squared
        determineType();        // update triangle type
        calculateArea();        // update area
        calculatePerimeter();   // update perimeter
    }
    
    public double getA() {
        return a;
    }
    
    public double getB() {
        return b;
    }
    
    public double getC() {
        return c;
    }
    
    public String getType() {
        return type;
    }
    
    public double getArea() {
        return area;
    }
    
    public double getPerimeter() {
        return perimeter;
    }
    
    // calculate area using Heron's formula
    public void calculateArea() {
        double s = (a + b + c) / 2;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public void calculatePerimeter() {
        perimeter = a + b + c;
    }
    
    // determines the type of triangle 
    private void determineType() {
        if (isRight())
            type = "R";
        else if (isObtuse())
            type = "O";
        else
            type = "A";
    }
    
    // checks if it is a right triangle type
    private boolean isRight() {
        return c2 == a2 + b2;
    }
    
     // checks if it is an obtuse triangle type
    private boolean isObtuse() {
        return c2 > a2 + b2;
    }
    
     // checks if it is an acute triangle typ
    private boolean isAcute() {
        return c2 < a2 + b2;
    }  
}
