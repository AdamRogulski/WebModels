package com.example.WebModels.model3d;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Model3DController {

    private Model3DService model3DService;

    public Model3DController(Model3DService model3DService) {
        this.model3DService = model3DService;
    }

    @GetMapping("/models/all")
    public List<Model3D> getAllModels(){
        return model3DService.getAll();
    }

    @PostMapping("/models/add")
    public ResponseEntity<String> saveModel(@RequestBody @Valid Model3D model3D){
        model3DService.add3DModel(model3D);
        return new ResponseEntity<>("Model added", HttpStatus.OK);
    }
}
