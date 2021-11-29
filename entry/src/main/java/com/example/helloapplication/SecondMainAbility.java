package com.example.helloapplication;

import com.example.helloapplication.slice.SecondMainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Text;
import ohos.agp.utils.Color;

public class SecondMainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
//        super.setMainRoute(SecondMainAbilitySlice.class.getName());

//
//新建UI布局
//        从上往下的布局
        DirectionalLayout dl = new DirectionalLayout(this);
//        创建文本对象
        Text t  = new Text(this);
        t.setText("第二个页面");
        t.setTextSize(100);
        t.setTextColor(Color.BLUE);
        t.setScrollbarBackgroundColor(Color.CYAN);

//        添加文本到布局中
        dl.addComponent(t);
//        把布局添加到子页面中
        super.setUIContent(dl);




    }
}
