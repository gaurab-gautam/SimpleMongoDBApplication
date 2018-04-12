/**
 *
 * @author Gaurab R. Gautam
 */


// package name
package mongodbapplication;

// imported libraries
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import complexobjects.DepartmentDocument;
import complexobjects.ProjectDocument;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import relationaldbtableattrclasses.Department;
import relationaldbtableattrclasses.Dept_Locations;
import relationaldbtableattrclasses.Employee;
import relationaldbtableattrclasses.Project;
import relationaldbtableattrclasses.Works_on;
import relationaldbtablesdata.DataTables;



/**
 * Name:        MongoDBApplication
 * Type:        Class
 * Description: Main class that is an entry point of the program.
 */
public class MongoDBApplication
{
    // variable declarations
    private enum File_Type {EMPLOYEE, DEPARTMENT, WORKS_ON, PROJECT, DEPT_LOCATIONS};
    final private static DataTables dataTables = new DataTables();

    /**
     * Name       : main
       Input      : Command operation arguments into array of string
       Output     : none
       Description: entry point of the application
     * @param args
     */
     public static void main(String[] args)
    {
        // Read the data files
        readDataFiles();
        
        // create and print complex objects
        ProjectDocument projDoc = new ProjectDocument(dataTables);
        DepartmentDocument deptDoc = new DepartmentDocument(dataTables);
        
        // print documents
        projDoc.print();
        deptDoc.print();
        
        // connect to mongo database
        DB companyDB = connectToMongoCompanyDB();
        
        // if connection is successfule, load documents
        if (companyDB != null)
        {
            loadDepartmentDocumentOnCompanyDB(companyDB, deptDoc);
            loadProjectDocumentOnCompanyDB(companyDB, projDoc);
            
            System.out.println("Successfully loaded documents to Company database!");
        }
        else
        {
            System.out.println("Connection failed!");
        }
    }
    
    /**
     * Name       : loadProjectDocumentOnCompanyDB
     * Input      : mongo database object, project document
     * Output     : None
     * Description: loads the document into mongo db 
     */
    private static void loadProjectDocumentOnCompanyDB(DB companyDB, ProjectDocument projDoc)
    {
        DBCollection collection = companyDB.getCollection("Project");
        
        for (int i = 0; i < projDoc.getProjects().size(); i++)
        {
            String projName = projDoc.getProjects().get(i).getpName();
            int projNum = projDoc.getProjects().get(i).getpNumber();
            String controllingDept = projDoc.getProjects().get(i).getdName();
            List<ProjectDocument.ProjectComplexObject.Employee> employees = 
                    projDoc.getProjects().get(i).getEmployees();
            
            BasicDBObject[] emps = new BasicDBObject[employees.size()];
            
            for (int j = 0; j < employees.size(); j++ )
            {
                emps[j] = new BasicDBObject("Lname", employees.get(j).getlName())
                        .append("Fname", employees.get(j).getfName())
                        .append("Hours", employees.get(j).getHours());
            }
            
            BasicDBObject doc = new BasicDBObject("Pname", projName)
                    .append("Pnumber", projNum)
                    .append("Dname", controllingDept)
                    .append("Employees", emps);
            
            collection.insert(doc);
        }
    }
    
    /**
     * Name       : loadDepartmentDocumentOnCompanyDB
     * Input      : mongo database object, department document
     * Output     : None
     * Description: loads the document into mongo db 
     */
    private static void loadDepartmentDocumentOnCompanyDB(DB companyDB, DepartmentDocument deptDoc)
    {
        DBCollection collection = companyDB.getCollection("Department");
        
        for (int i = 0; i < deptDoc.getDepartments().size(); i++)
        {
            String dName = deptDoc.getDepartments().get(i).getdName();
            String mgrLastName = deptDoc.getDepartments().get(i).getManagerLastName();
            List<String> dLocations = deptDoc.getDepartments().get(i).getdLocations();
            
            BasicDBObject doc = new BasicDBObject("Dname", dName)
                    .append("Lname", mgrLastName)
                    .append("Dlocation", dLocations);
            
            collection.insert(doc);
        }
    }
    
    /**
     * Name       : ConnectToMongoCompanyDB
     * Input      : None
     * Output     : Mongo database object
     * Description: Establish connections to mongo db 
     */
    private static DB connectToMongoCompanyDB()
    {
        try
        {
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            
            DB companyDB = mongoClient.getDB("mydb" );
            
            return companyDB;
        } 
        catch (UnknownHostException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * Name       : readDataFiles
     * Input      : None
     * Output     : None
     * Description: reads data files
     */
    private static void readDataFiles()
    {
        // stores input_file_line of input file
        String datafile = "";
        
        // read EMPLOYEE, DEPARTMENT, WORKS_ON, PROJECT, DEPT_LOCATIONS,DEPENDENT data files
        datafile = "input files\\EMPLOYEE.txt";
        readInputFile(File_Type.EMPLOYEE, datafile);
        
        datafile = "input files\\DEPARTMENT.txt";
        readInputFile(File_Type.DEPARTMENT, datafile);
        
        datafile = "input files\\DEPT_LOCATIONS.txt";
        readInputFile(File_Type.DEPT_LOCATIONS, datafile);
        
        datafile = "input files\\PROJECT.txt";
        readInputFile(File_Type.PROJECT, datafile);
        
        datafile = "input files\\WORKS_ON.txt";
        readInputFile(File_Type.WORKS_ON, datafile);
    }
    
     /**
     * Name       : readInputFile
     * Input      : file_type as enumerator, filename as string
     * Output     : None
     * Description: reads input file
     */
    private static void readInputFile(File_Type fileType, String filename)
    {
        // Reades file data
        BufferedReader reader = null;
        
        // stores line of input file
        String input_file_line;
        
        try 
        {
            // create an instances to read input file
            reader = new BufferedReader(new FileReader(filename));
             
            try 
            {
                // Read until the end of input file
                while ((input_file_line = reader.readLine()) != null)
                {
                    // Ignore empty line
                    if (input_file_line.trim().isEmpty())
                    {
                        continue;
                    }
                    
                    // Split input input_file_line
                    String tokens[] = input_file_line.split("',|, ");
                    
                    // process input file based on type
                    switch (fileType)
                    {
                        case EMPLOYEE:
                            processEmployeeData(tokens);
                            break;
                        case DEPARTMENT:
                            processDepartmentData(tokens);
                            break;
                        case WORKS_ON:
                            processWorks_OnData(tokens);
                            break;
                        case PROJECT:
                            processProjectData(tokens);
                            break;
                        case DEPT_LOCATIONS:
                            processDept_LocationsData(tokens);
                            break;
                    }
                }
            } 
            
            // Catch any IO exception
            catch (IOException ex) 
            {
                System.out.println(ex.getMessage());
            }
        } 
        
        // Catch File Not Found exception
        catch (FileNotFoundException ex) 
        {
            System.out.println("Input file [" + filename + "] does not exist!");
        } 
        
        finally 
        {
            try 
            {
                // Close the reader
                if (reader != null)
                    reader.close();
            } 
            
            // Catch IO exception and print message
            catch (IOException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Name       : processEmployeeData
     * Input      : tokens as array of strings
     * Output     : None
     * Description: parses the token, creates Employee object and adds it to the table
     */
    public static void processEmployeeData(String [] tokens)
    {
        Employee emp = new Employee(
                tokens[0].replace("'", "").trim(), 
                tokens[1].replace("'", "").trim().equalsIgnoreCase("null") ? "" :
                tokens[1].replace("'", "").trim(),  
                tokens[2].replace("'", "").trim(),
                tokens[3].replace("'", "").trim(), 
                tokens[4].replace("'", "").trim(), 
                tokens[5].replace("'", "").trim(),
                tokens[6].replace("'", "").trim().toCharArray()[0], 
                Float.parseFloat(tokens[7].replace("'", "").trim()), 
                tokens[8].replace("'", "").trim().equalsIgnoreCase("null") ? "" :
                tokens[8].replace("'", "").trim(), 
                Integer.parseInt(tokens[9].replace("'", "").trim()));
        
        dataTables.addEmployee(emp);
    }
    
    /**
     * Name       : processDept_LocationsData
     * Input      : tokens as array of strings
     * Output     : None
     * Description: parses the token, creates Department object and adds it to the table
     */
    public static void processDepartmentData(String [] tokens)
    {
        Department dept = new Department (
                tokens[0].replace("'", "").trim(), 
                Integer.parseInt(tokens[1].replace("'", "").trim()),  
                tokens[2].replace("'", "").trim(), 
                tokens[3].replace("'", "").trim());
        
        dataTables.addDepartment(dept);
    }
    
    /**
     * Name       : processDept_LocationsData
     * Input      : tokens as array of strings
     * Output     : None
     * Description: parses the token, creates works_on object and adds it to the table
     */
    public static void processWorks_OnData(String [] tokens)
    {
        Works_on works_on = new Works_on(
                tokens[0].replace("'", "").trim(), 
                Integer.parseInt(tokens[1].replace("'", "").trim()),
                Float.parseFloat(tokens[2].replace("'", "").trim()));
        
        dataTables.addWorks_on(works_on);
    }
    
    /**
     * Name       : processDept_LocationsData
     * Input      : tokens as array of strings
     * Output     : None
     * Description: parses the token, creates project object and adds it to the table
     */
    public static void processProjectData(String [] tokens)
    {
        Project proj = new Project (
                tokens[0].replace("'", "").trim(), 
                Integer.parseInt(tokens[1].replace("'", "").trim()),
                tokens[2].replace("'", "").trim(),
                Integer.parseInt(tokens[3].replace("'", "").trim()));
        
        dataTables.addProject(proj);
    }
    
    /**
     * Name       : processDept_LocationsData
     * Input      : tokens as array of strings
     * Output     : None
     * Description: parses the token, creates department_locations object and adds it to the table
     */
    public static void processDept_LocationsData(String [] tokens)
    {
        Dept_Locations loc = new Dept_Locations(
                Integer.parseInt(tokens[0].replace("'", "").trim()),
                tokens[1].replace("'", "").trim());
        
        dataTables.addDept_location(loc);
    }

}
