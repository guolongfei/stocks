package longfei.stocks.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Hello {
    @Autowired
    private StockService stockService;

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "id", defaultValue = "1") String id, Model model) {
        List<Stock> list = stockService.findAll(Integer.valueOf(id));
        model.addAttribute("stocks", list);
        return "hello";
    }
}
