/**
 *
 * @author Gaurab R. Gautam
 */

// package name
package relationaldbtableattrclasses;

/**
 * Name:        Project
 * Type:        Class
 * Description: Project class (with getters and setters) used to create object 
 *              that stores data from the input file.
 */
public class Project
{
    // variable declarations
    private String pName;
    private int pNumber;
    private String pLocation;
    private int dNum;

    // constructor
    public Project(String pName, int pNumber, String pLocation, int dNum)
    {
        this.pName = pName;
        this.pNumber = pNumber;
        this.pLocation = pLocation;
        this.dNum = dNum;
    }

    // Getters and setters ...
    
    public String getpName()
    {
        return pName;
    }

    public int getpNumber()
    {
        return pNumber;
    }

    public String getpLocation()
    {
        return pLocation;
    }

    public int getdNum()
    {
        return dNum;
    }

    public void setpName(String pName)
    {
        this.pName = pName;
    }

    public void setpNumber(int pNumber)
    {
        this.pNumber = pNumber;
    }

    public void setpLocation(String pLocation)
    {
        this.pLocation = pLocation;
    }

    public void setdNum(int dNum)
    {
        this.dNum = dNum;
    }
}
