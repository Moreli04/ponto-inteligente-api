package com.moreli.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moreli.pontointeligente.api.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Transactional(readOnly = true)
	public Funcionario findByCpf(String cpf);
	
	@Transactional(readOnly = true)
	public Funcionario findByEmail(String email);
	
	@Transactional(readOnly = true)
	public Funcionario findByCpfOrEmail(String cpf, String email);
}
