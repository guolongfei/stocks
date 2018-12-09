package longfei.stocks.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockMapper stockMapper;

    public List<Stock> findAll(int id) {
        List<Stock> list = stockMapper.findAll(id);
        return list;
    }
}
