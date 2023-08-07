package platform.projectPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class toLinux {
    public static void main(String[] args) {
        try {


            // 构建 git diff 命令
            ProcessBuilder processBuilder = new ProcessBuilder("git", "diff", "--name-only", "HEAD^", "HEAD");
            processBuilder.redirectErrorStream(true);

            // 启动外部进程
            Process process = processBuilder.start();

            // 获取进程的输入流并读取输出
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                // 这里可以处理每行的输出
                System.out.println(line);
            }

            // 等待进程执行完毕
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
