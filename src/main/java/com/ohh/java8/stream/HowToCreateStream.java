package com.ohh.java8.stream;

import com.ohh.java8.entity.Obj;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Stream 的几种创建方式
 *
 * @author Gary
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class HowToCreateStream {

    /**
     * 通过 Collection 的 stream 方法创建
     *
     * @return Stream
     */
    private static Stream<String> createStreamFromCollection() {
        List<String> strings = Arrays.asList("hello", "world", "Java", "Gary");
        return strings.stream();
    }

    /**
     * 测试 createStreamFromCollection 方法
     */
    @Test
    public void testCreateStreamFromCollection() {
        createStreamFromCollection().forEach(System.out::println);
    }

    /**
     * 通过 Stream 的 of 方法创建
     *
     * @return Stream
     */
    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "world", "Java", "Gary");
    }

    /**
     * 测试 createStreamFromValues 方法
     */
    @Test
    public void testCreateStreamFromValues() {
        createStreamFromValues().forEach(System.out::println);
    }

    /**
     * 通过 Arrays 的 stream 方法创建
     *
     * @return Stream
     */
    private static Stream<String> createStreamFromArrays() {
        return Arrays.stream(new String[]{"hello", "world", "Java", "Gary"});
    }

    /**
     * 测试 createStreamFromArrays 方法
     */
    @Test
    public void testCreateStreamFromArrays() {
        createStreamFromArrays().forEach(System.out::println);
    }

    /**
     * 通过 Files 的 lines 方法创建
     */
    private static void createStreamFromFile() {
        Path path = Paths.get("words.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 测试 createStreamFromFile 方法
     */
    @Test
    public void testCreateStreamFromFile() {
        createStreamFromFile();
    }

    /**
     * 通过 Stream 的 iterate 方法创建
     *
     * @return Stream
     */
    private static Stream<Integer> createStreamFromIterator() {
        return Stream.iterate(0, n -> n + 2).limit(10);
    }

    /**
     * 测试 createStreamFromIterator 方法
     */
    @Test
    public void testCreateStreamFromIterator() {
        createStreamFromIterator().forEach(System.out::println);
    }

    /**
     * 通过 Stream 的 generate 方法创建
     *
     * @return Stream
     */
    private static Stream<Double> createStreamFromGenerate() {
        return Stream.generate(Math::random).limit(10);
    }

    /**
     * 测试 createStreamFromGenerate 方法
     */
    @Test
    public void testCreateStreamFromGenerate() {
        createStreamFromGenerate().forEach(System.out::println);
    }

    /**
     * 通过 Stream 的 generate 方法，使用自定义的 Supplier 创建
     *
     * @return Stream
     */
    private Stream<Obj> createObjStreamFromGenerate(){
        return Stream.generate(new ObjSupplier()).limit(10);
    }

    /**
     * 测试 createObjStreamFromGenerate 方法
     */
    @Test
    public void testCreateObjStreamFromGenerate(){
        createObjStreamFromGenerate().forEach(System.out::println);
    }

    /**
     * 自定义的 Supplier
     */
    static class ObjSupplier implements Supplier<Obj> {
        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            int index = random.nextInt(100);
            return new Obj(index, String.format("Name#%d", index));
        }
    }
}
