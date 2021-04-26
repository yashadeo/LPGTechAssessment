package com.lpg.test.models.api;

import lombok.Data;

@Data
public class Attractions {
    int id;
    int cityId;
    String title;
    String type;
    double rating;
}
