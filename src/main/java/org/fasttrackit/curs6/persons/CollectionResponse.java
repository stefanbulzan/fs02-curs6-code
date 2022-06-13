package org.fasttrackit.curs6.persons;

import lombok.Builder;

import java.util.List;

@Builder
public record CollectionResponse<T>(List<T> content, PageInfo pageInfo) {
}

@Builder
record PageInfo(int currentPage, int pageSize, int totalElements, int totalPages) {
}
