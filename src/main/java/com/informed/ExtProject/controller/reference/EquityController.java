package com.informed.ExtProject.controller.reference;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.server.reference.EquityService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/equities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Equity getEquityById(@PathVariable int id) throws ObjectNotFoundException {
        Optional<Equity> optionalEquity = equityService.getEquityById(id);
        if (optionalEquity.isPresent()) {
            return optionalEquity.get();
        } else {
            throw new ObjectNotFoundException("could not find equity");
        }
    }

    @DeleteMapping("/equities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeEquityById(@PathVariable int id) {
        Optional<Equity> optionalEquity = equityService.getEquityById(id);
        if (optionalEquity.isPresent()) {
            equityService.removeEquityById(id);
            System.out.println("EquityController.removeEquityById(" + id + ")");
        } else {
            throw new com.informed.ExtProject.exception.ObjectNotFoundException("Failed to remove equity with ID:" + id + "does not exist");
        }
    }


}
