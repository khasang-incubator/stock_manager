package io.khasang.stockmanager.service.commandline;

public class RestoreDBImpl extends CommandLineLauncher {
    private String command = "\"" + pathToPqsl + "\"" + " -d " + nameOfDB + " -U " + userName + " -f " + "\"" + pathForBackupFile + "\"";

    public RestoreDBImpl(String userName, String password) {
        super(userName, password);
    }

    /**
     * Not for real use. Just for quick testing.
     * Restores postgreSQL database from file.
     * <p>
     * Uses command line to execute utility psql.
     * <p>
     * It gets command from local variable "command" above and use currentEnvironmentForPassword variables
     * to set password from local variable "password" above.
     * <p>
     * It's not safety method. If you want restore safety, password should be passed
     * into %APPDATA%\postgresql\pgpass.conf (windows) in following format:
     * hostname:port:database:username:password
     * then delete this method, variables "password" and "currentEnvironmentForPassword" and use method below.
     *
     * @return "success" or Exception
     */
    public String makeRestore() {
        return runCommand(command, currentEnvironmentForPassword);
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
//    public String makeRestore() {
//        return runCommand(command, currentEnvironmentForPassword);
//    }

}
