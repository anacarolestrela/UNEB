package com.example.teste.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.model.Produto;
import com.example.teste.service.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.listTodos();
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    @GetMapping("/produtos")
    public Page<Produto> listarProdutos(
            @PageableDefault(sort = "preco", direction = Sort.Direction.ASC) Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @GetMapping("/relatorios")
    public Map<String, Object> relatorioProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        long totalProdutos = produtos.size();

        BigDecimal somaPreco = produtos.stream().map(Produto::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> relatorio = new HashMap<>();
        relatorio.put("totalProdutos", totalProdutos);
        relatorio.put("somaPreco", somaPreco);
        return relatorio;
    }

    @PatchMapping("/{id}/preco")
    public ResponseEntity<?> atualizaPreco(@PathVariable Long id, @RequestBody Map<String, BigDecimal> request) {
        Optional<Produto> produOptional = produtoRepository.findById(id);
        if (produOptional.isEmpty()) {
            return ResponseEntity.notFound().build();// erro 404
        }
        Produto produto = produOptional.get();
        if (request.containsKey("novoPreco")) {
            BigDecimal novoPreco = request.get("novoPreco");
            if (novoPreco.compareTo(BigDecimal.ZERO) <= 0) {
                return ResponseEntity.badRequest().body("O preço deve ser maior que zero.");
            }
            produto.setPreco(novoPreco);
            produtoRepository.save(produto);
            return ResponseEntity.ok("Preço atualizado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Campo 'novoPreco' é obrigatório.");
        }
    }

}
