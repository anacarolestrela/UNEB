package com.lista.listadef.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lista.listadef.service.ProdutoRepository;
import com.lista.listadef.service.ProdutoService;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.lista.listadef.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> getall() {
        return produtoService.ListarTodos();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.delete(id);
    }

    @GetMapping("/paginados")
    public Page<Produto> listarpage(
            @PageableDefault(sort = "preco", direction = Sort.Direction.ASC) Pageable pageable) {

        return produtoRepository.findAll(pageable);
    }

    @GetMapping("/relatorio")
    public Map<String, Object> relatorioProdutos() {

        List<Produto> produtos = produtoRepository.findAll();
        long totalProdutos = produtos.size();

        BigDecimal somaPreco = produtos.stream().map(Produto::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> relatorio = new HashMap<>();
        relatorio.put("totalProdutos", totalProdutos);
        relatorio.put("somaPreco", somaPreco);
        return relatorio;
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<String> atualizar(
            @PathVariable Long id,
            @RequestBody Map<String, BigDecimal> request) {

        BigDecimal novoPreco = request.get("novoPreco");

        if (novoPreco == null || novoPreco.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest()
                    .body("O preço deve ser maior que zero e o campo 'novoPreco' é obrigatório.");
        }

        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setPreco(novoPreco);
                    produtoRepository.save(produto);
                    return ResponseEntity.ok("Preço atualizado com sucesso.");
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
