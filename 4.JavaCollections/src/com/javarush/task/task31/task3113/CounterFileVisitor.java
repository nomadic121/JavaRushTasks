package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CounterFileVisitor extends SimpleFileVisitor {

    private int foldersCount = -1;
    private int filesCount = 0;
    private long filesSize = 0;

    @Override
    public FileVisitResult preVisitDirectory(final Object dir, final BasicFileAttributes attrs) throws IOException {
        foldersCount++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(final Object file, final BasicFileAttributes attrs) throws IOException {
        filesCount++;
        filesSize += Files.size((Path) file);
        return super.visitFile(file, attrs);
    }

    public int getFoldersCount() {
        return foldersCount;
    }

    public int getFilesCount() {
        return filesCount;
    }

    public long getFilesSize() {
        return filesSize;
    }
}
