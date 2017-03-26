package com.travelsky.b2g.b2gservice.rest;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping(value="/swagger")
public class SwaggerController {



    @RequestMapping(value="/api-docs")
    public String apiDocs( ) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api-docs";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(param, headers);
        ResponseEntity<String> result =  restTemplate.exchange(url, HttpMethod.GET, entity, String.class);


        System.out.println(result.getBody());
        return result.getBody().replaceAll("http://localhost:8080/api-docs/","http://localhost:8080/api-docs/");
    }


}
