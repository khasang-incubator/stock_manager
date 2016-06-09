package io.khasang.stockmanager.dao;

public class RestoreDBImpl implements RestoreDB {
    private String pathToPqsl = "\"C:\\Program Files\\PostgreSQL\\9.4\\bin\\psql.exe\"";
    private String pathForBackupFile = "C:\\backup\\backup_stockmanager.sql";
    private String nameOfDB = "stockmanager";
    private String userName = "root";
    private String password = "root";

    private String command = pathToPqsl + " -d " + nameOfDB + " -U " + userName + " -f " + pathForBackupFile;
    private String[] environment = {"PGPASSWORD=" + password};


    /**
     * Not for real use. Just for quick testing.
     * Restores postgreSQL database from file.
     * <p>
     * Uses command line to execute utility psql.
     * <p>
     * It gets command from local variable "command" above and use environment variables
     * to set password from local variable "password" above.
     * <p>
     * It's not safety method. If you want restore safety, password should be passed
     * into %APPDATA%\postgresql\pgpass.conf (windows) in following format:
     * hostname:port:database:username:password
     * then delete this method, variables "password" and "environment" and use method below.
     *
     * @return "success" or Exception
     */
    @Override
    public String makeRestore() {
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
     * Restores postgreSQL database from file.
     *
     * Uses command line to execute utility psql.
     *
     * It gets command from local variable "command" above and
     * password from %APPDATA%\postgresql\pgpass.conf (windows)
     *
     * @return "success" or Exception
     */
//    @Override
//    public String makeRestore() {
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
