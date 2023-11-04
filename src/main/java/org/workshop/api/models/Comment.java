package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Comment {
    private String timestamp;
    private String text;
    private User user;
}
