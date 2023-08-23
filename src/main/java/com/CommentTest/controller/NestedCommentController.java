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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@RestController
@RequestMapping("nestedcomment")
public class NestedCommentController {

    @Autowired
    private NestedCommentService nestedCommentService;


    @GetMapping("")
    public ResponseEntity retrieveNestedComment(@RequestParam Long commentId) {

        String filePath = "/Users/choihyuksoon/Desktop/Project/CommentTest/test1_server.csv";

        File file = null;
        BufferedWriter bw = null;
        String NEWLINE = System.lineSeparator(); // 줄바꿈(\n)



        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<NestedCommentDTO.Response> response = nestedCommentService.nestedCommentRetrieve(commentId);
        stopWatch.stop();
        System.out.print("수행시간 >> " );
        System.out.println(stopWatch.getTotalTimeSeconds());

        try {
            file = new File(filePath);
            bw = new BufferedWriter(new FileWriter(file,true));

            bw.write(String.valueOf(stopWatch.getTotalTimeSeconds())+",");
            bw.write(NEWLINE);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }
}
