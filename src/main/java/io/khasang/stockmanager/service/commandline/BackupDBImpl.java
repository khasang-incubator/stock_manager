package io.khasang.stockmanager.service.commandline;

public class BackupDBImpl extends CommandLineLauncher{
    private String command = "\"" + pathToPgdump + "\"" + " -d " + nameOfDB + " -h " + hostName + " -U " + userName + " -w " +
            " -f " + "\"" + pathForBackupFile + "\"";

    public BackupDBImpl(String userName, String password) {
        super(userName, password);
    }

    /**
     * Not for real use. Just for quick testing.
     * Makes backup of postgreSQL database.
     * <p>
     * Uses command line to execute utility pg_dump.
     * <p>
     * It gets command from local variable "command" above and use currentEnvironmentForPassword variables
     * to set password from local variable "password" above.
     * <p>
     * It's not safety method. If you want make backup safety, password should be passed
     * into %APPDATA%\postgresql\pgpass.conf (windows) in following format:
     * hostname:port:database:username:password
     * then delete this method, variables "password" and "currentEnvironmentForPassword" and use method below.
     *
     * @return "success" or Exception
     */
    public String makeBackup() {
        return runCommand(command, currentEnvironmentForPassword);
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
//        return runCommand(command);
//    }
}
