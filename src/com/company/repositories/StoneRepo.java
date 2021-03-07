package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entites.Stone;
import com.company.repositories.interfaces.IStoneRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoneRepo implements IStoneRepo {
    private final IDB db;

    public StoneRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createStone(Stone stone) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO stone(stone_id, stone_name, stone_weight, stone_cost) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, stone.getStone_id());
            st.setString(2, stone.getName());
            st.setDouble(3, stone.getStone_Weight());
            st.setDouble(4, stone.getStone_cost());

            st.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
