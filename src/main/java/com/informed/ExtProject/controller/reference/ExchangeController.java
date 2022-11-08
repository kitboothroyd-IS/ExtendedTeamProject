package com.informed.ExtProject.controller.reference;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.server.reference.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trader")
public class ExchangeController {

    private ExchangeService exchangeService;

    @Autowired
    public void setExchangeService(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/exchanges")
    @ResponseStatus(HttpStatus.OK)
    public List<Exchange> getExchanges() {
        System.out.println("ExchangeController.getExchanges()");
        return exchangeService.getAllExchanges();
    }

    @PostMapping("/exchanges")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExchange(@RequestBody Exchange exchange) {
        System.out.println("ExchangeController.addExchange(" + exchange + ")");
        exchangeService.addExchange(exchange);
    }

}

