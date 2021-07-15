package com.br.web.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.web.entity.Perfil;
import com.br.web.entity.StatusEnum;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	List<Perfil> findByStatus(StatusEnum status);
	
	Page<Perfil> findAll(Pageable pageble);
}
