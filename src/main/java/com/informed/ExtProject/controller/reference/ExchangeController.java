package com.informed.ExtProject.controller.reference;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.server.reference.ExchangeService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/exchanges/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Exchange getExchangeById(@PathVariable int id) throws ObjectNotFoundException {
        Optional<Exchange> optionalExchange = exchangeService.getExchangeById(id);
        if (optionalExchange.isPresent()) {
            return optionalExchange.get();
        } else {
            throw new ObjectNotFoundException("could not find exchange");
        }
    }

    @DeleteMapping("/exchanges/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeExchangeById(@PathVariable int id) {
        Optional<Exchange> optionalExchange = exchangeService.getExchangeById(id);
        if (optionalExchange.isPresent()) {
            exchangeService.removeExchangeById(id);
            System.out.println("ExchangeController.removeExchangeById(" + id + ")");
        } else {
            throw new com.informed.ExtProject.exception.ObjectNotFoundException("Failed to remove exchange with ID:" + id + "does not exist");
        }
    }


}

