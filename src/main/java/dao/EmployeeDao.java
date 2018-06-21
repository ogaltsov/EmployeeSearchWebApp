package dao;

import dao.entity.EmployeesEntity;

public class EmployeeDao extends ObjectDao {

    public Object getObject(short id){
        return super.getObject(EmployeesEntity.class, id);
    }


}
