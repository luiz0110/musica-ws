package br.com.tech4me.musicaws.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.musicaws.shared.MusicaDto;

public interface MusicaService {

    List<MusicaDto> obterTodos();
    Optional<MusicaDto> obterMusicaPorId(String id);
    MusicaDto cadastrarMusica(MusicaDto musica);
    void excluirMusicaPorId(String id);
    Optional<MusicaDto> atualizarMusicaPorId(String id, MusicaDto musica);
    
}
