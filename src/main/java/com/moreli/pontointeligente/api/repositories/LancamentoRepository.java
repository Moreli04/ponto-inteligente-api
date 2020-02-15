package com.moreli.pontointeligente.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moreli.pontointeligente.api.entities.Lancamento;

@Repository
@NamedQueries({
	@NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
			query = "SELECT lanc from Lancamento lanc WHERE lanc.funcionario.id = ?1")
})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	@Transactional(readOnly = true)
	public List<Lancamento> findByFuncionarioId(Long funcionarioId);
	
	@Transactional(readOnly = true)
	public Page<Lancamento> findByFuncionarioId(Long funcionarioId, Pageable pageable);
}
