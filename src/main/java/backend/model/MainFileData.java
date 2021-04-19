package backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "maintfiles")
public class MainFileData extends AbstractEntity{
    @Column(name = "FilePath")
    String filePath;
    @Column(name = "Products_ID")
    String prod_id;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }
}
