package com.ufpso.parcial.apitiendaprocesosufpso.service;

import com.ufpso.parcial.apitiendaprocesosufpso.model.Article;
import com.ufpso.parcial.apitiendaprocesosufpso.model.Category;
import com.ufpso.parcial.apitiendaprocesosufpso.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryService categoryService;

    public Article createArticle(Article articleReq) {
        List<Article> category = (List<Article>) articleRepository.findAll();
        for (Article article : category)
            if(article.getDescripcion().equals(articleReq.getDescripcion()))
                return null;
        return articleRepository.save(articleReq);
    }

    public Article getArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty())
            return null;
        return article.get();
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

    public List<Article> getByCategory(String category){
        List<Article> articles = (List<Article>) articleRepository.findAll();
        List<Article> aux = new ArrayList<>();
        for (Article article : articles)
            if(article.getCategoria().equals(category))
                aux.add(article);
        return aux;
    }
}
