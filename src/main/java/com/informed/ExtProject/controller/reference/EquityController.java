package com.informed.ExtProject.controller.reference;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.server.reference.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trader")
public class EquityController {

    private EquityService equityService;

    @Autowired
    public void setEquityService(EquityService equityService) {
        this.equityService = equityService;
    }

    @GetMapping("/equities")
    @ResponseStatus(HttpStatus.OK)
    public List<Equity> getEquities() {
        System.out.println("EquityController.getEquities()");
        return equityService.getAllEquities();
    }

    @PostMapping("/equities")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEquity(@RequestBody Equity equity) {
        System.out.println("EquityController.addEquity(" + equity + ")");
        equityService.addEquity(equity);
    }

}
