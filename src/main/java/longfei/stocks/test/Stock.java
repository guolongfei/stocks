package longfei.stocks.test;

import java.io.Serializable;

public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
