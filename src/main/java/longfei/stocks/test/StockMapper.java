package longfei.stocks.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMapper {
    List<Stock> findAll(int id);
}
