package sinuca.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import sinuca.example.model.CalculoRequest;
import sinuca.example.service.SinucaService;

@Controller
@RequestMapping("/sinuca")
public class SinucaController {

    private final SinucaService service;

    public SinucaController(SinucaService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "html/index"; // vai carregar templates/index.html
    }

    @PostMapping("/calcular")
    public String calcular(@ModelAttribute CalculoRequest req, Model model) {
        Map<String, Double> resultado = service.calcular(req);
        model.addAttribute("resultado", resultado);
        return "html/index";
    }
}