package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnabledInfo {
    private Boolean status;
    private Comment comment;
}
