package longfei.stocks.beans;

import java.io.Serializable;

public class StockHistory implements Serializable {
    private static final long serialVersionUID = 123L;
    private String date;
    private String code;
    private double close;
    private double top;
    private double bottom;
    private double open;
    private double pre_close;
    private double change_num;
    private double change_rate;
    private double turnover_rate;
    private int volume;
    private double amount;
    private long value;
    private long equity;

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

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getPre_close() {
        return pre_close;
    }

    public void setPre_close(double pre_close) {
        this.pre_close = pre_close;
    }

    public double getChange_num() {
        return change_num;
    }

    public void setChange_num(double change_num) {
        this.change_num = change_num;
    }

    public double getChange_rate() {
        return change_rate;
    }

    public void setChange_rate(double change_rate) {
        this.change_rate = change_rate;
    }

    public double getTurnover_rate() {
        return turnover_rate;
    }

    public void setTurnover_rate(double turnover_rate) {
        this.turnover_rate = turnover_rate;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getEquity() {
        return equity;
    }

    public void setEquity(long equity) {
        this.equity = equity;
    }
}
