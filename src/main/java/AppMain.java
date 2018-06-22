
import dao.EmployeeDao;
import dao.ObjectDao;
import dao.entity.EmployeesEntity;
import web.controller.EmployeeController;
import web.model.SearchQuery;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        EmployeeController ctr = new EmployeeController(new EmployeeDao());
        SearchQuery searchQuery = new SearchQuery();
//        searchQuery.setFirstName("N43ick");
//        searchQuery.setSecondName("4V3N");
         // searchQuery.setPosition("hr43");
          searchQuery.setDepartment("HR");

        EmployeeDao dao = new EmployeeDao();

        System.out.println(dao.searchEmployee(searchQuery));
        dao.shutdown();


    }
}