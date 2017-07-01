package com.fcfphr.设计模式.观察者模式;

import java.util.ArrayList;

/**
 * 说明：被观察的目标,被观察的目标改变则通知观察者
 *
 * @author 范范
 *
 * 2017年3月1日
 */
public interface Subject {
	//添加观察者
	public void addObserver(Observer ob);
	//删除观察者
	public void deleteObserver(Observer ob);
	//通知 观察者
	public void noticeObserver(ArrayList<Observer> obs);
}
