package ralph.ci.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ralph.ci.springboot.bean.Account;
import ralph.ci.springboot.mapper.AccountMapper;

/**
 * @author ralph
 * @create 2021-06-06 18:56
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(Long id){
        return accountMapper.getAcct(id);
    }

}
