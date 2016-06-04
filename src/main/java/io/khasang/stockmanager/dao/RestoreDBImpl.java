package io.khasang.stockmanager.dao;

import java.io.IOException;

public class RestoreDBImpl implements RestoreDB {

    @Override
    public String makeRestore() {
        String result = "error ";
        int time = 0;
        String cmd[] = {
                "C:\\Program Files\\PostgreSQL\\9.4\\bin\\psql.exe",
                "-U",
                "root",
                "-d",
                "stockmanager",
                "-f",
                "C:\\backup\\backup_stockmanager.sql"
        };

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.environment().put("PGPASSWORD", "root");
            Process pr = pb.start();
            time = pr.waitFor();
        } catch (IOException| InterruptedException e) {
            result = e.getMessage();
        }

        if (time == 0) {
            result = "<b>backup is created</b>";
        } else {
            result = result + "fail to create backup";
        }

        return result;
    }
}
