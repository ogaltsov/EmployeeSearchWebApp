package dao.util;

public class QueryConstructor {
    private String query = "";
    public static final String EQUALS = " = ";
    public static final String ALLFIELDS = " * ";

    public QueryConstructor() {
    }

    private QueryConstructor(String query) {
        this.query = query;
    }

    public QueryConstructor select(String...fields) {
        query = "SELECT ";
        for(int i = 0; i<fields.length; i++){
            if(i==fields.length-1)
                query = query + fields[i] + " ";
            else
                query = query + fields[i] + ", ";
        }
        return new QueryConstructor(query);
    }


    public QueryConstructor from(String...tables) {
        query = query + "FROM ";
        for(int i = 0; i<tables.length; i++){
            if(i==tables.length-1)
                query = query + tables[i] + " ";
            else
                query = query + tables[i] + ", ";
        }
        return new QueryConstructor(query);
    }


    public QueryConstructor where(String operand1, String operator, String operand2) {
        query = query + "WHERE " + operand1 + operator  + operand2 + " ";
        return new QueryConstructor(query);
    }

    public QueryConstructor and(String operand1, String operator, String operand2) {
        query = query + "AND " + operand1 + operator + operand2 + " ";
        return new QueryConstructor(query);
    }

    public String end(){
        return query + ";";
    }





}
