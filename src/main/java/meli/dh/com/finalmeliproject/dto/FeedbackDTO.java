package meli.dh.com.finalmeliproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDTO{
    private long feedbackId;
    private String productId;
    private String description;
}
