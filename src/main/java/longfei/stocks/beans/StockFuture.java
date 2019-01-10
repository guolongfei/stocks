package longfei.stocks.beans;

import java.io.Serializable;

public class StockFuture implements Serializable {
    private static final long serialVersionUID = 123L;
    private String date;
    private String code;
    private double pre_close;
    private double close;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPre_close() {
        return pre_close;
    }

    public void setPre_close(double pre_close) {
        this.pre_close = pre_close;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }
}
