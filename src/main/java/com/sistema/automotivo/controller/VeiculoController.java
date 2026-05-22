package com.sistema.automotivo.controller;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é uma API REST
@RequestMapping("/api/veiculos") // URL base para acessar os veículos
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    // C - Criar (Cadastrar Veículo)
    @PostMapping
    public ResponseEntity<Veiculo> cadastrar(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = service.salvar(veiculo);
        return ResponseEntity.ok(novoVeiculo);
    }

    // R - Ler (Listar todos os Veículos)
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // U - Atualizar (Editar Preço, Quilometragem ou Status)
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        return service.buscarPorId(id).map(veiculo -> {
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAno(veiculoAtualizado.getAno());
            veiculo.setCor(veiculoAtualizado.getCor());
            veiculo.setPreco(veiculoAtualizado.getPreco());
            veiculo.setQuilometragem(veiculoAtualizado.getQuilometragem());
            veiculo.setStatus(veiculoAtualizado.getStatus());
            Veiculo atualizado = service.salvar(veiculo);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // D - Deletar (Remover Veículo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.remover(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}