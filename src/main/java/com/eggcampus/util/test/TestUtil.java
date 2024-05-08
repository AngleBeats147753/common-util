package com.eggcampus.util.test;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.sql.SqlExecutor;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.assertj.core.api.Assertions;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 黄磊
 */
public class TestUtil {

    private static final Path TABLE_SQL_PATH = Paths.get("db/table.sql");

    /**
     * 读取文件内容并返回字符串
     *
     * @param path 文件路径
     * @return 文件内容字符串
     * @throws IOException 读取文件异常
     */
    public static String readFile(Path path) throws IOException {
        return IoUtil.read(new ClassPathResource(path.toString()).getStream(), StandardCharsets.UTF_8);
    }

    /**
     * 执行 SQL 语句并返回影响行数
     *
     * @param dataSource 数据源
     * @param sqls       SQL 语句
     * @return 影响行数
     * @throws SQLException SQL 执行异常
     */
    public static Integer executeSql(DataSource dataSource, String sqls) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Integer count = 0;
            for (String sql : sqls.split(";")) {
                if (StrUtil.isBlank(sql)) {
                    continue;
                }
                SqlExecutor.execute(connection, sql);
                count++;
            }
            return count;
        }
    }

    /**
     * 初始化数据库表
     *
     * @param dataSource 数据源
     * @throws SQLException SQL 执行异常
     * @throws IOException  读取文件异常
     */
    public static synchronized void initTable(DataSource dataSource) throws SQLException, IOException {
        String tables = readFile(TABLE_SQL_PATH);
        executeSql(dataSource, tables);
    }

    /**
     * 初始化测试数据
     *
     * @param caseDir    测试用例目录
     * @param dataSource 数据源
     * @return 影响行数
     * @throws SQLException SQL 执行异常
     * @throws IOException  读取文件异常
     */
    public static Integer initData(Path caseDir, DataSource dataSource) throws SQLException, IOException {
        String content = readFile(caseDir.resolve("data.sql"));
        return executeSql(dataSource, content);
    }

    /**
     * 从指定路径读取 JSON 对象并返回
     *
     * @param path JSON 文件路径
     * @return JSON 对象
     * @throws IOException 读取文件异常
     */
    public static JSONObject readJsonObject(Path path) throws IOException {
        String content = readFile(path);
        if (StrUtil.isBlank(content)) {
            return null;
        }
        return JSONUtil.parseObj(content);
    }

    /**
     * 从指定路径读取 JSON 数组并返回
     *
     * @param path JSON 文件路径
     * @return JSON 数组
     * @throws IOException 读取文件异常
     */
    public static JSONArray readJsonArray(Path path) throws IOException {
        String content = readFile(path);
        if (StrUtil.isBlank(content)) {
            return null;
        }
        return JSONUtil.parseArray(content);
    }


    /**
     * 从指定路径读取 JSON 对象并转换为指定类型的对象返回
     *
     * @param caseDir   测试用例目录
     * @param beanClass 对象类型
     * @return JSON 对象
     * @throws IOException 读取文件异常
     */
    public static <T> T getGt(Path caseDir, Class<T> beanClass) throws IOException {
        String content = TestUtil.readFile(caseDir.resolve("gt.json"));
        T gt = null;
        if (StrUtil.isNotBlank(content)) {
            gt = JSONUtil.toBean(content, beanClass);
        }
        return gt;
    }

    /**
     * 从指定路径读取 JSON 数组并转换为指定类型的对象列表返回
     *
     * @param caseDir   测试用例目录
     * @param beanClass 对象类型
     * @return JSON 对象列表
     * @throws IOException 读取文件异常
     */
    public static <T> List<T> getGts(Path caseDir, Class<T> beanClass) throws IOException {
        String content = TestUtil.readFile(caseDir.resolve("gt.json"));
        List<T> gt = null;
        if (StrUtil.isNotBlank(content)) {
            gt = JSONUtil.parseArray(content)
                    .stream()
                    .map(o -> JSONUtil.toBean(o.toString(), beanClass))
                    .toList();
        }
        return gt;
    }

    /**
     * 从指定路径读取 JSON 数组并返回
     *
     * @param caseDir 测试用例目录
     * @return JSON 数组
     * @throws IOException 读取文件异常
     */
    public static JSONArray getInputParams(Path caseDir) throws IOException {
        return readJsonArray(caseDir.resolve("input.json"));
    }

    public static JSONObject getInputParam(Path caseDir) throws IOException {
        return readJsonObject(caseDir.resolve("input.json"));
    }

    /**
     * 根据异常类名字符串获取异常类
     *
     * @param exceptionString 异常类名字符串
     * @return 异常类
     * @throws Exception 异常
     */
    public static Class<?> getException(String exceptionString) throws Exception {
        Class<?> exception = null;
        if (!"null".equals(exceptionString)) {
            exception = Class.forName(exceptionString);
        }
        return exception;
    }

    /**
     * 断言两个对象是否相等，忽略指定字段
     *
     * @param prediction 预测对象
     * @param gt         实际对象
     */
    public static void assertObjectEqual(Object prediction, Object gt) {
        Assertions.assertThat(prediction).usingRecursiveComparison()
                .ignoringFields("createTime", "updateTime", "deleted", "version")
                .isEqualTo(gt);
    }

    /**
     * 断言两个分页对象是否相等，忽略指定字段和集合顺序
     *
     * @param prediction 预测对象
     * @param gt         实际对象
     */
    public static void assertPageDTOEqual(Object prediction, Object gt) {
        Assertions.assertThat(prediction).usingRecursiveComparison()
                .ignoringFields("records.createTime", "records.updateTime", "records.deleted", "records.version")
                .ignoringCollectionOrder()
                .isEqualTo(gt);
    }

    /**
     * 执行指定的函数，并根据预期异常类进行断言
     *
     * @param paramObject      参数对象
     * @param exceptionObject  预期异常类对象
     * @param executorFunction 执行函数
     * @return 执行结果
     */
    public static Object execute(Object paramObject, Object exceptionObject, ExecutorFunction executorFunction) {
        Object[] param = (Object[]) paramObject;
        Class<?> exception = (Class<?>) exceptionObject;

        Object result = null;
        Exception actualException = null;
        try {
            result = executorFunction.execute(param);
        } catch (Exception e) {
            actualException = e;
        }

        if (exception == null) {
            Assertions.assertThat(actualException).isNull();
        } else {
            Assertions.assertThat(actualException).isInstanceOf(exception);
        }
        return result;
    }

    /**
     * 执行指定的函数，并根据预期异常类进行断言
     *
     * @param paramObject      参数对象
     * @param exceptionObject  预期异常类对象
     * @param executorFunction 执行函数
     */
    public static void execute(Object paramObject, Object exceptionObject, ExecutorConsumer executorFunction) {
        Object[] param = (Object[]) paramObject;
        Class<?> exception = (Class<?>) exceptionObject;

        Exception actualException = null;
        try {
            executorFunction.execute(param);
        } catch (Exception e) {
            actualException = e;
        }

        if (exception == null) {
            Assertions.assertThat(actualException).isNull();
        } else {
            Assertions.assertThat(actualException).isInstanceOf(exception);
        }
    }

    @FunctionalInterface
    public interface ExecutorFunction {
        Object execute(Object[] param);
    }

    @FunctionalInterface
    public interface ExecutorConsumer {
        void execute(Object[] param);
    }
}
