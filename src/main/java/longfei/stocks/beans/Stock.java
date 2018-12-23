package longfei.stocks.beans;

import java.io.Serializable;

public class Stock implements Serializable {
    private static final long serialVersionUID = 123L;
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
