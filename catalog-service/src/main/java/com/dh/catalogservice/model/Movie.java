package com.dh.catalogservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author vaninagodoy
 */

@Data
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @Id
    private String id;

    private String name;

    private String genre;

    private String urlStream;

}
