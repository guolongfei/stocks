package longfei.stocks.controllers;

import longfei.stocks.beans.Stock;
import longfei.stocks.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StockListController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stocklist")
    public String stocklist(@RequestParam(name = "param", defaultValue = "") String param, Model model) {
        List<Stock> stocks = stockService.getStocks("".equals(param) ? null : param);
        model.addAttribute("stocks", stocks);
        return "stocklist";
    }
}
