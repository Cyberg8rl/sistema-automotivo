package com.sistema.automotivo.service;

import com.sistema.automotivo.model.Veiculo;
import com.sistema.automotivo.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Diz ao Spring que essa classe cuida das regras de negócio
public class VeiculoService {

    private final VeiculoRepository repository;

    // Construtor para o Spring injetar o Repositório automaticamente
    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    // 1. Cadastrar ou Atualizar Veículo
    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    // 2. Listar todos os veículos (Consulta)
    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    // 3. Buscar veículo por ID específico
    public Optional<Veiculo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // 4. Remover Veículo do estoque
    public void remover(Long id) {
        repository.deleteById(id);
    }
}