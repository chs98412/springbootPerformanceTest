package com.CommentTest.repository;

import com.CommentTest.entity.Article;
import com.CommentTest.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByArticle(Article article);
}
