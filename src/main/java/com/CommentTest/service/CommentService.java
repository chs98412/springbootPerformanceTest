package com.CommentTest.service;


import com.CommentTest.dto.CommentDTO;
import com.CommentTest.entity.Article;
import com.CommentTest.entity.Comment;
import com.CommentTest.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentService {


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleService articleService;

//    public CommentDTO.Response commentCreate(CommentDTO.Request request) {
//
//        Article article = articleService.articleFind(request.getPostId());
//
//
//        Comment makeComment = request.toEntity();
//        makeComment.setArticle(article);
//        makeComment.setMember(member);
//
//        Comment comment=commentRepository.save(makeComment);
//
//        return CommentDTO.Response
//                .builder()
//                .id(comment.getId())
//                .body(comment.getBody())
//                .build();
//    }

    public List<CommentDTO.Response> commentRetrieve(Long id) {
        Article article = articleService.articleFind(id);

        List<Comment> comments = commentRepository.findByArticle(article);

        List<CommentDTO.Response> response = new ArrayList<>();
        for (Comment comment : comments) {
            response.add(CommentDTO.Response
                    .builder()
                    .id(comment.getId())
                    .body(comment.getBody())
                    .build());
        }

        return response;

    }


    public Comment commentFind(Long id) {
        return commentRepository.findById(id).get();
    }
}

