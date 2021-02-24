/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 12:19 PM
 * Project Database
 */
public class Brand {

    protected int id;
    protected String brandName;

    public Brand(int id, String brandlName) {
        this.id = id;
        this.brandName = brandlName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String labelName) {
        this.brandName = labelName;
    }
}
