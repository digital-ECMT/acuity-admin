package com.acuity.visualisations.data.provider.local;

import com.acuity.visualisations.data.Data;
import com.acuity.visualisations.data.EmptyStubData;
import com.acuity.visualisations.data.LocalFileData;
import com.acuity.visualisations.data.provider.DataProvider;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@Profile("local-storage")
@Order(3)
@Slf4j
public class LocalFileSystemDataProvider implements DataProvider {

    @Value("${local-storage.path}")
    private String path;
    @Value("${local-storage.prefix}")
    private String prefix;

    @Override
    public boolean match(@NonNull String location) {
        return location.startsWith(prefix);
    }

    @Override
    public Data get(@NonNull String location) {
        return composeLocalPathFromExternalLocation(location)
                .map(Path::toFile)
                .<Data>map(LocalFileData::new)
                .orElseGet(EmptyStubData::getInstance);
    }

    protected final Optional<Path> composeLocalPathFromExternalLocation(@NonNull String location) {
        String localPath = location.split(prefix)[1];
        Path normalizedFullPath = Paths.get(path, localPath).normalize();
        if (normalizedFullPath.toString().startsWith(path)) {
            return Optional.of(normalizedFullPath);
        } else {
            log.warn("User has tried to access [{}] file which is out of local-storage scope = [{}]. Permission denied.",
                    normalizedFullPath, path);
            return Optional.empty();
        }
    }

}
