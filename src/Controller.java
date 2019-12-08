/******************************************************************************
 * Class:   Controller
 * 
 * Purpose: This is the controller in the MVC design patter. It adds all the 
 *          ActionListeners to the buttons, and updates the MainFrame with the
 *          calculated data received from the Triangle class.
 *          
 * Author:  Ryan Rickgauer
 *****************************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Controller {
 
    private Triangle triangle;
    private MainFrame mainFrame;
    private ActionListener calculateButtonActionListener;
    private ActionListener clearFieldsButtonActionListener;
    DecimalFormat df = new DecimalFormat();
                        
    // constructor
    public Controller(Triangle triangle, MainFrame mainFrame) {
        this.triangle = triangle;
        this.mainFrame = mainFrame;
        df.setMaximumFractionDigits(2); // set decimal formatter to have 2 decimal places
        
    }
    
    // add all ActionListeners
    public void control() {
        calculateButtonActions();
        clearFieldsButtonActions();
        
    }
    
    // add ActionListener to the calculateButton 
    public void calculateButtonActions() {
        calculateButtonActionListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    double a = mainFrame.getA();            // get side A
                    double b = mainFrame.getB();            // get side B
                    double c = mainFrame.getC();            // get side C
                    
                    if (validateLengths(a, b, c)) {
                        triangle = new Triangle(a, b, c);   // create a triangle with new dimensions
                        executeTypeActions();               // display type
                        executeAreaActions();               // display area
                        executePerimeterActions();          // display perimeter
                    }
                } 
                
                // a textfield was empty when the calculate button was clicked
                catch(NumberFormatException ex) {      
                    mainFrame.showEmptyTextFieldOptionPane();
                }  
            }
        };
        
        mainFrame.getCalculateButton().addActionListener(calculateButtonActionListener); 
    }
    
    // tests to make sure that the sides create a possible triangle
    private boolean validateLengths(double a, double b, double c) {
        
        // check for negatives
        if (a <= 0 || b <= 0 && c <= 0) {
            mainFrame.showNegativeDoubleOptionPanel(); 
            return false;
        } 

        // check for C >= a and C >= B
        else if (c < a || c < b) {
            mainFrame.showSmallSideCOptionPanel();
            return false;
        } 
        
        // check that C is less than A + B
        else if (c >= a + b) {
            mainFrame.showImpossibleTriangleOptionPanel();
            return false;
        }
        
        
        return true;
    }
    
    // set the type on the mainframe
    private void executeTypeActions() {
        String result = triangle.getType();              
        
        // determine what type to display
        switch(result) {
            
            case "O":   mainFrame.setResult("Obtuse");  // obtuse type
                        break;
            case "R":   mainFrame.setResult("Right");   // right type
                        break;
            default:    mainFrame.setResult("Acute");   // acute type
                        break;
        }
    }   
    
    // display the area
    private void executeAreaActions() {
        double area = triangle.getArea();                   // get area
        String areaFormatted = df.format(area);             // format area string
        mainFrame.setArea(areaFormatted);                   // set areaLabel to the formatted area
    }
    
    // display the perimeter
    private void executePerimeterActions() {
        double perimeter = triangle.getPerimeter();         // get perimeter
        String perimeterFormatted = df.format(perimeter);   // format perimeter string
        mainFrame.setPerimeter(perimeterFormatted);         // set the perimeter label on the mainframe
    }
    
    // clear the text from the 3 text fields
    public void clearFieldsButtonActions() {
        clearFieldsButtonActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.getTextFieldA().setText("");
                mainFrame.getTextFieldB().setText("");
                mainFrame.getTextFieldC().setText("");
            }
        };
        
        mainFrame.getClearFieldsButton().addActionListener(clearFieldsButtonActionListener);
    }

}
