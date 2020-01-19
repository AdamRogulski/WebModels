package com.example.WebModels.animation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AnimationController {

    private AnimationService animationService;

    public AnimationController(AnimationService animationService) {
        this.animationService = animationService;
    }

    @GetMapping("/animations")
    public List<Animation> getAllAnimations(){
        return animationService.getAll();
    }

    @GetMapping("/animations/{id}")
    public Animation getSingleAnimation(@PathVariable Long id){
        return animationService.getAnimationById(id);
    }

    @PostMapping("/animations/add")
    public ResponseEntity<String> addAnimation(@RequestBody @Valid Animation animation){
        animationService.save(animation);
        return new ResponseEntity<>("Animation added", HttpStatus.OK);
    }

    @DeleteMapping("/animations/{id}")
    public ResponseEntity<String> deleteAnimation(@PathVariable Long id){
        animationService.deleteById(id);
        return new ResponseEntity<>("Animation deleted", HttpStatus.OK);
    }
    
}
