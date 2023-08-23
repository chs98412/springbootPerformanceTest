package com.CommentTest.repository;

import com.CommentTest.entity.Article;
import com.CommentTest.entity.Comment;
import com.CommentTest.entity.NestedComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NestedCommentRepository extends JpaRepository<NestedComment,Long> {


    List<NestedComment> findAllByComment(Comment comment);
}

