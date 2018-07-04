package web.model;

import java.util.List;

public class ListToJsonArray {
        private List<Employee> jsonArray;

        public void setJsonArray(List<Employee> jsonArray) {
            this.jsonArray = jsonArray;
        }

        public List<Employee> getJsonArray() {
            return jsonArray;
        }

    @Override
    public String toString() {
        return "ListToJsonArray{" +
                "jsonArray=" + jsonArray +
                '}';
    }
}
