package com.example.helloapplication.slice;

import com.example.helloapplication.ResourceTable;
import com.example.helloapplication.SecondMainAbility;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.utils.Color;
import ohos.data.orm.BindUtils;

public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {
//
//    首先将bt放到成员变量中
//    定义为类变量 让变量全局可用
    Button bt;
    Button bt2;
    Button bt3;
    Button bt4;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        //        为第一个页面的按钮添加动作
//        根据id找到按钮
         bt = (Button)this.findComponentById(ResourceTable.Id_but1) ;
//        为接口添加一个点击事件
//        传入的是一个this
//        这里的this表示本类的类对象，而本类也是这个接口的实现类

//        理解：给but这个按钮添加了点击事件，当点击了这个按钮，就可以执行
//        onclick方法中的代码
        bt.setClickedListener(this);

//        获取第二个按钮
        bt2 = (Button)findComponentById(ResourceTable.Id_btn_2);
//        为第二个按钮添加事件
        bt2.setClickedListener(new MyListener());

//        获取第三个按钮
        bt3 = (Button)findComponentById(ResourceTable.Id_btn_3);
        bt3.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                Button btn_get = (Button)component;
                btn_get.setText("第三种单击事件被触发");
            }
        });
        bt4 = (Button)findComponentById(ResourceTable.Id_btn_4) ;
        bt4.setClickedListener(this::myOnClick);

    }
    public void myOnClick(Component component){
        Button bt_get = (Button)component ;
        bt_get.setTextSize(80);
        bt_get.setText("激活 函数引用");
        bt_get.setComponentSize(800,800);

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    public void onClick(Component component) {
//        执行跳转到第二个页面中需要的代码
        if (component == bt){
//            之后点击了bt这个按钮之后，才进行跳转
//            跳转到哪个页面中（意图-intent）
            Intent i = new Intent();
//            包含了页面的跳转信息
            Operation op =  new Intent.OperationBuilder()
                    .withDeviceId("")//跳转到那个设备 为空则跳转到本设备
                    .withBundleName("com.example.helloapplication")//跳转到哪个应用上
                    .withAbilityName("com.example.helloapplication.SecondMainAbility")//跳转到哪个页面上
                    .build();//将上面的三个信息进行打包
//            将打包后的Operation对象设置到intent意图中
            i.setOperation(op);
//            跳转页面
            startAbility(i);
        }
    }
}

class MyListener implements Component.ClickedListener{
    boolean bt2_flag=true;
    @Override
    public void onClick(Component component) {
        Button bt_get = (Button)component;
        if(bt2_flag){
            bt_get.setText("我被点击了");
            bt_get.setTextSize(200);
            bt_get.setComponentSize(800,800);
            bt2_flag = false;
        }else{
            bt_get.setText("没被点击2333");
            bt_get.setTextSize(200);
            bt_get.setScrollbarBackgroundColor(Color.CYAN);
            bt_get.setComponentSize(800,800);
            bt2_flag = true;
        }


    }
}
