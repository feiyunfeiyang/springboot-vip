package com.yunfei.shiro;

import com.yunfei.entity.TSysUser;
import com.yunfei.entity.TSysUserRoles;
import com.yunfei.service.TSysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CustomRealm extends AuthorizingRealm{

    @Resource
    private TSysUserService userService;
    @Resource
    private HashedCredentialsMatcher credentialsMatcher;

    @PostConstruct
    public void CustomRealm() {
        setCredentialsMatcher(credentialsMatcher);
    }

    // 授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String)principals.getPrimaryPrincipal();
        TSysUser user = userService.findByLogin(username);
        List<TSysUserRoles> userRolesList = user.getUserRolesList();
        Set<String> roles = new HashSet<>();
        userRolesList.forEach((vo) ->{
            roles.add(vo.getRole().getCode());
        });
        // Set<String> roles = getRolesByUsername(username);
        Set<String> permissions = getPermissionsByUsername(username);
        /*for (String role:roles){

        }*/
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions);
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    private Set<String> getPermissionsByUsername(String username) {
        Set<String> sets = new HashSet<String>();
        sets.add("user:delete");
        sets.add("user:add");
        return sets;
    }

    private Set<String> getRolesByUsername(String username){
        //List<String> list = userService.findRoleByLogin(username);
        //List<String> list = userDao.queryRolesByUsername(username);
        //Set<String> sets = new HashSet<>(list);
        return null;
    }
    // 认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        String password =  getPasswordByUsername(username);
        if(null == password){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,"customRealm");
        authenticationInfo.setCredentialsSalt(null);
        return authenticationInfo;
    }

    private  String getPasswordByUsername(String username){
        return userService.findPassWordByLogin(username);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456");
        System.out.println(md5Hash.toString());
    }
}
