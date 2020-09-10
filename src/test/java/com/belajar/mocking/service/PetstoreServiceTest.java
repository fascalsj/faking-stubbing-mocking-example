package com.belajar.mocking.service;

import com.belajar.mocking.client.HistoryClient;
import com.belajar.mocking.dto.inbound.UserPetstoreInboundDto;
import com.belajar.mocking.dto.outbound.UserPetstoreOutboundDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PetstoreServiceTest {

    @Autowired
    PetstoreService petstoreService;

    @MockBean
    HistoryClient historyClient;

    @Test
    public void createUser() throws JsonProcessingException {
        //Data Input
        UserPetstoreOutboundDto userPetstoreOutboundDto = new UserPetstoreOutboundDto();
        userPetstoreOutboundDto.setId(1);
        userPetstoreOutboundDto.setEmail("fascalsj@gmail.com");
        userPetstoreOutboundDto.setFirstName("Fascal");
        userPetstoreOutboundDto.setLastName("Sapty");
        userPetstoreOutboundDto.setPhone("082219080257");
        userPetstoreOutboundDto.setUserStatus(200);
        userPetstoreOutboundDto.setPassword("Fascal123");
        userPetstoreOutboundDto.setUsername("fascalsj");


        //Data Expected
        UserPetstoreInboundDto userPetstoreInboundDto = new UserPetstoreInboundDto();
        userPetstoreInboundDto.setCode(200);
        userPetstoreInboundDto.setType("unknown");
        userPetstoreInboundDto.setMessage("1");

        Mockito.when(historyClient.createUser(Mockito.any(UserPetstoreOutboundDto.class))).thenReturn(userPetstoreInboundDto);

        UserPetstoreInboundDto actual = petstoreService.createUser(userPetstoreOutboundDto);



    }
}
