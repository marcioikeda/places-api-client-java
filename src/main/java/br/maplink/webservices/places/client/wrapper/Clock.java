package br.maplink.webservices.places.client.wrapper;

import java.util.GregorianCalendar;

public interface Clock {

	public abstract GregorianCalendar nowForCachingPurpose();

}