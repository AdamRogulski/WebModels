package com.example.WebModels.animation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimationService {

    private  AnimationRepository animationRepository;

    public AnimationService(AnimationRepository animationRepository) {
        this.animationRepository = animationRepository;
    }

    protected List<Animation> getAll(){
        return animationRepository.findAll();
    }

    protected void save(Animation animation){
        animationRepository.save(animation);
    }

    protected boolean checkIfExistInDatabase(Animation animation){
        return animationRepository.existsById(animation.getAnimationId());
    }

    protected void deleteById(Long id){
        animationRepository.deleteById(id);
    }

    protected Animation getAnimationById(Long id){
        return animationRepository.getOne(id);
    }
}
