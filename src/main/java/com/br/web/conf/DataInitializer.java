package com.br.web.conf;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Component;

import com.br.web.Repository.PerfilRepository;
import com.br.web.Repository.UsuarioRepository;
import com.br.web.entity.Perfil;
import com.br.web.entity.StatusEnum;
import com.br.web.entity.Usuario;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

	
	@Autowired
	private PerfilRepository repositorioDePerfis;
//	
//	@Autowired
//	private UsuarioRepository repositorioDesuarios;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		for(int i = 0 ; i < 1000; i++) {
			save("admin"+i, StatusEnum.ATIVO);
		}
		
		PageRequest page = PageRequest.of(0, 10);
		Page<Perfil> perfis = this.repositorioDePerfis.findAll(page);
		for(Perfil perfil : perfis){
			System.out.println(perfil.getNome());
		}
//		
//
//			Perfil perfilAdmin = new Perfil();
//			perfilAdmin.setNome("admin");
//			perfilAdmin.setStatus(StatusEnum.ATIVO);
//			
//			Perfil perfilAluno = new Perfil();
//			perfilAluno.setNome("aluno");
//			perfilAluno.setStatus(StatusEnum.INATIVO);
//
//		//if(repositorioDePerfis.findAll().isEmpty()) {
//			repositorioDePerfis.save(perfilAdmin);
//			repositorioDePerfis.save(perfilAluno);
//		//}
//		
//		Usuario user1 = new Usuario();
//		
//		user1.setEmail("teste1@teste.com.br");
//		user1.setNome("teste1");
//		user1.setPerfil(perfilAdmin);
//		
//		Usuario user2 = new Usuario();
//		user2.setEmail("teste2@teste.com.br");
//		user2.setNome("teste2");
//		user2.setPerfil(perfilAluno);
//		
//		if(repositorioDesuarios.findAll().isEmpty()) {
//			repositorioDesuarios.save(user1);
//			repositorioDesuarios.save(user2);
//		}
//		
//		List<Perfil> perfis = this.repositorioDePerfis.findByStatus(StatusEnum.ATIVO);
//		
//		for(Perfil perfil : perfis){
//			System.out.println(perfil.getNome());
//		}
	}

	public void save(String nome, StatusEnum status) {
		
		Perfil perfil = new Perfil( nome, status);
		

			this.repositorioDePerfis.save(perfil);
		
	}
	
}
