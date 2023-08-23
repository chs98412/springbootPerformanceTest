package com.CommentTest.service;

import com.CommentTest.dto.CommentDTO;
import com.CommentTest.dto.NestedCommentDTO;
import com.CommentTest.entity.Article;
import com.CommentTest.entity.Comment;
import com.CommentTest.entity.NestedComment;
import com.CommentTest.repository.NestedCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NestedCommentService {

    @Autowired
    private NestedCommentRepository nestedCommentRepository;

    @Autowired
    private CommentService commentService;

    public List<NestedCommentDTO.Response> nestedCommentRetrieve(Long id) {
        Comment comment = commentService.commentFind(id);

        List<NestedComment> nestedComments = nestedCommentRepository.findAllByComment(comment);

        List<NestedCommentDTO.Response> response = new ArrayList<>();
        for (NestedComment nestedComment : nestedComments) {
            response.add(NestedCommentDTO.Response
                    .builder()
                    .id(nestedComment.getId())
                    .body(nestedComment.getBody())
                    .build());
        }

        return response;
    }
}
