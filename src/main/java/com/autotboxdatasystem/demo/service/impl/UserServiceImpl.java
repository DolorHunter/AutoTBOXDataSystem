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
    private final UserRoleDAO userRoleDAO;
    private final UserCarDAO userCarDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserRoleDAO userRoleDAO, UserCarDAO userCarDAO) {
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
        this.userCarDAO = userCarDAO;
    }

    @Override
    public boolean login(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();

        UserEntity user = userDAO.findByUsernameAndPassword(username, password);
        return user != null;
    }

    @Override
    public String addUser(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        String phone = userEntity.getPhone();
        String email = userEntity.getEmail();
        String avatar = userEntity.getAvatar();

        if (username == null || password == null) {
            return "Username or Password is null.";
        } else {
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
        if (avatar == null || avatar.equals("")) {
            userEntity.setAvatar("1");
        }

        userEntity.setIsActivated("1");
        userEntity.setIsDeleted("0");

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
        List<UserCarEntity> userCarList = userCarDAO.findByUserId(userEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("1");
                userCar.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userCarDAO.save(userCar);
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
        List<UserCarEntity> userCarList = userCarDAO.findByUserId(userEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("0");
                userCar.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userCarDAO.save(userCar);
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
        List<UserCarEntity> userCarList = userCarDAO.findByUserId(userEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("0");
                userCar.setIsDeleted("1");
                userCar.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userCarDAO.save(userCar);
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
        List<UserCarEntity> userCarList = userCarDAO.findByUserId(userEntity.getId());
        if (userCarList != null) {
            for (UserCarEntity userCar : userCarList) {
                userCar.setIsActivated("1");
                userCar.setIsDeleted("0");
                userCar.setLastUpdatedBy(userEntity.getLastUpdatedBy());
                userCarDAO.save(userCar);
            }
        }

        UserEntity user = userDAO.findById(userEntity.getId()).get();
        user.setIsDeleted("0");
        user.setIsActivated("1");
        user.setLastUpdatedBy(userEntity.getLastUpdatedBy());
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
        String oldPassword = userEntity.getRemark();
        String newPassword = userEntity.getPassword();
        if (oldPassword != null && newPassword != null &&
                oldPassword.equals(user.getPassword())) {
            user.setPassword(newPassword);
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
    public List<UserEntity> searchActivedUserList(UserEntity userEntity) {
        return userDAO.findByIsActivated("1");
    }

    @Override
    public Page<UserEntity> searchActivedUserPager(UserEntity userEntity) {
        Integer pageIndex = userEntity.getPageIndex();
        Integer pageSize = userEntity.getPageSize();
        return userDAO.findByIsActivated("1", PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }

    @Override
    public List<UserEntity> searchAllUserList(UserEntity userEntity) {
        return userDAO.findAll();
    }

    @Override
    public Page<UserEntity> searchAllUserPager(UserEntity userEntity) {
        Integer pageIndex = userEntity.getPageIndex();
        Integer pageSize = userEntity.getPageSize();
        return userDAO.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
}