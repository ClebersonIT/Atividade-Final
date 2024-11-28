package atividade.unifor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import atividade.unifor.model.GestaoAdministrativa;

public interface GestaoAdministrativaRepository extends MongoRepository<GestaoAdministrativa, String> {
}
