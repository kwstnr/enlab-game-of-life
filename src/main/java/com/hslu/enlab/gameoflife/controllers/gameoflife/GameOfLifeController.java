package com.hslu.enlab.gameoflife.controllers.gameoflife;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hslu.enlab.gameoflife.domain.World;

@RestController
public class GameOfLifeController {
    @PostMapping("/generate_world")
    public WorldResponse generateWorld(@RequestBody GenerationRequest generation) {
        World world = new World(generation.getWorld().toCells());
        for (int i = 0; i < generation.getGeneration(); i++) {
            world.nextGeneration();
        }
        return new WorldResponse(world.getCells());
    }
}
