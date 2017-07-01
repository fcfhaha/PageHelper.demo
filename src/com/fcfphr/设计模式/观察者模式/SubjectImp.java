package com.fcfphr.设计模式.观察者模式;

import java.util.ArrayList;

/**
 * 说明：被观察的目标对象
 *
 * @author 范范
 *
 * 2017年3月1日
 */
public class SubjectImp implements Subject {

	private ArrayList<Observer> observers;
	private String changes;
	

	public SubjectImp(){}
	
	@Override
	public void deleteObserver(Observer ob) {
		observers.remove(ob);
	}


	@Override
	public void noticeObserver(ArrayList<Observer> obs) {
		for (Observer observer : obs) {
			observer.update(changes);
		}
	}


	@Override
	public void addObserver(Observer ob) {
		observers.add(ob);
	}


	/**
	 * @return the observers
	 */
	public ArrayList<Observer> getObservers() {
		return observers;
	}


	/**
	 * @param observers the observers to set
	 */
	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}


	/**
	 * @return the changes
	 */
	public String getChanges() {
		return changes;
	}


	/**
	 * @param changes the changes to set
	 */
	public void setChanges(String changes) {
		this.changes = changes;
		this.noticeObserver(observers);
	}

	
}
