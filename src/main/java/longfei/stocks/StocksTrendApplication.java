package longfei.stocks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("longfei.stocks.test")
@SpringBootApplication
public class StocksTrendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StocksTrendApplication.class, args);
    }
}
