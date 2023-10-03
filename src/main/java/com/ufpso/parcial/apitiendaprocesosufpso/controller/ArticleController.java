package com.ufpso.parcial.apitiendaprocesosufpso.controller;

import com.ufpso.parcial.apitiendaprocesosufpso.model.Article;
import com.ufpso.parcial.apitiendaprocesosufpso.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        if(article != null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(article);
    }

    @GetMapping("article/list")
    public ResponseEntity<List<Article>> getAllArticle() {
        List<Article> articles = articleService.getAllArticle();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(articles);
    }

    @PostMapping("article")
    public ResponseEntity<Article> create(@RequestBody Article article) {
        if (article != null && article.getNombre() != null && article.getPrecio() != null) {
            Article createdArticle = articleService.createArticle(article);
            return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("article/update/{id}")
    public ResponseEntity<Article> update(@RequestBody Article article, @PathVariable Long id ) {
        Article updatedArticle = articleService.updateArticle(article, id);
        if (updatedArticle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedArticle);
    }

    @DeleteMapping("article/{id}")
    public ResponseEntity<List<Article>> delete(@PathVariable Long id ) {
        if (!articleService.deleteArticle(id))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
