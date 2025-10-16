package sinuca.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinuca.example.model.*;
import sinuca.example.service.SinucaService;

import java.util.*;

@Controller
@RequestMapping("/sinuca")
public class SinucaController {

    private final SinucaService service;

    public SinucaController(SinucaService service) {
        this.service = service;
    }

    // === Tela 1: configuração inicial ===
    @GetMapping("/inicio")
    public String telaInicial() {
        return "inicio";
    }

    // Recebe número de partidas e valor da ficha
    @PostMapping("/configurar")
    public String configurar(@RequestParam int qtdPartidas,
                            @RequestParam double valorFicha,
                            @RequestParam List<String> nomesJogadores,
                            @RequestParam String todosJogaram, 
                            Model model) {

        List<Partida> partidas = new ArrayList<>();
        
        for (int i = 1; i <= qtdPartidas; i++) {
            // se todos jogaram já preenche todas as partidas com os mesmos jogadores
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
            // se todos jogaram todas, ja calcula e vai direto para o resultado
            Map<String, Double> totais = service.calcular(req);
            String resultado = service.gerarResumo(totais);
            model.addAttribute("resultado", resultado);
            return "resultado";
        } else {
            // se nem todos jogaram, vai pra tela de seleção manual
            model.addAttribute("req", req);
            return "partidas";
        }

        
    }

    // === Tela 2: recebe as partidas com os jogadores ===
    @PostMapping("/calcular")
    public String calcular(@ModelAttribute CalculoRequest req, Model model) {
        Map<String, Double> totais = service.calcular(req);
        String resultado = service.gerarResumo(totais);

        model.addAttribute("resultado", resultado);
        return "resultado";
    }

    @GetMapping("/")
    public String redirecionarInicio() {
        return "redirect:/sinuca/inicio";
    }
}
