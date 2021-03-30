package com.autotboxdatasystem.demo.dao;

import com.autotboxdatasystem.demo.entity.CarWarningEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarWarningDAO extends PagingAndSortingRepository<CarWarningEntity, Integer> {

    void deleteAllByVin(String Vin);

    CarWarningEntity findByVinAndSendingTimeAndErrorContentAndFaultCategory(String vin, String sendingTime,
                                                                            String errorContent, String faultCategory);

    List<CarWarningEntity> findByVin(String Vin);

    Page<CarWarningEntity> findByVin(String Vin, Pageable pageable);

    List<CarWarningEntity> findByErrorContent(String errorContent);

    Page<CarWarningEntity> findByErrorContent(String errorContent, Pageable pageable);

    List<CarWarningEntity> findByFaultCategory(String faultCategory);

    Page<CarWarningEntity> findByFaultCategory(String faultCategory, Pageable pageable);

    List<CarWarningEntity> findBySendingTimeBetween(String time1, String time2);

    Page<CarWarningEntity> findBySendingTimeBetween(String time1, String time2, Pageable pageable);

    @Query("select cw.sendingTime, cwd.carType, cw.faultCategory, cwd.errorDetail " +
           "from CarWarningEntity as cw,  CarWarningDetailEntity as cwd " +
           "where substring(cw.vin, 1,6) = cwd.carType and " +
           "cw.errorContent = cwd.errorContent and " +
           "cw.sendingTime BETWEEN ?1 and ?2")
    List<Object> findDetailBySendingTimeBetween(String time1, String time2);

    List<CarWarningEntity> findAll();

    Page<CarWarningEntity> findAll(Pageable pageable);
}
