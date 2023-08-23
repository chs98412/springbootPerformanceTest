package com.CommentTest.controller;

import com.CommentTest.dto.NestedCommentDTO;
import com.CommentTest.service.NestedCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("nestedcomment")
public class NestedCommentController {

    @Autowired
    private NestedCommentService nestedCommentService;


    @GetMapping("")
    public ResponseEntity retrieveNestedComment(@RequestParam Long commentId) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<NestedCommentDTO.Response> response = nestedCommentService.nestedCommentRetrieve(commentId);
        stopWatch.stop();
        System.out.print("수행시간 >> " );
        System.out.println(stopWatch.getTotalTimeSeconds());
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }
}
