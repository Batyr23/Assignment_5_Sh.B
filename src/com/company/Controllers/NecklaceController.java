package com.company.Controllers;

import com.company.entites.Necklace;
import com.company.repositories.interfaces.INecklaceRepo;

public class NecklaceController {

    private final INecklaceRepo repo2;

    public NecklaceController(INecklaceRepo repo2) {
        this.repo2 = repo2;
    }

    public String createNecklace(int necklace_id, String necklace_name, double necklace_weight, double necklace_cost, int num_stones) {
        Necklace necklace = new Necklace(necklace_id, necklace_name, necklace_weight, necklace_cost, num_stones);

        boolean created = repo2.createNecklace(necklace);

        return (created ? "necklace was created!" : "necklace creation was failed!");
    }

    public void UpdateOverAllWeight(int necklace_id, int stone_id, int num_stones){
        repo2.UpdateOverAllWeight(necklace_id, stone_id, num_stones);
    }

    public void UpdateOverAllCost(int necklace_id, int stone_id, int num_stones){
        repo2.UpdateOverAllCost(necklace_id, stone_id, num_stones);
    }

}
