package com.jerry.KangFuRoad.provider.model;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;

import com.jerry.KangFuRoad.provider.DAOFactory;
import com.jerry.KangFuRoad.provider.RegularCheckDao;

public class Regular {
	private final String TAG = Regular.class.getName() + "TAG";
	
	private String date = null;
	private String biZhong = null;
	private String danBai = null;
	private String qianXue = null;
	private String hongXiBao = null;
	private String ph = null;
	
    private static DAOFactory daoFactory = DAOFactory.getInstance();
    
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getBiZhong() {
		return biZhong;
	}


	public void setBiZhong(String biZhong) {
		this.biZhong = biZhong;
	}


	public String getDanBai() {
		return danBai;
	}


	public void setDanBai(String danBai) {
		this.danBai = danBai;
	}


	public String getQianXue() {
		return qianXue;
	}


	public void setQianXue(String qianXue) {
		this.qianXue = qianXue;
	}


	public String getHongXiBao() {
		return hongXiBao;
	}


	public void setHongXiBao(String hongXiBao) {
		this.hongXiBao = hongXiBao;
	}


	public String getPh() {
		return ph;
	}


	public void setPh(String ph) {
		this.ph = ph;
	}
	
	public static void save(Map<String, String> regularMap, Context context){
		RegularCheckDao dao = null;
		
		try{
			 dao = daoFactory.getRegularDao(context);
			 dao.save(regularMap);
		} finally {
			if(dao != null){
				dao.close();
			}
		}
	}


	public static void save(Regular regular, Context context){
		RegularCheckDao dao = null;
		
		try{
			 dao = daoFactory.getRegularDao(context);
			 dao.save(regular);
		} finally {
			if(dao != null){
				dao.close();
			}
		}
	}
	
	public static Regular getRegularById(String id, Context context){
		Regular regular = null;
		RegularCheckDao dao = null;
		
		try{
			 dao = daoFactory.getRegularDao(context);
			 dao.save(regular);
		} finally {
			if(dao != null){
				dao.close();
			}
		}
		
		return regular;
	} 
	
	public static ArrayList<Regular> getAllRegular(Context context){
		ArrayList<Regular> regulars = new ArrayList<Regular>();
		RegularCheckDao dao = null;
		
		try{
			 dao = daoFactory.getRegularDao(context);
			 regulars = dao.getAllRegular();
		} finally {
			if(dao != null){
				dao.close();
			}
		}
		
		return regulars;
	}
	
}
