package com.eddy.commentsrest.service;

import com.eddy.commentsrest.entity.CommentEntity;
import com.eddy.commentsrest.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentEntity createComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    public ResponseEntity<CommentEntity> getComment(Long id) {
        Optional<CommentEntity> comment = commentRepository.findById(id);

        return comment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<CommentEntity> updateComment(Long id, CommentEntity commentEntity) {
        Optional<CommentEntity> previousCommentOptional = commentRepository.findById(id);

        if (previousCommentOptional.isPresent()) {
            CommentEntity previousCommentEntity = previousCommentOptional.get();
            previousCommentEntity.setText(commentEntity.getText());

            commentRepository.save(previousCommentEntity);
            return new ResponseEntity<>(previousCommentEntity, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteComment(Long id) {
        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Comment deleted.", HttpStatus.OK);
    }
}
