package longfei.stocks.mappers;

import longfei.stocks.beans.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMapper {
    List<Stock> getAllStocks();

    List<Stock> getStocksByName(String name);

    List<Stock> getStocksByCode(String code);
}
