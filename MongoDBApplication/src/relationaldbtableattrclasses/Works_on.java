/**
 *
 * @author Gaurab R. Gautam
 */


// package name
package relationaldbtableattrclasses;

/**
 * Name:        Works_on
 * Type:        Class
 * Description: Works_on class (with getters and setters) used to create object 
 *              that stores data from the input file.
 */
public class Works_on
{
    // variable declarations
    private String essn;
    private int pno;
    private float hours;

    // constructor
    public Works_on(String essn, int pno, float hours)
    {
        this.essn = essn;
        this.pno = pno;
        this.hours = hours;
    }

    // Getters and setters ... 
    
    public String getEssn()
    {
        return essn;
    }

    public int getPno()
    {
        return pno;
    }

    public float getHours()
    {
        return hours;
    }

    public void setEssn(String essn)
    {
        this.essn = essn;
    }

    public void setPno(int pno)
    {
        this.pno = pno;
    }

    public void setHours(float hours)
    {
        this.hours = hours;
    }
}
