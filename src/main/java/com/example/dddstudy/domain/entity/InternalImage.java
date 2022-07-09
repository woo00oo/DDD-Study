package com.example.dddstudy.domain.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image{
    @Override
    public String getURL() {
        return null;
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnailURL() {
        return null;
    }
}
