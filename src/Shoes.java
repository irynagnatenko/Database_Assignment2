/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 12:24 PM
 * Project Database
 */
public class Shoes {

    protected int id;
    protected int brandId;
    protected int sizeId;
    protected int colorId;
    protected double price;
    protected int shoeStock;

    public Shoes(int id, int brandId, int sizeId, int colorId, double price, int shoeStock) {
        this.id = id;
        this.brandId = brandId;
        this.sizeId = sizeId;
        this.colorId = colorId;
        this.price = price;
        this.shoeStock = shoeStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShoeStock() {
        return shoeStock;
    }

    public void setShoeStock(int shoeStock) {
        this.shoeStock = shoeStock;
    }
}
