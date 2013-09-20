package com.jerry.KangFuRoad.provider;

import android.content.Context;

public class DAOFactory {
    private static DAOFactory instance = null;

    private Context globalContext = null;
    private boolean cacheDAOInstances = false;
    private RegularCheckDao cachedRegularDAO = null;
    private BloodCheckDao cachedBloodDAO = null;
    private TableDao cachedTablesDAO = null;

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    private DAOFactory() {
    }

    public RegularCheckDao getTeamDAO(Context context) {
        if (cacheDAOInstances) {
            if (cachedRegularDAO == null) {
                cachedRegularDAO = new RegularCheckDao(getProperDAOContext(context));
            }
            return cachedRegularDAO;
        } else {
            return new RegularCheckDao(getProperDAOContext(context));
        }
    }
    

    public TableDao getTablesDAO(Context context) {
        if (cacheDAOInstances) {
            if (cachedTablesDAO == null) {
            	cachedTablesDAO = new TableDao(getProperDAOContext(context));
            }
            return cachedTablesDAO;
        } else {
            return new TableDao(getProperDAOContext(context));
        }
    }

    public BloodCheckDao getMeetingDAO(Context context) {
        if (cacheDAOInstances) {
            if (cachedBloodDAO == null) {
                cachedBloodDAO = new BloodCheckDao(getProperDAOContext(context));
            }
            return cachedBloodDAO;
        } else {
            return new BloodCheckDao(getProperDAOContext(context));
        }
    }

    public void setGlobalContext(Context context) {
        globalContext = context;
    }

    public void setCacheDAOInstances(boolean cacheDAOInstances) {
        this.cacheDAOInstances = cacheDAOInstances;
    }

    private Context getProperDAOContext(Context context) {
        if (globalContext != null) {
            return globalContext;
        } else {
            return context;
        }
    }
}
