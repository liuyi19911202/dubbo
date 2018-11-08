package cn.ly.system.provider.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ly.common.service.dao.CrudDao;
import cn.ly.system.api.entity.SysRole;

/**
 * 角色DAO接口
 *
 * @author liuyi
 */
@Mapper
public interface SysRoleMapper extends CrudDao<SysRole> {

    /**
     * 查询用户角色列表
     *
     * @param userId the user id
     * @return the list
     */
    List<SysRole> findListByUserId(String userId);

    /**
     * 删除角色菜单
     *
     * @param role the role
     * @return the int
     */
    int deleteRoleMenu(SysRole role);

    /**
     * 插入角色菜单
     *
     * @param role the role
     * @return the int
     */
    int insertRoleMenu(SysRole role);
}
