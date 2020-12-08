package com.autotboxdatasystem.demo.service.impl;

import com.autotboxdatasystem.demo.dao.*;
import com.autotboxdatasystem.demo.entity.*;
import com.autotboxdatasystem.demo.service.UserService;
import com.autotboxdatasystem.demo.util.DateUtil;
import com.autotboxdatasystem.demo.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final MenuDAO menuDAO;
    private final UserRoleDAO userRoleDAO;
    private final RoleMenuDAO roleMenuDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, MenuDAO menuDAO,
                           UserRoleDAO userRoleDAO, RoleMenuDAO roleMenuDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.menuDAO = menuDAO;
        this.userRoleDAO = userRoleDAO;
        this.roleMenuDAO = roleMenuDAO;
    }

    @Override
    public Integer addUser(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        String phone = userEntity.getPhone();
        String email = userEntity.getEmail();

        if (username == null || password == null) {
            return -1;
        }
        if (userDAO.findByUsername(username) != null) {
            return -10;
        }
        if (userDAO.findByEmail(email) != null) {
            return -11;
        }
        if (userDAO.findByPhone(phone) != null) {
            return -12;
        }
        if (!RegexUtil.isUsername(username)) {
            return -20;
        }
        if (!RegexUtil.isPassword(password)) {
            return -21;
        }
        if (email != null && !RegexUtil.isEmail(email)) {
            return -22;
        }
        if (phone != null && !RegexUtil.isPhone(phone)) {
            return -23;
        }

        userEntity.setIsActivated("1");
        userEntity.setIsDeleted("0");

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        userEntity.setPassword(password);

        userEntity.setCreatedBy(username);
        userEntity.setCreatedDate(DateUtil.getCurDateTime());
        userEntity.setLastUpdatedBy(username);
        userEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        userDAO.save(userEntity);
        return 0;
    }

    @Override
    public void activateUserById(UserEntity userEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByUserId(userEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("1");
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("1");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    @Override
    public void deactivateUserById(UserEntity userEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByUserId(userEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("0");
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("0");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    @Override
    public void softDeleteUserById(UserEntity userEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByUserId(userEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("0");
                userRole.setIsDeleted("1");
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("0");
        user.setIsDeleted("1");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    @Override
    public void restoreUserById(UserEntity userEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByUserId(userEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("1");
                userRole.setIsDeleted("0");
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsDeleted("0");
        user.setIsActivated("1");
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    @Override
    public void hardDeleteUserById(UserEntity userEntity) {
        userRoleDAO.deleteAllByUserId(userEntity.getId());
        userDAO.deleteById(userEntity.getId());
    }

    @Override
    public boolean updateUsernameById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String username = userEntity.getUsername();
        if (username != null && RegexUtil.isUsername(username) &&
                userDAO.findByUsername(username) == null) {
            /* Need to update all username !! */
            // Role Table
            List<RoleEntity> roleList = roleDAO.findByCreatedBy(username);
            if (roleList != null) {
                for (RoleEntity role : roleList) {
                    role.setCreatedBy(username);
                    roleDAO.save(role);
                }
            }
            roleList = roleDAO.findByLastUpdatedBy(username);
            if (roleList != null) {
                for (RoleEntity role : roleList) {
                    role.setLastUpdatedBy(username);
                    roleDAO.save(role);
                }
            }
            // Menu Table
            List<MenuEntity> menuList = menuDAO.findByCreatedBy(username);
            if (menuList != null) {
                for (MenuEntity menu : menuList) {
                    menu.setCreatedBy(username);
                    menuDAO.save(menu);
                }
            }
            menuList = menuDAO.findByLastUpdatedBy(username);
            if (menuList != null) {
                for (MenuEntity menu : menuList) {
                    menu.setLastUpdatedBy(username);
                    menuDAO.save(menu);
                }
            }
            // UserRole Table
            List<UserRoleEntity> userRoleList = userRoleDAO.findByUsername(username);
            if (userRoleList != null) {
                for (UserRoleEntity userRole : userRoleList) {
                    userRole.setUsername(username);
                    userRoleDAO.save(userRole);
                }
            }
            userRoleList = userRoleDAO.findByCreatedBy(username);
            if (userRoleList != null) {
                for (UserRoleEntity userRole : userRoleList) {
                    userRole.setCreatedBy(username);
                    userRoleDAO.save(userRole);
                }
            }
            userRoleList = userRoleDAO.findByLastUpdatedBy(username);
            if (userRoleList != null) {
                for (UserRoleEntity userRole : userRoleList) {
                    userRole.setLastUpdatedBy(username);
                    userRoleDAO.save(userRole);
                }
            }
            // RoleMenu Table
            List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByCreatedBy(username);
            if (roleMenuList != null) {
                for (RoleMenuEntity roleMenu : roleMenuList) {
                    roleMenu.setCreatedBy(username);
                    roleMenuDAO.save(roleMenu);
                }
            }
            roleMenuList = roleMenuDAO.findByLastUpdatedBy(username);
            if (roleMenuList != null) {
                for (RoleMenuEntity roleMenu : roleMenuList) {
                    roleMenu.setLastUpdatedBy(username);
                    roleMenuDAO.save(roleMenu);
                }
            }
            // User Table
            if (user.getUsername().equals(user.getCreatedBy())) {
                user.setCreatedBy(username);
            }
            user.setUsername(username);
            user.setLastUpdatedBy(username);
            user.setLastUpdatedDate(DateUtil.getCurDateTime());
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmailById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String email = userEntity.getEmail();
        if (email != null && RegexUtil.isEmail(email) &&
                userDAO.findByEmail(email) == null) {
            user.setEmail(email);
            user.setLastUpdatedBy(user.getUsername());
            user.setLastUpdatedDate(DateUtil.getCurDateTime());
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePhoneById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String phone = userEntity.getPhone();
        if (phone != null && RegexUtil.isPhone(phone) &&
            userDAO.findByPhone(phone) == null) {
            user.setPhone(phone);
            user.setLastUpdatedBy(user.getUsername());
            user.setLastUpdatedDate(DateUtil.getCurDateTime());
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePasswordById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String password = userEntity.getPassword();
        if (password != null && RegexUtil.isPassword(password)) {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            user.setPassword(password);
            user.setLastUpdatedBy(user.getUsername());
            user.setLastUpdatedDate(DateUtil.getCurDateTime());
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAvatarById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String avatar = userEntity.getAvatar();
        if (avatar != null) {
            user.setAvatar(avatar);
            user.setLastUpdatedBy(user.getUsername());
            user.setLastUpdatedDate(DateUtil.getCurDateTime());
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Override
    public void resetPasswordById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        user.setPassword(password);
        user.setLastUpdatedBy(user.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    @Override
    public UserEntity searchUserById(UserEntity userEntity) {
        return userDAO.findById(userEntity.getId()).get();
    }

    @Override
    public UserEntity searchUserByUsername(UserEntity userEntity) {
        return userDAO.findByUsername(userEntity.getUsername());
    }

    @Override
    public Page<UserEntity> searchActivedUser(Integer pageIndex, Integer pageSize) {
        return userDAO.findByIsActivated("1", PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public Page<UserEntity> searchAllUser(Integer pageIndex, Integer pageSize) {
        return userDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}