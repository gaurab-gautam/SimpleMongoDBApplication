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
import relationaldbtableattrclasses.Employee;
import relationaldbtableattrclasses.Project;
import relationaldbtableattrclasses.Works_on;

/**
 * Name:        DepartmentDocument
 * Type:        Class
 * Description: Class to create complex department object (document).
 */
public class ProjectDocument
{
    // internal class
    public class ProjectComplexObject
    {    
        // internal class
        public class Employee
        {
            // variable declarations
            private final String lName;
            private final String fName;
            private final float hours;

            // constructor
            public Employee(String lName, String fName, float hours)
            {
                this.lName = lName;
                this.fName = fName;
                this.hours = hours;
            }
            
            // print function
            public void print()
            {
                System.out.println(lName + ", " + fName + " " + hours + " hrs");
            }

            // Getters ...
            
            public String getlName()
            {
                return lName;
            }

            public String getfName()
            {
                return fName;
            }

            public float getHours()
            {
                return hours;
            }
        }
        
        // variable declarations
        private String pName;
        private int pNumber;
        private String dName;
        private final List<Employee> employees = new ArrayList();
        
        // Getters ...
        
        public String getpName()
        {
            return pName;
        }

        public int getpNumber()
        {
            return pNumber;
        }

        public String getdName()
        {
            return dName;
        }

        public List<Employee> getEmployees()
        {
            return employees;
        }
        // ... End Getter functions ...
        
        // add employee to the list
        public void addEmployee(String ln, String fn, float hrs)
        {
            this.employees.add(new Employee(ln, fn, hrs));
        }
        
        // print function
        public void print()
        {
            System.out.println(pName + " " + pNumber + " " + dName);
            System.out.println("Employees: ");
            
            for (Employee e : this.employees)
            {
                e.print();
            }
        }
    }
    
    // List that stores complex object
    private List<ProjectComplexObject> projects = new ArrayList();

    // constructor
    public ProjectDocument(DataTables dataTables)
    {
        createComplexProjectCollection(dataTables);
    }
    
    // Getter function
    public List<ProjectComplexObject> getProjects()
    {
        return projects;
    }
    
    /**
     * Name       : createComplexProjectCollection
     * Input      : DataTables object
     * Output     : None
     * Description: Creates complex Project collections
     */
    private void createComplexProjectCollection(DataTables dataTables)
    {
        for (Project p : dataTables.getProjectTable())
        {
            ProjectComplexObject proj = new ProjectComplexObject();
            proj.pName = p.getpName();
            proj.pNumber = p.getpNumber();
            
            for (Department d : dataTables.getDepartmentTable())
            {
                if (p.getdNum() == d.getdNumber())
                {
                    proj.dName = d.getdName();
                    break;
                }
            }
            
            for (Works_on w : dataTables.getWorks_onTable())
            {
                if (p.getpNumber() == w.getPno())
                {
                    for (Employee e : dataTables.getEmployeeTable())
                    {
                        if (e.getSsn().equals(w.getEssn()))
                        {
                            proj.addEmployee(e.getlName(), e.getfName(), w.getHours());
                            break;
                        }
                    }
                }
            }
            
            this.projects.add(proj);
        }
    }
    
    // print function
    public void print()
    {
        System.out.println("====================PROJECTS======================");
            
        for (ProjectComplexObject p : this.projects)
        {
            p.print();
            System.out.println("-------------------------------------------");
        }
        
        System.out.println("==================END PROJECTS====================");
    }
}
