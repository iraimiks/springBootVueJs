package lv.raimonds.webshopspring.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "GoodItems")
public class GoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "descript")
    private String descript;
    @Column(name = "simpDescript")
    private String simpDescript;
    @Column(name = "price")
    private BigDecimal price;
    public GoodItems(){

    }

    public GoodItems(String itemName, String descript, String simpDescript, BigDecimal price) {
        this.itemName = itemName;
        this.descript = descript;
        this.simpDescript = simpDescript;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getSimpDescript() {
        return simpDescript;
    }

    public void setSimpDescript(String simpDescript) {
        this.simpDescript = simpDescript;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "GoodItems [id=" +id +", Goods" + itemName +
                "]";
    }
}
