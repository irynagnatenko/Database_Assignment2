/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 12:24 PM
 * Project Database
 */
public class Size {

    protected int id;
    protected String sizeName;

    public Size(int id, String sizeName) {
        this.id = id;
        this.sizeName = sizeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
}