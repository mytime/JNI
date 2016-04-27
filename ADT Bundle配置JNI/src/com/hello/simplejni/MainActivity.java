package com.hello.simplejni;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * jni简便开发流程
 * 
 * ① 写java代码 native 声明本地方法
 * ② 添加本地支持 右键单击项目->andorid tools->add native surport
		* 如果发现 finish不能点击需要给工作空间配置ndk目录的位置
		* window->preferences->左侧选择android->ndk 把ndk解压的目录指定进来
 * ③ 如果写的是.c的文件 先修改一下生成的.cpp文件的扩展名 不要忘了 相应修改Android.mk文件中LOCAL_SRC_FILES的值
 * ④ javah生成头文件 在生成的头文件中拷贝c的函数名到.c的文件
 * ⑤ 解决CDT插件报错的问题
 * 右键单击项目选择 properties 选测 c/c++ general->paths and symbols->include选项卡下->点击add..->file system 选择ndk目录下 platforms文件夹 对应平台下(项目支持的最小版本)
 	usr 目录下 arch-arm -> include  确定后 会解决代码提示和报错的问题
 * ⑥编写C函数 如果需要单独编译一下c代码就在c/c++视图中找到小锤子 
 *  如果想直接运行到模拟器上 就不用锤子了
 * ⑦ java代码中不要忘了 system.loadlibrary();  
 *
 */

public class MainActivity extends Activity {
	
	//创建一个静态模块
	static{
		//加载so文件
		System.loadLibrary("hello");
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void click(View v){
    	//调用本地函数
    	Toast.makeText(getApplicationContext(), helloFromC(), 0).show();    	
    }
    
    public native String helloFromC();


}
