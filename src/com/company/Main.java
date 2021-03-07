package com.company;

import com.company.Controllers.NecklaceController;
import com.company.Controllers.StoneController;
import com.company.data.DB;
import com.company.data.interfaces.IDB;
import com.company.repositories.NecklaceRepo;
import com.company.repositories.StoneRepo;
import com.company.repositories.interfaces.INecklaceRepo;
import com.company.repositories.interfaces.IStoneRepo;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        IDB db = new DB();
        IStoneRepo repo = new StoneRepo(db);
        INecklaceRepo repo_2 = new NecklaceRepo(db);

        StoneController controller = new StoneController(repo);
        NecklaceController controller_2 = new NecklaceController(repo_2);

        MyApplication app = new MyApplication(controller, controller_2);
        app.start();

    }
}
