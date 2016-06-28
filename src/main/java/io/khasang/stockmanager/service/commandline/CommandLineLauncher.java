package io.khasang.stockmanager.service.commandline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@PropertySource(value = {"classpath:hibernate.properties"})
public abstract class CommandLineLauncher {
    protected String pathToPgdump = "C:\\Program Files\\PostgreSQL\\9.4\\bin\\pg_dump.exe";
    protected String pathToPqsl = "C:\\Program Files\\PostgreSQL\\9.4\\bin\\psql.exe";
    protected String pathForBackupFile = "C:\\backup\\backup_stockmanager.sql";
    protected String nameOfDB = "stockmanager";
    protected String hostName = "localhost";
    protected String userName;
    protected String password;

    protected String[] currentEnvironmentForPassword;

    @Autowired
    protected Environment environment;

    public CommandLineLauncher(String userName, String password) {
        this.userName = userName;
        this.password = password;
        currentEnvironmentForPassword = new String[] {"PGPASSWORD=" + password};
    }

    //TODO change javadoc
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
    public final synchronized String runCommand(String command, String[] currentEnvironmentForPassword) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec(command, currentEnvironmentForPassword);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getErrorStream()))) {
                String errorMessage = bufferedReader.readLine();
                if (errorMessage != null) {
                    return errorMessage;
                } else {
                    return "success";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error:" + e;
        }
    }

}
