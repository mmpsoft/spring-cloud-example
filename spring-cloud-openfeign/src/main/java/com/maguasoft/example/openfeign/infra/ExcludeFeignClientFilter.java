package com.maguasoft.example.openfeign.infra;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Arrays;

public class ExcludeFeignClientFilter implements TypeFilter {

    private final String[] excludePackages;

    public ExcludeFeignClientFilter(String[] excludePackages) {
        this.excludePackages = excludePackages;
    }

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        if (excludePackages == null || excludePackages.length == 0) {
            return false;
        }

        return Arrays.stream(excludePackages).anyMatch(it -> metadataReader.getClassMetadata().getClassName().startsWith(it));
    }
}
