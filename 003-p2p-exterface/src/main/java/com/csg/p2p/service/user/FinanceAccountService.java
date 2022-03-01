package com.csg.p2p.service.user;

import com.csg.p2p.model.user.FinanceAccount;

/**
 * ClassName:FinanceAccountService
 * Package:com.csg.p2p.service.user
 * Description:
 *
 * @date: 2022/1/22 14:41
 * @author: csg
 */

public interface FinanceAccountService {
    FinanceAccount queryFinanceAccountByUid(Integer uid);
}
