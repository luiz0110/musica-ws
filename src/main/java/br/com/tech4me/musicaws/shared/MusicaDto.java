package br.com.tech4me.musicaws.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class MusicaDto {
    private String id;
    
    @NotEmpty(message = "O Título deve ser preenchido!")
    @NotBlank(message = "O Título não deve ter apenas espaços em Branco!")
    @Size(min =4, message = "O Título deve conter ao menos 2 caracteres.")
    private String titulo;

    @NotEmpty(message = "O Nome do Artista deve ser informado")
    @NotBlank(message = "O Nome do Artista não deve ter apenas espaços em Branco!")
    private String artista;

    @NotEmpty(message = "O Nome do Album deve ser informado")
    @NotBlank(message = "O Nome do Album não deve ter apenas espaços em Branco!")
    private String album;

    @Positive(message = "O Ano de Lançametno deve ser Maior do que Zero.")
    private int anoLancamento;
    private String genero;
    private String compositor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }


}
