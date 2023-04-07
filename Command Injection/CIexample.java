import java.util.*;
import java.io.File;
import java.io.*;

public class CommandInjection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username");
        String user = sc.nextLine();

        String userPath = ".\\Data\\" + user;

        File file = new File(userPath);

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir", userPath);
            Process process = pb.start();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Error executing command");
        }
    }
}
`
      }
    }
  ]
}
