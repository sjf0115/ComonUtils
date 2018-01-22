import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * 文件工具类
 * @author sjf0115
 * @Date Created in 下午6:02 18-1-22
 */
public class FileUtil {

    /**
     * 写文件
     *
     * @param fileName
     * @param contents
     */
    public static void WriteToFile(String fileName, String contents) throws IOException {

        File newFile = new File(fileName);
        Files.write(contents, newFile, Charsets.UTF_8);

    }

    /**
     * 追加文件
     *
     * @param fileName
     * @param contents
     */
    public static void appendToFile(String fileName, String contents) throws IOException {

        File newFile = new File(fileName);
        Files.append(contents, newFile, Charsets.UTF_8);

    }

    /**
     * 读取文件
     *
     * @param path
     * @return
     */
    public static List<String> readLineFromText(String path) throws IOException {

        List<String> lines = Lists.newArrayList();
        if (StringUtils.isBlank(path)) {
            return lines;
        }
        File testFile = new File(path);
        lines = Files.readLines(testFile, Charsets.UTF_8);
        return lines;

    }

    /**
     * 从Resource下读取文件
     *
     * @param fileName
     * @return
     */
    public static List<String> readFromResource(String fileName) throws IOException {

        List<String> lines = Lists.newArrayList();
        if (StringUtils.isBlank(fileName)) {
            return lines;
        }
        String path = FileUtil.class.getResource("/" + fileName).getPath().toString();
        lines = readLineFromText(path);
        return lines;
    }

    /**
     * 读取GZ文件
     * @param fileName
     * @return
     * @throws Exception
     */
    public static List<String> readFromGZ(String fileName) throws Exception {

        InputStream in = new GZIPInputStream(new FileInputStream(fileName));
        Scanner sc = new Scanner(in);
        List<String> lines = Lists.newArrayList();
        while(sc.hasNextLine()){
            lines.add(sc.nextLine());
        }
        return lines;

    }
}
