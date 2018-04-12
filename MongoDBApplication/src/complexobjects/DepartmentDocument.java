/**
 *
 * @author Gaurab R. Gautam
 */


// package name
package complexobjects;

// imported libraries
import java.util.ArrayList;
import java.util.List;
import relationaldbtablesdata.DataTables;
import relationaldbtableattrclasses.Department;
import relationaldbtableattrclasses.Dept_Locations;
import relationaldbtableattrclasses.Employee;

/**
 * Name:        DepartmentDocument
 * Type:        Class
 * Description: Class to create complex department object (document).
 */
public class DepartmentDocument
{
    // embedded department complex object class use to create the document
    public class DepartmentComplexObject
    {
        // variable declarations
        private String dName;
        private String managerLastName;
        private List<String> dLocations = new ArrayList();
        
        // print function
        public void print()
        {
            System.out.println(dName + " " + managerLastName);
            System.out.println("Locations: " + dLocations);
        }

        // Getters ...
        
        public String getdName()
        {
            return dName;
        }

        public String getManagerLastName()
        {
            return managerLastName;
        }

        public List<String> getdLocations()
        {
            return dLocations;
        }
    }
    
    // list of department document
    private final List<DepartmentComplexObject> departments = new ArrayList();
    
    // constructor
    public DepartmentDocument(DataTables dataTables)
    {
        createComplexDepartmentCollection(dataTables);
    }
    
    // Getter function: gets departments
    public List<DepartmentComplexObject> getDepartments()
    {
        return departments;
    }
    
    /**
     * Name       : createComplexDepartmentCollection
     * Input      : DataTables object
     * Output     : None
     * Description: Creates complex department collections
     */
    private void createComplexDepartmentCollection(DataTables dataTables)
    {
        for (Department d : dataTables.getDepartmentTable())
        {
            DepartmentComplexObject dept = new DepartmentComplexObject();
            
            // get the name of the department
            dept.dName = d.getdName();
           
            for (Employee e : dataTables.getEmployeeTable())
            {
                if (d.getMgr_ssn().equalsIgnoreCase(e.getSsn()))
                {
                    dept.managerLastName = e.getlName();
                    break;
                }
            }
            
            for (Dept_Locations loc : dataTables.getDept_locationsTable())
            {
                if (loc.getdNumber() == d.getdNumber())
                {
                    dept.getdLocations().add(loc.getdLocation());
                }
            }
            
            this.departments.add(dept);
        }
    }
    
    // Print function
    public void print()
    {
        System.out.println("===================DEPARTMENTS====================");
            
        for (DepartmentComplexObject d : this.departments)
        {
            d.print();
            System.out.println("-------------------------------------------");
        }
        
        System.out.println("=================END DEPARTMENTS==================");
    }
}
