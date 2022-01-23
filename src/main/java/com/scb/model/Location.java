package com.scb.model;

import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@JsonApiResource(type="location")
@Data
public class Location {

    @JsonApiId
    private Long id;

    @JsonApiField
    private String name;

}
