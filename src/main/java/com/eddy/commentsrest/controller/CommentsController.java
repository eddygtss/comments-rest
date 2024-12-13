package com.eddy.commentsrest.controller;

import com.eddy.commentsrest.entity.CommentEntity;
import com.eddy.commentsrest.service.CommentService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {
    CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public CommentEntity addComment(@RequestBody CommentEntity commentEntity) {
        return commentService.createComment(commentEntity);
    }

    @PutMapping("/comment/{id}")
    public HttpEntity<CommentEntity> updateComment(@RequestBody CommentEntity commentEntity,
                                            @PathVariable long id) {
        return commentService.updateComment(id, commentEntity);
    }

    @GetMapping("/comment/{id}")
    public HttpEntity<CommentEntity> getComment(@PathVariable long id) {
        return commentService.getComment(id);
    }

    @DeleteMapping("/comment/{id}")
    public HttpEntity<String> deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
