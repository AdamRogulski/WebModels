package com.example.WebModels.render;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Render {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long renderId;

    @NotEmpty
    private String source;

    private String description;

    public Long getRenderId() {
        return renderId;
    }

    public void setRenderId(Long renderId) {
        this.renderId = renderId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
