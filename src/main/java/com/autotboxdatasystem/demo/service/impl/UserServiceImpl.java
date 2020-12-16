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
    private final CarDAO carDAO;
    private final UserCarDAO userCarDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, MenuDAO menuDAO,
                           UserRoleDAO userRoleDAO, RoleMenuDAO roleMenuDAO, CarDAO carDAO, UserCarDAO userCarDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.menuDAO = menuDAO;
        this.userRoleDAO = userRoleDAO;
        this.roleMenuDAO = roleMenuDAO;
        this.carDAO = carDAO;
        this.userCarDAO = userCarDAO;
    }

    @Override
    public boolean login(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        UserEntity user = userDAO.findByUsernameAndPassword(username, password);
        return user != null;
    }

    @Override
    public String addUser(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        String phone = userEntity.getPhone();
        String email = userEntity.getEmail();

        if (username == null || password == null) {
            return "Username or Password is null.";
        } else {
            if (!RegexUtil.isUsername(username)) {
                return "Username illegal.";
            }
            if (!RegexUtil.isPassword(password)) {
                return "Password illegal.";
            }
            if (userDAO.findByUsername(username) != null) {
                return "Username was taken.";
            }
        }
        if (email != null) {
            if (!RegexUtil.isEmail(email)) {
                return "Email illegal.";
            }
            if (userDAO.findByEmail(email) != null) {
                return "Email was taken.";
            }
        }
        if (phone != null) {
            if (!RegexUtil.isPhone(phone)) {
                return "Phone illegal.";
            }
            if (userDAO.findByPhone(phone) != null) {
                return "Phone was taken.";
            }
        }

        userEntity.setIsActivated("1");
        userEntity.setIsDeleted("0");

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        userEntity.setPassword(password);
        userEntity.setAvatar("avatar_1.jpg");

        userEntity.setCreatedDate(DateUtil.getCurDateTime());
        userEntity.setLastUpdatedDate(DateUtil.getCurDateTime());

        userDAO.save(userEntity);
        return "";
    }

    @Override
    public void activateUserById(UserEntity userEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByUserId(userEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("1");
                userRole.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("1");
        user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    @Override
    public void deactivateUserById(UserEntity userEntity) {
        List<UserRoleEntity> userRoleList = userRoleDAO.findByUserId(userEntity.getId());
        if (userRoleList != null) {
            for (UserRoleEntity userRole : userRoleList) {
                userRole.setIsActivated("0");
                userRole.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("0");
        user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
                userRole.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsActivated("0");
        user.setIsDeleted("1");
        user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
                userRole.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                userRoleDAO.save(userRole);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsDeleted("0");
        user.setIsActivated("1");
        user.setLastUpdatedBy(userEntity.getUsername());
        user.setLastUpdatedDate(DateUtil.getCurDateTime());
        userDAO.save(user);
    }

    @Override
    public void hardDeleteUserById(UserEntity userEntity) {
        userRoleDAO.deleteAllByUserId(userEntity.getId());
        userDAO.deleteById(userEntity.getId());
    }

    @Override
    public boolean updateStatusById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String status = userEntity.getStatus();
        if (status != null) {
            user.setStatus(status);
            user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
            user.setLastUpdatedDate(DateUtil.getCurDateTime());
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRemarkById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String remark = userEntity.getRemark();
        if (remark != null) {
            user.setRemark(remark);
            user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
            user.setLastUpdatedDate(DateUtil.getCurDateTime());
            userDAO.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUsernameById(UserEntity userEntity) {
        UserEntity user = userDAO.findById(userEntity.getId()).get();
        String oldUsername = user.getUsername();
        String newUsername = userEntity.getUsername();
        if (newUsername != null && RegexUtil.isUsername(newUsername) &&
                userDAO.findByUsername(newUsername) == null) {
            /* Need to update all username !! */
            // Role Table
            List<RoleEntity> roleList = roleDAO.findByCreatedBy(oldUsername);
            if (roleList != null) {
                for (RoleEntity role : roleList) {
                    role.setCreatedBy(newUsername);
                    role.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    role.setLastUpdatedDate(DateUtil.getCurDateTime());
                    roleDAO.save(role);
                }
            }
            roleList = roleDAO.findByLastUpdatedBy(oldUsername);
            if (roleList != null) {
                for (RoleEntity role : roleList) {
                    role.setLastUpdatedBy(newUsername);
                    role.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    role.setLastUpdatedDate(DateUtil.getCurDateTime());
                    roleDAO.save(role);
                }
            }
            // Menu Table
            List<MenuEntity> menuList = menuDAO.findByCreatedBy(oldUsername);
            if (menuList != null) {
                for (MenuEntity menu : menuList) {
                    menu.setCreatedBy(newUsername);
                    menu.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    menu.setLastUpdatedDate(DateUtil.getCurDateTime());
                    menuDAO.save(menu);
                }
            }
            menuList = menuDAO.findByLastUpdatedBy(oldUsername);
            if (menuList != null) {
                for (MenuEntity menu : menuList) {
                    menu.setLastUpdatedBy(newUsername);
                    menu.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    menu.setLastUpdatedDate(DateUtil.getCurDateTime());
                    menuDAO.save(menu);
                }
            }
            // UserRole Table
            List<UserRoleEntity> userRoleList = userRoleDAO.findByUsername(oldUsername);
            if (userRoleList != null) {
                for (UserRoleEntity userRole : userRoleList) {
                    userRole.setUsername(newUsername);
                    userRole.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                    userRoleDAO.save(userRole);
                }
            }
            userRoleList = userRoleDAO.findByCreatedBy(oldUsername);
            if (userRoleList != null) {
                for (UserRoleEntity userRole : userRoleList) {
                    userRole.setCreatedBy(newUsername);
                    userRole.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                    userRoleDAO.save(userRole);
                }
            }
            userRoleList = userRoleDAO.findByLastUpdatedBy(oldUsername);
            if (userRoleList != null) {
                for (UserRoleEntity userRole : userRoleList) {
                    userRole.setLastUpdatedBy(newUsername);
                    userRole.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    userRole.setLastUpdatedDate(DateUtil.getCurDateTime());
                    userRoleDAO.save(userRole);
                }
            }
            // RoleMenu Table
            List<RoleMenuEntity> roleMenuList = roleMenuDAO.findByCreatedBy(oldUsername);
            if (roleMenuList != null) {
                for (RoleMenuEntity roleMenu : roleMenuList) {
                    roleMenu.setCreatedBy(newUsername);
                    roleMenu.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    roleMenu.setLastUpdatedDate(DateUtil.getCurDateTime());
                    roleMenuDAO.save(roleMenu);
                }
            }
            roleMenuList = roleMenuDAO.findByLastUpdatedBy(oldUsername);
            if (roleMenuList != null) {
                for (RoleMenuEntity roleMenu : roleMenuList) {
                    roleMenu.setLastUpdatedBy(newUsername);
                    roleMenu.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    roleMenu.setLastUpdatedDate(DateUtil.getCurDateTime());
                    roleMenuDAO.save(roleMenu);
                }
            }
            // Car Table
            List<CarEntity> carList = carDAO.findByCreatedBy(oldUsername);
            if (carList != null) {
                for (CarEntity car : carList) {
                    car.setCreatedBy(newUsername);
                    car.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    car.setLastUpdatedDate(DateUtil.getCurDateTime());
                    carDAO.save(car);
                }
            }
            carList = carDAO.findByLastUpdatedBy(oldUsername);
            if (carList != null) {
                for (CarEntity car : carList) {
                    car.setLastUpdatedBy(newUsername);
                    car.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    car.setLastUpdatedDate(DateUtil.getCurDateTime());
                    carDAO.save(car);
                }
            }
            // UserCar Table
            List<UserCarEntity> userCarList = userCarDAO.findByUsername(oldUsername);
            if (userCarList != null) {
                for (UserCarEntity userCar : userCarList) {
                    userCar.setUsername(newUsername);
                    userCar.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
                }
            }
            userCarList = userCarDAO.findByCreatedBy(oldUsername);
            if (userCarList != null) {
                for (UserCarEntity userCar : userCarList) {
                    userCar.setCreatedBy(newUsername);
                    userCar.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
                    userCarDAO.save(userCar);
                }
            }
            userCarList = userCarDAO.findByLastUpdatedBy(oldUsername);
            if (userCarList != null) {
                for (UserCarEntity userCar : userCarList) {
                    userCar.setLastUpdatedBy(newUsername);
                    userCar.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                    userCar.setLastUpdatedDate(DateUtil.getCurDateTime());
                    userCarDAO.save(userCar);
                }
            }
            // User Table
            if (oldUsername.equals(user.getCreatedBy())) {
                user.setCreatedBy(newUsername);
            }
            user.setUsername(newUsername);
            user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
            user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
            user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
            user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
            user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
        user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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