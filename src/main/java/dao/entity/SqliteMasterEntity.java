package dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "sqlite_master", schema = "main", catalog = "")
public class SqliteMasterEntity {
    private String type;
    private String name;
    private String tblName;
    private Short rootpage;
    private String sql;

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tbl_name")
    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }

    @Basic
    @Column(name = "rootpage")
    public Short getRootpage() {
        return rootpage;
    }

    public void setRootpage(Short rootpage) {
        this.rootpage = rootpage;
    }

    @Basic
    @Column(name = "sql")
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SqliteMasterEntity that = (SqliteMasterEntity) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (tblName != null ? !tblName.equals(that.tblName) : that.tblName != null) return false;
        if (rootpage != null ? !rootpage.equals(that.rootpage) : that.rootpage != null) return false;
        if (sql != null ? !sql.equals(that.sql) : that.sql != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tblName != null ? tblName.hashCode() : 0);
        result = 31 * result + (rootpage != null ? rootpage.hashCode() : 0);
        result = 31 * result + (sql != null ? sql.hashCode() : 0);
        return result;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
