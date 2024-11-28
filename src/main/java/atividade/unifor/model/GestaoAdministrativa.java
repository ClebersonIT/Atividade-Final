package atividade.unifor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "gestao_administrativa")
public class GestaoAdministrativa {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private String senha;
    private boolean gestorAdministrativo;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isGestorAdministrativo() {
		return gestorAdministrativo;
	}
	public void setGestorAdministrativo(boolean gestorAdministrativo) {
		this.gestorAdministrativo = gestorAdministrativo;
	}
    
    
}
