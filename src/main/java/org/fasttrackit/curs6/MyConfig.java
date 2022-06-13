package org.fasttrackit.curs6;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("data")
public record MyConfig(
        String storage,
        int maxSize
) {
}

