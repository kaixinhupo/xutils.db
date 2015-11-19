package org.xutils;

import android.app.Application;

import org.xutils.db.DbManagerImpl;


/**
 * Created by Lianxw on 15/11/19.
 * 任务控制中心,db注入等接口的入口.
 * 需要在在application的onCreate中初始化: x.Ext.init(this);
 */
public final class x {

    private x() {
    }

    public static boolean isDebug() {
        return Ext.debug;
    }

    public static Application app() {
        if (Ext.app == null) {
            throw new RuntimeException("please invoke x.Ext.init(app) on Application#onCreate()");
        }
        return Ext.app;
    }

    public static DbManager getDb(DbManager.DaoConfig daoConfig) {
        return DbManagerImpl.getInstance(daoConfig);
    }

    public static class Ext {
        private static boolean debug;
        private static Application app;

        private Ext() {
        }


        public static void init(Application app) {
            if (Ext.app == null) {
                Ext.app = app;
            }
        }

        public static void setDebug(boolean debug) {
            Ext.debug = debug;
        }

    }
}
