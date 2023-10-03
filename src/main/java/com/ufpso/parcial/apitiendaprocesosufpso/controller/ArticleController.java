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
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @GetMapping("article/list")
    public ResponseEntity<List<Article>> getAllArticle() {
        return ResponseEntity.ok(articleService.getAllArticle());
    }

    @PostMapping("article")
    public ResponseEntity<Article> create(@RequestBody Article article) {
        return new ResponseEntity<>(articleService.createArticle(article), HttpStatus.CREATED);
    }

    @PutMapping("article/update/{id}")
    public ResponseEntity<Article> update(@RequestBody Article article, @PathVariable Long id ) {
        return new ResponseEntity<>(articleService.updateArticle(article,id),HttpStatus.OK);
    }

    @DeleteMapping("article/{id}")
    public ResponseEntity<List<Article>> delete(@PathVariable Long id ) {
        return new ResponseEntity(articleService.deleteArticle(id),HttpStatus.NO_CONTENT);
    }
}
