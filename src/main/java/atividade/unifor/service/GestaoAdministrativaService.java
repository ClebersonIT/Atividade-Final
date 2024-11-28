package atividade.unifor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade.unifor.model.GestaoAdministrativa;
import atividade.unifor.repository.GestaoAdministrativaRepository;

@Service
public class GestaoAdministrativaService {

    @Autowired
    private GestaoAdministrativaRepository repository;

    public List<GestaoAdministrativa> listarTodos() {
        return repository.findAll();
    }

    public GestaoAdministrativa buscarPorId(String id) {
        return repository.findById(id).orElse(null);
    }

    public GestaoAdministrativa salvar(GestaoAdministrativa gestao) {
        return repository.save(gestao);
    }

    public GestaoAdministrativa atualizar(String id, GestaoAdministrativa gestao) {
        if (repository.existsById(id)) {
            gestao.setId(id);
            return repository.save(gestao);
        }
        return null;
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}
