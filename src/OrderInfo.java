import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 1:16 PM
 * Project Database
 */
public class OrderInfo {
    protected int id;
    protected int orderId;
    protected List<Shoes> shoeList;

    public OrderInfo(int id, int orderId, List<Shoes> shoeList) {
        this.id = id;
        this.orderId = orderId;
        this.shoeList = shoeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Shoes> getShoeList() {
        return shoeList;
    }

    public void setShoeList(List<Shoes> shoeList) {
        this.shoeList = shoeList;

    }
}

