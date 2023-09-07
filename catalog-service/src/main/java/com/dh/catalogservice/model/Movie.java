package com.dh.catalogservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * @author vaninagodoy
 */

@Data
@Document
@RequiredArgsConstructor
public class Movie {
    @MongoId
    private Long id;

    private String name;

    private String genre;

    private String urlStream;

}
