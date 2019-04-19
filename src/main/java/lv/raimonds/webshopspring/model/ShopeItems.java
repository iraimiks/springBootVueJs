package lv.raimonds.webshopspring.model;



import javax.persistence.*;


@Entity
@Table(name = "shopeItems")
public class ShopeItems{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idShopItems;

    @Column(name = "productCode")
    private String productCode;
    @Column(name = "productName")
    private String productName;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "longDescription")
    private String longDescription;
    @Column(name = "imgUrl")
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ShopeItems() {
    }

    public ShopeItems(String productCode, String productName, double price, String description, String longDescription) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.longDescription = longDescription;
    }

    public long getIdShopItems() {
        return idShopItems;
    }

    public void setIdShopItems(long idShopItems) {
        this.idShopItems = idShopItems;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
