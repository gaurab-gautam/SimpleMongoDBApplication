/**
 *
 * @author Gaurab R. Gautam
 */


// package name
package relationaldbtablesdata;

// imported libraries
import relationaldbtableattrclasses.Department;
import relationaldbtableattrclasses.Employee;
import relationaldbtableattrclasses.Works_on;
import relationaldbtableattrclasses.Dept_Locations;
import relationaldbtableattrclasses.Project;
import java.util.ArrayList;
import java.util.List;

/**
 * Name:        DepartmentDocument
 * Type:        Class
 * Description: Class to create tables based on data from the input file.
 */
public class DataTables
{
    // variable declarations
    // list of objects
    
    private List<Employee> employeeTable = new ArrayList();
    private List<Department> departmentTable = new ArrayList();
    private List<Works_on> works_onTable = new ArrayList();
    private List<Project> projectTable = new ArrayList();
    private List<Dept_Locations> dept_locationsTable = new ArrayList();

    // Add object to table
    // ..............................................
    
    public void addEmployee(Employee e)
    {
        this.employeeTable.add(e);
    }
    
    public void addDepartment(Department d)
    {
        this.departmentTable.add(d);
    }

    public void addWorks_on(Works_on w)
    {
        this.works_onTable.add(w);
    }

    public void addProject(Project p)
    {
        this.projectTable.add(p);
    }

    public void addDept_location(Dept_Locations loc)
    {
        this.dept_locationsTable.add(loc);
    }
    // .............................................
    
    // Getter functions ...
    
    public List<Employee> getEmployeeTable()
    {
        return employeeTable;
    }

    public List<Department> getDepartmentTable()
    {
        return departmentTable;
    }

    public List<Works_on> getWorks_onTable()
    {
        return works_onTable;
    }

    public List<Project> getProjectTable()
    {
        return projectTable;
    }

    public List<Dept_Locations> getDept_locationsTable()
    {
        return dept_locationsTable;
    }
}
