package longfei.stocks.controllers;

import longfei.stocks.beans.Stock;
import longfei.stocks.beans.StockFuture;
import longfei.stocks.beans.StockHistory;
import longfei.stocks.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stocklist")
    public String stocklist(@RequestParam(name = "param", defaultValue = "") String param, Model model) {
        List<Stock> stocks = stockService.getStocks("".equals(param) ? null : param);
        //stocks.stream().map(Stock::getName).forEach(System.out::println);
        model.addAttribute("stocks", stocks);
        return "stocklist";
    }

    @PostMapping("/historyData")
    @ResponseBody
    public String historydata(@RequestParam(name = "code") String code, @RequestParam(name = "start", defaultValue = "") String start, @RequestParam(name = "end", defaultValue = "") String end, Model model) {
        List<StockHistory> histories = stockService.getHistory(code, start, end);
        histories.stream().map(StockHistory::getDate).forEach(System.out::println);
        StringBuilder sb = new StringBuilder();
        if (histories.size() > 0) {
            sb.append("日期,收盘价,最高价,最低价\n");
            for (int i = 0; i < histories.size(); i++) {
                StockHistory sh = histories.get(i);
                sb.append(sh.getDate() + "," + sh.getClose() + "," + sh.getTop() + "," + sh.getBottom() + "\n");
            }
        }
        return sb.toString();
    }

    @PostMapping("/historyData2")
    @ResponseBody
    public String historydata2(@RequestParam(name = "code") String code, @RequestParam(name = "start", defaultValue = "") String start, @RequestParam(name = "end", defaultValue = "") String end, Model model) {

        List<StockHistory> histories = stockService.getHistory(code, start, start);
        List<StockFuture> futures = stockService.getFuture(code);
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        if(futures.size()>0){
            sb1.append("{name:'前收盘',data:[["+histories.get(0).getPre_close()+",'"+histories.get(0).getDate()+"'],");
            sb2.append("{name:'收盘',data:[["+histories.get(0).getClose()+",'"+histories.get(0).getDate()+"'],");
            for(int i=0;i<futures.size();i++){
                StockFuture future=futures.get(0);
                sb1.append("["+future.getPre_close()+",'"+future.getDate()+"'],");
                sb2.append("["+future.getClose()+",'"+future.getDate()+"'],");
            }
            sb1.deleteCharAt(-1);
            sb2.deleteCharAt(-1);
        }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        return "["+sb1.toString()+","+sb2.toString()+"]";
    }

}
