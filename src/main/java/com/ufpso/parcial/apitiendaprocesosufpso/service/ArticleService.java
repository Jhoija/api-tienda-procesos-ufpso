package com.ufpso.parcial.apitiendaprocesosufpso.service;

import com.ufpso.parcial.apitiendaprocesosufpso.model.Article;
import com.ufpso.parcial.apitiendaprocesosufpso.model.Category;
import com.ufpso.parcial.apitiendaprocesosufpso.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    private CategoryService categoryService;

    public Article createArticle(Article articleReq) {
        List<Category> CategoryDB = categoryService.getAllCategory();
        if (CategoryDB == null)
            return null;
        for(Category category : CategoryDB){
            if((category.getNombre()).equals(articleReq.getNombre()))
                return articleRepository.save(articleReq);
        }
        return null;
    }

    public Article getArticleById(Long id) {
        Article article = articleRepository.findById(id).get();
        if (article != null)
            return article;
        return null;
    }

    public List<Article> getAllArticle() {
        List<Article> allArticle = (List<Article>) articleRepository.findAll();
        if(allArticle != null)
            return allArticle;
        return null;
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
