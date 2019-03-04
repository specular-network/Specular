package com.specular.service.impl;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.specular.service.DigestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jzx
 * @date 2019/03/04 09:55
 * @Description:
 */
@Service
@Slf4j
public class DigestServiceImpl implements DigestService {
    
    /**
     * TODO 更新加密算法
     * @param str
     * @return
     */
    @Override
    public String encrypt(String str) {
        HashFunction hf = Hashing.md5();
        String md5String= hf.hashString(str, Charsets.UTF_8).toString();
        return md5String;
    }
}
