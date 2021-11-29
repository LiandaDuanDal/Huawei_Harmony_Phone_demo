package com.example.helloapplication;

import com.example.helloapplication.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.render.render3d.Component;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
////        为第一个页面的按钮添加动作
////        根据id找到按钮
//        Button bt = (Button)findComponentById(ResourceTable.Id_but1) ;
////        为接口


    }
}
