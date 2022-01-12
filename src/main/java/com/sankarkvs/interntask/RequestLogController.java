package com.sankarkvs.interntask;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/")
@AllArgsConstructor
public class RequestLogController {

    private RequestLogService requestLogService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/api/call")
    public ResponseEntity call(@RequestParam Map<String, String> req) throws IOException {
        String uri="https://app.insuremyteam.com/v1/op/lead/sankarkumar";
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        JSONObject body=new JSONObject();
        body.put("name",req.get("name"));
        RestTemplate restTemplate=new RestTemplate();
        HttpEntity<String> request =
                new HttpEntity<String>(body.toString(), httpHeaders);

        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity(uri, request, String.class);

        JsonNode root = objectMapper.readTree(responseEntityStr.getBody());

        return responseEntityStr;
    }
}
