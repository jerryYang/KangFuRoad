package com.jerry.KangFuRoad.provider.model;

import java.util.ArrayList;

import android.content.Context;

import com.jerry.KangFuRoad.provider.DAOFactory;
import com.jerry.KangFuRoad.provider.TableDao;
import com.jerry.KangFuRoad.provider.Contract.TableContract.TableItem;

public class Table {
	private final String TAG = Table.class.getName() + "TAG";
	
	private String table = null;
	private ArrayList<TableItem> items = null;
	
    private static DAOFactory daoFactory = DAOFactory.getInstance();
    
    public static Table getTableByName(String tableName, Context context){
    	TableDao dao = null;
    	Table table = null;
    	try{
    		dao = daoFactory.getTablesDAO(context);
    		table = dao.getTableByName(tableName);
    	} finally{
    		if(dao != null){
    			dao.close();
    		}
    	}
    	
    	return table;
    }
    
    
	public ArrayList<TableItem> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<TableItem> items) {
		this.items = items;
	}
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public String getTable() {
		return table;
	}

}
