package generator;

import dao.EmployeeDao;
import web.model.Employee;

import java.io.*;

public class EmployeesEntityGenerator {
    String[] fName;
    String[] sName;
    String[] position={"Programmer","Hr","Analyst","Director","Secretary","Architector","Teamlead","Administrator"};
    String[] department={"Hr", "Security", "Software", "It", "Administration","Finance","Pr"};


    public static void main(String[] args) throws IOException {
        EmployeesEntityGenerator generator = new EmployeesEntityGenerator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));  //path name to names.txt
        String line = reader.readLine();
        EmployeeDao dao = new EmployeeDao();


        String[] temp = line.split(",\\s{0,10}");
        generator.fName=temp;
        generator.sName=temp;


        for(int i=0; i<1000; i++){
            Employee employee = new Employee();
            employee.setId(1000+i);
            employee.setFirstName(generator.fName[(int)(Math.random()*190)]);
            employee.setSecondName(generator.sName[(int)(Math.random()*190)]);
            employee.setPosition(generator.position[(int) (Math.random()*7)]);
            employee.setDepartment(generator.department[(int) (Math.random()*6)]);
            employee.setMail(employee.getFirstName()+ employee.getSecondName()+"@company.com");

            //dao.saveObject(employee);
        }

    }

}
