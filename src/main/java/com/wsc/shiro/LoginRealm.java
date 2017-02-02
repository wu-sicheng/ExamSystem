package com.wsc.shiro;

import com.wsc.service.inter.IPersonService;
import org.apache.shiro.realm.AuthorizingRealm;

import javax.annotation.Resource;

/**
 * Created by wsc on 17-2-2.
 */
public class LoginRealm extends AuthorizingRealm {

    @Resource
    private IPersonService iPersonService;











}
