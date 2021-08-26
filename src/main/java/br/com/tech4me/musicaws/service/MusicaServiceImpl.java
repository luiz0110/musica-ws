package br.com.tech4me.musicaws.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.musicaws.model.Musica;
import br.com.tech4me.musicaws.repository.MusicaRepository;
import br.com.tech4me.musicaws.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService{
    @Autowired
    MusicaRepository repositorio;

        @Override
        public List<MusicaDto> obterTodos() {
            List<Musica> musi = repositorio.findAll();

            return musi.stream()
                .map(m -> new ModelMapper().map(m, MusicaDto.class))
                .collect(Collectors.toList());
        }
     @Override
     public Optional<MusicaDto> obterMusicaPorId(String id){
         Optional<Musica> musi = repositorio.findById(id);

         if (musi.isPresent()) {
             return Optional.of(new ModelMapper().map(musi.get(), MusicaDto.class));
         }
         return Optional.empty();
     }

     @Override
     public MusicaDto cadastrarMusica (MusicaDto musica){
         ModelMapper mapper = new ModelMapper();
         Musica musiParaSalvar = mapper.map(musica, Musica.class);
         musiParaSalvar = repositorio.save(musiParaSalvar);
         return mapper.map(musiParaSalvar, MusicaDto.class);
     }
     
     @Override
     public void excluirMusicaPorId(String id) {
         repositorio.deleteById(id);
         
     }        
   

    @Override
    public Optional<MusicaDto> atualizarMusicaPorId(String id, MusicaDto musica){
    ModelMapper mapper = new ModelMapper();
    Optional<Musica> musi = repositorio.findById(id);
    Musica musiParaSalvar = mapper.map(musica, Musica.class);

        if (musi.isPresent()) {
             musiParaSalvar.setId(id);
             musiParaSalvar = repositorio.save(musiParaSalvar);
             return Optional.of(mapper.map(musiParaSalvar, MusicaDto.class));
        }
    
        return Optional.empty();
    }

}
