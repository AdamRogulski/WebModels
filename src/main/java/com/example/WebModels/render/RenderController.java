package com.example.WebModels.render;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RenderController {

    private RenderService renderService;

    public RenderController(RenderService renderService) {
        this.renderService = renderService;
    }

    @GetMapping("/render/all")
    public List<Render> getRenders(){
        return renderService.getAllRenders();
    }

    @PostMapping("/render/add")
    public ResponseEntity<String> addRender(@RequestBody @Valid Render render){
        renderService.addRender(render);
        return new ResponseEntity<>("Render added", HttpStatus.OK);
    }
}
