package web.model;

import dao.entity.EmployeesEntity;

import java.util.List;

public class ListToJsonArray {
        private List<EmployeesEntity> jsonArray;

        public void setJsonArray(List<EmployeesEntity> jsonArray) {
            this.jsonArray = jsonArray;
        }

        public List<EmployeesEntity> getJsonArray() {
            return jsonArray;
        }

    @Override
    public String toString() {
        return "ListToJsonArray{" +
                "jsonArray=" + jsonArray +
                '}';
    }
}
