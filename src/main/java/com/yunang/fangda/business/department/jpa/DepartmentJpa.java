package com.yunang.fangda.business.department.jpa;

import com.yunang.fangda.business.department.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ld
 * @name 部门
 * @table
 * @remarks
 */
public interface DepartmentJpa extends JpaSpecificationExecutor<DepartmentModel>,
        JpaRepository<DepartmentModel, String> {

}
