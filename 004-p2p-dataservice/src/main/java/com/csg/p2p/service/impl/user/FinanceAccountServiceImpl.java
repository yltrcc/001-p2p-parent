package com.csg.p2p.service.impl.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.csg.p2p.mapper.user.FinanceAccountMapper;
import com.csg.p2p.model.user.FinanceAccount;
import com.csg.p2p.service.user.FinanceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * ClassName:FinanceAccountServiceImpl
 * Package:com.csg.p2p.service.impl.user
 * Description:
 *
 * @date: 2022/1/22 14:42
 * @author: csg
 */
@Component
@Service(interfaceClass = FinanceAccountService.class, version = "1.0.0", timeout = 15000)
public class FinanceAccountServiceImpl implements FinanceAccountService {

    @Autowired
    private FinanceAccountMapper financeAccountMapper;

    @Override
    public FinanceAccount queryFinanceAccountByUid(Integer uid) {
        return financeAccountMapper.selectFinanceAccountByUid(uid);
    }
}
