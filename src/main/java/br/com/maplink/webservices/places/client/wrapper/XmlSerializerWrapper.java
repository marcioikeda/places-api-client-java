package br.com.maplink.webservices.places.client.wrapper;

public interface XmlSerializerWrapper {

	public abstract <T> T deserialize(Class<T> klazz, String xml);

	public abstract String serialize(Object object);

}