package com.ufpso.parcial.apitiendaprocesosufpso.repository;

import com.ufpso.parcial.apitiendaprocesosufpso.controller.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
