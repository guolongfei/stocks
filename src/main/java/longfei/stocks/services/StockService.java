package longfei.stocks.services;

import longfei.stocks.beans.Stock;
import longfei.stocks.mappers.StockMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockMapper stockMapper;

    public List<Stock> getStocks(String param) {
        List<Stock> stocks;
        if (param == null) {
            stocks = stockMapper.getAllStocks();
        } else if (StringUtils.isNumeric(param)) {
            System.out.println("yes:" + param);
            stocks = stockMapper.getStocksByCode(param);
        } else {
            System.out.println("No:" + param);
            stocks = stockMapper.getStocksByName(param);
        }
        return stocks;
    }
}
