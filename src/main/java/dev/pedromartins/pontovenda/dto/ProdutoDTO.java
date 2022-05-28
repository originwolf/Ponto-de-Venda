package dev.pedromartins.pontovenda.dto;

import java.util.Objects;

public class ProdutoDTO {
    private Long id;
    private String nome;

    public ProdutoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ProdutoDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoDTO)) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
