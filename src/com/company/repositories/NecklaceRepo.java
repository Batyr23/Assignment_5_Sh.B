package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entites.Necklace;
import com.company.repositories.interfaces.INecklaceRepo;

import java.sql.*;

public class NecklaceRepo implements INecklaceRepo {
    private final IDB db;

    public NecklaceRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createNecklace(Necklace necklace) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO necklace(necklace_id, necklace_name, necklace_weight, necklace_cost, num_stones) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, necklace.getNecklace_id());
            st.setString(2, necklace.getNecklace_name());
            st.setDouble(3, necklace.getNecklace_Weight());
            st.setDouble(4, necklace.getNecklace_cost());
            st.setInt(5, necklace.getNumber_stones());

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

    @Override
    public void UpdateOverAllCost(int necklace_id, int stone_id, int num_stones) {
        Connection con = null;
        try {
            con = db.getConnection();

            //UpdateQuery have to be sent to the relational table
            String sql = "INSERT INTO stone_necklace (necklace_id,stone_id,num_stones,total_cost) VALUES(?,?,?,?)";

            double TotalCost = 0;
            double one_stone_cost = 0;
            double Necklace_Cost = 0;
            double TotalCost_Stones = 0;

            // Here we select one stone's cost by stone_id and record this value to double b
            String sql_1 = "Select stone_cost From stone Where stone_id = ?";
            PreparedStatement statement = con.prepareStatement(sql_1);
            statement.setInt(1,stone_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                one_stone_cost = resultSet.getInt("stone_cost");
            }

            // Here we select one necklace_cost by id then record the cost to variable  double c
            String sql_2 = "Select necklace_cost From necklace Where necklace_id = ?";
            PreparedStatement statement1 = con.prepareStatement(sql_2);
            statement1.setInt(1, necklace_id);
            ResultSet resultSet1 = statement1.executeQuery();

            if(resultSet1.next()) {
                Necklace_Cost = resultSet1.getDouble("necklace_cost");
            }

            // Here we send our UPDATE query for necklace cost
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            /**
                Calling interface to calculate sum and multiply
                типо мы пишем тут реализацию этой функции сразу внутри репо
                используя лямбда выражению
                через sum я буду суммировать для нахождения веса и цены
                черещ multiply я буду находить общий вес и цену чисто камней неужных для одного неклейса
                Total weight = num_stones * stone_weight + necklace_weight
                Total cost = num_stones * stone_cost + necklace_cost
             */

            Sum sum;
            sum = (h,k) -> h + k;

            Multiply multiply;
            multiply = (h,k) -> h * k;

            TotalCost_Stones = multiply.multiply(one_stone_cost, num_stones);
            TotalCost = sum.sum(TotalCost_Stones, Necklace_Cost);

            preparedStatement.setDouble(1,necklace_id);
            preparedStatement.setInt(2,stone_id);
            preparedStatement.setInt(3,num_stones);
            preparedStatement.setDouble(4, TotalCost);
            preparedStatement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void UpdateOverAllWeight(int necklace_id, int stone_id, int num_stones) {
        Connection con = null;
        try {
            con = db.getConnection();

            //UpdateQuery have to be sent to the relational table
            String sql = "Update stone_necklace Set total_weight = ? Where necklace_id = ?";

            double TotalWeight = 0;
            double one_stone_weight = 0;
            double Necklace_Weight = 0;
            double TotalWeight_Stones = 0;

            // Here we select one stone's cost by stone_id and record this value to double b
            String sql_1 = "Select stone_weight From stone Where stone_id = ?";
            PreparedStatement statement = con.prepareStatement(sql_1);
            statement.setInt(1,stone_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                one_stone_weight = resultSet.getInt("stone_weight");
            }

            // Here we select one necklace_weight by id then record the cost to variable  double c
            String sql_2 = "Select necklace_weight From necklace Where necklace_id = ?";
            PreparedStatement statement1 = con.prepareStatement(sql_2);
            statement1.setInt(1, necklace_id);
            ResultSet resultSet1 = statement1.executeQuery();

            if(resultSet1.next()) {
                Necklace_Weight = resultSet1.getDouble("necklace_weight");
            }

            // Here we send our UPDATE query for necklace weight
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            /**
             Calling interface to calculate sum and multiply
             типо мы пишем тут реализацию этой функции сразу внутри репо
             используя лямбда выражению
             через sum я буду суммировать для нахождения веса и цены
             черещ multiply я буду находить общий вес и цену чисто камней неужных для одного неклейса
             Total weight = num_stones * stone_weight + necklace_weight
             Total cost = num_stones * stone_cost + necklace_cost
             */

            Sum sum;
            sum = (h,k) -> h + k;

            Multiply multiply;
            multiply = (h,k) -> h * k;

            TotalWeight_Stones = multiply.multiply(one_stone_weight, num_stones);
            TotalWeight = sum.sum(TotalWeight_Stones, Necklace_Weight);

            preparedStatement.setDouble(1,TotalWeight);
            preparedStatement.setInt(2,necklace_id);
            preparedStatement.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static interface Sum {
        double sum(double h, double k);
    }

    private static interface Multiply {
        double multiply(double h, double k);
    }
}