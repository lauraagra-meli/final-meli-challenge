package meli.dh.com.finalmeliproject.service.feedback;

import meli.dh.com.finalmeliproject.dto.FeedbackDTO;
import meli.dh.com.finalmeliproject.model.Feedback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IFeedbackService {
    FeedbackDTO createFeedback(String productId, Feedback feedback);
    List<FeedbackDTO> allFeedbacksByProducts(String productId);
    FeedbackDTO updateFeedbackById(long feedbackId, Feedback feedback);
    void deleteFeedbackById(long feedbackId);
}
