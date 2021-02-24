/**
 * Created by Iryna Gnatenko
 * Date 2021-02-21
 * Time 9:00 PM
 * Project Database
 */

// Objektmodeller
//  Best practice är att skapa klasser i vår Java kod som motsvarar de tabeller vi läser från i databasen
//  Beroende på behov i programmet kan objektmodellerna få exakt motsvara tabellerna i databasen
//  Eller så kan de få motsvara de utläsningar vi gör om vi slår ihop tabeller eller bara läser från vissa kolumner

public class ShoesInStock {
    protected int brandId;
    protected String brandName;
    protected int sizeId;
    protected String size;
    protected int colorId;
    protected String color;
    protected int shoeId;
    protected int amountLeft;

    public ShoesInStock(int brandId, String brandName, int sizeId, String size, int colorId, String color, int shoeId, int amountLeft) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.sizeId = sizeId;
        this.size = size;
        this.colorId = colorId;
        this.color = color;
        this.shoeId = shoeId;
        this.amountLeft = amountLeft;
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

    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int shoeId) {
        this.shoeId = shoeId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }
}
