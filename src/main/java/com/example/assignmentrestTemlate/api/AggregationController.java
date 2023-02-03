package com.example.assignmentrestTemlate.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AggregationController {
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/aggregation")
    public ResponseEntity<?> getAggregation(
            @RequestParam(required = false) List<String> shipmentsOrderNumbers,
            @RequestParam(required = false) List<String> trackOrderNumbers,
            @RequestParam(required = false) List<String> pricingCountryCodes) {

        List<String> results = new ArrayList<>();

        if (shipmentsOrderNumbers != null) {
            String orderSplit = shipmentsOrderNumbers.get(0);

                    String url = "http://127.0.0.1:4000/shipment-products?orderNumber=" + orderSplit;
                    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                    results.add(String.valueOf(response));
                    //return ResponseEntity.ok(response.getBody());

        }

        if (trackOrderNumbers != null) {
            String orderSplit = shipmentsOrderNumbers.get(1);

                    String url = "http://127.0.0.1:4000/track-status?orderNumber=" + orderSplit;
                    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                    results.add(String.valueOf(response));
                    //return ResponseEntity.ok(response.getBody());

        }


        if (pricingCountryCodes != null) {
            List<String> prices = new ArrayList<>();

                    String url = "http://127.0.0.1:4000/pricing?countryCode=" + pricingCountryCodes.get(0);
                    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                    prices.add(String.valueOf(response));

            String urlTwo = "http://127.0.0.1:4000/pricing?countryCode=" + pricingCountryCodes.get(1);
            ResponseEntity<String> responseTwo = restTemplate.getForEntity(urlTwo, String.class);
            prices.add(String.valueOf(responseTwo));

            results.add(String.valueOf(prices));


        }

       return ResponseEntity.ok(results);
    }
}
