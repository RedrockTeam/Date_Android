#如期 【Date】   Android客户端

##项目结构
	app/
		config/					全局配置文件
		home/					模块
			presenter/			presenter层
			view/				view层
		model/					model，包含bean
			bean/				Java bean对象
		util/					工具类
		widget/					自定义控件
	
##命名规范
*	包名小写
*	JAVA部分
	*	采用驼峰法
	*	Activity类：Activity为后缀、Fragment类：Fragment为后缀、Adapter类：Adapter为后缀...
	*	抽象类Abs开头
	*	接口I开头

*	资源文件
	*	小写加下划线分割
	*	contentview命名：activity_功能模块.xml，fragment_功能模块.xml
	
        >例如：activity_main.xml、activity_more.xml、fragment_main.xml
    *	组件命名：组件简写\_模块\_描述.xml
    	*	Button：btn\_模块\_描述.xml
    	
    		>例如：btn\_main\_login.xml
		*	Dialog：dialog\_模块\_描述.xml
		
       		>例如：dialog\_main\_hint.xml       
		*	PopupWindow命名：pw\_模块\_描述.xml
			
       		>例如：pw\_main\_info.xml
    *	adapter的子布局：item\_功能模块\_描述.xml
    
       >例如：item_main_goods_list.xml、
	*	包含项：include_描述.xml（include文件可能多模块复用，所以不加模块）
	
       >例如：include_head.xml、include_bottom.xml

	
##API
*   私信模块

        {
            status : 200,
            info : "请求成功",
            data : {
                "user_id" : 123,
                "user_name" : "Lecion",
                "user_signature" : "个性签名",
                "user_avatar" : "http://****.jpg",	//用户头像
                "user_gender" : 2, 		//1是男，2是女
                "content" : "约了我的炮",
                "date_id" : 12,		//约会的id，只针对系统发送的含有约会的私信
                "letter_status" : 1,	//私信状态，1 => 未读， 2 => 已读
                "user_data_status" : 2,	//用户和约会的状态,0 => , 1 => 以接受, 2 => 默认（未处理）
            }
        }