package dev.pedromartins.pontovenda.controller;

import dev.pedromartins.pontovenda.domain.Produto;
import dev.pedromartins.pontovenda.dto.ProdutoDTO;
import dev.pedromartins.pontovenda.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> list() {
        return produtoService.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id) {
        return ResponseEntity.ok(produtoService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.save(produtoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.replace(produtoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
