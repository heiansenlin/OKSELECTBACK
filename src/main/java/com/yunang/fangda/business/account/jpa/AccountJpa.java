package com.yunang.fangda.business.account.jpa;

import com.yunang.fangda.business.account.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ld
 * @name 账户
 * @table
 * @remarks
 */
public interface AccountJpa extends JpaSpecificationExecutor<AccountModel>,
        JpaRepository<AccountModel, String> {

    /**
     * @param account
     * @return
     */
    List<AccountModel> findByAccount(String account);

//    @Query(value = "select a.* from account_table a left join user_table u on a.user = u.uuid where u.phone = #{phone}",nativeQuery = true)
    List<AccountModel> findByUserModelPhone(@Param(value = "phone") String phone);

    List<AccountModel> findByAccountLike(String account);
}
