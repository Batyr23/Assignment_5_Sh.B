package com.company.Controllers;

import com.company.entites.Stone;
import com.company.repositories.interfaces.IStoneRepo;

public class StoneController {
    private final IStoneRepo repo;

    public StoneController(IStoneRepo repo) {
        this.repo = repo;
    }

    public String createStone(int stone_id, String stone_name, double stone_weight, double stone_cost) {
        Stone stone = new Stone(stone_id, stone_name, stone_weight, stone_cost);

        boolean created = repo.createStone(stone);

        return (created ? "Stone was created!" : "Stone creation was failed!");
    }

}
