package io.khasang.stockmanager.dao;

import java.io.IOException;

public class BackupDBImpl implements BackupDB {
    @Override
    public String makeBackup() {
        String result = "error ";
        int time = 0;
        String cmd[] = {
                "C:\\Program Files\\PostgreSQL\\9.4\\bin\\pg_dump.exe",
                "-d",
                "stockmanager",
                "-h",
                "localhost",
                "-U",
                "root",
                "-w",
                "-f",
                "C:\\backup\\backup_stockmanager.sql"
        };

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.environment().put("PGPASSWORD", "root");
            Process pr = pb.start();
            time = pr.waitFor();
        } catch (IOException | InterruptedException e) {
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
