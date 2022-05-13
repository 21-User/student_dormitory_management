package com.fc.vo;

import com.fc.entity.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingVO extends Building {
    private String dormitoryManagerSn;
    private String dormitoryManagerName;
}
