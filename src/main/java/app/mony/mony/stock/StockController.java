package app.mony.mony.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {

    @GetMapping("/find")
    public void find(){
        StockOpenAPI stockOpenAPI = new StockOpenAPI();
        stockOpenAPI.requestStockInfo();
    }
}
