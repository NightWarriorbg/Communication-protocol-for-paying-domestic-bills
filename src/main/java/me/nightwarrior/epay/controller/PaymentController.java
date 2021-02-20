package me.nightwarrior.epay.controller;

import lombok.extern.slf4j.Slf4j;
import me.nightwarrior.epay.model.Merchant;
import me.nightwarrior.epay.model.MerchantList;
import me.nightwarrior.epay.model.Request;
import me.nightwarrior.epay.model.Response;
import me.nightwarrior.epay.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    MerchantService merchantService;

    @GetMapping(value = "/merchants", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
    public @ResponseBody
    MerchantList getMerchantsData(@RequestParam(defaultValue = "bg") String lang) {
        logger.info("START getMerchantsData");

        return merchantService.getMerchantsDataList();
    }

    @PostMapping(value = "/checkBill", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Response checkBill(@RequestBody Request request) throws RuntimeException{
        logger.info("Starting checkBill");
        logger.info("Request merchantId: " + request.getMerchantId());
        logger.info("Request subscrNumber: " + request.getSubscrNumber());

        Response response = new Response("00", new Date(20103011),11.23,null, null, "", "", "1234567890");
        return validateData(request.getMerchantId(), request.getSubscrNumber(), response);
    }

    @PostMapping(value = "/checkBillBlocked", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Response checkBillBlocked(@RequestBody Request request) {
        logger.info("Starting checkBillBlocked");
        logger.info("Request transactionId: " + request.getTransactionId());
        logger.info("Request dt: " + request.getDt());
        logger.info("Request merchantId: " + request.getMerchantId());
        logger.info("Request subscrNumber: " + request.getSubscrNumber());

        Response response = new Response("00", null,1000d,10d, 1010d, "", "", null);
        return validateData(request.getMerchantId(), request.getSubscrNumber(), response);
    }

    @PostMapping(value = "/payBill", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Response payBill(@RequestBody Request request) {
        logger.info("Starting payBill");
        logger.info("Request transactionId: " + request.getTransactionId());
        logger.info("Request dt: " + request.getDt());
        logger.info("Request amount: " + request.getAmount());
        logger.info("Request merchantId: " + request.getMerchantId());
        logger.info("Request subscrNumber: " + request.getSubscrNumber());

        Response response = new Response("00", null,null,null, null, null, null, null);
        return validateData(request.getMerchantId(), request.getSubscrNumber(), response);
    }

    @PostMapping(value = "/reverseBill", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Response reverseBill(@RequestBody Request request) {
        logger.info("Starting reverseBill");
        logger.info("Request transactionId: " + request.getTransactionId());
        logger.info("Request dt: " + request.getDt());
        logger.info("Request amount: " + request.getAmount());
        logger.info("Request merchantId: " + request.getMerchantId());
        logger.info("Request subscrNumber: " + request.getSubscrNumber());

        Response response = new Response("00", null,null,null, null, null, null, null);
        return validateData(request.getMerchantId(), request.getSubscrNumber(), response);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Response validateData(String requestMerchantId, String requestSubscrNumber, Response response) {
        int randomNumber = getRandomNumber(1, 4);

        // There is a 25% chance to make the subscriber number an invalid one to test error handling
        if (randomNumber == 2) {
            requestSubscrNumber = "";
        }

        for (Merchant merchant : merchantService.getMerchantsDataList().getMerchantsList()) {
            if (merchant.getMerchantId().equals(requestMerchantId) && merchant.getSubscrNumberRe().equals(requestSubscrNumber)) {
                return response;
            }
        }
        throw new RuntimeException("Run Time Error");
    }


}