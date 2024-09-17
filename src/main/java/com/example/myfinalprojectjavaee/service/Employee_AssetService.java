package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.AssetRepo;
import com.example.myfinalprojectjavaee.dao.EmployeeRepo;
import com.example.myfinalprojectjavaee.dao.Employee_AssetRepo;
import com.example.myfinalprojectjavaee.entity.AssetEntity;
import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;


@Service
public class Employee_AssetService {

    @Autowired
    private Employee_AssetRepo employeeAssetRepo;
    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public void assignEmployeeToAsset(int assetId, List<Integer> employeeIds) {
        for (int employeeId : employeeIds) {
            // پیدا کردن آخرین تخصیص برای کارمند و دارایی مشخص
            List<Employee_AssetEntity> employeeAssetEntities = employeeAssetRepo.findEmployee_AssetEntitiesByEmployeeIdAndAssetId(assetId, employeeId);

            // دریافت بیشینه نسخه برای تخصیص‌های موجود
            int currentVersion = 0;
            for (Employee_AssetEntity employeeAsset : employeeAssetEntities) {
                currentVersion = Math.max(currentVersion, employeeAsset.getVersion());
            }

            // ایجاد رکورد جدید برای تخصیص
            Employee_AssetEntity newAssignment = new Employee_AssetEntity();
            newAssignment.setEmployeeEntity(new EmployeeEntity(employeeId)); // تنظیم کارمند
            newAssignment.setAssetEntity(new AssetEntity(assetId)); // تنظیم دارایی
            newAssignment.setVersion(currentVersion + 1); // افزایش نسخه با توجه به آخرین تخصیص
            newAssignment.setAssignStatus(true); // وضعیت را به assigned تغییر دهید
            newAssignment.setAssignedDate(new Date()); // تاریخ انتساب را به تاریخ و ساعت فعلی تنظیم کنید

            // ذخیره رکورد جدید
            employeeAssetRepo.save(newAssignment);
            System.out.println("این کارمند با ID " + employeeId + " به دارایی با ID " + assetId + " تخصیص داده شد. (نسخه: " + newAssignment.getVersion() + ")");
        }
    }

    public void unAssignEmployeeFromAsset(int assetId, List<Integer> employeeIds) {
        for (int employeeId : employeeIds) {
            // پیدا کردن تخصیص‌های موجود برای کارمند و دارایی مشخص
            List<Employee_AssetEntity> employeeAssetEntities = employeeAssetRepo.findEmployee_AssetEntitiesByEmployeeIdAndAssetId(assetId, employeeId);

            // اگر تخصیص وجود داشته باشد و آخرین وضعیت آن true باشد
            if (!employeeAssetEntities.isEmpty()) {
                Employee_AssetEntity lastAssignment = employeeAssetEntities.get(employeeAssetEntities.size() - 1); // آخرین تخصیص را بگیرید
                if (lastAssignment.getAssignStatus()) { // اگر وضعیت تخصیص active باشد
                    // ایجاد رکورد جدید با نسخه‌ای جدید
                    Employee_AssetEntity newUnassignment = new Employee_AssetEntity();
                    newUnassignment.setEmployeeEntity(lastAssignment.getEmployeeEntity()); // تنظیم کارمند
                    newUnassignment.setAssetEntity(lastAssignment.getAssetEntity()); // تنظیم دارایی
                    newUnassignment.setVersion(lastAssignment.getVersion() + 1); // افزایش نسخه
                    newUnassignment.setAssignStatus(false); // تغییر وضعیت به unassigned
                    newUnassignment.setUnassignedDate(new Date()); // تاریخ لغو را به تاریخ و ساعت فعلی تنظیم کنید
                    // ذخیره رکورد جدید
                    employeeAssetRepo.save(newUnassignment);
                    System.out.println("تخصیص کارمند با ID " + employeeId + " از دارایی با ID " + assetId + " لغو شد. (نسخه: " + newUnassignment.getVersion() + ")");
                } else {
                    System.out.println("تخصیص کارمند با ID " + employeeId + " قبلاً لغو شده و فعال نیست.");
                }
            } else {
                System.out.println("هیچ تخصیص فعالی برای کارمند با ID " + employeeId + " و دارایی با ID " + assetId + " وجود ندارد.");
            }
        }
    }
    public List<Employee_AssetEntity> findAll() {
        return employeeAssetRepo.findAll();
    }

    public List<Employee_AssetEntity> findEmployeeAssetById(int id) {
        return employeeAssetRepo.findAllById(Collections.singleton(id));
    }


    public List<Employee_AssetEntity> getEmployee_AssetEntitiesByAssetId(int assetId) {
        return employeeAssetRepo.findEmployee_AssetEntitiesByAssetId(assetId);
    }

    public List<Employee_AssetEntity> getEmployee_AssetEntitiesByEmployeeId(int employeeId) {
        return employeeAssetRepo.findEmployee_AssetEntitiesByEmployeeId(employeeId);
    }

    public List<Employee_AssetEntity> findAvailableEmployeesForUnAssign(int assetId){
        return employeeAssetRepo.availableEmployeesForUnAssign(assetId);
    }
}
