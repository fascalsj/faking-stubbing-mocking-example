package com.belajar.mocking.client;

import com.belajar.mocking.config.RestTemplateConfig;
import com.belajar.mocking.dto.inbound.HistoryInboundDto;
import com.belajar.mocking.dto.inbound.UserPetstoreInboundDto;
import com.belajar.mocking.dto.outbound.HistoryOutboundDto;
import com.belajar.mocking.dto.outbound.UserPetstoreOutboundDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HistoryClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${url}")
    private String urlSwagger;

    public HistoryInboundDto createHistory(HistoryOutboundDto orderToPetstoreOutboundDto) throws JsonProcessingException {
        return restTemplate.postForEntity(urlSwagger+ "/v2/store/order", RestTemplateConfig.setupRequest(orderToPetstoreOutboundDto), HistoryInboundDto.class).getBody();
    }

    public UserPetstoreInboundDto createUser(UserPetstoreOutboundDto userPetstoreOutboundDto) throws JsonProcessingException {
        return restTemplate.postForEntity(urlSwagger+ "/v2/user", RestTemplateConfig.setupRequest(userPetstoreOutboundDto), UserPetstoreInboundDto.class).getBody();
    }


}
