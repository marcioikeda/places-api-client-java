package br.maplink.webservices.places.client.helper;

import java.util.GregorianCalendar;

public interface Clock {

	public abstract GregorianCalendar nowForCachingPurpose();

}