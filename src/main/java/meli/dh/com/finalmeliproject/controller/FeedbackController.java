package meli.dh.com.finalmeliproject.controller;

import meli.dh.com.finalmeliproject.dto.FeedbackDTO;
import meli.dh.com.finalmeliproject.model.Feedback;
import meli.dh.com.finalmeliproject.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/feedback")
public class FeedbackController {

    @Autowired
    IFeedbackService feedbackService;

    @PostMapping("/{productId}")
    public ResponseEntity<FeedbackDTO> createFeedback(@PathVariable String productId, @RequestBody Feedback feedback){
        FeedbackDTO productFeedback = feedbackService.createFeedback(productId, feedback);
        return ResponseEntity.ok().body(productFeedback);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<FeedbackDTO>> allFeedbacksByProducts(@PathVariable String productId){
        List<FeedbackDTO> allFeedbacks = feedbackService.allFeedbacksByProducts(productId);
        return ResponseEntity.ok().body(allFeedbacks);
    }

    @PutMapping("/{feedbackId}")
    public ResponseEntity<FeedbackDTO> updateFeedbackById(@PathVariable long feedbackId, @RequestBody Feedback feedback){
        FeedbackDTO updatedProduct = feedbackService.updateFeedbackById(feedbackId, feedback);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<Void> deleteFeedbackById(@PathVariable long feedbackId){
        feedbackService.deleteFeedbackById(feedbackId);
        return ResponseEntity.noContent().build();
    }
}
