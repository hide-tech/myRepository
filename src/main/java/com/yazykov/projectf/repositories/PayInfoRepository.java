package com.yazykov.projectf.repositories;

import com.yazykov.projectf.models.storage.PayInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayInfoRepository extends JpaRepository<PayInfo, Long> {
}
