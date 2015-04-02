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
    *	组件命名：组件简写_描述.xml
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

	
