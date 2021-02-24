/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 12:16 PM
 * Project Database
 */

public class Category {

    protected int id;
    protected String categoryName;

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
