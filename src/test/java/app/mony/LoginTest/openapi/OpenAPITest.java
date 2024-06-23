package app.mony.LoginTest.openapi;


import app.mony.mony.stock.StockOpenAPI;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
public class OpenAPITest {

    @Test
    @DisplayName("오픈API - 주식시세 데이터 조회")
    void getStockTest(){

        StockOpenAPI stockOpenAPI = new StockOpenAPI();
        stockOpenAPI.requestStockInfo();
    }
}
