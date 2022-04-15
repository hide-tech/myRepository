package com.yazykov.projectf.services;

import com.yazykov.projectf.dto.PayInfoDto;
import com.yazykov.projectf.models.storage.PayInfo;

public interface PayInfoService {

    PayInfo save(PayInfoDto payInfoDto);

    void delete(Long id);
}
