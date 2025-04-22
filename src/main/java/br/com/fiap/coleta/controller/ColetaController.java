package br.com.fiap.coleta.controller;


import br.com.fiap.coleta.model.Coleta;
import br.com.fiap.coleta.service.ColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coleta")
public class ColetaController {

    @Autowired
    private ColetaService coletaService;

    @GetMapping("/health")
    public String healthCheck(){

        return "OK";
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Coleta insertColeta(@RequestBody Coleta coleta) {
        return coletaService.insertColeta(coleta);
    }

    @GetMapping("/coletas")
    @ResponseStatus(HttpStatus.OK)
    public List<Coleta> selectColetas() {
        return coletaService.selectColetas();
    }

    @GetMapping("/idcoleta")
    public ResponseEntity<Coleta> selectColetaById(@RequestParam Long id) {
        return coletaService.selectColetaById(id)
                .map(coleta -> ResponseEntity.ok(coleta))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteColeta(@RequestBody Coleta coleta) {
        coletaService.deleteColeta(coleta);
    }

}
