package io.khasang.stockmanager.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBBackup {
    public DBBackup() {
    }

    public String backup() {
        String result;
        List<String> cmds = new ArrayList<>();
        cmds.add("C:\\Program Files\\PostgreSQL\\9.4\\bin\\pg_dump.exe");
        cmds.add("-h");
        cmds.add("localhost");
        cmds.add("-p");
        cmds.add("5432");
        cmds.add("-U");
        cmds.add("root");
        cmds.add("--role");
        cmds.add("root");
        cmds.add("-d");
        cmds.add("booktown");
        cmds.add(">");
        cmds.add("D:\\backup\\booktown.backup");
        cmds.add("-W");
        cmds.add("root");

        ProcessBuilder processBuilder = new ProcessBuilder(cmds);
        try {
            Process start = processBuilder.start();
            int i = start.waitFor();
            if (i == 0) {
                result = "Backup is created";
            } else {
                result = "Fail to backup";
            }
        } catch (IOException | InterruptedException e) {
            result = "Something goes wrong";
            e.printStackTrace();
        }
        return result;
    }
}
