package sinuca.example.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import sinuca.example.model.CalculoRequest;
import sinuca.example.service.SinucaService;

@RestController
@RequestMapping("/api")
public class SinucaController {

    private final SinucaService service;

    public SinucaController(SinucaService service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public Map<String, Double> calcular(@RequestBody CalculoRequest req) {
        return service.calcular(req);
    }
}