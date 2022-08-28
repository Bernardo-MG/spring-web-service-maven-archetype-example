/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2022 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.spring_web_service_maven_archetype_example.test.domain.integration.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bernardomg.example.spring_web_service_maven_archetype_example.domain.model.ExampleEntity;
import com.bernardomg.example.spring_web_service_maven_archetype_example.domain.service.DefaultExampleEntityService;
import com.bernardomg.example.spring_web_service_maven_archetype_example.pagination.model.DisabledPagination;
import com.bernardomg.example.spring_web_service_maven_archetype_example.pagination.model.DisabledSort;
import com.bernardomg.example.spring_web_service_maven_archetype_example.pagination.model.PageIterable;
import com.bernardomg.example.spring_web_service_maven_archetype_example.pagination.model.Pagination;
import com.bernardomg.example.spring_web_service_maven_archetype_example.pagination.model.Sort;
import com.bernardomg.example.spring_web_service_maven_archetype_example.test.config.annotation.IntegrationTest;
import com.google.common.collect.Iterables;

@IntegrationTest
@DisplayName("Default entity service")
public class ITDefaultExampleEntityService {

    @Autowired
    private DefaultExampleEntityService service;

    public ITDefaultExampleEntityService() {
        super();
    }

    @Test
    @DisplayName("Returns all the entities")
    public void testGetAllEntities() {
        final Pagination                            pagination;
        final Sort                                  sort;
        final PageIterable<? extends ExampleEntity> result;

        pagination = new DisabledPagination();
        sort = new DisabledSort();

        result = service.getAll(pagination, sort);

        Assertions.assertEquals(30, Iterables.size(result));
    }

}
