package com.CommentTest.service;


import com.CommentTest.entity.Article;
import com.CommentTest.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;



    public Article articleFind(Long postId) {
        return articleRepository.findById(postId).get();
    }

}
