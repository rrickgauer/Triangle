/******************************************************************************
 * Class:   Driver
 * 
 * Purpose: This class is the main class, and the "driver" of the application.
 *          It initializes the 3 other classes to start running the program.
 *          
 *          The reasoning for creating this was to practice writing software 
 *          using the Model View Controller (MVC) design pattern. The application
 *          has users enter the lengths of the 3 sides of a triangle. Then, the
 *          user can view the triangle's type, area, and perimeter. Before 
 *          the calculation begins, the program validates the lengths, and 
 *          checks if the lengths entered can mathematically represent a triangle.
 *          
 *          
 * Author:  Ryan Rickgauer
 * 
 *****************************************************************************/

public class Driver {
    public static void main(String[] args) {
        Controller controller = new Controller(new Triangle(), new MainFrame());
        controller.control();
         
    }
}
