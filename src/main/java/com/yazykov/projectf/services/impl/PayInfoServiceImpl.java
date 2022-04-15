package com.yazykov.projectf.services.impl;

import com.yazykov.projectf.dto.PayInfoDto;
import com.yazykov.projectf.models.storage.PayInfo;
import com.yazykov.projectf.repositories.PayInfoRepository;
import com.yazykov.projectf.services.PayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayInfoServiceImpl implements PayInfoService {
    @Autowired
    private PayInfoRepository payInfoRepository;

    @Override
    public PayInfo save(PayInfoDto payInfoDto) {
        PayInfo payInfo = convertDtoToPayInfo(payInfoDto);
        return payInfoRepository.save(payInfo);
    }

    private PayInfo convertDtoToPayInfo(PayInfoDto payInfoDto) {
        PayInfo payInfo = new PayInfo();

        payInfo.setBankName(payInfoDto.getBankName());
        payInfo.setAccountNumber(payInfoDto.getAccountNumber());
        payInfo.setBikNumber(payInfoDto.getBikNumber());

        return payInfo;
    }

    @Override
    public void delete(Long id) {
        payInfoRepository.delete(payInfoRepository.getById(id));
    }
}
