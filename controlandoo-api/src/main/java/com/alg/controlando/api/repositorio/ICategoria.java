package com.alg.controlando.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alg.controlando.api.models.Categoria;
//interface com a classe JPArepository, essa classe e reponsavel por gerar
//para mim os metodos de CRUD e etc do modelo rest 
public interface ICategoria  extends JpaRepository<Categoria, Long>{

}

