package com.sankarkvs.interntask;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RequestLogService {
    private final RequestLogRepository requestLogRepository;

    public String addLog(String log){
        RequestLog requestLog=new RequestLog();
        requestLog.setData(log);
        try{
            requestLogRepository.insert(requestLog);
            return "Successfully Add Request";
        }
        catch (Exception e){
            return "Something went wrong";
        }
    }
}
