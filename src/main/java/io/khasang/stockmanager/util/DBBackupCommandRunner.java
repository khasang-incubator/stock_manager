package io.khasang.stockmanager.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBBackupCommandRunner {

    public String backup() {
        StringBuilder sb = new StringBuilder();
        try {
            Resource resource = new ClassPathResource("pg_dump.sh");
            Process chmod = Runtime.getRuntime().exec("chmod 755 " + resource.getURL().getPath());
            Process p = Runtime.getRuntime().exec(resource.getURL().getPath());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                sb.append(s);
            }
            while ((s = stdError.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            sb.append("ERROR: ");
            sb.append(e.getMessage());
        }
        return sb.toString();
    }

}
