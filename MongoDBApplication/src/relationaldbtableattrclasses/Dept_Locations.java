/**
 *
 * @author Gaurab R. Gautam
 */


// package name
package relationaldbtableattrclasses;

/**
 * Name:        Dept_Locations
 * Type:        Class
 * Description: Dept_Locations class (with getters and setters) used to create object 
 *              that stores data from the input file.
 */
public class Dept_Locations
{
    // variable declarations
    private int dNumber;
    private String dLocation;

    // constructors
    public Dept_Locations(int dNumber, String dLocation)
    {
        this.dNumber = dNumber;
        this.dLocation = dLocation;
    }
    
    // Getters and setters ...

    public int getdNumber()
    {
        return dNumber;
    }

    public String getdLocation()
    {
        return dLocation;
    }

    public void setdNumber(int dNumber)
    {
        this.dNumber = dNumber;
    }

    public void setdLocation(String dLocation)
    {
        this.dLocation = dLocation;
    }
}
