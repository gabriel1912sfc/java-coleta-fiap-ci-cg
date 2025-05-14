package br.com.fiap.coleta.controller;


import br.com.fiap.coleta.dto.ColetaCreateDTO;
import br.com.fiap.coleta.dto.ColetaExhibitionDTO;
import br.com.fiap.coleta.model.Coleta;
import br.com.fiap.coleta.service.ColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ColetaExhibitionDTO insertColeta(@RequestBody @Valid ColetaCreateDTO coletaCreateDTO) {
        return coletaService.insertColeta(coletaCreateDTO);
    }

    @GetMapping("/coletas")
    @ResponseStatus(HttpStatus.OK)
    public List<Coleta> selectColetas() {
        return coletaService.selectColetas();
    }

    @GetMapping("/{id}")
    public Optional<ColetaExhibitionDTO> selectColetaById(@PathVariable Long id) {
        return coletaService.selectColetaById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteColeta(@PathVariable Long id) {
        coletaService.deleteColeta(id);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ColetaExhibitionDTO updateColeta(
            @PathVariable Long id,
            @RequestBody @Valid ColetaCreateDTO coletaCreateDTO) {
        return coletaService.updateColeta(id, coletaCreateDTO);
    }

}
