package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.ColetaCreateDTO;
import br.com.fiap.coleta.dto.ColetaExhibitionDTO;
import br.com.fiap.coleta.exceptions.ColetaNotFoundException;
import br.com.fiap.coleta.model.Coleta;
import br.com.fiap.coleta.repository.ColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository coletaRepository;

    public ColetaExhibitionDTO insertColeta(ColetaCreateDTO coletaCreateDTO){

        Coleta coleta = new Coleta();
        BeanUtils.copyProperties(coletaCreateDTO, coleta);

        Coleta createdColeta = coletaRepository.save(coleta);
        return new ColetaExhibitionDTO(createdColeta);

    }

    public List<Coleta> selectColetas(){
        return this.coletaRepository.findAll();
    }

    public Optional<ColetaExhibitionDTO> selectColetaById(Long id){
        Optional<Coleta> coletaOptional = coletaRepository.findById(id);

        if(coletaOptional.isPresent()){
            return Optional.of(new ColetaExhibitionDTO(coletaOptional.get()));
        } else {
            throw new ColetaNotFoundException("Coleta não existente!");
        }
    }

    public void deleteColeta(Long id){
        Optional<Coleta> coletaOptional = this.coletaRepository.findById(id);
        if(coletaOptional.isPresent()){
            this.coletaRepository.delete(coletaOptional.get());
        } else {
            throw new ColetaNotFoundException("Coleta não encontrada!");
        }

    }

    public ColetaExhibitionDTO updateColeta(Long id, ColetaCreateDTO coletaCreateDTO){
        Optional<Coleta> optionalColeta = this.coletaRepository.findById(id);

        if(optionalColeta.isPresent()){

            Coleta coleta = optionalColeta.get();
            BeanUtils.copyProperties(coletaCreateDTO, coleta, "id");
            Coleta createdColeta = coletaRepository.save(coleta);

            return new ColetaExhibitionDTO(createdColeta);
        } else {
            throw new ColetaNotFoundException("Coleta não encontrada!");
        }
    }

}
