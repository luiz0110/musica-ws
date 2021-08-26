package br.com.tech4me.musicaws.view.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.tech4me.musicaws.model.MusicaRequest;
import br.com.tech4me.musicaws.service.MusicaService;
import br.com.tech4me.musicaws.shared.MusicaDto;




@RestController
@RequestMapping("/api/musicas")
@CrossOrigin

public class MusicaController {

    @Autowired
    MusicaService servico;

       
    @GetMapping(value="/{id}")
    public ResponseEntity<MusicaDto> obterMusicaPorId(@PathVariable String id){
        Optional<MusicaDto> musi = servico.obterMusicaPorId(id);

            if(musi.isPresent()){
            return new ResponseEntity<>(musi.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<MusicaDto>> obterMusicas(){
        return new ResponseEntity<>(servico.obterTodos(),HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> cadastrarMusica(@RequestBody @Valid MusicaDto musica)   {
        return new ResponseEntity<>(servico.cadastrarMusica(musica), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMusica(@PathVariable String id){
        servico.excluirMusicaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   
    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> atualizarMusica(@PathVariable String id, @RequestBody @Valid MusicaRequest musica) {
        MusicaDto dto = new ModelMapper().map(musica, MusicaDto.class);
        Optional<MusicaDto> musi = servico.atualizarMusicaPorId(id, dto);

        if (musi.isPresent()) {
            return new ResponseEntity<>(musi.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
    }
}
