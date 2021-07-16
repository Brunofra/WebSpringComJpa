package com.br.web.conf;

import java.util.Arrays;
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
import com.br.web.entity.Funcionalidades;
import com.br.web.entity.Perfil;
import com.br.web.entity.StatusEnum;
import com.br.web.entity.Usuario;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{

	
	@Autowired
	private PerfilRepository repositorioDePerfis;
	
	@Autowired
	private UsuarioRepository repositorioDesuarios;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		// tratamento lazy e eager não sendo o ideal o uso do eager no onetomany
		Funcionalidades escrita = new Funcionalidades("escrita");
		Funcionalidades leitura = new Funcionalidades("leitura");
		
		Perfil perfil = new Perfil("Admin",StatusEnum.ATIVO,Arrays.asList(escrita));
		Perfil perfil2 = new Perfil("Aluno",StatusEnum.ATIVO,Arrays.asList(leitura));
		
		Usuario user = new Usuario();
		user.setNome("teste");
		user.setEmail("teste@teste.com.br");
		user.setPerfis(Arrays.asList(perfil2));
		
		Usuario user2 = new Usuario();
		user2.setNome("teste2");
		user2.setEmail("teste2@teste.com.br");
		user2.setPerfis(Arrays.asList(perfil));
		this.repositorioDesuarios.save(user);
		this.repositorioDesuarios.save(user2);
		
		List<Usuario> users = this.repositorioDesuarios.findAll();
		
		for(Usuario user3 : users){
			for (Perfil perfil3 : user3.getPerfis()) {
				System.out.println(perfil3.getNome());
				for (Funcionalidades funcionalidade : perfil3.getFuncionalidades()) {

					System.out.println(funcionalidade.getNome());
				}
			}
		}
		
		Usuario usuario = this.repositorioDesuarios.findByNome("2");
		
		System.out.println(usuario.getNome());
			// paginação 
//		for(int i = 0 ; i < 1000; i++) {
//			save("admin"+i, StatusEnum.ATIVO);
//		}
//		
//		PageRequest page = PageRequest.of(0, 10);
//		Page<Perfil> perfis = this.repositorioDePerfis.findAll(page);
//		for(Perfil perfil : perfis){
//			System.out.println(perfil.getNome());
//		}
//		
// 			criação e leitura de objetos no H2
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

//	public void save(String nome, StatusEnum status) {
//		
//		Perfil perfil = new Perfil( nome, status);
//		
//
//			this.repositorioDePerfis.save(perfil);
//		
//	}
	
}
