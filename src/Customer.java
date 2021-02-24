/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 1:08 PM
 * Project Database
 */
public class Customer {
    protected int id;
    protected String name;
    protected String lastName;
    protected int cityId;
    protected String userName;
    protected String password;

    public Customer(){};

    public Customer(int id, String name, String lastName, int cityId, String userName, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cityId = cityId;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
