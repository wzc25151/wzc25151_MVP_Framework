package com.sousouhardware.base;

import com.sousouhardware.config.ViewDictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxiangbo on 2016/7/17.
 */
public class ObjViewManager {
    private static Map<Class, Object> objMap = new HashMap<Class, Object>();

    private static Object getObjectInstance(Class clazz) {
        Object obj = null;
        try {
            if (objMap.containsKey(clazz)) {
                obj = objMap.get(clazz);
            } else {
                obj = clazz.newInstance();
                objMap.put(clazz, obj);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 获取类的实例
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObjInstance(Class<T> clazz) {
        Object objectInstance = getObjectInstance(clazz);
        T cast = clazz.cast(objectInstance);
        return cast;
    }

    /**
     * 通过类名获取实例，针对V
     * @param className
     * @return
     */
    public static BaseFragment getFragmentClassInstance(String className){
        BaseFragment fg = null;
        try {
            if (className.length()>4&&className.substring(className.length()-4).contains("View")){
            }else {
                className = ViewDictionary.VIEW_BASE_PATH +className+"View";
            }
            fg = (BaseFragment) getObjInstance(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  fg;
    }

    /**
     * 通过类名前缀组装View和Presenter
     * @param strPreClassName
     * @return
     */
    public static BaseFragment setupContract(String strPreClassName) {
        BaseView viewInstance = null;
        try {
            Class<? extends BaseView> viewClazz = (Class<? extends BaseView>) Class.forName(ViewDictionary.VIEW_BASE_PATH+strPreClassName + "View");
            Class<? extends BasePresenter> presenterClazz = (Class<? extends BasePresenter>) Class.forName(ViewDictionary.VIEW_BASE_PATH +strPreClassName + "Presenter");
            viewInstance = getObjInstance(viewClazz);
            BasePresenter presenterInstance = getObjInstance(presenterClazz);
            viewInstance.setPresenter(presenterInstance);
            presenterInstance.setView(viewInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (BaseFragment) viewInstance;
    }
}
