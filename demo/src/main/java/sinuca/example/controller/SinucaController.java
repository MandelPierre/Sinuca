package sinuca.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinuca.example.model.*;
import sinuca.example.service.SinucaService;
import sinuca.example.model.Jogador;

import java.util.*;

@Controller
@RequestMapping("/sinuca")
public class SinucaController {

    private final SinucaService service;

    public SinucaController(SinucaService service) {
        this.service = service;
    }

    @GetMapping("/inicio")
    public String telaInicial() {
        return "inicio";
    }

    @PostMapping("/configurar")
    public String configurar(@RequestParam int qtdPartidas,
                            @RequestParam double valorFicha,
                            @RequestParam List<String> nomesJogadores,
                            @RequestParam String todosJogaram, 
                            Model model) {

        List<Partida> partidas = new ArrayList<>();
        
        for (int i = 1; i <= qtdPartidas; i++) {
            if (todosJogaram.equals("sim")) {
               partidas.add(new Partida("Partida " + i, new ArrayList<>(nomesJogadores))); 
            }
            partidas.add(new Partida("Partida " + i, new ArrayList<>()));
        }

        CalculoRequest req = new CalculoRequest();
        req.setPartidas(partidas);
        req.setValorFicha(valorFicha);
        req.setNomesJogadores(nomesJogadores);

        if (todosJogaram.equals("sim")) {
            Map<Jogador, Double> totais = service.calcular(req);
            String resultado = service.gerarResumo(totais);
            model.addAttribute("resultado", resultado);
            return "resultado";
        } else {
            model.addAttribute("req", req);
            return "partidas";
        }

        
    }

    @PostMapping("/calcular")
    public String calcular(@ModelAttribute CalculoRequest req, Model model) {
        Map<Jogador, Double> totais = service.calcular(req);
        String resultado = service.gerarResumo(totais);

        model.addAttribute("resultado", resultado);
        return "resultado";
    }

    @GetMapping("/")
    public String redirecionarInicio() {
        return "redirect:/sinuca/inicio";
    }
}
