package com.belajar.mocking.controller;


import com.belajar.mocking.entity.InvoiceEntity;
import com.belajar.mocking.entity.InvoiceItemEntity;
import com.belajar.mocking.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(InvoiceController.class)
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceService invoiceService;

    @Test
    public void createSuccess() throws Exception {
        InvoiceItemEntity invoiceItemEntityExpected = new InvoiceItemEntity();
        invoiceItemEntityExpected.setId(1);
        invoiceItemEntityExpected.setItemName("sangkar burung");
        invoiceItemEntityExpected.setPricePcs(10000);
        invoiceItemEntityExpected.setQty(10);
        invoiceItemEntityExpected.setIdInvoice(1);
        invoiceItemEntityExpected.setItemId(1);
        invoiceItemEntityExpected.setPriceTotal(100000);

        List<InvoiceItemEntity> invoiceItemEntitiesExpected = new ArrayList<>();
        invoiceItemEntitiesExpected.add(invoiceItemEntityExpected);

        InvoiceEntity invoiceEntityExpected = new InvoiceEntity();
        invoiceEntityExpected.setId(1);
        invoiceEntityExpected.setInvoiceItemList(invoiceItemEntitiesExpected);
        invoiceEntityExpected.setDiscountPercentage(10);
        invoiceEntityExpected.setTotalAmount(10000);
        invoiceEntityExpected.setStatus(true);

        Mockito.when(invoiceService.create(Mockito.any(InvoiceEntity.class)))
                .thenReturn(invoiceEntityExpected);

        MockHttpServletRequestBuilder requestBuilders = MockMvcRequestBuilders
                .post("/invoice")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"total_amount\": 10000,\n" +
                        "    \"discount_percentage\": 10,\n" +
                        "    \"status\": true,\n" +
                        "    \"invoice_item_list\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"id_invoice\": 1,\n" +
                        "            \"item_id\": 1,\n" +
                        "            \"item_name\": \"sangkar burung\",\n" +
                        "            \"qty\": 10,\n" +
                        "            \"price_pcs\": 10000,\n" +
                        "            \"price_total\": 100000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}");

        mockMvc.perform(requestBuilders)
                .andExpect(MockMvcResultMatchers.content().json(
                        "{\n" +
                                "    \"id\": 1,\n" +
                                "    \"total_amount\": 10000,\n" +
                                "    \"discount_percentage\": 10,\n" +
                                "    \"status\": true,\n" +
                                "    \"invoice_item_list\": [\n" +
                                "        {\n" +
                                "            \"id\": 1,\n" +
                                "            \"id_invoice\": 1,\n" +
                                "            \"item_id\": 1,\n" +
                                "            \"item_name\": \"sangkar burung\",\n" +
                                "            \"qty\": 10,\n" +
                                "            \"price_pcs\": 10000,\n" +
                                "            \"price_total\": 100000\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}"
                ))
                .andDo(MockMvcResultHandlers.print());
    }


}