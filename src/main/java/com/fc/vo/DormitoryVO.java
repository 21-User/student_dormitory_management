package com.fc.vo;

import com.fc.entity.Dormitory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryVO extends Dormitory {
    private String buildingName;
}
