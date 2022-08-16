package meli.dh.com.finalmeliproject.service.feedback;

import meli.dh.com.finalmeliproject.dto.FeedbackDTO;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.model.Feedback;
import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.repository.IFeedbackRepository;
import meli.dh.com.finalmeliproject.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService implements IFeedbackService{

    @Autowired
    IFeedbackRepository feedbackRepository;

    @Autowired
    IProductRepo productRepository;

    @Override
    public FeedbackDTO createFeedback(String productId, Feedback feedback) {
        try {
            Product product = productRepository.findById(productId);
            var oldFeedbacks = product.getFeedbacks();
            oldFeedbacks.add(feedback);
            product.setFeedbacks(oldFeedbacks);
            var updated = productRepository.save(product);

            feedback.setProduct(updated);
            Feedback newFeedback = feedbackRepository.save(feedback);

            return new FeedbackDTO(newFeedback.getId(), newFeedback.getProduct().getName(), newFeedback.getDescription());
        }
        catch (Exception ex){
            throw new NotFoundExceptionImp("Product id not found");
        }
    }

    @Override
    public List<FeedbackDTO> allFeedbacksByProducts(String productId) {
        try {
            Product product = productRepository.findById(productId);

            if (product.getFeedbacks().isEmpty()){
                throw new NotFoundExceptionImp("There's no feedback about this product.");
            }

            return product.getFeedbacks().stream()
                    .map(products -> new FeedbackDTO(products.getId(), products.getProduct().getId(), products.getDescription()))
                    .collect(Collectors.toList());

        }
        catch (Exception ex){
            throw new NotFoundExceptionImp("Product id not found");
        }
    }

    @Override
    public FeedbackDTO updateFeedbackById(long feedbackId, Feedback feedback) {
        try {
            Feedback feedbackById = feedbackRepository.findById(feedbackId).get();
            Product product = feedbackById.getProduct();
            feedbackById.setId(feedbackId);
            feedbackById.setDescription(feedback.getDescription());
            Feedback updatedFeedback = feedbackRepository.save(feedbackById);
            productRepository.save(product);
            return new FeedbackDTO(updatedFeedback.getId(), updatedFeedback.getProduct().getId(), updatedFeedback.getDescription());

        }
        catch (Exception ex){
            throw new NotFoundExceptionImp("Feedback id not found");
        }
    }

    @Override
    public void deleteFeedbackById(long feedbackId) {
        try {
            feedbackRepository.deleteById(feedbackId);
        }
        catch (Exception ex){
            throw new NotFoundExceptionImp("Feedback id not found, please try again");
        }
    }
}
