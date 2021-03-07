package com.company.repositories.interfaces;

import com.company.entites.Necklace;

public interface INecklaceRepo {
    boolean createNecklace(Necklace necklace);
    void UpdateOverAllWeight(int necklace_id, int stone_id, int number_stones);
    void UpdateOverAllCost(int necklace_id, int stone_id, int number_stones);
}
