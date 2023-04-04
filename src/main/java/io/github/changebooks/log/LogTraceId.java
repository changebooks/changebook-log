package io.github.changebooks.log;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * 追溯id
 *
 * @author changebooks@qq.com
 */
public final class LogTraceId {
    /**
     * 函数接口
     */
    public interface Gen {
        /**
         * 生成新id
         *
         * @return id
         */
        default String nextId() {
            return UUID.randomUUID().toString();
        }

    }

    /**
     * 键名
     */
    public static final String KEY_NAME = "tid";

    /**
     * 生成新id的函数接口
     */
    private static Gen gen = new Gen() {
    };

    private LogTraceId() {
    }

    /**
     * 获取追溯id
     *
     * @return 追溯id
     */
    public static String get() {
        return MDC.get(KEY_NAME);
    }

    /**
     * 设置追溯id
     *
     * @param id 新的追溯id
     */
    public static void set(String id) {
        MDC.put(KEY_NAME, id);
    }

    /**
     * 未设置过？
     *
     * @return empty ? true : false
     */
    public static boolean isEmpty() {
        String id = get();
        return id == null || id.isEmpty();
    }

    /**
     * 初始化追溯id
     */
    public static void init() {
        if (isEmpty()) {
            set(gen.nextId());
        }
    }

    /**
     * 设置函数接口
     *
     * @param gen 函数接口
     */
    public static void setGen(Gen gen) {
        if (gen != null) {
            LogTraceId.gen = gen;
        }
    }

}
