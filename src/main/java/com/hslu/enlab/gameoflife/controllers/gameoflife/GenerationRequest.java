package com.hslu.enlab.gameoflife.controllers.gameoflife;

public class GenerationRequest {
    private WorldDto world;
    private int generation;

    public WorldDto getWorld() {
        return world;
    }

    public void setWorld(WorldDto world) {
        this.world = world;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
