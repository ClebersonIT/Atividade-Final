package atividade.unifor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import atividade.unifor.model.GestaoAdministrativa;
import atividade.unifor.service.GestaoAdministrativaService;

@RestController
@RequestMapping("/api/gestao")
public class GestaoAdministrativaController {

    @Autowired
    private GestaoAdministrativaService service;

    @GetMapping
    public List<GestaoAdministrativa> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GestaoAdministrativa> buscarPorId(@PathVariable String id) {
        GestaoAdministrativa gestao = service.buscarPorId(id);
        return gestao != null ? ResponseEntity.ok(gestao) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public GestaoAdministrativa salvar(@RequestBody GestaoAdministrativa gestao) {
        return service.salvar(gestao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GestaoAdministrativa> atualizar(@PathVariable String id, @RequestBody GestaoAdministrativa gestao) {
        GestaoAdministrativa atualizado = service.atualizar(id, gestao);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
