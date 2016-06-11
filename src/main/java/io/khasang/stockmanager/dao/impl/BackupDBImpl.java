package io.khasang.stockmanager.dao.impl;

import io.khasang.stockmanager.dao.BackupDB;

public class BackupDBImpl implements BackupDB {
    private String pathToPgdump = "\"C:\\Program Files\\PostgreSQL\\9.4\\bin\\pg_dump.exe\"";
    private String pathForBackupFile = "C:\\backup\\backup_stockmanager.sql";
    private String nameOfDB = "stockmanager";
    private String hostName = "localhost";
    private String userName = "root";
    private String password = "root";

    private String command = pathToPgdump + " -d " + nameOfDB + " -h " + hostName + " -U " + userName + " -w " +
            " -f " + pathForBackupFile;
    private String[] environment = {"PGPASSWORD=" + password};

    /**
     * Not for real use. Just for quick testing.
     * Makes backup of postgreSQL database.
     * <p>
     * Uses command line to execute utility pg_dump.
     * <p>
     * It gets command from local variable "command" above and use environment variables
     * to set password from local variable "password" above.
     * <p>
     * It's not safety method. If you want make backup safety, password should be passed
     * into %APPDATA%\postgresql\pgpass.conf (windows) in following format:
     * hostname:port:database:username:password
     * then delete this method, variables "password" and "environment" and use method below.
     *
     * @return "success" or Exception
     */
    @Override
    public String makeBackup() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command, environment);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error:" + e;
        }
    }

    /**
     * Makes backup of postgreSQL database.
     *
     * Uses command line to execute utility pg_dump.
     *
     * It gets command from local variable "command" above and
     * password from %APPDATA%\postgresql\pgpass.conf (windows)
     *
     * @return "success" or Exception
     */
//    @Override
//    public String makeBackup() {
//        try {
//            Runtime runtime = Runtime.getRuntime();
//            runtime.exec(command);
//            return "success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error:" + e;
//        }
//    }

}
