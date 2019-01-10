package longfei.stocks.mappers;

import longfei.stocks.beans.Stock;
import longfei.stocks.beans.StockFuture;
import longfei.stocks.beans.StockHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMapper {
    List<Stock> getAllStocks();

    List<Stock> getStocksByName(String name);

    List<Stock> getStocksByCode(String code);

    List<StockHistory> getHistory(String code, String start, String end);

    List<StockFuture> getFuture(String code);
}
