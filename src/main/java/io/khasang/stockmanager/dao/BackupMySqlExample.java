package io.khasang.stockmanager.dao;

import org.springframework.stereotype.Component;

@Component
public class BackupMySqlExample {
    public String backupDatabase() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("mysqldump -u root -proot webstore -r  \"C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\backup.sql\"");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error:" + e;
        }
    }
}
