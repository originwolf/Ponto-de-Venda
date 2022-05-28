package dev.pedromartins.pontovenda.service;

import dev.pedromartins.pontovenda.domain.Produto;
import dev.pedromartins.pontovenda.dto.ProdutoDTO;
import dev.pedromartins.pontovenda.exception.BadRequestException;
import dev.pedromartins.pontovenda.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    private static List<Produto> produtoList;
    static {
        produtoList = new ArrayList<>(List.of(new Produto(1, "Notebook"), new Produto(2, "Geladeira")));
    }

    public List<Produto> listAll() {
        return produtoRepository.findAll();
//        return produtoList;
    }

    public Produto findByIdOrThrowBadRequestException(long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new BadRequestException("Produto não encontrado. "+ id));
    }

    public Produto save(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        Produto savedProduto = findByIdOrThrowBadRequestException(produtoDTO.getId());
        produto.setId(savedProduto.getId());
        produto.setNome(produtoDTO.getNome());
        produtoRepository.save(produto);
    }
}
