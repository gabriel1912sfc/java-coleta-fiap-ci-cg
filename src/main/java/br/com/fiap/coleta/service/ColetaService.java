package br.com.fiap.coleta.service;

import br.com.fiap.coleta.model.Coleta;
import br.com.fiap.coleta.repository.ColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository coletaRepository;

    public Coleta insertColeta(Coleta coleta){
        return this.coletaRepository.save(coleta);
    }

    public List<Coleta> selectColetas(){
        return this.coletaRepository.findAll();
    }

    public Optional<Coleta> selectColetaById(Long id){
        return this.coletaRepository.findById(id);
    }

    public void deleteColeta(Coleta coleta){
        this.coletaRepository.delete(coleta);
    }

}
