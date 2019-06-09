package com.blujay.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blujay.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
