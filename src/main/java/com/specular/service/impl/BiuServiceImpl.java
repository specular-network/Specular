package com.specular.service.impl;

import com.specular.dto.UserDto;
import com.specular.entity.Biu;
import com.specular.enums.BusinessExceptionEnum;
import com.specular.exception.BusinessException;
import com.specular.form.biu.DelBiuForm;
import com.specular.form.biu.MakeBiuForm;
import com.specular.repository.BiuRepository;
import com.specular.service.AuthService;
import com.specular.service.BiuService;
import com.specular.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * @author jzx
 * @date 2019/03/07 15:57
 * @Description:
 */
@Service
@Slf4j
public class BiuServiceImpl implements BiuService {
    
    @Autowired
    BiuRepository biuRepository;
    
    @Autowired
    AuthService authService;
    
    @Override
    public void make(MakeBiuForm makeBiuForm) {
        Biu biu = new Biu();
        BeanUtils.copyProperties(makeBiuForm, biu);
        UserDto userDto = authService.getUserInfoByToken(makeBiuForm.getToken());
        biu.setCreatedUserId(userDto.getId());
        biu.setUpdatedUserId(userDto.getId());
        biu.setCreatedAt(DateUtils.getTimeSpan());
        biu.setUpdatedAt(DateUtils.getTimeSpan());
        biu.setDeletedAt(0);
        biuRepository.save(biu);
    }
    
    @Override
    public void del(DelBiuForm delBiuForm) {
        Biu biu=biuRepository.findById(delBiuForm.getId()).orElseThrow(() ->new BusinessException(BusinessExceptionEnum.BIU_NOT_FOUND_ERROR));
        UserDto userDto = authService.getUserInfoByToken(delBiuForm.getToken());
        biu.setUpdatedUserId(userDto.getId());
        biu.setDeletedAt(DateUtils.getTimeSpan());
        biuRepository.deleteById(delBiuForm.getId());
    }
}
