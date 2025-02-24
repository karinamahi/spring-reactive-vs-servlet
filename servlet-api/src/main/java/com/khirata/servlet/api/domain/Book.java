package com.khirata.servlet.api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public record Book (
        @Id Long id, String title, String subtitle, String publisher) {
}
