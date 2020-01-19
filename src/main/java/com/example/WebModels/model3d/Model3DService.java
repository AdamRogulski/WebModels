package com.example.WebModels.model3d;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Model3DService {

    private Model3DRepository model3DRepository;

    public Model3DService(Model3DRepository model3DRepository) {
        this.model3DRepository = model3DRepository;
    }

    protected void add3DModel(Model3D model3D){
        model3DRepository.save(model3D);
    }

    protected List<Model3D> getAll(){
        return model3DRepository.findAll();
    }
}
