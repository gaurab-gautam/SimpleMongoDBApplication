/**
 *
 * @author Gaurab R. Gautam
 */


// package name
package relationaldbtableattrclasses;

/**
 * Name:        Employee
 * Type:        Class
 * Description: Employee class (with getters and setters) used to create object 
 *              that stores data from the input file.
 */
public class Employee
{
    // variable declarations
    private String fName;
    private String mInit;
    private String lName;
    private String ssn;
    private String bDate;
    private String address;
    private char sex;
    private float salary;
    private String super_ssn;
    private int dno;

    // constructor
    public Employee(String fName, String mInit, String lName, String ssn, 
            String bDate, String address, char sex, float salary, String super_ssn, int dno)
    {
        this.fName = fName;
        this.mInit = mInit;
        this.lName = lName;
        this.ssn = ssn;
        this.bDate = bDate;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        this.super_ssn = super_ssn;
        this.dno = dno;
    }

    // Getters and setters ...
    
    public String getfName()
    {
        return fName;
    }

    public String getmInit()
    {
        return mInit;
    }

    public String getlName()
    {
        return lName;
    }

    public String getSsn()
    {
        return ssn;
    }

    public String getbDate()
    {
        return bDate;
    }

    public String getAddress()
    {
        return address;
    }

    public char getSex()
    {
        return sex;
    }

    public float getSalary()
    {
        return salary;
    }

    public String getSuper_ssn()
    {
        return super_ssn;
    }

    public int getDno()
    {
        return dno;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public void setmInit(String mInit)
    {
        this.mInit = mInit;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    public void setbDate(String bDate)
    {
        this.bDate = bDate;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setSex(char sex)
    {
        this.sex = sex;
    }

    public void setSalary(float salary)
    {
        this.salary = salary;
    }

    public void setSuper_ssn(String super_ssn)
    {
        this.super_ssn = super_ssn;
    }

    public void setDno(int dno)
    {
        this.dno = dno;
    }
}
