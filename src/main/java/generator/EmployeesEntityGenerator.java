package generator;

import dao.EmployeeDao;
import dao.entity.EmployeesEntity;

import java.io.*;

public class EmployeesEntityGenerator {
    String[] fName;
    String[] sName;
    String[] position={"Programmer","HR","Analyst","Director","Secretary","Architector","Teamlead","Administrator"};
    String[] department={"HR", "Security", "Software", "IT", "Administration","Finance","PR"};


    public static void main(String[] args) throws IOException {
        EmployeesEntityGenerator generator = new EmployeesEntityGenerator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(""))));  //path name to names.txt
        String line = reader.readLine();
        EmployeeDao dao = new EmployeeDao();


        String[] temp = line.split(",\\s{0,10}");
        generator.fName=temp;
        generator.sName=temp;


        for(int i=0; i<1000; i++){
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setId((short)(1000+i));
            employeesEntity.setFirstName(generator.fName[(int)(Math.random()*190)]);
            employeesEntity.setSecondName(generator.sName[(int)(Math.random()*190)]);
            employeesEntity.setPosition(generator.position[(int) (Math.random()*7)]);
            employeesEntity.setDepartment(generator.department[(int) (Math.random()*6)]);
            employeesEntity.setMail(employeesEntity.getFirstName()+employeesEntity.getSecondName()+"@company.com");

            //dao.saveObject(employeesEntity);
        }

    }

}
