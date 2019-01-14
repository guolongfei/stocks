package longfei.stocks.services;

import longfei.stocks.beans.Stock;
import longfei.stocks.beans.StockFuture;
import longfei.stocks.beans.StockHistory;
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
            stocks = stockMapper.getStocksByCode(param);
        } else {
            stocks = stockMapper.getStocksByName(param);
        }
        return stocks;
    }

    public List<StockHistory> getHistory(String code, String start, String end) {
        List<StockHistory> histories = stockMapper.getHistory(code, start, end);
        return histories;
    }

    public List<StockFuture> getFuture(String code) {
        List<StockFuture> futures = stockMapper.getFuture(code);
        return futures;
    }

    public StockHistory getLastData(String code) {
        return stockMapper.getLastData(code);
    }
}
