package com.belajar.mocking.service;

import com.belajar.mocking.client.HistoryClient;
import com.belajar.mocking.dto.inbound.UserPetstoreInboundDto;
import com.belajar.mocking.dto.outbound.UserPetstoreOutboundDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class PetstoreService {

    final
    HistoryClient historyClient;

    public PetstoreService(HistoryClient historyClient) {
        this.historyClient = historyClient;
    }

    public UserPetstoreInboundDto createUser(UserPetstoreOutboundDto userPetstoreOutboundDto) throws JsonProcessingException {
        return historyClient.createUser(userPetstoreOutboundDto);
    }
}
