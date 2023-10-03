package com.ufpso.parcial.apitiendaprocesosufpso.service;

import com.ufpso.parcial.apitiendaprocesosufpso.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private com.ufpso.parcial.apitiendaprocesosufpso.repository.ArticleRepository articleRepository;

    public Article createArticle(Article ArticleReq) {
        return articleRepository.save(ArticleReq);
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).get();
    }

    public List<Article> getAllArticle() {
        return (List<Article>) articleRepository.findAll();
    }

    public Article updateArticle(Article ArticleReq, Long id) {
        Optional<Article> ArticleDB = articleRepository.findById(id);
        if (ArticleDB.isEmpty()) {
            return null;
        }
        return articleRepository.save(ArticleDB.get());
    }

    public boolean deleteArticle(Long id) {
        Optional<Article> ArticleDB = articleRepository.findById(id);
        if (ArticleDB.isEmpty()) {
            return false;
        }
        articleRepository.delete(ArticleDB.get());
        return true;
    }
}
