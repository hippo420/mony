package app.mony.mony.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
@Slf4j
public class StockOpenAPI {


    public void requestStockInfo(){
        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

         log.info("===================OPEN_API START===================");

        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getStockPriceInfo")
                        .queryParam("serviceKey","Be3wPn71hYxVTe/bL3aEqwSJzd1pgZBcsHCFFwOD/Y/XYY9tTCDUmWtNO85mYjtTcWe0RCkVyoIg1d45IFzeuQ==")
                        .queryParam("numOfRows","1")
                        .queryParam("numOfRows","1")
                        .queryParam("itmsNm","SK하이닉스")
                        .queryParam("resultType","json")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        log.info(response);
        log.info("===================OPEN_API   END===================");

    }
}
