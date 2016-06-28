package io.khasang.stockmanager.service.commandline;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CommandLineLauncherTest {
    private CommandLineLauncher commandLineLauncher;
    private String pathToPgdumpTest;
    private String pathToPqslTest;
    private String pathForBackupFileTest;

    @Before
    public void setUp() throws Exception {
        commandLineLauncher = new CommandLineLauncher("","") {
            {
                pathToPgdumpTest = pathToPgdump;
                pathToPqslTest = pathToPqsl;
                pathForBackupFileTest = pathForBackupFile;
            }
        };
    }

    @Test
    public void pgDumpExistTest() throws Exception {
        assertTrue(Files.exists(Paths.get(pathToPgdumpTest)));
    }

    @Test
    public void pqslExistTest() throws Exception {
        assertTrue(Files.exists(Paths.get(pathToPqslTest)));
    }

    @Test
    public void backupFolderExistTest() throws Exception {
        assertTrue(Files.exists(Paths.get(pathForBackupFileTest).getParent()));
    }

    @Test
    public void backupFileExistTest() throws Exception {
        assertTrue(Files.exists(Paths.get(pathForBackupFileTest)));
    }


}