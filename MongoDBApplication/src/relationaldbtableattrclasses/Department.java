/**
 *
 * @author Gaurab R. Gautam
 */


// package name
package relationaldbtableattrclasses;


/**
 * Name:        Department
 * Type:        Class
 * Description: Department class (with getters and setters) used to create object 
 *              that stores data from the input file.
 */
public class Department
{
    // variable declarations
    private String dName;
    private int dNumber;
    private String mgr_ssn;
    private String mgr_start_date;

    // constructor
    public Department(String dName, int dNumber, String mgr_ssn, String mgr_start_date)
    {
        this.dName = dName;
        this.dNumber = dNumber;
        this.mgr_ssn = mgr_ssn;
        this.mgr_start_date = mgr_start_date;
    }

    // Getters and setters ...
    
    public String getdName()
    {
        return dName;
    }

    public int getdNumber()
    {
        return dNumber;
    }

    public String getMgr_ssn()
    {
        return mgr_ssn;
    }

    public String getMgr_start_date()
    {
        return mgr_start_date;
    }

    public void setdName(String dName)
    {
        this.dName = dName;
    }

    public void setdNumber(int dNumber)
    {
        this.dNumber = dNumber;
    }

    public void setMgr_ssn(String mgr_ssn)
    {
        this.mgr_ssn = mgr_ssn;
    }

    public void setMgr_start_date(String mgr_start_date)
    {
        this.mgr_start_date = mgr_start_date;
    }
}
