/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 1:06 PM
 * Project Database
 */
public class City {
    protected int id;
    protected String CityName;

    public City(int id, String cityName) {
        this.id = id;
        CityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }
}
