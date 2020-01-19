package com.example.WebModels.render;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenderService {

    private RenderRepository renderRepository;

    public RenderService(RenderRepository renderRepository) {
        this.renderRepository = renderRepository;
    }

    protected List<Render> getAllRenders(){
        return renderRepository.findAll();
    }

    protected void addRender(Render render){
        renderRepository.save(render);
    }
}
