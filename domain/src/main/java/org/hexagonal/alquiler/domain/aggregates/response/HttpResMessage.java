package org.hexagonal.alquiler.domain.aggregates.response;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class HttpResMessage {
    private String message;
}
