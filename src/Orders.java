import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 1:15 PM
 * Project Database
 */
public class Orders {
    protected int id;
    protected int customerId;
    protected Date date;


    public Orders(int id, int customerId, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}