package com.CommentTest.controller;

import com.CommentTest.dto.CommentDTO;
import com.CommentTest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

//    @PostMapping("")
//    public ResponseEntity createComment( @RequestBody CommentDTO.Request request) {
//        CommentDTO.Response response = commentService.commentCreate(request);
//        return new ResponseEntity(response, HttpStatus.CREATED);
//    }

    @GetMapping("")
    public ResponseEntity retrieveComment(@RequestParam Long id) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        List<CommentDTO.Response> response = commentService.commentRetrieve(id);


        stopWatch.stop();
        System.out.print("수행시간 >> " );
        System.out.println(stopWatch.getTotalTimeSeconds());

        String filePath = "/Users/choihyuksoon/Desktop/Project/CommentTest/test1_server.csv";

        File file = null;
        BufferedWriter bw = null;
        String NEWLINE = System.lineSeparator(); // 줄바꿈(\n)

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
